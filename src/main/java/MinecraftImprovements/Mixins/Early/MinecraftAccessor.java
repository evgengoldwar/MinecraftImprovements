package MinecraftImprovements.Mixins.Early;

import net.minecraft.client.Minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = Minecraft.class)
public interface MinecraftAccessor {

    @Accessor("debugFPS")
    int getFps();
}
