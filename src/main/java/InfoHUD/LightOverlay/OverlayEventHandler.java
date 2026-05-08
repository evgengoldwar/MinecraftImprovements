package InfoHUD.LightOverlay;

import net.minecraftforge.client.event.RenderWorldLastEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OverlayEventHandler {

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent event) {
        LightLevelOverlayRenderer.render(event.partialTicks);
    }
}
