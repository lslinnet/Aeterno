package net.gloombone.aeterno;

import cpw.mods.fml.common.FMLCommonHandler;
import net.gloombone.aeterno.handler.ConfigurationHandler;
import net.gloombone.aeterno.init.ModBlocks;
import net.gloombone.aeterno.init.ModItems;
import net.gloombone.aeterno.proxy.*;
import net.gloombone.aeterno.reference.Reference;
import net.gloombone.aeterno.tileentities.TileEntityTownPortal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Aeterno {

	public static boolean debug; 
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	public static CreativeTabs aeternoTab = new CreativeTabs("aeternoTab"){
		public Item getTabIconItem() {
			return Items.clock;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		debug = false;
        // Configuration handling
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());

        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();

        ModBlocks.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		GameRegistry.registerTileEntity(TileEntityTownPortal.class, "townportal");
		
		proxy.registerTileEntities();
	}
}
