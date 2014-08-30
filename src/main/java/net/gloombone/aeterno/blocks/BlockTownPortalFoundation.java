package net.gloombone.aeterno.blocks;

import net.gloombone.aeterno.Aeterno;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockTownPortalFoundation extends BlockTownPortalBase {

	public BlockTownPortalFoundation() {
		super(Material.rock);
		
		this.setBlockBounds(0, 0, 0, 1, .5F, 1);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighorblock) {
//		updateMultiBlockStructure(world, x, y, z);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		//clearDebugBlocks(world, x, y, z);
		updateMultiBlockStructure(world, x, y, z);
	}
	
	public void updateMultiBlockStructure(World world, int x, int y, int z) {
		isMultiBlockStructure(world, x, y, z);
	}
	
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
	@Override
    public boolean canPlaceBlockAt(World world, int x1, int y1, int z1) {
    	// Do not allow placement next to formed structures
    	// Should not allow next to 3 of the same kind either.
    	for (int x2 = -1; x2 == 1; x2 += 2) {
			for (int z2 = -1; z2 == 1; z2 += 2) {
				if (world.getBlock(x1+x2, y1, z1+z2).equals(Aeterno.blockTownPortalFoundation) &&
						world.getBlockMetadata(x1+x2, y1, z1+z2) != 0) {
					// We found a block which is already in a multiblock structure in the area
					// do not allow placement next to it.
					
					return false;
				}
			}
		}
        return super.canPlaceBlockAt(world, x1, y1, z1);
    }
	
	public boolean isMultiBlockStructure(World world, int x1, int y1, int z1) {
		
		boolean isFormed = false;
		boolean currentStructure = true;
		
		System.out.println("---------- NEW ----------");
		
		// Figure out the center of the block and based on that
		// verify the structure of the structure
		
		
		int moveX = 0;
		int lastX = x1;
		int moveZ = 0;
		int lastY = y1;
		int visited = 0;
		int blocksFound = 0;
		
		for (int i = 0; i < 5; i++) {
			moveX = (i % 2 == 1) ? (int)Math.ceil((i+1)/2) * -1 : 0 + (int)((i+1)/2);
			System.out.println((x1 + moveX) + " : " + lastX + " : " + Math.abs((x1 + moveX)-(lastX)));

			if (world.getBlock(x1+moveX, y1, z1).equals(Aeterno.blockTownPortalFoundation) ) {
				visited++;
				world.setBlock(x1+moveX, y1+7, z1, Blocks.wool, 13, 2);
				blocksFound++;
				for (int j = 0; j < 4; j++) {
					moveZ = (j % 2 == 1) ? (int)Math.ceil((j+2)/2) * -1 : 0 + (int)((j+2)/2);
					if (world.getBlock(x1+moveX, y1, z1+moveZ).equals(Aeterno.blockTownPortalFoundation)) {
						world.setBlock(x1+moveX, y1+7, z1+moveZ, Blocks.wool, 14, 2);
						blocksFound++;
					}
					visited++;
				}
			}
			lastX = x1 + moveX;

		}
		System.out.println("Visited: " + visited);
		/*
		// Search z axis +/-2 blocks
		// offsetX
		for (int oX = -2; oX < 3; oX++) {
			// offsetZ
			System.out.print("Working with oX:oZ [ ");
			for (int oZ = -2; oZ < 3; oZ++) {
				if (!isFormed) {
					System.out.print(oX + ":" + oZ + " ");
					for (int x2 = -1; x2 < 2; x2++) {
						for (int z2 = -1; z2 < 2; z2++) {
							if (x2 == 0 && z2 == 0) {
								continue;
							}
							if (currentStructure && !world.getBlock(x1+oX+x2, y1, z1+oZ+z2).equals(Aeterno.blockTownPortalFoundation)) {
								System.out.print("~failed here~");
								currentStructure = false;
							}
							
							if (Aeterno.debug) {
								//world.setBlock(x1+oX+x2, y1+11+oX+oZ, z1+oZ+z2, Blocks.glowstone);
							}
						}
					}
					if (Aeterno.debug) {
						//world.setBlock(x1+oX, y1+10+oX+oZ, z1+oZ, Blocks.emerald_ore);
					}
					isFormed = currentStructure;
				}
			}
			System.out.println("]");
		}
		*/
		

		
		System.out.println("Formed : " + isFormed);

		return false;
	}
	
	public void clearDebugBlocks(World world, int x1, int y1, int z1) {
		if (Aeterno.debug) {
			for (int x2 = -5; x2 < 6; x2++) {
				for (int z2 = -5; z2 < 6; z2++) {
					world.setBlock(x1+x2, y1+10, z1+z2, Blocks.air);
					world.setBlock(x1+x2, y1+11, z1+z2, Blocks.air);
				}
			}
			System.out.println("Airspace cleared");			
		}
	}
}
