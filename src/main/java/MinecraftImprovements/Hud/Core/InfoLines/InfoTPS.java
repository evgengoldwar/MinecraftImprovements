package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Hud.Core.DataStorage;
import MinecraftImprovements.Hud.Core.InfoLine;

public class InfoTPS extends InfoLine {

    public InfoTPS(int order) {
        super(order);
    }

    @Override
    public boolean canRender() {
        return DataStorage.tps != -1;
    }

    @Override
    public String getLineString() {
        return String.format("Server %s", getTPS());
    }

    public static String getTPS() {
        return String.format(
            "TPS: %s%s §r(MSPT: %s%s§r)",
            DataStorage.getTPSColor(),
            DataStorage.tps,
            DataStorage.getMSPTColor(),
            DataStorage.mspt);
    }
}
