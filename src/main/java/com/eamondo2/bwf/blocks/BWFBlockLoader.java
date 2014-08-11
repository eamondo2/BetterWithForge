package com.eamondo2.bwf.blocks;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

/**
 * Created by eamon_000 on 8/5/2014.
 */
public class BWFBlockLoader {
	public static BWFBlockMillStone millstone = new BWFBlockMillStone(Material.rock);

	public static void initPhase() {
		Blocks.dirt.setHarvestLevel("shovel", 0);
		GameRegistry.registerBlock(millstone, "blockMillstone");


	}
}
