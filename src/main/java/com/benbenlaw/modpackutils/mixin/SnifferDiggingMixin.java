package com.benbenlaw.modpackutils.mixin;

import com.benbenlaw.modpackutils.config.MUConfig;
import com.benbenlaw.modpackutils.config.StartupConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.world.entity.animal.sniffer.SnifferAi$Digging")
public class SnifferDiggingMixin {

    @ModifyConstant(method = "stop", constant = @Constant(longValue = 9600L))
    private long benbenlaw$modifySniffingCooldown(long original) {
        return Long.parseLong(MUConfig.snifferCooldown.get());
    }
}