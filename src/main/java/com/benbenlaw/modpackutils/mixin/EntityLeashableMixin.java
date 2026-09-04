package com.benbenlaw.modpackutils.mixin;

import com.benbenlaw.modpackutils.util.MUTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Leashable;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityLeashableMixin implements Leashable {

    @Unique
    private Leashable.@Nullable LeashData benbenlaw$leashData;

    @Override
    public Leashable.@Nullable LeashData getLeashData() {
        return this.benbenlaw$leashData;
    }

    @Override
    public void setLeashData(Leashable.@Nullable LeashData leashData) {
        this.benbenlaw$leashData = leashData;
    }

    @Override
    public boolean canBeLeashed() {
        return ((Entity)(Object)this).is(MUTags.Entity.LEASHABLE);
    }

    @Inject(method = "saveWithoutId", at = @At("TAIL"))
    private void benbenlaw$saveLeash(ValueOutput output, CallbackInfo ci) {
        if (!(((Object)this) instanceof Mob)) {
            this.writeLeashData(output, this.benbenlaw$leashData);
        }
    }

    @Inject(method = "load", at = @At("TAIL"))
    private void benbenlaw$loadLeash(ValueInput input, CallbackInfo ci) {
        if (!(((Object)this) instanceof Mob)) {
            this.readLeashData(input);
        }
    }
}