package MinecraftImprovements.Hud;

import java.util.ArrayList;
import java.util.List;

import MinecraftImprovements.Hud.Core.InfoLines.InfoBiome;
import MinecraftImprovements.Hud.Core.InfoLines.InfoDimension;
import net.minecraftforge.common.MinecraftForge;

import MinecraftImprovements.Configs.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Hud.Core.InfoLines.InfoBloodMagic;
import MinecraftImprovements.Hud.Core.InfoLines.InfoFPS;
import MinecraftImprovements.Hud.Core.InfoLines.InfoMemory;
import MinecraftImprovements.Hud.Core.InfoLines.InfoPing;
import MinecraftImprovements.Hud.Core.InfoLines.InfoPosition;
import MinecraftImprovements.Hud.Core.InfoLines.InfoTPS;
import MinecraftImprovements.Hud.Core.InfoLines.InfoThaumcraft;
import MinecraftImprovements.Hud.Event.BloodMagicEvent;
import MinecraftImprovements.Hud.Event.JoinWorldEvent;
import MinecraftImprovements.Hud.Event.TickListener;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;

public class Hud {

    public static List<InfoLine> lines = new ArrayList<>();

    public static void initEvent() {
        FMLCommonHandler.instance()
            .bus()
            .register(new TickListener());
        MinecraftForge.EVENT_BUS.register(new JoinWorldEvent());

        if (Loader.isModLoaded(HudUtils.BLOOD_MAGIC_ID)) {
            MinecraftForge.EVENT_BUS.register(new BloodMagicEvent());
        }
    }

    public static void initLines() {
        lines.clear();

        lines.add(new InfoMemory(HudConfig.hudOrder.MemoryOrder, false));
        lines.add(new InfoMemory(HudConfig.hudOrder.ServerMemoryOrder, true));
        lines.add(new InfoPing(HudConfig.hudOrder.PingOrder));
        lines.add(new InfoTPS(HudConfig.hudOrder.TpsOrder));
        lines.add(new InfoPosition(HudConfig.hudOrder.PositionOrder));
        lines.add(new InfoFPS(HudConfig.hudOrder.FpsOrder));
        lines.add(new InfoDimension(HudConfig.hudOrder.DimensionOrder));
        lines.add(new InfoBiome(HudConfig.hudOrder.BiomeOrder));

        if (Loader.isModLoaded(HudUtils.BLOOD_MAGIC_ID)) {
            lines.add(new InfoBloodMagic(HudConfig.hudOrder.LpOrder));
        }

        if (Loader.isModLoaded(HudUtils.THAUMCRAFT_ID)) {
            lines.add(new InfoThaumcraft(HudConfig.hudOrder.WarpOrder));
        }
    }
}
