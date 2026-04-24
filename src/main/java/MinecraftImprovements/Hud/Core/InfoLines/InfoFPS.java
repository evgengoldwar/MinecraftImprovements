package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Mixins.Early.MinecraftAccessor;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class InfoFPS extends InfoLine {

    public InfoFPS(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return String.format("%s fps", ((MinecraftAccessor) this.mc).getFps());
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(Items.clock);
    }
}
