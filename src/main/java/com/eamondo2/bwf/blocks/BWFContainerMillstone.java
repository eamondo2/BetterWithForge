package com.eamondo2.bwf.blocks;

import com.eamondo2.bwf.tile.BWFTileEntityMillstone;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * Created by eamon_000 on 8/14/2014.
 */
public class BWFContainerMillstone extends BWFContainer {
	protected BWFTileEntityMillstone teMill;

	public BWFContainerMillstone(InventoryPlayer playerInv, BWFTileEntityMillstone te) {
		this.teMill = te;


	}
}
