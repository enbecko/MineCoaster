package com.roller.roller.blocks;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.Base;
import com.roller.roller.tileEntity.EntityTrackTransition;

public class BlockTrackTransition extends BaseBlock{

	public BlockTrackTransition(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		// TODO Auto-generated method stub
		return new EntityTrackTransition();
	}
	
	   public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	    {
	    	Base te = (Base) world.getTileEntity(x, y, z);
	    	System.out.println(te.alignment+" "+te.down);
	    	if(p.getHeldItem() != null)
	    	{
	    		if(p.getHeldItem().isItemEqual(new ItemStack(Main.alignWrench)))
	    		{
	    			if(te.alignment < 7)
	    				te.alignment++;
	    			else
	    				te.alignment = 0;
	    			return true;
	    		}
	    	}
			return super.onBlockActivated(world, x, y, z, p, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
	    }


}
