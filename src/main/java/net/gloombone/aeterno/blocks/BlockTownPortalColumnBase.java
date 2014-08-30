package net.gloombone.aeterno.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockTownPortalColumnBase extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon upIcon;

	public BlockTownPortalColumnBase() {
		super(Material.glass);
		this.setHardness(0.3F);
		this.setStepSound(soundTypeGlass);
		this.setLightLevel(0.35F);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side != 1 && side != 0 ? this.blockIcon : this.upIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.blockIcon = registry.registerIcon(this.getTextureName() + "Side");
		this.upIcon = registry.registerIcon(this.getTextureName() + "Up");
	}
}
