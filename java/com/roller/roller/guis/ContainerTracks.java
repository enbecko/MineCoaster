package com.roller.roller.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import com.roller.roller.TETMP2;
import com.roller.roller.blocks.BaseBlock;

public class ContainerTracks extends Container{

    protected TETMP2 tileEntity;

    public ContainerTracks (InventoryPlayer inventoryPlayer, BaseBlock te, int beginIndex){
            tileEntity = new TETMP2();

            //the Slot constructor takes the IInventory and the slot number in that it binds to
            //and the x-y coordinates it resides on-screen

            addSlotToContainer(new SlotNotUsable(tileEntity, 0, beginIndex, 84));
            addSlotToContainer(new SlotNotUsable(tileEntity, 1, beginIndex+20, 84));
            addSlotToContainer(new SlotNotUsable(tileEntity, 2, beginIndex+40, 84));
            addSlotToContainer(new SlotNotUsable(tileEntity, 3, beginIndex+60, 84));
            addSlotToContainer(new SlotNotUsable(tileEntity, 4, beginIndex+80, 84));
            addSlotToContainer(new SlotNotUsable(tileEntity, 5, beginIndex, 110));
            addSlotToContainer(new SlotNotUsable(tileEntity, 6, beginIndex+20, 110));
            addSlotToContainer(new SlotNotUsable(tileEntity, 7, beginIndex+40, 110));
            addSlotToContainer(new SlotNotUsable(tileEntity, 8, beginIndex+60, 110));
            addSlotToContainer(new SlotNotUsable(tileEntity, 9, beginIndex+80, 110));
            addSlotToContainer(new SlotNotUsable(tileEntity, 10, beginIndex, 136));
            addSlotToContainer(new SlotNotUsable(tileEntity, 11, beginIndex+20, 136));
            addSlotToContainer(new SlotNotUsable(tileEntity, 12, beginIndex+40, 136));
            addSlotToContainer(new SlotNotUsable(tileEntity, 13, beginIndex+60, 136));
            addSlotToContainer(new SlotNotUsable(tileEntity, 14, beginIndex+80, 136));      
            addSlotToContainer(new SlotNotUsable(tileEntity, 15, beginIndex+20, 162));
            addSlotToContainer(new SlotNotUsable(tileEntity, 16, beginIndex+40, 162));
            addSlotToContainer(new SlotNotUsable(tileEntity, 17, beginIndex+60, 162));  
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
    	p.inventory.setInventorySlotContents(p.inventory.currentItem, new ItemStack(this.tileEntity.getStackInSlot(action).getItem(), p.inventory.getCurrentItem().stackSize));
		return false;   	
    }
    
    public ItemStack slotClick(int p_75144_1_, int p_75144_2_, int p_75144_3_, EntityPlayer p)
    {
    	if(p_75144_1_ >= 0 && p_75144_1_ <= 17)
    	{
	    	Minecraft.getMinecraft().playerController.sendEnchantPacket(this.windowId, p_75144_1_);
	    	p.closeScreen();
    	}
        return super.slotClick(p_75144_1_, p_75144_2_, p_75144_3_, p);
        
    }


}
