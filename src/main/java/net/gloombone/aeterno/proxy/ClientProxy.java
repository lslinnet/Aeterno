package net.gloombone.aeterno.proxy;

import net.gloombone.aeterno.proxy.renderer.tileentity.TileEntityRenderTownPortal;
import net.gloombone.aeterno.tileentities.TileEntityTownPortal;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerTileEntities() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTownPortal.class, new TileEntityRenderTownPortal());
    }
}
