package com.eamondo2.bwf.items;


import cpw.mods.fml.common.registry.GameRegistry;

public class BWFItemLoader {
    public static BWFItempileDirt pileDirt = new BWFItempileDirt();
	public static BWFItempileGravel pileGravel = new BWFItempileGravel();
	public static BWFItempileSoulSand pileSoulSand = new BWFItempileSoulSand();
	public static BWFItempileSand pileSand = new BWFItempileSand();
	public static BWFItemCrushedIron crushedIron = new BWFItemCrushedIron();


	public static void initPhase() {


		GameRegistry.registerItem(pileDirt, "itemPileDirt");
		GameRegistry.registerItem(pileGravel, "itemPileGravel");
		GameRegistry.registerItem(pileSoulSand, "itemPileSoulSand");
		GameRegistry.registerItem(pileSand, "itemPileSand");
		GameRegistry.registerItem(crushedIron, "itemCrushedIron");
	}
}
