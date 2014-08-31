package net.gloombone.aeterno.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.gloombone.aeterno.blocks.*;
import net.gloombone.aeterno.reference.Reference;
import net.minecraft.block.Block;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks {

    public static final Block blockTownPortal = new BlockPortal();
    public static final Block blockTownPortalFoundation = new BlockPortalFoundation();
    public static final Block blockTownPortalColumn = new BlockPortalColumn();
    public static final Block blockTownPortalColumnTop = new BlockPortalColumnTop();
    public static final Block blockTownPortalControls = new BlockPortalControls();

    public static void init() {
        blockTownPortal.setBlockName("townPortal").setBlockTextureName(Reference.MODID + ":blockTownPortal");
        blockTownPortalFoundation.setBlockName("townPortalFoundation").setBlockTextureName(Reference.MODID + ":blockTownPortalFoundation");

        // Columns
        blockTownPortalColumn.setBlockName("townPortalColumn").setBlockTextureName(Reference.MODID + ":blockTownPortalColumn");
        blockTownPortalColumnTop.setBlockName("townPortalColumnTop").setBlockTextureName(Reference.MODID + ":blockTownPortalColumnTop");
        blockTownPortalControls.setBlockName("townPortalControls").setBlockTextureName(Reference.MODID + ":blockTownPortal");

        GameRegistry.registerBlock(blockTownPortal, "townPortal");
        GameRegistry.registerBlock(blockTownPortalFoundation, "townPortalFoundation");
        GameRegistry.registerBlock(blockTownPortalColumn, "townPortalColumn");
        GameRegistry.registerBlock(blockTownPortalColumnTop, "townPortalColumnTop");
    }
}
