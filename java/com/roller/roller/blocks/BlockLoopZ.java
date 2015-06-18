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

public class BlockLoopZ extends BaseBlock{

	public BlockLoopZ(Material p_i45394_1_) {
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
			w.setBlock(x,y,z+1,Main.track225, 2, 0);
			w.setBlock(x,y,z+2,Main.track225_2, 2, 0);
			w.setBlock(x,y+1,z+3,Main.up, 2, 0);
			/**((Base)w.getTileEntity(x, y, z)).alignment = 1;
			((Base)w.getTileEntity(x+1, y, z)).alignment = 1;
			((Base)w.getTileEntity(x+2, y, z)).alignment = 1;
			((Base)w.getTileEntity(x+3, y+1, z)).alignment = 1;*/
			w.setBlock(x,y+2,z+4,Main.track225, 2, 0);
			w.setBlock(x,y+3,z+4,Main.track225_2, 2, 0);
			((Base)w.getTileEntity(x, y+2, z+4)).alignment = 4;
			((Base)w.getTileEntity(x, y+3, z+4)).alignment = 4;
			w.setBlock(x,y+4,z+4,Main.up90, 2, 0);
			w.setBlock(x,y+5,z+4,Main.up90, 2, 0);
			w.markBlockForUpdate(x, y+4, z+4);
			w.markBlockForUpdate(x, y+5, z+4);
			((Base)w.getTileEntity(x, y+4, z+4)).alignment = 2;
			((Base)w.getTileEntity(x, y+5, z+4)).alignment = 2;
			w.setBlock(x,y+6,z+4,Main.track225Top, 2, 0);
			w.setBlock(x,y+7,z+4,Main.track225_2Top, 2, 0);
			w.markBlockForUpdate(x, y+6, z+4);
			w.markBlockForUpdate(x, y+7, z+4);		
			((Base)w.getTileEntity(x, y+6, z+4)).alignment = 4;
			((Base)w.getTileEntity(x, y+7, z+4)).alignment = 4;
			w.setBlock(x,y+8,z+3,Main.hortop, 2, 0);
			w.markBlockForUpdate(x, y+8, z+3);
			((Base)w.getTileEntity(x, y+8, z+3)).alignment = 2;
			w.setBlock(x,y+9,z+2,Main.track225Top, 2, 0);
			w.setBlock(x,y+9,z+1,Main.track225_2Top, 2, 0);
			w.setBlock(x,y+9,z,Main.basetop, 2, 0);
			((Base)w.getTileEntity(x, y+9, z+2)).alignment = 0;
			((Base)w.getTileEntity(x, y+9, z+1)).alignment = 0;
			((Base)w.getTileEntity(x, y+9, z)).alignment = 0;
			w.markBlockForUpdate(x, y+9, z+2);
			w.markBlockForUpdate(x, y+9, z+1);
			w.markBlockForUpdate(x, y+9, z);
			w.setBlock(x,y+9,z-1,Main.quertop, 2, 0);
			w.setBlock(x+1,y+9,z-1,Main.quertop, 2, 0);
			w.setBlock(x+1,y+9,z-2,Main.basetop, 2, 0);
			((Base)w.getTileEntity(x, y+9, z-1)).alignment = 3;
			((Base)w.getTileEntity(x+1, y+9, z-1)).alignment = 1;
			((Base)w.getTileEntity(x+1, y+9, z-2)).alignment = 0;
			w.markBlockForUpdate(x+1, y+9, z-1);
			w.markBlockForUpdate(x+1, y+9, z-1);
			w.markBlockForUpdate(x+1, y+9, z-2);
			w.setBlock(x+1,y+9,z-4,Main.track225Top, 2, 0);
			w.setBlock(x+1,y+9,z-3,Main.track225_2Top, 2, 0);
			((Base)w.getTileEntity(x+1, y+9, z-4)).alignment = 2;
			((Base)w.getTileEntity(x+1, y+9, z-3)).alignment = 2;
			w.markBlockForUpdate(x+1, y+9, z-4);
			w.markBlockForUpdate(x+1, y+9, z-3);
			w.setBlock(x+1,y+8,z-5,Main.hortop, 2, 0);
			w.setBlock(x+1,y+7,z-6,Main.track225_2Top, 2, 0);
			w.setBlock(x+1,y+6,z-6,Main.track225Top, 2, 0);
			((Base)w.getTileEntity(x+1, y+8, z-5)).alignment = 0;
			((Base)w.getTileEntity(x+1, y+7, z-6)).alignment = 6;
			((Base)w.getTileEntity(x+1, y+6, z-6)).alignment = 6;
			w.markBlockForUpdate(x+1, y+8, z-5);
			w.markBlockForUpdate(x+1, y+7, z-6);
			w.markBlockForUpdate(x+1, y+6, z-6);
			w.setBlock(x+1,y+5,z-6,Main.up90, 2, 0);
			w.setBlock(x+1,y+4,z-6,Main.up90, 2, 0);
			((Base)w.getTileEntity(x+1, y+5, z-6)).alignment = 0;
			((Base)w.getTileEntity(x+1, y+4, z-6)).alignment = 0;
			w.markBlockForUpdate(x+1, y+5, z-6);
			w.markBlockForUpdate(x+1, y+4, z-6);
			w.setBlock(x+1,y+3,z-6,Main.track225_2, 2, 0);
			w.setBlock(x+1,y+2,z-6,Main.track225, 2, 0);
			((Base)w.getTileEntity(x+1, y+3, z-6)).alignment = 6;
			((Base)w.getTileEntity(x+1, y+2, z-6)).alignment = 6;
			w.markBlockForUpdate(x+1, y+3, z-6);
			w.markBlockForUpdate(x+1, y+2, z-6);
			w.setBlock(x+1,y+1,z-5,Main.up, 2, 0);
			((Base)w.getTileEntity(x+1, y+1, z-5)).alignment = 2;
			w.markBlockForUpdate(x+1, y+1, z-5);
			w.setBlock(x+1,y,z-4,Main.track225_2, 2, 0);
			w.setBlock(x+1,y,z-3,Main.track225, 2, 0);
			((Base)w.getTileEntity(x+1, y, z-4)).alignment = 2;
			((Base)w.getTileEntity(x+1, y, z-3)).alignment = 2;
			w.markBlockForUpdate(x+1, y, z-4);
			w.markBlockForUpdate(x+1, y, z-3);
			w.setBlock(x+1,y,z-2,Main.base, 2, 0);
			((Base)w.getTileEntity(x+1, y, z-2)).alignment = 0;
			w.markBlockForUpdate(x+1, y, z-2);
		}
    }

	
}
