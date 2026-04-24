package MinecraftImprovements.Hud.Network;

import MinecraftImprovements.MinecraftImprovements;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OSLHandshakePayload {

    public static final String CHANNEL = MinecraftImprovements.MODID + "HUD";

    public static C17PacketCustomPayload getHandshake() {
        PacketBuffer buffer = new PacketBuffer(Unpooled.buffer());

        List<String> channels = new ArrayList<>();

        channels.add(CHANNEL + "|TPS");
        channels.add(CHANNEL + "|Mem");

        for (String channel : channels) {
            try {
                buffer.writeStringToBuffer(channel);
            } catch (IOException ignored) {}
        }
        return new C17PacketCustomPayload("OSL|Handshake", buffer);
    }
}
