package net.gloombone.aeterno.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.gloombone.aeterno.item.ItemAeterno;
import net.gloombone.aeterno.item.ItemPortalKey;
import net.gloombone.aeterno.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems {
    public static final ItemAeterno portalKey = new ItemPortalKey();

    public static void init() {
        portalKey.setUnlocalizedName("itemPortalKey").setTextureName(Reference.MODID + ":itemPortalKey");
        GameRegistry.registerItem(portalKey, "itemPortalKey");
    }
}
