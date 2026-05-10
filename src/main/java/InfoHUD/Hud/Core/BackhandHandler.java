package InfoHUD.Hud.Core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import xonin.backhand.api.core.BackhandUtils;

public class BackhandHandler {

    public static boolean isLoaded() {
        return Loader.isModLoaded("backhand");
    }

    public static ItemStack getBackHandItemStack(EntityPlayer player) {
        if (!isLoaded()) return null;

        return BackhandUtils.getOffhandItem(player);
    }
}
