package com.eamondo2.bwf.items;


import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLoader {
    public static BWFItempileDirt pileDirt = new BWFItempileDirt();

	public static void initPhase() {
		GameRegistry.registerItem(pileDirt, "itemPileDirt");
	}
}
