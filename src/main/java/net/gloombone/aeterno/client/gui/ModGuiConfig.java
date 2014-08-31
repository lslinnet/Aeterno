package net.gloombone.aeterno.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.gloombone.aeterno.handler.ConfigurationHandler;
import net.gloombone.aeterno.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import javax.security.auth.login.Configuration;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen guiScreen) {

        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MODID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString())
        );
    }
}
