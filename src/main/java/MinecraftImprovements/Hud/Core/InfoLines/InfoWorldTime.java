package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Configs.HudConfig;
import MinecraftImprovements.Hud.Core.InfoLine;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class InfoWorldTime extends InfoLine {

    public InfoWorldTime(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        long totalTicks = world.getTotalWorldTime();
        long worldTime = world.getWorldTime();

        long totalSeconds = totalTicks / 20;
        long remainingSeconds = totalSeconds % 86_400;
        long totalHours = remainingSeconds / 3600;
        long totalMinutes = (remainingSeconds % 3600) / 60;
        long totalSecs = remainingSeconds % 60;

        long adjustedTime = (worldTime + 6_000) % 24_000;
        long hours = adjustedTime / 1_000;
        long minutes = ((adjustedTime % 1000) * 60) / 1000;

        boolean isNight = (worldTime % 24000) >= 13000;
        String nightSuffix = isNight ? " (" + EnumChatFormatting.DARK_GRAY + "Night" + EnumChatFormatting.RESET + ")" : "";

        if (totalHours > 0) {
            return tr("info_worldtime.2", totalHours, String.format("%02d:%02d", hours, minutes) , nightSuffix);
        } else if (totalMinutes > 0) {
            return tr("info_worldtime.1", totalMinutes, String.format("%02d:%02d", hours, minutes) , nightSuffix);
        } else {
            return tr("info_worldtime.0", totalSecs, String.format("%02d:%02d", hours, minutes) , nightSuffix);
        }
    }

    @Override
    public String getItemName() {
        return HudConfig.hudItems.WorldTimeItem;
    }

    @Override
    public boolean canRender() {
        return HudConfig.hudEnabled.WorldTimeEnable;
    }
}
