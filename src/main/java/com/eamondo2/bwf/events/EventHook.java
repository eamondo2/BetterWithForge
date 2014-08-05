package com.eamondo2.bwf.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Set;


public class EventHook {

	@SubscribeEvent
	public void Onblockbroken(BlockEvent.BreakEvent e) {
		System.out.println("SHIT");


	}

	@SubscribeEvent
	public void blockHarvestEvent(BlockEvent.HarvestDropsEvent e) {
		System.out.println("HERVESTEVENT");
		EntityPlayer p = null;
		if (e.harvester != null) {
			p = e.harvester;
		}
		Block b = e.block;
		ItemStack stack = null;

		if (p.getHeldItem() == null) {
			return;
		} else {
			stack = p.getHeldItem();
		}
		String effective = "noteffective";
		if (b.getHarvestTool(0) != null) {
			effective = b.getHarvestTool(e.blockMetadata);
		} else {
			return;
		}
		System.out.println(effective);
		Set<String> set = stack.getItem().getToolClasses(stack);
		for (String s : set) {
			System.out.println(s);
		}


	}


}
