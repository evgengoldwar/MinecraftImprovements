package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HudConfig;
import MinecraftImprovements.Hud.Core.DataStorage;
import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Hud.HudUtils;

public class InfoSlimeChunk extends InfoLine {

    public InfoSlimeChunk(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return tr("info_slimechunk");
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.SlimeChunkItem;
    }

    @Override
    public boolean canRender() {
        return HudConfig.hudEnabled.SlimeChunkEnable && HudUtils.isSlimeChunk(
            DataStorage.worldSeed == -1 ? mc.getIntegratedServer().worldServers[0].getSeed() : DataStorage.worldSeed,
            playerMP,
            world);
    }
}
