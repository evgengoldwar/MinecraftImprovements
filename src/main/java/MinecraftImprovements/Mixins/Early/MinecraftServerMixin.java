package MinecraftImprovements.Mixins.Early;

import net.minecraft.server.MinecraftServer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import MinecraftImprovements.Hud.Core.TPSSender;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    public void onServerTick(CallbackInfo ci) {
        TPSSender.onServerTick((MinecraftServer) (Object) this);
    }
}
