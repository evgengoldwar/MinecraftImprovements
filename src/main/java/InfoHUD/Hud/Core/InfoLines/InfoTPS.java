package InfoHUD.Hud.Core.InfoLines;

import InfoHUD.Configs.HudConfig;
import InfoHUD.Hud.Core.DataStorage;
import InfoHUD.Hud.Core.InfoLine;

public class InfoTPS extends InfoLine {

    public InfoTPS(int order) {
        super(order);
    }

    @Override
    public boolean canRender() {
        return DataStorage.tps != -1 && HudConfig.hudEnabled.TpsEnable;
    }

    @Override
    public String getLineString() {
        return tr("info_tps", DataStorage.getTPSColor(), DataStorage.tps, DataStorage.getMSPTColor(), DataStorage.mspt);
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.TpsItem;
    }
}
