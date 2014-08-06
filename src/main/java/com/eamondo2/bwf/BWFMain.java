package com.eamondo2.bwf;


import com.eamondo2.bwf.blocks.BlockLoader;
import com.eamondo2.bwf.events.EventHook;
import com.eamondo2.bwf.items.ItemLoader;
import com.eamondo2.bwf.proxies.CommonProxy;
import com.eamondo2.bwf.recipes.BWFRecipeLoader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import java.util.logging.Logger;


@Mod(modid = "BetterWithForge", name = "Better With Forge", version = "0.0.0")
public class BWFMain {
	@Instance(value = "BetterWithForge")
	public static BWFMain instance;

	@SidedProxy(clientSide = "com.eamondo2.bwf.proxies.ClientProxy", serverSide = "com.eamondo2.bwf.proxies.CommonProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Logger.getLogger("BWFMAIN").info("PRELOADING");
		//load custom items
		ItemLoader.initPhase();
        //load custom blocks
		BlockLoader.initPhase();
		//load custom recipes
		BWFRecipeLoader.initPhase();

	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent e) {
		proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(new EventHook());

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {


	}


}
