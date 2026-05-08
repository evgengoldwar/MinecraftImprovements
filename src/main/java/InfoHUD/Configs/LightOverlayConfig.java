package InfoHUD.Configs;

import com.gtnewhorizon.gtnhlib.config.Config;

import static InfoHUD.InfoHUD.MODID;

@Config(modid = MODID, category = "light", configSubDirectory = "InfoHUD", filename = "LightOverlayConfig")
@Config.LangKey("infohud.config.light.name")
public class LightOverlayConfig {

    @Config.DefaultBoolean(false)
    @Config.Order(1)
    public static boolean DisableFollowNumber;
}
