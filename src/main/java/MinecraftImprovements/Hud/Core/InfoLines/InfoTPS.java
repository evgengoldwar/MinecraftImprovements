package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HUD.HudConfig;
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
        return String.format("%s", getTPS());
    }

    public static String getTPS() {
        return String.format(
            "TPS: %s%s §rMSPT: %s%s",
            DataStorage.getTPSColor(),
            DataStorage.tps,
            DataStorage.getMSPTColor(),
            DataStorage.mspt);
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.tpsItem;
    }
}
