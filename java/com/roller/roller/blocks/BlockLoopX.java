package com.roller.roller.blocks;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.Base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockLoopX extends BaseBlock{

	public BlockLoopX(Material p_i45394_1_) {
		super(p_i45394_1_);
	}

	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase p, ItemStack p_149689_6_) 
    {
		boolean build = false; 
		if(p instanceof EntityPlayer && !((EntityPlayer)p).capabilities.isCreativeMode)
		{
			if(((EntityPlayer)p).inventory.getCurrentItem().stackSize >= 22)
			{
				((EntityPlayer)p).inventory.getCurrentItem().stackSize -= 22;
				build = true;
			}else
			{
    			for(int k = 0; k < 10-1; k++)
    			{
    				((EntityPlayer)p).addChatMessage(new ChatComponentText(""));  
    			}
    			((EntityPlayer)p).addChatMessage(new ChatComponentText("Not enough tracks"));
        		if(!w.isRemote)
            		w.spawnEntityInWorld(new EntityItem(w, x+0.5F,y+0.5F, z+0.5F, new ItemStack(Main.base)));
        		w.setBlockToAir(x, y, z);
			}
		}else if(p instanceof EntityPlayer && ((EntityPlayer)p).capabilities.isCreativeMode)
			build = true;
		if(build)
		{
			w.setBlock(x,y,z,Main.base, 2, 0);
			w.setBlock(x+1,y,z,Main.track225, 2, 0);
			w.setBlock(x+2,y,z,Main.track225_2, 2, 0);
			w.setBlock(x+3,y+1,z,Main.up, 2, 0);
			((Base)w.getTileEntity(x, y, z)).alignment = 1;
			((Base)w.getTileEntity(x+1, y, z)).alignment = 1;
			((Base)w.getTileEntity(x+2, y, z)).alignment = 1;
			((Base)w.getTileEntity(x+3, y+1, z)).alignment = 1;
			w.setBlock(x+4,y+2,z,Main.track225, 2, 0);
			w.setBlock(x+4,y+3,z,Main.track225_2, 2, 0);
			((Base)w.getTileEntity(x+4, y+2, z)).alignment = 5;
			((Base)w.getTileEntity(x+4, y+3, z)).alignment = 5;
			w.setBlock(x+4,y+4,z,Main.up90, 2, 0);
			w.setBlock(x+4,y+5,z,Main.up90, 2, 0);
			w.markBlockForUpdate(x+4, y+4, z);
			w.markBlockForUpdate(x+4, y+5, z);
			((Base)w.getTileEntity(x+4, y+4, z)).alignment = 3;
			((Base)w.getTileEntity(x+4, y+5, z)).alignment = 3;
			w.setBlock(x+4,y+6,z,Main.track225Top, 2, 0);
			w.setBlock(x+4,y+7,z,Main.track225_2Top, 2, 0);
			w.markBlockForUpdate(x+4, y+6, z);
			w.markBlockForUpdate(x+4, y+7, z);		
			((Base)w.getTileEntity(x+4, y+6, z)).alignment = 7;
			((Base)w.getTileEntity(x+4, y+7, z)).alignment = 7;
			w.setBlock(x+3,y+8,z,Main.hortop, 2, 0);
			w.markBlockForUpdate(x+3, y+8, z);
			((Base)w.getTileEntity(x+3, y+8, z)).alignment = 3;
			w.setBlock(x+2,y+9,z,Main.track225Top, 2, 0);
			w.setBlock(x+1,y+9,z,Main.track225_2Top, 2, 0);
			w.setBlock(x,y+9,z,Main.basetop, 2, 0);
			((Base)w.getTileEntity(x+2, y+9, z)).alignment = 1;
			((Base)w.getTileEntity(x+1, y+9, z)).alignment = 1;
			((Base)w.getTileEntity(x, y+9, z)).alignment = 1;
			w.markBlockForUpdate(x+2, y+9, z);
			w.markBlockForUpdate(x+1, y+9, z);
			w.markBlockForUpdate(x, y+9, z);
			w.setBlock(x-1,y+9,z,Main.quertop, 2, 0);
			w.setBlock(x-1,y+9,z+1,Main.quertop, 2, 0);
			w.setBlock(x-2,y+9,z+1,Main.basetop, 2, 0);
			((Base)w.getTileEntity(x-1, y+9, z)).alignment = 3;
			((Base)w.getTileEntity(x-1, y+9, z+1)).alignment = 1;
			((Base)w.getTileEntity(x-2, y+9, z+1)).alignment = 1;
			w.markBlockForUpdate(x-1, y+9, z+1);
			w.markBlockForUpdate(x-1, y+9, z+1);
			w.markBlockForUpdate(x-2, y+9, z+1);
			w.setBlock(x-4,y+9,z+1,Main.track225Top, 2, 0);
			w.setBlock(x-3,y+9,z+1,Main.track225_2Top, 2, 0);
			((Base)w.getTileEntity(x-4, y+9, z+1)).alignment = 3;
			((Base)w.getTileEntity(x-3, y+9, z+1)).alignment = 3;
			w.markBlockForUpdate(x-4, y+9, z+1);
			w.markBlockForUpdate(x-3, y+9, z+1);
			w.setBlock(x-5,y+8,z+1,Main.hortop, 2, 0);
			w.setBlock(x-6,y+7,z+1,Main.track225_2Top, 2, 0);
			w.setBlock(x-6,y+6,z+1,Main.track225Top, 2, 0);
			((Base)w.getTileEntity(x-5, y+8, z+1)).alignment = 1;
			((Base)w.getTileEntity(x-6, y+7, z+1)).alignment = 5;
			((Base)w.getTileEntity(x-6, y+6, z+1)).alignment = 5;
			w.markBlockForUpdate(x-5, y+8, z+1);
			w.markBlockForUpdate(x-6, y+7, z+1);
			w.markBlockForUpdate(x-6, y+6, z+1);
			w.setBlock(x-6,y+5,z+1,Main.up90, 2, 0);
			w.setBlock(x-6,y+4,z+1,Main.up90, 2, 0);
			((Base)w.getTileEntity(x-6, y+5, z+1)).alignment = 1;
			((Base)w.getTileEntity(x-6, y+4, z+1)).alignment = 1;
			w.markBlockForUpdate(x-6, y+5, z+1);
			w.markBlockForUpdate(x-6, y+4, z+1);
			w.setBlock(x-6,y+3,z+1,Main.track225_2, 2, 0);
			w.setBlock(x-6,y+2,z+1,Main.track225, 2, 0);
			((Base)w.getTileEntity(x-6, y+3, z+1)).alignment = 7;
			((Base)w.getTileEntity(x-6, y+2, z+1)).alignment = 7;
			w.markBlockForUpdate(x-6, y+3, z+1);
			w.markBlockForUpdate(x-6, y+2, z+1);
			w.setBlock(x-5,y+1,z+1,Main.up, 2, 0);
			((Base)w.getTileEntity(x-5, y+1, z+1)).alignment = 3;
			w.markBlockForUpdate(x-5, y+1, z+5);
			w.setBlock(x-4,y,z+1,Main.track225_2, 2, 0);
			w.setBlock(x-3,y,z+1,Main.track225, 2, 0);
			((Base)w.getTileEntity(x-4, y, z+1)).alignment = 3;
			((Base)w.getTileEntity(x-3, y, z+1)).alignment = 3;
			w.markBlockForUpdate(x-4, y, z+1);
			w.markBlockForUpdate(x-3, y, z+1);
			w.setBlock(x-2,y,z+1,Main.base, 2, 0);
			((Base)w.getTileEntity(x-2, y, z+1)).alignment = 1;
			w.markBlockForUpdate(x-2, y, z+1);
		}

    }

	
}
