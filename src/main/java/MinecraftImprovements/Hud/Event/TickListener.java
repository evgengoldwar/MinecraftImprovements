package MinecraftImprovements.Hud.Event;

import net.minecraft.client.Minecraft;

import MinecraftImprovements.Hud.Core.DataStorage;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class TickListener {

    private int tpsTimer = 20;

    @SubscribeEvent
    public void onTick(TickEvent.WorldTickEvent event) {
        if (tpsTimer == 0) {
            tpsTimer = 20;

            if (Minecraft.getMinecraft()
                .isSingleplayer()) {
                try {
                    DataStorage.getClientTPS();
                } catch (NullPointerException ignored) {}
            }
        }

        tpsTimer--;
    }
}
