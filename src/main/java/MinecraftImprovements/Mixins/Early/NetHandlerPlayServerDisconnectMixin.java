package MinecraftImprovements.Mixins.Early;

import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.IChatComponent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import MinecraftImprovements.Hud.Core.ServerDataStorage;

@Mixin(NetHandlerPlayServer.class)
public class NetHandlerPlayServerDisconnectMixin {

    @Inject(method = "onDisconnect", at = @At("HEAD"))
    public void onPlayerDisconnect(IChatComponent reason, CallbackInfo ci) {
        NetHandlerPlayServer handler = (NetHandlerPlayServer) (Object) this;
        ServerDataStorage.unsubscribeAll(handler.playerEntity);
    }
}
