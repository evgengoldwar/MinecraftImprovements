package MinecraftImprovements.Hud.Event;

import MinecraftImprovements.Hud.Core.DataStorage;
import MinecraftImprovements.Hud.Hud;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class JoinWorldEvent {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayer player) {

            if (player.worldObj.isRemote) {
                if (player instanceof EntityClientPlayerMP) {
                    DataStorage.resetTPS();
                    Hud.initLines();
                }
            } else {
                if (player instanceof EntityPlayerMP) {
                    DataStorage.resetTPS();
                    Hud.initLines();
                }
            }
        }
    }
}
