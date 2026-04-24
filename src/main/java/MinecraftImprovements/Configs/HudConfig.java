package MinecraftImprovements.Configs;

import com.gtnewhorizon.gtnhlib.config.Config;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.util.EnumChatFormatting;

import static MinecraftImprovements.MinecraftImprovements.MODID;

@Config(modid = MODID, category = "HUD", configSubDirectory = "Minecraft Improvements")
@Config.Entry(ConfigEntry.HudCategory.class)
public class HudConfig {

    public static final HudOrder hudOrder = new HudOrder();

    @Config.Entry(ConfigEntry.HudOrderCategory.class)
    public static class HudOrder {

        @Config.Comment("FPS Line order")
        @Config.DefaultInt(1)
        @Config.RangeInt(min = 1, max = 100)
        public int fpsOrder;

        @Config.Comment("Memory Line order")
        @Config.DefaultInt(2)
        @Config.RangeInt(min = 1, max = 100)
        public int memoryOrder;

        @Config.Comment("Ping Line order")
        @Config.DefaultInt(3)
        @Config.RangeInt(min = 1, max = 100)
        public int pingOrder;

        @Config.Comment("Position Line order")
        @Config.DefaultInt(4)
        @Config.RangeInt(min = 1, max = 100)
        public int positionOrder;

        @Config.Comment("TPS Line order")
        @Config.DefaultInt(5)
        @Config.RangeInt(min = 1, max = 100)
        public int tpsOrder;

    }
}
