package com.eamondo2.bwf.blocks;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by eamon_000 on 8/14/2014.
 */
public class BWFContainer extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return false;
	}
}
