package com.eamondo2.bwf.blocks;


import net.minecraft.init.Blocks;

/**
 * Created by eamon_000 on 8/5/2014.
 */
public class BlockLoader {
	public static void initPhase() {
		Blocks.dirt.setHarvestLevel("shovel", 0);
	}
}
