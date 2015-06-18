package com.roller.roller.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotNotUsable extends Slot {

	int slot;
	
	public SlotNotUsable(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
		this.slot = par2;
	}
	
    @Override
   public boolean isItemValid(ItemStack par1ItemStack)
   {
       return false;
   }

    public boolean canTakeStack(EntityPlayer p)
    {
       return false;
    }

}

