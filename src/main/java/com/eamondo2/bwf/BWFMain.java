package com.eamondo2.bwf;

import com.eamondo2.bwf.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


/**
 * Created by eamon_000 on 8/4/2014.
 */

@Mod(modid="BetterWithForge", name="Better With Forge", version="0.0.0")
public class BWFMain {
	@Instance(value = "BetterWithForge")
	public static BWFMain instance;

	@SidedProxy (clientSide="com.eamondo2.bwf.proxies.ClientProxy", serverSide = "com.eamondo2.bwf.proxies.CommonProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit (FMLPreInitializationEvent e){

	}

	@Mod.EventHandler
	public void load (FMLInitializationEvent e){

	}

	@Mod.EventHandler
	public void postInit (FMLPostInitializationEvent e){

		
	}








}
