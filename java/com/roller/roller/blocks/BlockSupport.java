package com.roller.roller.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.Base;
import com.roller.roller.tileEntity.EntitySupport;

public class BlockSupport extends BlockContainer{

	public BlockSupport(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new EntitySupport();
	}
	
	//You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
            return -1;
    }
    
    
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    public void onNeighborChange(IBlockAccess w, int x, int y, int z, int tileX, int tileY, int tileZ)
    {
    	((EntitySupport)w.getTileEntity(x, y, z)).neighbourchange = true;
    }
    
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z)
    {   
    	if(!world.isRemote && !player.capabilities.isCreativeMode)
        	world.spawnEntityInWorld(new EntityItem(world, x+0.5F,y+0.5F, z+0.5F, new ItemStack(Main.base)));
    	return world.setBlockToAir(x, y, z);
    }

}
