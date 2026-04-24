package MinecraftImprovements.Hud.Core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public abstract class InfoLine {

    private final int order;
    public final Minecraft mc = Minecraft.getMinecraft();
    public final EntityClientPlayerMP playerMP = mc.thePlayer;

    public InfoLine(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public boolean canRender() {
        return true;
    }

    public String getLineString() {
        return "";
    }

    public int getX() {
        return MathHelper.floor_double(playerMP.posX);
    }

    public int getY() {
        return MathHelper.floor_double(playerMP.boundingBox.minY);
    }

    public int getZ() {
        return MathHelper.floor_double(playerMP.posZ);
    }

    public ItemStack getItemStack() {
        return null;
    }
}
