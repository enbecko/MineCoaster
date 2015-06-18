package com.roller.roller;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TETMP extends TileEntity implements IInventory{

	ItemStack[] stks = new ItemStack[7];
	
	public TETMP()
	{
    	stks[0] = new ItemStack(Main.alignWrench);
    	stks[1] = new ItemStack(Main.modeWrench);
    	stks[2] = new ItemStack(Main.speedWrench);
    	stks[3] = new ItemStack(Main.speedMWrench);
    	stks[4] = new ItemStack(Main.tester);
    	stks[5] = new ItemStack(Main.key);
    	stks[6] = new ItemStack(Main.paintBrush);
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return stks.length;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return stks[p_70301_1_];
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return stks[p_70304_1_];
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
