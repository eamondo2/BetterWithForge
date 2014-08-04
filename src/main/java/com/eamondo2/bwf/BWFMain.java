package com.eamondo2.bwf;


import com.eamondo2.bwf.items.ItemLoader;
import com.eamondo2.bwf.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.logging.Logger;


@Mod(modid="BetterWithForge", name="Better With Forge", version="0.0.0")
public class BWFMain {
	@Instance(value = "BetterWithForge")
	public static BWFMain instance;

	@SidedProxy (clientSide="com.eamondo2.bwf.proxies.ClientProxy", serverSide = "com.eamondo2.bwf.proxies.CommonProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit (FMLPreInitializationEvent e){
		Logger.getLogger("BWFMAIN").info("PRELOADING");
		//load custom items
		ItemLoader.initPhase();


	}

	@Mod.EventHandler
	public void load (FMLInitializationEvent e){
		proxy.registerRenderers();


	}

	@Mod.EventHandler
	public void postInit (FMLPostInitializationEvent e){


	}








}
