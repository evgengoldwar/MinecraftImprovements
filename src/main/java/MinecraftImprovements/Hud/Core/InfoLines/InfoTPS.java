package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Hud.Core.DataStorage;
import MinecraftImprovements.Hud.Core.InfoLine;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class InfoTPS extends InfoLine {

    public InfoTPS(int order) {
        super(order);
    }

    @Override
    public boolean canRender() {
        return DataStorage.tps != -1;
    }

    @Override
    public String getLineString() {
        return String.format("%s", getTPS());
    }

    public static String getTPS() {
        return String.format(
            "TPS: %s%s §rMSPT: %s%s",
            DataStorage.getTPSColor(),
            DataStorage.tps,
            DataStorage.getMSPTColor(),
            DataStorage.mspt);
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(Blocks.command_block);
    }
}
