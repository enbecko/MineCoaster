package com.roller.roller.guis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.roller.roller.TETMP;
import com.roller.roller.tileEntity.TEWallpic;

public class ContainerWallpic extends Container{

	List <File> fileList = new ArrayList<File>();
	TEWallpic pic;

    public ContainerWallpic (TEWallpic pic){
            //the Slot constructor takes the IInventory and the slot number in that it binds to
            //and the x-y coordinates it resides on-screen
    	this.pic = pic;
		this.fileList = pic.getFileList();
    }

    public boolean enchantItem(EntityPlayer player, int action)
    {
		pic.pic = new ResourceLocation("roller:textures/wallpics/"+this.fileList.get(action).getName());
		pic.getWorldObj().markBlockForUpdate(pic.xCoord, pic.yCoord, pic.zCoord);
		return true;
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            return null;
    }



}
