package com.eamondo2.bwf.recipes;

import com.eamondo2.bwf.items.BWFItemLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by eamon_000 on 8/6/2014.
 */
public class BWFRecipeLoader {


	public static void initPhase() {
		ItemStack pileDirtStack = new ItemStack(BWFItemLoader.pileDirt);
		ItemStack resDirt = new ItemStack(Blocks.dirt);
		GameRegistry.addShapedRecipe(resDirt, "xx", "xx", 'x', pileDirtStack);
		ItemStack pileGravelStack = new ItemStack(BWFItemLoader.pileGravel);
		ItemStack resGravel = new ItemStack(Blocks.gravel);
		GameRegistry.addShapedRecipe(resGravel, "xx", "xx", 'x', pileGravelStack);
		ItemStack pileSandStack = new ItemStack(BWFItemLoader.pileSand);
		ItemStack resSand = new ItemStack(Blocks.sand);
		GameRegistry.addShapedRecipe(resSand, "xx", "xx", 'x', pileSandStack);
		ItemStack pileSoulStack = new ItemStack(BWFItemLoader.pileSoulSand);
		ItemStack resSoul = new ItemStack(Blocks.soul_sand);
		GameRegistry.addShapedRecipe(resSoul, "xx", "xx", 'x', pileSoulStack);

	}

}
