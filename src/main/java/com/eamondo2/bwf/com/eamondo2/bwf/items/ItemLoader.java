package com.eamondo2.bwf.com.eamondo2.bwf.items;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemLoader {

	public static void initPhase(){

		//iterate through array of items. auto-updated, hopefully
		BWFItempileDirt pile = new BWFItempileDirt();
		GameRegistry.registerItem(pile, "itemPileDirt");
	}
}
