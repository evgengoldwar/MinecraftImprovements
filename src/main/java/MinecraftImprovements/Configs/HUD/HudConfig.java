package MinecraftImprovements.Configs.HUD;

import static MinecraftImprovements.MinecraftImprovements.MODID;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config(
    modid = MODID,
    category = "hud",
    configSubDirectory = "Minecraft Improvements",
    filename = "Minecraft Improvements")
@Config.LangKey("minecraftimprovements.config.hud.name")
public class HudConfig {

    public static final HudOrder hudOrder = new HudOrder();
    public static final HudItems hudItems = new HudItems();
    public static final HudEnabled hudEnabled = new HudEnabled();

    @Config.LangKey("minecraftimprovements.config.hud.hud_order.name")
    public static class HudOrder {

        @Config.DefaultInt(1)
        @Config.RangeInt(min = 1, max = 100)
        public int FpsOrder;

        @Config.DefaultInt(4)
        @Config.RangeInt(min = 1, max = 100)
        public int MemoryOrder;

        @Config.DefaultInt(5)
        @Config.RangeInt(min = 1, max = 100)
        public int ServerMemoryOrder;

        @Config.DefaultInt(2)
        @Config.RangeInt(min = 1, max = 100)
        public int PingOrder;

        @Config.DefaultInt(6)
        @Config.RangeInt(min = 1, max = 100)
        public int positionOrder;

        @Config.DefaultInt(3)
        @Config.RangeInt(min = 1, max = 100)
        public int tpsOrder;

        @Config.DefaultInt(7)
        @Config.RangeInt(min = 1, max = 100)
        public int lpOrder;

    }

    @Config.LangKey("minecraftimprovements.config.hud.hud_icons.name")
    public static class HudItems {

        @Config.DefaultString("minecraft:clock")
        public String FpsItem;

        @Config.DefaultString("minecraft:redstone")
        public String MemoryItem;

        @Config.DefaultString("minecraft:redstone")
        public String ServerMemoryItem;

        @Config.DefaultString("minecraft:stone")
        public String PingItem;

        @Config.DefaultString("minecraft:grass")
        public String PositionItem;

        @Config.DefaultString("minecraft:command_block")
        public String TpsItem;

        @Config.DefaultString("AWWayofTime:weakBloodOrb")
        public String LpItem;

    }

    @Config.LangKey("minecraftimprovements.config.hud.hud_toggles.name")
    public static class HudEnabled {

        @Config.DefaultBoolean(true)
        public boolean FpsEnable;

        @Config.DefaultBoolean(true)
        public boolean MemoryEnable;

        @Config.DefaultBoolean(true)
        public boolean ServerMemoryEnable;

        @Config.DefaultBoolean(true)
        public boolean PingEnable;

        @Config.DefaultBoolean(true)
        public boolean PositionEnable;

        @Config.DefaultBoolean(true)
        public boolean TpsEnable;

        @Config.DefaultBoolean(true)
        public boolean LpEnable;
    }

}
