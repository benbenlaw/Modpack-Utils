package com.benbenlaw.modpackutils.mixin.client;

import com.benbenlaw.modpackutils.config.MUConfig;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.LevelHeightAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ClientLevel.ClientLevelData.class)
public class HorizonHeightMixin {

    @Inject(method = "getHorizonHeight", at = @At("HEAD"), cancellable = true)
    public void getHorizonHeight(LevelHeightAccessor levelHeightAccessor, CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(MUConfig.horizonHeight.get());
    }
}
