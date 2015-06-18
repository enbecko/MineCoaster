package com.roller.roller;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.roller.roller.blocks.BlockTrackBase;
import com.roller.roller.tileEntity.EntityMainTrain;
import com.roller.roller.tileEntity.EntityTrackBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTrain extends Item{

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p, World w, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (w.getBlock(x, y, z) instanceof BlockTrackBase)
        {
        	EntityTrackBase te = (EntityTrackBase) w.getTileEntity(x, y, z);
            if (!w.isRemote && te.start)
            {
                EntityMainTrain entityminecart = new EntityMainTrain(w, x+0.5F, y, z+0.5F, 0);
				if(p.inventory.getCurrentItem().stackTagCompound != null)
				{
					entityminecart.red = p.inventory.getCurrentItem().stackTagCompound.getInteger("red");
					entityminecart.green = p.inventory.getCurrentItem().stackTagCompound.getInteger("gre");
					entityminecart.blue = p.inventory.getCurrentItem().stackTagCompound.getInteger("blu");
				}
                w.spawnEntityInWorld(entityminecart);
            }

            --p_77648_1_.stackSize;
            return true;
        }
        else
        {
            return false;
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

    
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
	      list.add(EnumChatFormatting.WHITE+"Can only be placed on starts");
	      list.add(EnumChatFormatting.WHITE+"Start needs redstone input to power");
	      if (itemstack.stackTagCompound != null) {
	            int red = itemstack.stackTagCompound.getInteger("red");
	            int green = itemstack.stackTagCompound.getInteger("gre");
	            int blue = itemstack.stackTagCompound.getInteger("blu");
	            list.add(EnumChatFormatting.RED+"red: " + red);
	            list.add(EnumChatFormatting.GREEN+"green: " + green);
	            list.add(EnumChatFormatting.BLUE+"blue: " + blue);
	      }
	}
	
}
