package com.eamondo2.bwf.items;


import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLoader {

	public static void initPhase() {


		BWFItempileDirt pile = new BWFItempileDirt();
		GameRegistry.registerItem(pile, "itemPileDirt");
	}
}
