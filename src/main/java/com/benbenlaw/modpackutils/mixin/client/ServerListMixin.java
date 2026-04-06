package com.benbenlaw.modpackutils.mixin.client;

import com.benbenlaw.modpackutils.config.MUConfig;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerList.class)
public class ServerListMixin {

    @Inject(method = "load", at = @At("RETURN"))
    private void injectCustomServer(CallbackInfo ci) {

        if (!MUConfig.serverName.get().isEmpty() && !MUConfig.serverIP.get().isEmpty()) {

            ServerList serverList = (ServerList) (Object) this;
            List<ServerData> servers = ((ServerListAccessor) serverList).getServerList();

            String serverName = MUConfig.serverName.get();
            String serverIP = MUConfig.serverIP.get();

            servers.removeIf(server -> server.ip.equals(serverIP));
            ServerData customServer = new ServerData(serverName, serverIP, ServerData.Type.OTHER);
            servers.addFirst(customServer);
            serverList.save();
        }
    }
}

