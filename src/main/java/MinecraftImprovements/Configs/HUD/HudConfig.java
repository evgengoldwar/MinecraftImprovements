package MinecraftImprovements.Configs.HUD;

import static MinecraftImprovements.MinecraftImprovements.MODID;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config(modid = MODID, category = "hud", configSubDirectory = "Minecraft Improvements")
@Config.Entry(HudEntry.HudCategory.class)
public class HudConfig {

    public static final HudOrder hudOrder = new HudOrder();
    public static final HudItems hudItems = new HudItems();

    @Config.Entry(HudEntry.HudOrderCategory.class)
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

    @Config.Entry(HudEntry.HudItemsCategory.class)
    public static class HudItems {

        @Config.Comment("FPS Line item")
        @Config.DefaultString("minecraft:clock")
        public String fpsItem;

        @Config.Comment("Memory Line item")
        @Config.DefaultString("minecraft:redstone")
        public String memoryItem;

        @Config.Comment("Ping Line item")
        @Config.DefaultString("minecraft:stone")
        public String pingItem;

        @Config.Comment("Position Line item")
        @Config.DefaultString("minecraft:grass")
        public String positionItem;

        @Config.Comment("TPS Line order")
        @Config.DefaultString("minecraft:command_block")
        public String tpsItem;

    }
}
