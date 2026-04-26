package MinecraftImprovements.Mixins.Early;

import MinecraftImprovements.Configs.GeneralConfig;
import net.minecraft.client.renderer.InventoryEffectRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryEffectRenderer.class)
public class InventoryEffectRendererMixin {

    @Inject(method = "func_147044_g", at = @At("HEAD"), cancellable = true)
    private void cancelPotionEffectRendering(CallbackInfo ci) {
        if (GeneralConfig.DisablePotionEffect) {
            ci.cancel();
        }
    }
}
