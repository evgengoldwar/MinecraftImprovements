package MinecraftImprovements.Mixins.Early;

import java.util.Comparator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraftforge.client.GuiIngameForge;

import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import MinecraftImprovements.Hud.Core.InfoLine;
import MinecraftImprovements.Hud.Hud;

@Mixin(value = GuiIngameForge.class)
public class GuiIngameMixin extends GuiIngame {

    @Shadow
    private FontRenderer fontrenderer;

    public GuiIngameMixin(Minecraft mc) {
        super(mc);
    }

    @Inject(
        method = "renderHUDText",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/settings/GameSettings;showDebugInfo:Z",
            shift = At.Shift.BEFORE))
    private void renderHud(int width, int height, CallbackInfo ci) {
        int hudY = 0;

        List<InfoLine> orderedLines = Hud.lines;

        orderedLines.sort(Comparator.comparingInt(InfoLine::getOrder));

        for (InfoLine line : orderedLines) {
            if (!line.canRender()) continue;
            drawHudInfo(line.getLineString(), 0, hudY);
            hudY += 11;
        }
    }

    @Unique
    private void drawHudInfo(String string, int x, int y) {
        GL11.glPushMatrix();
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        FontRenderer fr = mc.fontRenderer;
        fr.drawString(string, x + 4, y + 4, 14737632);
        GL11.glPopMatrix();
    }
}
