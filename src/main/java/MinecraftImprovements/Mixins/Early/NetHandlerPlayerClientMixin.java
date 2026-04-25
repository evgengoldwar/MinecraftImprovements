package MinecraftImprovements.Mixins.Early;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S3FPacketCustomPayload;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import MinecraftImprovements.Hud.Core.DataStorage;
import MinecraftImprovements.Hud.Network.OSLHandshakePayload;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

@Mixin(value = NetHandlerPlayClient.class)
public class NetHandlerPlayerClientMixin {

    @Shadow
    @Final
    private NetworkManager netManager;

    /* Register OSL networking channels */
    @Inject(method = "handleJoinGame", at = @At("TAIL"))
    private void sendHandshake(CallbackInfo ci) {
        C17PacketCustomPayload packet = OSLHandshakePayload.getHandshake();
        if (packet != null) {
            this.netManager.scheduleOutboundPacket(packet);
        }
    }

    /* Grab own player ping on remote servers */
    @Inject(method = "handlePlayerListItem", at = @At("HEAD"))
    private void getPing(S38PacketPlayerListItem packet, CallbackInfo ci) {
        if (packet == null || packet.func_149122_c() == null) {
            return;
        }
        if (packet.func_149122_c()
            .equals(Minecraft.getMinecraft().thePlayer.getDisplayName())) {
            DataStorage.ping = packet.func_149120_e();
        }
    }

    /* Handle custom packets */
    @Inject(method = "handleCustomPayload", at = @At("HEAD"))
    private void handleTPSPacket(S3FPacketCustomPayload packet, CallbackInfo ci) {
        if (packet == null || packet.func_149169_c() == null) {
            return;
        }

        if (packet.func_149169_c()
            .equals(OSLHandshakePayload.CHANNEL + "|TPS")) {

            ByteBuf bytebuf = Unpooled.wrappedBuffer(packet.func_149168_d());
            try {
                double tps = bytebuf.readDouble();
                double mspt = bytebuf.readDouble();
                DataStorage.tps = tps;
                DataStorage.mspt = mspt;
            } catch (Exception ignored) {}
        }

        if (packet.func_149169_c()
            .equals(OSLHandshakePayload.CHANNEL + "|Mem")) {

            ByteBuf bytebuf = Unpooled.wrappedBuffer(packet.func_149168_d());
            try {
                DataStorage.serverMemUsed = bytebuf.readInt();
                DataStorage.serverMemAllocated = bytebuf.readInt();
                DataStorage.serverMemMax = bytebuf.readInt();
            } catch (Exception ignored) {}
        }
    }
}
