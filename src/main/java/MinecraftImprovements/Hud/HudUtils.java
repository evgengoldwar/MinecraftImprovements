package MinecraftImprovements.Hud;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;

import baubles.api.BaublesApi;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.lib.events.EventHandlerRunic;

public class HudUtils {

    public static final String BLOOD_MAGIC_ID = "AWWayofTime";
    public static final String THAUMCRAFT_ID = "Thaumcraft";

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

    public static int getWarpPerm(EntityPlayer player) {
        return Thaumcraft.proxy.getPlayerKnowledge()
            .getWarpPerm(player.getCommandSenderName());
    }

    public static int getWarpSticky(EntityPlayer player) {
        return Thaumcraft.proxy.getPlayerKnowledge()
            .getWarpSticky(player.getCommandSenderName());
    }

    public static int getWarpTemp(EntityPlayer player) {
        return Thaumcraft.proxy.getPlayerKnowledge()
            .getWarpTemp(player.getCommandSenderName());
    }

    public static int getWarpTotal(EntityPlayer player) {
        return Thaumcraft.proxy.getPlayerKnowledge()
            .getWarpTotal(player.getCommandSenderName()) + getWarpFromGear(player);
    }

    private static int getWarpFromGear(EntityPlayer player) {
        int w = EventHandlerRunic.getFinalWarp(player.getCurrentEquippedItem(), player);

        for (int a = 0; a < 4; ++a) {
            w += EventHandlerRunic.getFinalWarp(player.inventory.armorItemInSlot(a), player);
        }

        IInventory baubles = BaublesApi.getBaubles(player);

        for (int a = 0; a < 4; ++a) {
            w += EventHandlerRunic.getFinalWarp(baubles.getStackInSlot(a), player);
        }

        return w;
    }
}
