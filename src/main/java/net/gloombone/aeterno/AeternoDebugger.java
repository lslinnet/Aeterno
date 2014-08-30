package net.gloombone.aeterno;

import net.minecraft.block.Block;
import net.minecraft.world.World;


public class AeternoDebugger {
	public boolean debug = false;
	
	public AeternoDebugger() {
		
	}
	
	public void setBlock(World world, int x, int y, int z, Block block) {
		if (debug) {
			world.setBlock(x, y, z, block);
		}
	}
	
	public void log(String message) {
		if (debug) {
			System.out.println(message);	
		}
	}
}
