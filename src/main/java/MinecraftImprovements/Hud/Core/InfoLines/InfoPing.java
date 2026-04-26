package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HudConfig;
import MinecraftImprovements.Hud.Core.DataStorage;
import MinecraftImprovements.Hud.Core.InfoLine;

public class InfoPing extends InfoLine {

    public InfoPing(int order) {
        super(order);
    }

    @Override
    public boolean canRender() {
        return !mc.isSingleplayer() && HudConfig.hudEnabled.PingEnable;
    }

    @Override
    public String getLineString() {
        return String.format("Ping: %s ms", DataStorage.ping);
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.PingItem;
    }
}
