package com.roller.roller;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemSubTrain extends Item{

    
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
	      list.add(EnumChatFormatting.WHITE+"Right click normal train with this");
	      if (itemstack.stackTagCompound != null) {
	            int red = itemstack.stackTagCompound.getInteger("red");
	            int green = itemstack.stackTagCompound.getInteger("gre");
	            int blue = itemstack.stackTagCompound.getInteger("blu");
	            list.add(EnumChatFormatting.RED+"red: " + red);
	            list.add(EnumChatFormatting.GREEN+"green: " + green);
	            list.add(EnumChatFormatting.BLUE+"blue: " + blue);
	      }
	}
	
	 @SideOnly(Side.CLIENT)
	    public int getColorFromItemStack(ItemStack itemstack, int p_82790_2_)
	    {
		   if (itemstack.stackTagCompound != null) {
		         StringBuilder red =  new StringBuilder().append(Integer.toHexString((itemstack.stackTagCompound.getInteger("red")-1)*8));
		         StringBuilder green =  new StringBuilder().append(Integer.toHexString((itemstack.stackTagCompound.getInteger("gre")-1)*8));
		         StringBuilder blue =  new StringBuilder().append(Integer.toHexString((itemstack.stackTagCompound.getInteger("blu")-1)*8));
		         if (red.length() < 2) {
		        	    red.insert(0, '0'); // pad with leading zero if needed
		        	}
		         if (green.length() < 2) {
		        	 green.insert(0, '0'); // pad with leading zero if needed
		        	}
		         if (blue.length() < 2) {
		        	 blue.insert(0, '0'); // pad with leading zero if needed
		        	}
		         String hx = red.toString()+green.toString()+blue.toString()+"";
		         try{
		        	 return Integer.parseInt(hx, 16);
		         }catch(Exception e)
		         {}

		   }
	        return 16777215;
	    }
	
    public void onCreated(ItemStack stk, World w, EntityPlayer par3EntityPlayer) 
    {
    	if (w.isRemote) {
			stk.stackTagCompound = new NBTTagCompound();
			stk.stackTagCompound.setInteger("red", 32);
			stk.stackTagCompound.setInteger("gre", 32);
			stk.stackTagCompound.setInteger("blu", 32);
		}
    }
	
}
