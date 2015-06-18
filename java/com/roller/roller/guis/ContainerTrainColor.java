package com.roller.roller.guis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.roller.roller.tileEntity.EntityTrain;

public class ContainerTrainColor extends Container{

	EntityTrain train;

    public ContainerTrainColor (EntityTrain train){
            //the Slot constructor takes the IInventory and the slot number in that it binds to
            //and the x-y coordinates it resides on-screen
    	this.train = train;
    }

    public boolean enchantItem(EntityPlayer player, int action)
    {
    	String tmp = action+"";
    	System.out.println(tmp);
    	int r, g, b;
    	if(action < 1)
    	{
        	g = 0;
        	b = 0;
        	r = 0;
    	}
    	else if(action < 10)
    	{
        	g = 0;
        	b = Integer.parseInt(tmp.substring(0, 1));
        	r = 0;
    	}
    	else if(action < 100)
    	{
        	g = 0;
        	b = Integer.parseInt(tmp.substring(0, 2));
        	r = 0;
    	}
    	else if(action < 1000)
    	{
        	g = Integer.parseInt(tmp.substring(0, 1));
        	b = Integer.parseInt(tmp.substring(1,3 ));
        	r = 0;
    	}
    	else if(action < 10000)
    	{
        	g = Integer.parseInt(tmp.substring(0, 2));
        	b = Integer.parseInt(tmp.substring(2, 4));
        	r = 0;
    	}
    	else if(action < 100000)
    	{
        	g = Integer.parseInt(tmp.substring(1, 3));
        	b = Integer.parseInt(tmp.substring(3, 5));
        	r = Integer.parseInt(tmp.substring(0, 1));
    	}
    	else
    	{
        	g = Integer.parseInt(tmp.substring(2, 4));
        	b = Integer.parseInt(tmp.substring(4, 6));
        	r = Integer.parseInt(tmp.substring(0, 2));
    	}
    	train.red = r;
    	train.green = g;
    	train.blue = b;
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
