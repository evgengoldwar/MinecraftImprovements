package MinecraftImprovements.Configs.HUD;

import net.minecraft.util.EnumChatFormatting;

import MinecraftImprovements.Hud.HudUtils;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.common.Loader;

public class HudEntry {

    public static class HudCategory extends GuiConfigEntries.CategoryEntry {

        public HudCategory(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
            super(owningScreen, owningEntryList, configElement);

            this.btnSelectCategory.displayString = EnumChatFormatting.GOLD + "HUD";
        }
    }

    public static class HudOrderCategory extends GuiConfigEntries.CategoryEntry {

        public HudOrderCategory(GuiConfig owningScreen, GuiConfigEntries owningEntryList,
            IConfigElement<?> configElement) {
            super(owningScreen, owningEntryList, configElement);

            this.btnSelectCategory.displayString = EnumChatFormatting.GREEN + "HUD Order";
        }
    }

    public static class HudItemsCategory extends GuiConfigEntries.CategoryEntry {

        public HudItemsCategory(GuiConfig owningScreen, GuiConfigEntries owningEntryList,
            IConfigElement<?> configElement) {
            super(owningScreen, owningEntryList, configElement);

            this.btnSelectCategory.displayString = EnumChatFormatting.GREEN + "HUD Items";
        }
    }

    public static class HudEnabledCategory extends GuiConfigEntries.CategoryEntry {

        public HudEnabledCategory(GuiConfig owningScreen, GuiConfigEntries owningEntryList,
            IConfigElement<?> configElement) {
            super(owningScreen, owningEntryList, configElement);

            this.btnSelectCategory.displayString = EnumChatFormatting.GREEN + "HUD Enabled";
        }
    }

    public static class HudBloodMagicMod extends GuiConfigEntries.CategoryEntry {

        public HudBloodMagicMod(GuiConfig owningScreen, GuiConfigEntries owningEntryList,
            IConfigElement<?> configElement) {
            super(owningScreen, owningEntryList, configElement);
            this.btnSelectCategory.displayString = EnumChatFormatting.GREEN + "HUD Blood Magic";
            this.btnSelectCategory.enabled = Loader.isModLoaded(HudUtils.BLOOD_MAGIC_ID);
        }
    }
}
