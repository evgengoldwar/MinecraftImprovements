package MinecraftImprovements.Hud.Core;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayerMP;

public class ServerDataStorage {

    public static final Set<UUID> tpsSubscribers = new HashSet<>();
    public static final Set<UUID> memSubscribers = new HashSet<>();

    public static void subscribeTPS(EntityPlayerMP player) {
        tpsSubscribers.add(player.getUniqueID());
    }

    public static void subscribeMem(EntityPlayerMP player) {
        memSubscribers.add(player.getUniqueID());
    }

    public static void unsubscribeAll(EntityPlayerMP player) {
        tpsSubscribers.remove(player.getUniqueID());
        memSubscribers.remove(player.getUniqueID());
    }
}
