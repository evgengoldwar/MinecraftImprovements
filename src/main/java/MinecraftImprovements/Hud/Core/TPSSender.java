package MinecraftImprovements.Hud.Core;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;

import MinecraftImprovements.MinecraftImprovements;
import io.netty.buffer.Unpooled;

public class TPSSender {

    private static int tickCounter = 0;

    public static void onServerTick(MinecraftServer server) {
        tickCounter++;

        if (tickCounter % 20 != 0) {
            return;
        }

        if (ServerDataStorage.tpsSubscribers.isEmpty() && ServerDataStorage.memSubscribers.isEmpty()) {
            return;
        }

        double meanTickTime = MathHelper.average(server.tickTimeArray) * 1.0E-6D;
        double tps = Math.min(1000.0D / meanTickTime, 20.0D);

        Runtime runtime = Runtime.getRuntime();
        long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
        long maxMem = runtime.maxMemory() / 1024 / 1024;
        long allocatedMem = runtime.totalMemory() / 1024 / 1024;

        for (EntityPlayerMP playerMP : server.getConfigurationManager().playerEntityList) {

            if (ServerDataStorage.tpsSubscribers.contains(playerMP.getUniqueID())) {
                sendTPSPacket(playerMP, tps, meanTickTime);
            }

            if (ServerDataStorage.memSubscribers.contains(playerMP.getUniqueID())) {
                sendMemPacket(playerMP, usedMem, maxMem, allocatedMem);
            }
        }
    }

    private static void sendTPSPacket(EntityPlayerMP player, double tps, double mspt) {
        PacketBuffer buffer = new PacketBuffer(Unpooled.buffer());
        buffer.writeDouble(round(tps));
        buffer.writeDouble(round(mspt));

        S3FPacketCustomPayload packet = new S3FPacketCustomPayload(
            MinecraftImprovements.NETWORK_MODID + "HUD|TPS",
            buffer);

        player.playerNetServerHandler.sendPacket(packet);
    }

    private static void sendMemPacket(EntityPlayerMP player, long used, long max, long allocated) {
        PacketBuffer buffer = new PacketBuffer(Unpooled.buffer());
        buffer.writeInt((int) used);
        buffer.writeInt((int) max);
        buffer.writeInt((int) allocated);

        S3FPacketCustomPayload packet = new S3FPacketCustomPayload(
            MinecraftImprovements.NETWORK_MODID + "HUD|Mem",
            buffer);

        player.playerNetServerHandler.sendPacket(packet);
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
