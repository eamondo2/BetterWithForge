package com.eamondo2.bwf.tile;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by eamon_000 on 8/10/2014.
 */
public class BWFTileEntityLoader {
	public static void initPhase() {
		GameRegistry.registerTileEntity(BWFTileEntityMillstone.class, "test");

	}

}
