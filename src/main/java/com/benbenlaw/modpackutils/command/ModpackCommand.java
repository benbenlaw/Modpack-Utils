package com.benbenlaw.modpackutils.command;

import com.benbenlaw.modpackutils.config.MUConfig;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ModpackCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("modpack").executes(ModpackCommand::execute));
    }

    private static int execute(CommandContext<CommandSourceStack> command) {
        if (command.getSource().getEntity() instanceof Player player) {

            if (!MUConfig.modpackName.get().isEmpty() && !MUConfig.modpackVersion.get().isEmpty()) {
                player.sendSystemMessage(Component.translatable("chat.modpackutils.modpack", MUConfig.modpackName.get(), MUConfig.modpackVersion.get())
                        .withStyle(ChatFormatting.BLUE));
            } else {
                player.sendSystemMessage(Component.translatable("chat.modpackutils.modpack_not_set")
                        .withStyle(ChatFormatting.RED));
            }
        }
        return Command.SINGLE_SUCCESS;
    }
}