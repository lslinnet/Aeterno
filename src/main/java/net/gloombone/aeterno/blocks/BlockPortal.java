package net.gloombone.aeterno.blocks;

import net.gloombone.aeterno.tileentities.TileEntityTownPortal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPortal extends BlockTileEntityAeterno {
	public BlockPortal() {
		// Should be changed to something more steady later on.
		super(Material.ground);
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityTownPortal();
	}
}
