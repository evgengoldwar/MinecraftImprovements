package MinecraftImprovements.Mixins.Early;

import java.util.List;

import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.client.C17PacketCustomPayload;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import MinecraftImprovements.Hud.Core.ServerDataStorage;
import MinecraftImprovements.Hud.Network.ServerPacketHandler;
import MinecraftImprovements.MinecraftImprovements;

@Mixin(NetHandlerPlayServer.class)
public class NetHandlerPlayServerMixin {

    @Inject(method = "processVanilla250Packet", at = @At("HEAD"), cancellable = true)
    public void onCustomPayload(C17PacketCustomPayload packet, CallbackInfo ci) {
        String channelName = packet.func_149559_c();

        if ("OSL|Handshake".equals(channelName)) {
            NetHandlerPlayServer handler = (NetHandlerPlayServer) (Object) this;

            List<String> channels = ServerPacketHandler.readHandshakeChannels(packet);

            String prefix = MinecraftImprovements.NETWORK_MODID + "HUD|";

            if (channels.contains(prefix + "TPS")) {
                ServerDataStorage.subscribeTPS(handler.playerEntity);
            }

            if (channels.contains(prefix + "Mem")) {
                ServerDataStorage.subscribeMem(handler.playerEntity);
            }

            ci.cancel();
        }
    }
}
