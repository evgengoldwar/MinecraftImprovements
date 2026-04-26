package MinecraftImprovements.Hud.Core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public abstract class InfoLine {

    private final int order;
    private ItemStack cachedStack = null;
    private String cachedItemName = null;
    public final Minecraft mc = Minecraft.getMinecraft();
    public final EntityClientPlayerMP playerMP = mc.thePlayer;
    public final World world = playerMP.worldObj;
    public final WorldProvider worldProvider = world.provider;

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

    public String getItemName() {
        return "";
    }

    public ItemStack getChachedItemStack() {
        String currentItemName = getItemName();

        if (currentItemName != null && currentItemName.equals(cachedItemName)) {
            return cachedStack;
        }

        cachedItemName = currentItemName;

        if (currentItemName == null || currentItemName.isEmpty()) {
            cachedStack = null;
            return null;
        }

        String[] parts = currentItemName.split("/");
        String registryName = parts[0];
        int meta = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;

        Item item = (Item) Item.itemRegistry.getObject(registryName);
        cachedStack = (item != null) ? new ItemStack(item, 1, meta) : null;

        return cachedStack;
    }

    public static String tr(String key, Object... params) {
        return StatCollector.translateToLocalFormatted("minecraftimprovements.hud.info_line." + key, params);
    }
}
