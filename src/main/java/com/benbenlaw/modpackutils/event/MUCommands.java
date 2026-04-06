package com.benbenlaw.modpackutils.event;

import com.benbenlaw.modpackutils.ModpackUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@EventBusSubscriber(modid = ModpackUtils.MOD_ID)
public class MUCommands {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        ConfigCommand.register(event.getDispatcher());
    }
}
