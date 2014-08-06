package com.eamondo2.bwf.events;

import com.eamondo2.bwf.items.ItemLoader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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
        System.out.println("Harvest Event Called");
        Boolean isPlayer = false;
        Boolean correctTool = false;
        /* This needs to have several stages
        1, determine if a player broke the block.
        2, determine what toolClass was used to do the breaking
        3, compare to the toolClass for the block that was broken
        4, either drop the normal drops or drop piles
         */

        EntityPlayer p = null;
        if (e.harvester == null){
            isPlayer = false;
        } else {
            p = e.harvester;
            isPlayer = true;
        }
        Block b = e.block;
		ItemStack inHand = null;
		String blockToolClass = "";
        if (b.getHarvestTool(e.blockMetadata) != null){
            blockToolClass = b.getHarvestTool(e.blockMetadata);
        }
        Set<String> inHandToolClasses = null;
        if (isPlayer){
            if(p.getHeldItem() != null){
                inHand = p.getHeldItem();
                if (inHand.getItem().getToolClasses(inHand) != null){
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


        //now that we have both strings to compare against, make a method to drop the appropriate item
        if (correctTool){
            //drop teh orig block
        }else {
            //don't
            e.drops.clear();
            //insert logic for determining block type, and the appropriate pile to drop
            if (b.equals(Blocks.dirt) ||b.equals( Blocks.grass)){
                //This is where we create the new stack
                ItemStack pileDirt = new ItemStack(ItemLoader.pileDirt);


            }

        }


	}


}
