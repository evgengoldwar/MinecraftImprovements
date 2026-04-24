package MinecraftImprovements.Configs;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.util.EnumChatFormatting;

public class ConfigEntry {

    public static class HudCategory extends GuiConfigEntries.CategoryEntry {
        public HudCategory(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
            super(owningScreen, owningEntryList, configElement);

            this.btnSelectCategory.displayString = EnumChatFormatting.GOLD + "HUD";
        }
    }

    public static class HudOrderCategory extends GuiConfigEntries.CategoryEntry {
        public HudOrderCategory(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
            super(owningScreen, owningEntryList, configElement);

            this.btnSelectCategory.displayString = EnumChatFormatting.GREEN + "HUD Order";
        }
    }
}
