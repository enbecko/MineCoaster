package com.roller.roller.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.EntityTrackBase;
import com.roller.roller.tileEntity.EntityTrain;

public class BlockTrackBase extends BaseBlock{

	public BlockTrackBase(Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setBlockBounds(0, 0, 0, 1, 3F/8F, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new EntityTrackBase();
	}
	/**
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	EntityTrackBase te = (EntityTrackBase) world.getTileEntity(x, y, z);
    	if(p.getHeldItem() != null)
    	{
    		if(p.getHeldItem().isItemEqual(new ItemStack(Main.train)) && te.start)
    		{
    			world.spawnEntityInWorld(new EntityTrain(world, te.xCoord+0.5F, te.yCoord, te.zCoord+0.5F));
    			System.out.println(te.alignment+" cock");
    			return true;
    		}
    	}
    	return super.onBlockActivated(world, x, y, z, p, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }*/

}
