package MinecraftImprovements.Hud.Core.InfoLines;

import static MinecraftImprovements.Hud.HudUtils.getWarpPerm;
import static MinecraftImprovements.Hud.HudUtils.getWarpSticky;
import static MinecraftImprovements.Hud.HudUtils.getWarpTemp;
import static MinecraftImprovements.Hud.HudUtils.getWarpTotal;

import MinecraftImprovements.Configs.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;

public class InfoThaumcraft extends InfoLine {

    public InfoThaumcraft(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return tr(
            "info_warp",
            getWarpTotal(playerMP),
            getWarpPerm(playerMP),
            getWarpSticky(playerMP),
            getWarpTemp(playerMP));
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
