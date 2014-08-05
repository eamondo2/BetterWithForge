package com.eamondo2.bwf.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Created by eamon_000 on 8/5/2014.
 */
public class EventHook {

	@SubscribeEvent
	public void Onblockbroken(BlockEvent.BreakEvent e) {
		System.out.println("SHIT");

	}


}
