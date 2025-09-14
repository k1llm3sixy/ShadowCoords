package com.k1llm3sixy.shadowcoords;

import com.k1llm3sixy.shadowcoords.commands.Commands;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShadowCoords implements ClientModInitializer {
    private static final String MOD_ID = "ShadowCoords";
    private static final Logger logger = LoggerFactory.getLogger(MOD_ID);
    private static final String nick = MinecraftClient.getInstance().getSession().getUsername();

    @Override
    public void onInitializeClient() {
        logger.info("Mod started! Have a good day " + nick);
        Commands.register();
    }
}