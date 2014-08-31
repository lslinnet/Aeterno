package net.gloombone.aeterno.blocks;

        import net.minecraft.block.Block;
        import net.minecraft.block.material.Material;

public class BlockPortalBase extends BlockAeterno {

    protected BlockPortalBase(Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setHardness(100.0F);
        this.setResistance(4000.0F);
        this.setStepSound(soundTypePiston);
    }

}
