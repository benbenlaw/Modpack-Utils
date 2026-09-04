package com.benbenlaw.modpackutils.mixin;

import com.benbenlaw.modpackutils.util.MUTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MobLeashableMixin {
    @Inject(method = "canBeLeashed", at = @At("HEAD"), cancellable = true)
    private void benbenlaw$tagOverride(CallbackInfoReturnable<Boolean> cir) {
        if (((Entity)(Object)this).is(MUTags.Entity.LEASHABLE)) {
            cir.setReturnValue(true);
        }
    }
}