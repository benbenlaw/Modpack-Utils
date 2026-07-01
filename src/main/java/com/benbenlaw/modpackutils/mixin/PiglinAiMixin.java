package com.benbenlaw.modpackutils.mixin;

import com.benbenlaw.modpackutils.config.MUConfig;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.BaseFireBlock;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PiglinAi.class)
public class PiglinAiMixin {

    @Final
    @Shadow
    @Mutable
    public static Item BARTERING_ITEM;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void overrideBarteringItem(CallbackInfo ci) {
        BARTERING_ITEM = BuiltInRegistries.ITEM.getValue(Identifier.parse(MUConfig.piglinBarteringItem.get()));
    }
}
