package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HUD.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Mixins.Early.MinecraftAccessor;

public class InfoFPS extends InfoLine {

    public InfoFPS(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return String.format("%s fps", ((MinecraftAccessor) this.mc).getFps());
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.fpsItem;
    }
}
