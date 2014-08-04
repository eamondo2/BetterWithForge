package com.eamondo2.bwf.com.eamondo2.bwf.items;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemLoader {
	static ArrayList<BWFItem> loadList = new ArrayList<BWFItem>();
	public static boolean addToItemList(BWFItem item){
		if (loadList.add(item)){
			return true;
		}



		return false;
	}
	public static void initPhase(){
		Item pileDirt = new BWFItempileDirt();
		GameRegistry.registerItem(pileDirt, "itemPileDirt");
		//iterate through array of items. auto-updated, hopefully
		Iterator iterator = loadList.iterator();

	}
}
