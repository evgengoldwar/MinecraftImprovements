package InfoHUD.KeyBinds;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import InfoHUD.InfoHUD;
import InfoHUD.LightOverlay.LightLevelOverlayRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyBindHandler {

    public static KeyBinding toggleLight = new KeyBinding("Toggle Light Overlay", Keyboard.KEY_L, InfoHUD.MODNAME);

    public KeyBindHandler() {
        ClientRegistry.registerKeyBinding(toggleLight);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (toggleLight.isPressed()) {
            LightLevelOverlayRenderer.toggleMode();
        }
    }
}
