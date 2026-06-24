package com.benbenlaw.modpackutils.event;

import com.benbenlaw.modpackutils.config.MUConfig;
import dev.wuffs.bcc.Config;
import net.neoforged.fml.CrashReportCallables;
import net.neoforged.fml.ModList;

public class ModpackCrashInformation {

    public static void register() {

        if (MUConfig.modpackName.get().isEmpty() || MUConfig.modpackVersion.get().isEmpty()) {
            return;
        }

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

        String finalModpackName = modpackName;
        String finalModpackVersion = modpackVersion;
        CrashReportCallables.registerCrashCallable("Modpack Information",
                () -> "This Crash is from " + finalModpackName + " " + finalModpackVersion);
    }
}