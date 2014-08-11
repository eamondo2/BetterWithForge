package com.eamondo2.bwf;


import com.eamondo2.bwf.blocks.BWFBlockLoader;
import com.eamondo2.bwf.events.EventHook;
import com.eamondo2.bwf.items.BWFItemLoader;
import com.eamondo2.bwf.proxies.CommonProxy;
import com.eamondo2.bwf.recipes.BWFRecipeLoader;
import com.eamondo2.bwf.tile.BWFTileEntityLoader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import java.util.logging.Logger;


@Mod(modid = "BetterWithForge", name = "Better With Forge", version = "0.0.0")
public class BWFMain {
	public static CreativeTabs modTab = new CreativeTabs("BetterWithForge") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Items.item_frame;
		}
	};


	@Instance(value = "BetterWithForge")
	public static BWFMain instance;

	@SidedProxy(clientSide = "com.eamondo2.bwf.proxies.ClientProxy", serverSide = "com.eamondo2.bwf.proxies.CommonProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Logger.getLogger("BWFMAIN").info("PRELOADING");
		//load custom items
		BWFItemLoader.initPhase();
		//load custom blocks
		BWFBlockLoader.initPhase();
		//load custom recipes
		BWFRecipeLoader.initPhase();
		//load custom TE
		BWFTileEntityLoader.initPhase();

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
