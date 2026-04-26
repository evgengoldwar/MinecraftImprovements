package MinecraftImprovements.Configs;

import com.gtnewhorizon.gtnhlib.config.Config;

import static MinecraftImprovements.MinecraftImprovements.MODID;

@Config(
    modid = MODID,
    configSubDirectory = "Minecraft Improvements",
    filename = "GeneralConfig")
@Config.LangKey("minecraftimprovements.config.general.name")
public class GeneralConfig {

    @Config.DefaultBoolean(true)
    @Config.Order(1)
    public static boolean DisablePotionEffect;
}
