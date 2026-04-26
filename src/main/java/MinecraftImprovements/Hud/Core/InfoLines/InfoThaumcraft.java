package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HUD.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Hud.HudUtils;

public class InfoThaumcraft extends InfoLine {

    public InfoThaumcraft(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return "Warp: " + HudUtils.getWarpTotal(playerMP) + " (Perm: " + HudUtils.getWarpPerm(playerMP) + " | Sticky: " + HudUtils.getWarpTemp(playerMP) + " | Temp: " + HudUtils.getWarpTemp(playerMP) + ")";
    }

    @Override
    public boolean canRender() {
        return HudConfig.hudEnabled.WarpEnable;
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.WarpItem;
    }
}
