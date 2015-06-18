package com.roller.roller.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.Base;
import com.roller.roller.tileEntity.EntityTrackPitched;

public class BlockTrackPitched extends BaseBlock{

	public BlockTrackPitched(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new EntityTrackPitched();
	}

	   public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	    {
	    	Base te = (Base) world.getTileEntity(x, y, z);
	    	System.out.println(te.alignment);
			return super.onBlockActivated(world, x, y, z, p, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
	    }

}
