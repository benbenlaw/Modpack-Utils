package com.benbenlaw.modpackutils.command;

import com.benbenlaw.modpackutils.config.MUConfig;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import dev.wuffs.bcc.BetterCompatibilityChecker;
import dev.wuffs.bcc.Config;
import dev.wuffs.bcc.data.BetterStatus;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.ModList;

public class ModpackCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("modpack").executes(ModpackCommand::execute));
    }

    private static int execute(CommandContext<CommandSourceStack> command) {
        if (command.getSource().getEntity() instanceof Player player) {

            String modpackName = MUConfig.modpackName.get();
            String modpackVersion = MUConfig.modpackVersion.get();

            if (ModList.get().isLoaded("bcc")) {
                if (MUConfig.modpackName.get().equals("USE_BCC")) {
                    modpackName = Config.data().modpackName().value();
                }
                if (MUConfig.modpackVersion.get().equals("USE_BCC")) {
                    modpackVersion = Config.data().modpackVersion().value();
                }
            }

            if (!MUConfig.modpackName.get().isEmpty() && !MUConfig.modpackVersion.get().isEmpty()) {
                player.sendSystemMessage(Component.translatable("chat.modpackutils.modpack", modpackName, modpackVersion)
                        .withStyle(ChatFormatting.BLUE));
            } else {
                player.sendSystemMessage(Component.translatable("chat.modpackutils.modpack_not_set")
                        .withStyle(ChatFormatting.RED));
            }
        }
        return Command.SINGLE_SUCCESS;
    }
}