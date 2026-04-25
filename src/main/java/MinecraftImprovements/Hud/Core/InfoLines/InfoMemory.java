package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HUD.HudConfig;
import MinecraftImprovements.Hud.Core.DataStorage;
import MinecraftImprovements.Hud.Core.InfoLine;

public class InfoMemory extends InfoLine {

    private final boolean isServer;

    public InfoMemory(int order, boolean server) {
        super(order);
        isServer = server;
    }

    @Override
    public boolean canRender() {
        return !(isServer && DataStorage.serverMemUsed == -1);
    }

    @Override
    public String getLineString() {
        return String
            .format("%sMem: %s", this.isServer ? "Server " : "", this.isServer ? getServerMemory() : getMemory());
    }

    public static String getMemory() {
        Runtime runtime = Runtime.getRuntime();

        int mb = 1048576;
        String used = (runtime.totalMemory() - runtime.freeMemory()) / (long) mb + "MB / "
            + runtime.totalMemory() / (long) mb
            + "MB";
        String max = runtime.maxMemory() / (long) mb + "MB";
        return String.format("%s | %s", used, max);
    }

    public static String getServerMemory() {
        return String.format(
            "%sMB / %sMB | %sMB",
            DataStorage.serverMemUsed,
            DataStorage.serverMemAllocated,
            DataStorage.serverMemMax);
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.memoryItem;
    }
}
