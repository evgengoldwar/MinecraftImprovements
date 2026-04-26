package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Mixins.Early.MinecraftAccessor;

public class InfoFPS extends InfoLine {

    public InfoFPS(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return tr("info_fps", playerMP.getDisplayName(), ((MinecraftAccessor) this.mc).getFps());
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.FpsItem;
    }

    @Override
    public boolean canRender() {
        return HudConfig.hudEnabled.FpsEnable;
    }
}
