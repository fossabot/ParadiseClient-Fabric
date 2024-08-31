package io.github.spigotrce.paradiseclientfabric.command.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import io.github.spigotrce.paradiseclientfabric.Helper;
import io.github.spigotrce.paradiseclientfabric.ParadiseClient_Fabric;
import io.github.spigotrce.paradiseclientfabric.command.Command;
import net.minecraft.client.MinecraftClient;

/**
 * Represents a command that toggles the display of server IP on the HUD.
 *
 * @author SpigotRCE
 * @since 1.4
 */
public class ScreenShareCommand extends Command {

    /**
     * Constructs a new instance of {@link ScreenShareCommand}.
     *
     * @param minecraftClient The Minecraft client instance.
     */
    public ScreenShareCommand(MinecraftClient minecraftClient) {
        super("paradisescreenshare", "Toggles IP displayed on HUD", minecraftClient);
    }

    /**
     * Builds the command structure using Brigadier's {@link LiteralArgumentBuilder}.
     *
     * @return The built command structure.
     */
    @Override
    public LiteralArgumentBuilder<FabricClientCommandSource> build() {
        return literal(getName()).executes((context -> {
            ParadiseClient_Fabric.getHudMod().showServerIP = !ParadiseClient_Fabric.getHudMod().showServerIP;
            Helper.printChatMessage(ParadiseClient_Fabric.getHudMod().showServerIP ? "Server IP shown" : "Server IP hidden");
            return SINGLE_SUCCESS;
        }));
    }
}
