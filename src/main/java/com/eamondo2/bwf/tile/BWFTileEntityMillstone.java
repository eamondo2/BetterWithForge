package com.eamondo2.bwf.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by eamon_000 on 8/10/2014.
 */
public class BWFTileEntityMillstone extends TileEntity implements IInventory {
	public Boolean isOn = false;
	//some form of percentage complete for milling process
	public int progress = 0;

	public ItemStack[] millstoneInventory;

	public BWFTileEntityMillstone() {
		millstoneInventory = new ItemStack[27];
	}


	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setBoolean("isOn", isOn);
		par1.setInteger("progress", progress);

	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.isOn = par1.getBoolean("isOn");
		this.progress = par1.getInteger("progress");
	}

	public TileEntity createTileentity(World world, int metadata) {
		return new BWFTileEntityMillstone();
	}


	@Override
	public int getSizeInventory() {
		return millstoneInventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return millstoneInventory[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		ItemStack stack = getStackInSlot(var1);
		if (stack != null) {
			if (stack.stackSize <= var2) {
				setInventorySlotContents(var1, null);
			} else {
				stack = stack.splitStack(var2);
				if (stack.stackSize == 0) {
					setInventorySlotContents(var1, null);
				}
			}
		}


		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		ItemStack stack = getStackInSlot(var1);
		if (stack != null) {
			setInventorySlotContents(var1, null);

		}

		return stack;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		millstoneInventory[var1] = var2;
		if (var2 != null && var2.stackSize > getInventoryStackLimit()) {
			var2.stackSize = getInventoryStackLimit();
		}


	}

	@Override
	public String getInventoryName() {
		return "Millstone";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return false;
	}
}
