package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HUD.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Hud.Event.BloodMagicEvent;
import MinecraftImprovements.Hud.HudUtils;

public class InfoBloodMagic extends InfoLine {

    public InfoBloodMagic(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return "LP: " + getCurrentLP() + " / " + getMaxLP();
    }

    private String getCurrentLP() {
        return String.format("%,d", HudUtils.getPlayerLPTag(playerMP));
    }

    private String getMaxLP() {
        return String.format(
            "%,d",
            Math.max(HudUtils.getPlayerMaxLPTag(playerMP), BloodMagicEvent.getMaxLP(playerMP.getDisplayName())));
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.LpItem;
    }

    @Override
    public boolean canRender() {
        return HudConfig.hudEnabled.LpEnable;
    }
}
