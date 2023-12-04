package de.chloedev.noframeratelimit.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Shadow
    @Final
    private Window window;

    @Inject(method = "getFramerateLimit", at = @At(value = "HEAD"), cancellable = true)
    public void removeTitleFramerateLimit(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(this.window.getFramerateLimit());
    }
}
