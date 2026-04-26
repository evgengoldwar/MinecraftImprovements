package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HUD.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;

public class InfoPosition extends InfoLine {

    public InfoPosition(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return String.format("Block: %s, %s, %s", getX(), getY(), getZ());
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.PositionItem;
    }

    @Override
    public boolean canRender() {
        return HudConfig.hudEnabled.PositionEnable;
    }
}
