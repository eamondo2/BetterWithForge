package com.eamondo2.bwf.items;

import com.eamondo2.bwf.BWFMain;

/**
 * Created by eamon_000 on 8/6/2014.
 */
public class BWFItemCrushedIron extends BWFItem {
	public BWFItemCrushedIron() {
		setMaxStackSize(64);
		setCreativeTab(BWFMain.modTab);
		setUnlocalizedName("itemCrushedIron");
		setTextureName("bwf:itemCrushedIronOre");

	}
}
