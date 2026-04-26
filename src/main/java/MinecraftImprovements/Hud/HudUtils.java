package MinecraftImprovements.Hud;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class HudUtils {

    public static final String BLOOD_MAGIC_ID = "AWWayofTime";

    private static NBTTagCompound getPersistentDataTag(EntityPlayer player) {
        NBTTagCompound forgeData = player.getEntityData()
            .getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
        return forgeData.getCompoundTag("BloodMagic");
    }

    public static int getPlayerLPTag(EntityPlayer player) {
        NBTTagCompound data = getPersistentDataTag(player);
        if (data.hasKey("BM:StoredLP")) {
            return data.getInteger("BM:StoredLP");
        }

        return 0;
    }

    public static int getPlayerMaxLPTag(EntityPlayer player) {
        NBTTagCompound data = getPersistentDataTag(player);
        if (data.hasKey("BM:MaxStoredLP")) {
            return data.getInteger("BM:MaxStoredLP");
        }

        return 0;
    }
}
