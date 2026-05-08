package InfoHUD.Hud.Core.InfoLines;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import InfoHUD.Configs.HudConfig;
import InfoHUD.Hud.Core.InfoLine;

public class InfoCountItem extends InfoLine {

    public InfoCountItem(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        ItemStack heldItem = playerMP.getHeldItem();

        if (heldItem == null) {
            return "";
        }

        int count = 0;

        for (ItemStack stack : playerMP.inventory.mainInventory) {
            if (stack == null) {
                continue;
            }

            if (stack.getItem() == heldItem.getItem() && stack.getItemDamage() == heldItem.getItemDamage()) {
                count += stack.stackSize;
            }
        }

        return String.valueOf(count);
    }

    @Override
    public boolean canRender() {
        ItemStack heldItem = playerMP.getHeldItem();

        if (heldItem == null) return false;

        int count = 0;

        for (ItemStack stack : playerMP.inventory.mainInventory) {
            if (stack == null) {
                continue;
            }

            if (stack.getItem() == heldItem.getItem() && stack.getItemDamage() == heldItem.getItemDamage()) {
                count++;
            }
        }

        return count > 1 && HudConfig.hudEnabled.CountItemEnable;
    }
}
