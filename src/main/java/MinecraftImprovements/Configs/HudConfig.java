package MinecraftImprovements.Configs;

import static MinecraftImprovements.MinecraftImprovements.MODID;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config(
    modid = MODID,
    category = "hud",
    configSubDirectory = "Minecraft Improvements",
    filename = "Minecraft Improvements")
@Config.LangKey("minecraftimprovements.config.hud.name")
public class HudConfig {

    public static final HudGeneral hudGeneral = new HudGeneral();
    public static final HudOrder hudOrder = new HudOrder();
    public static final HudItems hudItems = new HudItems();
    public static final HudEnabled hudEnabled = new HudEnabled();


    @Config.LangKey("minecraftimprovements.config.hud.hud_general.name")
    public static class HudGeneral {

        @Config.DefaultInt(0)
        @Config.Order(2)
        public int HudX;

        @Config.DefaultInt(0)
        @Config.Order(2)
        public int HudY;

        @Config.DefaultFloat(1.0F)
        @Config.RangeFloat(min = 0.5F, max = 2.0F)
        @Config.Order(3)
        public float HudScale;
    }

    @Config.LangKey("minecraftimprovements.config.hud.hud_order.name")
    public static class HudOrder {

        @Config.DefaultInt(1)
        @Config.RangeInt(min = 1, max = 100)
        @Config.Order(1)
        public int FpsOrder;

        @Config.DefaultInt(4)
        @Config.RangeInt(min = 1, max = 100)
        @Config.Order(2)
        public int MemoryOrder;

        @Config.DefaultInt(5)
        @Config.RangeInt(min = 1, max = 100)
        @Config.Order(3)
        public int ServerMemoryOrder;

        @Config.DefaultInt(2)
        @Config.RangeInt(min = 1, max = 100)
        @Config.Order(4)
        public int PingOrder;

        @Config.DefaultInt(6)
        @Config.RangeInt(min = 1, max = 100)
        @Config.Order(5)
        public int PositionOrder;

        @Config.DefaultInt(3)
        @Config.RangeInt(min = 1, max = 100)
        @Config.Order(6)
        public int TpsOrder;

        @Config.DefaultInt(7)
        @Config.RangeInt(min = 1, max = 100)
        @Config.Order(7)
        public int LpOrder;

        @Config.DefaultInt(8)
        @Config.RangeInt(min = 1, max = 100)
        @Config.Order(8)
        public int WarpOrder;
    }

    @Config.LangKey("minecraftimprovements.config.hud.hud_icons.name")
    public static class HudItems {

        @Config.DefaultString("minecraft:clock")
        @Config.Order(1)
        public String FpsItem;

        @Config.DefaultString("minecraft:redstone")
        @Config.Order(2)
        public String MemoryItem;

        @Config.DefaultString("minecraft:redstone")
        @Config.Order(3)
        public String ServerMemoryItem;

        @Config.DefaultString("minecraft:stone")
        @Config.Order(4)
        public String PingItem;

        @Config.DefaultString("minecraft:grass")
        @Config.Order(5)
        public String PositionItem;

        @Config.DefaultString("minecraft:command_block")
        @Config.Order(6)
        public String TpsItem;

        @Config.DefaultString("AWWayofTime:weakBloodOrb")
        @Config.Order(7)
        public String LpItem;

        @Config.DefaultString("Thaumcraft:ItemEldritchObject")
        @Config.Order(8)
        public String WarpItem;

    }

    @Config.LangKey("minecraftimprovements.config.hud.hud_toggles.name")
    public static class HudEnabled {

        @Config.DefaultBoolean(true)
        @Config.Order(1)
        public boolean FpsEnable;

        @Config.DefaultBoolean(true)
        @Config.Order(2)
        public boolean MemoryEnable;

        @Config.DefaultBoolean(true)
        @Config.Order(3)
        public boolean ServerMemoryEnable;

        @Config.DefaultBoolean(true)
        @Config.Order(4)
        public boolean PingEnable;

        @Config.DefaultBoolean(true)
        @Config.Order(5)
        public boolean PositionEnable;

        @Config.DefaultBoolean(true)
        @Config.Order(6)
        public boolean TpsEnable;

        @Config.DefaultBoolean(true)
        @Config.Order(7)
        public boolean LpEnable;

        @Config.DefaultBoolean(true)
        @Config.Order(8)
        public boolean WarpEnable;
    }

}
