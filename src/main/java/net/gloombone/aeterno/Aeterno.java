package net.gloombone.aeterno;

import net.gloombone.aeterno.blocks.BlockTownPortal;
import net.gloombone.aeterno.blocks.BlockTownPortalColumn;
import net.gloombone.aeterno.blocks.BlockTownPortalColumnTop;
import net.gloombone.aeterno.blocks.BlockTownPortalControls;
import net.gloombone.aeterno.blocks.BlockTownPortalFoundation;
import net.gloombone.aeterno.items.ItemPortalKey;
import net.gloombone.aeterno.proxy.*;
import net.gloombone.aeterno.tileentities.TileEntityTownPortal;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Aeterno.MODID, version = Aeterno.VERSION)
public class Aeterno {
	public static final String MODID = "aeterno";
	public static final String VERSION = "pre-alpha 1.7.2-0.1";
	
	public static Block blockTownPortal;
	public static Block blockTownPortalFoundation;
	public static Block blockTownPortalColumn;
	public static Block blockTownPortalColumnTop;
	public static Block blockTownPortalControls;
	
	public static Item itemPortalKey;
	
	public static boolean debug; 
	
	@SidedProxy(clientSide="net.gloombone.aeterno.proxy.ClientProxy", serverSide="net.gloombone.aeterno.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs aeternoTab = new CreativeTabs("aeternoTab"){
		public Item getTabIconItem() {
			return Items.clock;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		debug = false;
		itemPortalKey = new ItemPortalKey().setUnlocalizedName("itemPortalKey").setCreativeTab(aeternoTab).setTextureName(MODID + ":itemPortalKey");
		GameRegistry.registerItem(itemPortalKey, "itemPortalKey");
		
		blockTownPortal = new BlockTownPortal()
			.setBlockName("blockTownPortal")
			.setCreativeTab(aeternoTab)
			.setBlockTextureName(MODID + ":blockTownPortal");

		blockTownPortalFoundation = new BlockTownPortalFoundation()
			.setBlockName("blockTownPortalFoundation")
			.setCreativeTab(aeternoTab)
			.setBlockTextureName(MODID + ":blockTownPortalFoundation");
		
		// Columns
		blockTownPortalColumn = new BlockTownPortalColumn()
			.setBlockName("blockTownPortalColumn")
			.setCreativeTab(aeternoTab)
			.setBlockTextureName(MODID + ":blockTownPortalColumn");
		blockTownPortalColumnTop = new BlockTownPortalColumnTop()
			.setBlockName("blockTownPortalColumnTop")
			.setCreativeTab(aeternoTab)
			.setBlockTextureName(MODID + ":blockTownPortalColumnTop");

		blockTownPortalControls = new BlockTownPortalControls()
			.setBlockName("blockTownPortalControls")
			.setCreativeTab(aeternoTab)
			.setBlockTextureName(MODID + ":blockTownPortal");
			
		
		GameRegistry.registerBlock(blockTownPortal, "blockTownPortal");
		GameRegistry.registerBlock(blockTownPortalFoundation, "blockTownPortalFoundation");
		GameRegistry.registerBlock(blockTownPortalColumn, "blockTownPortalColumn");
		GameRegistry.registerBlock(blockTownPortalColumnTop, "blockTownPortalColumnTop");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		GameRegistry.registerTileEntity(TileEntityTownPortal.class, "townportal");
		
		proxy.registerProxies();
	}
}
