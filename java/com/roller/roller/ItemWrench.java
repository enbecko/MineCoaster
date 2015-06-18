package com.roller.roller;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemWrench extends Item implements IInventory{

	ItemStack[] stks = new ItemStack[4];
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer p)
    {
    	p.openGui(Main.instance, p.inventory.currentItem, w, 0, 0, 0);
    	stks[0] = new ItemStack(Main.alignWrench);
    	stks[1] = new ItemStack(Main.modeWrench);
    	stks[2] = new ItemStack(Main.speedWrench);
    	stks[3] = new ItemStack(Main.speedMWrench);
       return stack;
    }
    
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
	      list.add(EnumChatFormatting.RED+"right click");
	      list.add(EnumChatFormatting.RED+"in the sky to change");
	      if(this == Main.alignWrench)
	      {
	    	  list.add(EnumChatFormatting.BLUE+"Use this to change the");
	    	  list.add(EnumChatFormatting.BLUE+"alignment of a track piece");
	      }
	      if(this == Main.modeWrench)
	      {
	    	  list.add(EnumChatFormatting.BLUE+"Use this to change the");
	    	  list.add(EnumChatFormatting.BLUE+"mode of a track piece");
	    	  list.add(EnumChatFormatting.GREEN+"(Straight tracks can be made");
	    	  list.add(EnumChatFormatting.GREEN+"starts with this)");
	      }
	      if(this == Main.speedWrench)
	      {
	    	  list.add(EnumChatFormatting.BLUE+"Use this to change the");
	    	  list.add(EnumChatFormatting.BLUE+"the speed of a powered or");
	    	  list.add(EnumChatFormatting.BLUE+"braking track piece");
	    	  list.add(EnumChatFormatting.RED+"right click increase");
	    	  list.add(EnumChatFormatting.RED+"SHIFT+right click decrease");
	      }
	      if(this == Main.speedMWrench)
	      {
	    	  list.add(EnumChatFormatting.BLUE+"Use this to change the");
	    	  list.add(EnumChatFormatting.BLUE+"the ac/deceleration of a ");
	    	  list.add(EnumChatFormatting.BLUE+"powered or braking track piece");
	    	  list.add(EnumChatFormatting.RED+"right click increase");
	    	  list.add(EnumChatFormatting.RED+"SHIFT+right click decrease");
	      }
	      if(this == Main.tester)
	      {
	    	  list.add(EnumChatFormatting.BLUE+"Use this to check the");
	    	  list.add(EnumChatFormatting.BLUE+"track pieces with \"?\" on top");
	    	  list.add(EnumChatFormatting.GREEN+"(Best used on starts)");
	      }
	      if(this == Main.key)
	      {
	    	  list.add(EnumChatFormatting.BLUE+"Use this to lock or");
	    	  list.add(EnumChatFormatting.BLUE+"unlock tracks (destroyable or not)");
	    	  list.add(EnumChatFormatting.GREEN+"(Spread across with the tester)");
	      }
	      

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
