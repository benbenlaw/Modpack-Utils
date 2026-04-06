package com.benbenlaw.modpackutils.event;

import com.benbenlaw.modpackutils.config.MUConfig;
import net.neoforged.fml.CrashReportCallables;

public class ModpackCrashInformation {

    public static void register() {

        if (MUConfig.modpackName.get().isEmpty() || MUConfig.modpackVersion.get().isEmpty()) {
            return;
        }

        CrashReportCallables.registerCrashCallable("Modpack Information",
                () -> "This Crash is from " + MUConfig.modpackName.get() + " " + MUConfig.modpackVersion.get());
    }
}