package com.eamondo2.bwf.blocks;

import com.eamondo2.bwf.BWFMain;
import com.eamondo2.bwf.tile.BWFTileEntityMillstone;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by eamon_000 on 8/9/2014.
 */
public class BWFBlockMillStone extends BWFBlockContainer {
	public IIcon frontIcon;
	public IIcon topIcon;
	public IIcon botIcon;

	public BWFBlockMillStone(Material material) {
		super(material);
		setCreativeTab(BWFMain.modTab);


	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new BWFTileEntityMillstone();


	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister icon) {
		this.topIcon = icon.registerIcon("bwf:blockMillstone" + "_top");
		this.frontIcon = icon.registerIcon("bwf:blockMillstone" + "_front");
		this.botIcon = icon.registerIcon("bwf:blockMillstone" + "_bottom");

	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		switch (side) {
			//down
			case 1:
				return this.botIcon;

			//up
			case 0:
				return this.topIcon;

			//?
			default:
				return this.frontIcon;


		}

	}


}
