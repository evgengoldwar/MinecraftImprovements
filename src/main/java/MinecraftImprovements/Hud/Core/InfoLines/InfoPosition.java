package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Hud.Core.InfoLine;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class InfoPosition extends InfoLine {

    public InfoPosition(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return String.format("Block: %s, %s, %s", getX(), getY(), getZ());
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(Blocks.grass);
    }
}
