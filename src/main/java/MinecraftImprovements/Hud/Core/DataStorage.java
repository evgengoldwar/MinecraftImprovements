package MinecraftImprovements.Hud.Core;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

public class DataStorage {

    public static double tps = -1;
    public static double mspt = -1;
    public static int ping = 0;
    public static int serverMemUsed = -1;
    public static int serverMemAllocated = -1;
    public static int serverMemMax = -1;

    public static void getClientTPS() {
        try {
            long[] tickTimes = Minecraft.getMinecraft()
                .getIntegratedServer().tickTimeArray;
            mspt = round(MathHelper.average(tickTimes) * 1.0E-6D);
            tps = round(1000.0D / mspt);

            if (tps > 20.0) {
                tps = 20.0;
            }
        } catch (NumberFormatException ignored) {}
    }

    public static String getTPSColor() {
        return (tps < 20) ? "§c" : "§a";
    }

    public static String getMSPTColor() {
        return (mspt < 40) ? "§a" : (mspt < 45) ? "§e" : (mspt < 50) ? "§6" : "§c";
    }

    private static double round(double value) {
        return (new BigDecimal(value)).setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
    }

    public static void resetTPS() {
        tps = -1;
        mspt = -1;
    }
}
