package MinecraftImprovements.Hud;

import MinecraftImprovements.Configs.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Hud.Core.InfoLines.InfoFPS;
import MinecraftImprovements.Hud.Core.InfoLines.InfoMemory;
import MinecraftImprovements.Hud.Core.InfoLines.InfoPing;
import MinecraftImprovements.Hud.Core.InfoLines.InfoPosition;
import MinecraftImprovements.Hud.Core.InfoLines.InfoTPS;
import MinecraftImprovements.Hud.Event.JoinWorldEvent;
import MinecraftImprovements.Hud.Event.TickListener;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class Hud {

    public static List<InfoLine> lines = new ArrayList<>();

    public static void initEvent() {
        FMLCommonHandler.instance().bus().register(new TickListener());
        MinecraftForge.EVENT_BUS.register(new JoinWorldEvent());
    }

    public static void initLines() {
        lines.clear();

        lines.add(new InfoMemory(HudConfig.hudOrder.memoryOrder, false));
        lines.add(new InfoMemory(HudConfig.hudOrder.memoryOrder, true));
        lines.add(new InfoPing(HudConfig.hudOrder.pingOrder));
        lines.add(new InfoTPS(HudConfig.hudOrder.tpsOrder));
        lines.add(new InfoPosition(HudConfig.hudOrder.positionOrder));
        lines.add(new InfoFPS(HudConfig.hudOrder.fpsOrder));
    }
}
