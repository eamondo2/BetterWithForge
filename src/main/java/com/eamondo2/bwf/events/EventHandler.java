package com.eamondo2.bwf.events;

import cpw.mods.fml.common.Mod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;


public class EventHandler {

	@Mod.EventHandler
	public void onBlockHarvestEvent(BlockEvent.HarvestDropsEvent e) {
		Map<String, ItemStack> toolCheck = new HashMap<String, ItemStack>();
		//Silk touch overwrites all other qualifiers
		if (e.isSilkTouching) {
			return;
		}

		toolCheck.put("axe", new ItemStack(Items.stone_axe));
		toolCheck.put("axe", new ItemStack(Items.iron_axe));
		toolCheck.put("axe", new ItemStack(Items.diamond_axe));
		toolCheck.put("pick", new ItemStack(Items.wooden_pickaxe));
		toolCheck.put("pick", new ItemStack(Items.iron_pickaxe));
		toolCheck.put("pick", new ItemStack(Items.stone_pickaxe));
		toolCheck.put("pick", new ItemStack(Items.diamond_pickaxe));
		toolCheck.put("shovel", new ItemStack(Items.wooden_shovel));
		toolCheck.put("shovel", new ItemStack(Items.stone_shovel));
		toolCheck.put("shovel", new ItemStack(Items.iron_shovel));
		toolCheck.put("shovel", new ItemStack(Items.diamond_shovel));

		ItemStack testcase = new ItemStack(Items.wooden_shovel);


		ArrayList<ItemStack> alteredDrops = new ArrayList<ItemStack>();
		Block b = e.block;
		String toolReq = b.getHarvestTool(0);
		EntityPlayer p = null;
		if (e.harvester != null) {
			p = e.harvester;
		}
		if (p.getHeldItem().getMaxStackSize() > 1) {
			return; //Not a tool that I know of.
		}
		Set<String> test = p.getHeldItem().getItem().getToolClasses(testcase);
		for (String s : test) {
			Logger.getLogger("EVENT").info(s);
		}


	}

}
