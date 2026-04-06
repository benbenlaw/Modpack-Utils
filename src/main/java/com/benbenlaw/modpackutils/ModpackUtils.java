package com.benbenlaw.modpackutils;


import com.benbenlaw.modpackutils.config.DimensionConfig;
import com.benbenlaw.modpackutils.config.MUConfig;
import com.benbenlaw.modpackutils.config.StartupConfig;
import com.benbenlaw.modpackutils.event.ModpackCrashInformation;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(ModpackUtils.MOD_ID)
public class ModpackUtils {
    public static final String MOD_ID = "modpackutils";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ModpackUtils(final IEventBus eventBus, final ModContainer modContainer) {

        //Configs
        modContainer.registerConfig(ModConfig.Type.STARTUP, StartupConfig.SPEC, "bbl/modpackutils/startup.toml");
        modContainer.registerConfig(ModConfig.Type.STARTUP, MUConfig.SPEC, "bbl/modpackutils/modpack.toml");
        modContainer.registerConfig(ModConfig.Type.STARTUP, DimensionConfig.SPEC, "bbl/modpackutils/dimensions.toml");

        //Modpack Crash Information
        ModpackCrashInformation.register();


    }
}
