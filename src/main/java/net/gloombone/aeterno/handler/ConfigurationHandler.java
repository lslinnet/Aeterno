package net.gloombone.aeterno.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.gloombone.aeterno.reference.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean enableDebug = false;

    public static void init(File configFile) {

        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MODID)) {
            // Resync configs
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
//        Settings.Transmutation.useTemplateFile = configuration.getBoolean(Messages.Configuration.TRANSMUTATION_KNOWLEDGE_TEMPLATE, Messages.Configuration.CATEGORY_TRANSMUTATION, true, StatCollector.translateToLocal(Messages.Configuration.TRANSMUTATION_KNOWLEDGE_TEMPLATE_COMMENT), Messages.Configuration.TRANSMUTATION_KNOWLEDGE_TEMPLATE_LABEL);
        enableDebug = configuration.getBoolean("enableDebug", Configuration.CATEGORY_GENERAL, false, "Want to add additional debugging messages to the output log?");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
