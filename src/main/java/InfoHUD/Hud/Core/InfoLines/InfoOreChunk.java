package InfoHUD.Hud.Core.InfoLines;

import InfoHUD.Configs.HudConfig;
import InfoHUD.Hud.Core.InfoLine;
import gregtech.common.GTWorldgenerator;

public class InfoOreChunk extends InfoLine {

    public InfoOreChunk(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        if (isOreChunk()) {
            return tr("info_orechunk");
        }

        return "";
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.OreChunkItem;
    }

    @Override
    public boolean canRender() {
        return HudConfig.hudEnabled.OreChunkEnable && isOreChunk();
    }

    private boolean isOreChunk() {
        try {
            int chunkX = getX() >> 4;
            int chunkZ = getZ() >> 4;

            if (GTWorldgenerator.oregenPattern == GTWorldgenerator.OregenPattern.EQUAL_SPACING) {
                return (chunkX % 3 == 1 || chunkX % 3 == -2) && (chunkZ % 3 == 1 || chunkZ % 3 == -2);
            }

            if (GTWorldgenerator.oregenPattern == GTWorldgenerator.OregenPattern.AXISSYMMETRICAL) {
                return (chunkX % 3 == -1 || chunkX % 3 == 1) && (chunkZ % 3 == -1 || chunkZ % 3 == 1);
            }
        } catch (Throwable ignored) {}
        return false;
    }
}
