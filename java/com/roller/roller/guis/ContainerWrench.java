package com.roller.roller.guis;

import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.roller.roller.ItemWrench;
import com.roller.roller.TETMP;

public class ContainerWrench extends Container{

    protected TETMP tileEntity;

    public ContainerWrench (InventoryPlayer inventoryPlayer, ItemWrench te, int beginIndex){
            tileEntity = new TETMP();

            //the Slot constructor takes the IInventory and the slot number in that it binds to
            //and the x-y coordinates it resides on-screen

            addSlotToContainer(new SlotNotUsable(tileEntity, 0, beginIndex-20, 162));
            addSlotToContainer(new SlotNotUsable(tileEntity, 1, beginIndex+20-20, 162));
            addSlotToContainer(new SlotNotUsable(tileEntity, 2, beginIndex+40-20, 162));
            addSlotToContainer(new SlotNotUsable(tileEntity, 3, beginIndex+60-20, 162));
            addSlotToContainer(new SlotNotUsable(tileEntity, 4, beginIndex+80-20, 162));
            addSlotToContainer(new SlotNotUsable(tileEntity, 5, beginIndex+100-20, 162));
            addSlotToContainer(new SlotNotUsable(tileEntity, 6, beginIndex+120-20, 162));

            for (int i = 0; i < 9; i++) {
                    addSlotToContainer(new SlotNotUsable(inventoryPlayer, i,  i * 20, 184));
            }


    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            return null;
    }
    
    public boolean enchantItem(EntityPlayer p, int action)
    {
    	p.inventory.setInventorySlotContents(p.inventory.currentItem, this.tileEntity.getStackInSlot(action));
		return false;   	
    }
    
    public ItemStack slotClick(int p_75144_1_, int p_75144_2_, int p_75144_3_, EntityPlayer p)
    {
    	if(p_75144_1_ >= 0 && p_75144_1_ <= 6)
    	{
	    	Minecraft.getMinecraft().playerController.sendEnchantPacket(this.windowId, p_75144_1_);
	    	p.closeScreen();
    	}
        return super.slotClick(p_75144_1_, p_75144_2_, p_75144_3_, p);
        
    }


}
