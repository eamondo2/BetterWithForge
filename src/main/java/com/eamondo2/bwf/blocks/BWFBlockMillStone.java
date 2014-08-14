package com.eamondo2.bwf.blocks;

import com.eamondo2.bwf.BWFMain;
import com.eamondo2.bwf.tile.BWFTileEntityMillstone;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {

		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || player.isSneaking()) {
			return false;
		}
		player.openGui(BWFMain.instance, BWFMain.millstoneGUIID, world, x, y, z);
		return true;
	}

	private void dropItems(World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null) {
			return;
		}
		if (!(te instanceof IInventory)) {
			return;
		}
		IInventory inventory = (IInventory) te;
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);
			if (item != null && item.stackSize > 0) {
				EntityItem ent = new EntityItem(world, x, y, z, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
				if (item.hasTagCompound()) {
					ent.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}
				world.spawnEntityInWorld(ent);
				item.stackSize = 0;
			}
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {

		super.breakBlock(world, x, y, z, block, meta);
		world.removeTileEntity(x, y, z);
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
