package MinecraftImprovements.Hud.Event;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import MinecraftImprovements.Hud.Core.DataStorage;
import MinecraftImprovements.Hud.Hud;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class JoinWorldEvent {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayer) {
            DataStorage.resetTPS();
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onEntityJoinWorldClient(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityClientPlayerMP) {
            Hud.initLines();
        }
    }
}
