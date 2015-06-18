package com.roller.roller;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TETMP2 extends TileEntity implements IInventory{

	ItemStack[] stks = new ItemStack[18];
	
	public TETMP2()
	{
    	stks[0] = new ItemStack(Main.base);
    	stks[1] = new ItemStack(Main.quer);
    	stks[2] = new ItemStack(Main.baseWater);
    	stks[3] = new ItemStack(Main.curve);
    	stks[4] = new ItemStack(Main.turn);
    	stks[5] = new ItemStack(Main.track225);
    	stks[8] = new ItemStack(Main.loopX);
    	//stks[7] = new ItemStack(Main.basetop);
    	stks[6] = new ItemStack(Main.track225Top);
    	stks[9] = new ItemStack(Main.loopZ);
    	stks[10] = new ItemStack(Main.up);
    	stks[11] = new ItemStack(Main.up90);
    	stks[12] = new ItemStack(Main.hortop);
    	stks[13] = new ItemStack(Main.basetop);
    	stks[14] = new ItemStack(Main.quertop);
    	stks[15] = new ItemStack(Main.transition);
    	stks[16] = new ItemStack(Main.pitched);
    	stks[17] = new ItemStack(Main.pitchedCurve);
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
