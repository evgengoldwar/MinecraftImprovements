package MinecraftImprovements.Configs;

import static MinecraftImprovements.MinecraftImprovements.MODID;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config(modid = MODID, configSubDirectory = "Minecraft Improvements", filename = "GeneralConfig")
@Config.LangKey("minecraftimprovements.config.general.name")
public class GeneralConfig {

    @Config.DefaultBoolean(true)
    @Config.Order(1)
    public static boolean DisablePotionEffect;
}
