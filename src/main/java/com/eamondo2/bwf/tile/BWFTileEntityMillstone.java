package com.eamondo2.bwf.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by eamon_000 on 8/10/2014.
 */
public class BWFTileEntityMillstone extends TileEntity {
	public Boolean test = false;

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setBoolean("test", test);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.test = par1.getBoolean("test");
	}

	public TileEntity createTileentity(World world, int metadata) {
		return new BWFTileEntityMillstone();
	}


}
