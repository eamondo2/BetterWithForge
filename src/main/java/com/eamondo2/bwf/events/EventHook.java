package com.eamondo2.bwf.events;

import com.eamondo2.bwf.items.ItemLoader;
import com.eamondo2.bwf.utils.BWFUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;


public class EventHook {

	@SubscribeEvent
	public void Onblockbroken(BlockEvent.BreakEvent e) {
		System.out.println("SHIT");


	}

	@SubscribeEvent
	public void blockHarvestEvent(BlockEvent.HarvestDropsEvent e) {
		System.out.println("Harvest Event Called");
		Boolean isPlayer = false;
		Boolean correctTool = BWFUtils.TestHarvestEvent(e.harvester, e.block, e.blockMetadata);
		Block b = e.block;


		//now that we have both strings to compare against, make a method to drop the appropriate item
		if (correctTool) {
			//drop teh orig block
			System.out.println("CORRECT");
		} else {
			System.out.println("FALSE");
			//don't
			e.drops.clear();
			//insert logic for determining block type, and the appropriate pile to drop
			if (b.equals(Blocks.dirt) || b.equals(Blocks.grass) || b.equals(Blocks.farmland)) {
				//This is where we create the new stack
				ItemStack pileDirt = new ItemStack(ItemLoader.pileDirt, 3);
				e.drops.add(pileDirt);


			} else if (b.equals(Blocks.sand)) {
				ItemStack pileSand = new ItemStack(ItemLoader.pileSand, 3);
				e.drops.add(pileSand);

			} else if (b.equals(Blocks.gravel)) {
				ItemStack pileGravel = new ItemStack(ItemLoader.pileGravel, 3);
				e.drops.add(pileGravel);
			} else if (b.equals(Blocks.soul_sand)) {
				ItemStack pileSoulSand = new ItemStack(ItemLoader.pileSoulSand, 3);
				e.drops.add(pileSoulSand);
			} else if (b.equals(Blocks.log)) {

			}


		}


	}

	@SubscribeEvent
	public void playerBreakSpeed(net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed e) {
		Boolean correctTool = BWFUtils.TestHarvestEvent(e.entityPlayer, e.block, e.metadata);
		if (correctTool) {


		} else {
			Float origSpeed = e.originalSpeed;
			Float newSpeed = origSpeed / 3F;
			e.newSpeed = newSpeed;


		}
	}

}
