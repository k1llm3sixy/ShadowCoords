package com.k1llm3sixy.shadowcoords.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import static com.k1llm3sixy.shadowcoords.config.Config.toggle;

public class Commands {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, commandRegistryAccess) -> {
            commands(dispatcher);
        });
    }

    private static void commands(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(
                ClientCommandManager.literal("shadowcoords")
                        .then(
                                ClientCommandManager.literal("toggle")
                                        .executes(ctx -> {
                                                    toggle = !toggle;
                                                    ctx.getSource().sendFeedback(Text.literal("§1[§b§lShadowCoords§1] " + (toggle ? Text.translatable("toggle.on").getString() : Text.translatable("toggle.off").getString())));
                                                    return 1;
                                                }
                                        )
                        )
        );
    }
}