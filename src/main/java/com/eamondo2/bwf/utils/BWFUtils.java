package com.eamondo2.bwf.utils;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.Set;

/**
 * Created by eamon_000 on 8/6/2014.
 */
public class BWFUtils {
	public static boolean TestHarvestEvent(EntityPlayer e, Block b, int blockMetaData) {
		Boolean isPlayer = false;
		Boolean correctTool = false;
	    /* This needs to have several stages
        1, determine if a player broke the block.
        2, determine what toolClass was used to do the breaking
        3, compare to the toolClass for the block that was broken
        4, either drop the normal drops or drop piles
         */

		EntityPlayer p = null;
		if (e == null) {
			isPlayer = false;
		} else {
			p = e;
			isPlayer = true;
		}

		ItemStack inHand = null;
		String blockToolClass = "";
		if (b.getHarvestTool(blockMetaData) != null) {
			blockToolClass = b.getHarvestTool(blockMetaData);
		}
		Set<String> inHandToolClasses = null;
		if (isPlayer) {
			if (p.getHeldItem() != null) {
				inHand = p.getHeldItem();
				if (inHand.getItem().getToolClasses(inHand) != null) {
					inHandToolClasses = inHand.getItem().getToolClasses(inHand);
				}

			}
		}
		String inHandToolClass = "";
		if (inHand != null && inHand.getItem().getToolClasses(inHand) != null) {
			for (String s : inHandToolClasses) {
				inHandToolClass = s;
				System.out.println(s);
			}
		}
		System.out.println(blockToolClass);
		//Determine if correct tool
		if (inHandToolClass.equalsIgnoreCase(blockToolClass)) {
			correctTool = true;
		} else {
			correctTool = false;
		}

		return correctTool;
	}

}
