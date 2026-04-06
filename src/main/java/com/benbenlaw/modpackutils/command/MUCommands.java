package com.benbenlaw.modpackutils.command;

import com.benbenlaw.modpackutils.ModpackUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber(modid = ModpackUtils.MOD_ID)
public class MUCommands {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        DiscordCommand.register(event.getDispatcher());
        ModpackCommand.register(event.getDispatcher());
    }
}
