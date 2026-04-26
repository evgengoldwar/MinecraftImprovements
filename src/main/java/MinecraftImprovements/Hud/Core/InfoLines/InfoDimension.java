package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;

public class InfoDimension extends InfoLine {

    public InfoDimension(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return tr("info_dimension", worldProvider.getDimensionName(), worldProvider.dimensionId);
    }

    @Override
    public boolean canRender() {
        return HudConfig.hudEnabled.DimensionEnable;
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.DimensionItem;
    }
}
