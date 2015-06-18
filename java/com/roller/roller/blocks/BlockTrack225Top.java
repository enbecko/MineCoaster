package com.roller.roller.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.Base;
import com.roller.roller.tileEntity.EntityTrack225Top;

public class BlockTrack225Top extends BaseBlock{

	public BlockTrack225Top(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new EntityTrack225Top();
	}
	
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase p, ItemStack p_149689_6_) 
    {
    	if(w.getBlock(x, y, z-1) == Blocks.air)
    		w.setBlock(x, y, z-1, Main.track225_2Top, 2, 0);
    	else
    	{
    		if(w.getBlock(x-1, y, z) == Blocks.air)
    		{
        		w.setBlock(x-1, y, z, Main.track225_2Top, 2, 0);
    	    	Base te = (Base) w.getTileEntity(x, y, z);
    	    	Base te2 = (Base) w.getTileEntity(x-1, y, z);
    	    	te.alignment = 1;
    	    	te2.alignment = 1;
    		}else if(w.getBlock(x, y, z+1) == Blocks.air)
    		{
        		w.setBlock(x, y, z+1, Main.track225_2Top, 2, 0);
    	    	Base te = (Base) w.getTileEntity(x, y, z);
    	    	Base te2 = (Base) w.getTileEntity(x, y, z+1);
    	    	te.alignment = 2;
    	    	te2.alignment = 2;
    		}else if(w.getBlock(x+1, y, z) == Blocks.air)
    		{
        		w.setBlock(x+1, y, z, Main.track225_2Top, 2, 0);
    	    	Base te = (Base) w.getTileEntity(x, y, z);
    	    	Base te2 = (Base) w.getTileEntity(x+1, y, z);
    	    	te.alignment = 3;
    	    	te2.alignment = 3;
    		}else if(w.getBlock(x, y+1, z) == Blocks.air)
    		{
        		w.setBlock(x, y+1, z, Main.track225_2Top, 2, 0);
    	    	Base te = (Base) w.getTileEntity(x, y, z);
    	    	Base te2 = (Base) w.getTileEntity(x, y+1, z);
    	    	te.alignment = 4;
    	    	te2.alignment = 4;
    		}else
    		{
	    		if(!w.isRemote && p instanceof EntityPlayer && !((EntityPlayer)p).capabilities.isCreativeMode)
	        		w.spawnEntityInWorld(new EntityItem(w, x+0.5F,y+0.5F, z+0.5F, new ItemStack(Main.base)));
    			w.setBlockToAir(x, y, z);
    		}
    	}
    }
	
	   public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	    {
	    	Base te = (Base) world.getTileEntity(x, y, z);
	    	System.out.println(te.alignment+" "+te.down);
	    	if(p.getHeldItem() != null)
	    	{
	    		if(p.getHeldItem().isItemEqual(new ItemStack(Main.alignWrench)))
	    		{
	    			while(true)
	    			{
		    			if(te.alignment < 7)
		    				te.alignment++;
		    			else
		    				te.alignment = 0;
		    			if(te.alignment == 0)
		    			{
		    				if(world.getBlock(x, y+1, z) == Main.track225_2Top)
		    					world.setBlockToAir(x, y+1, z);
		    	    		if(world.getBlock(x, y, z-1) == Blocks.air)
		    	    		{
		    	    			world.setBlock(x, y, z-1, Main.track225_2Top, 2, 0);
		    	    	    	Base te2 = (Base) world.getTileEntity(x, y, z-1);
		    	    	    	te.alignment = 0;
		    	    	    	te2.alignment = 0;
		    	    	    	break;
		    	    		}
		    			}else if(te.alignment == 1)
		    	    	{
		    				if(world.getBlock(x, y, z-1) == Main.track225_2Top)
		    					world.setBlockToAir(x, y, z-1);
		    	    		if(world.getBlock(x-1, y, z) == Blocks.air)
		    	    		{
		    	    			world.setBlock(x-1, y, z, Main.track225_2Top, 2, 0);
			    	    	    Base te2 = (Base) world.getTileEntity(x-1, y, z);
			    	    	    te.alignment = 1;
			    	    	    te2.alignment = 1;
		    	    	    	break;
		    	    		}
		    	    	}else if(te.alignment == 2)
		    	    	{
		    				if(world.getBlock(x-1, y, z) == Main.track225_2Top)
		    					world.setBlockToAir(x-1, y, z);
		    	    		if(world.getBlock(x, y, z+1) == Blocks.air)
		    	    		{
		    	    			world.setBlock(x, y, z+1, Main.track225_2Top, 2, 0);
			    	    	   	Base te2 = (Base) world.getTileEntity(x, y, z+1);
			    	    	   	te.alignment = 2;
			    	    	   	te2.alignment = 2;
		    	    	    	break;
		    	    		}
		    	    	}else if(te.alignment == 3)
		    	    	{
		    				if(world.getBlock(x, y, z+1) == Main.track225_2Top)
		    					world.setBlockToAir(x, y, z+1);
		    	    		if(world.getBlock(x+1, y, z) == Blocks.air)
		    	    		{
		    	    			world.setBlock(x+1, y, z, Main.track225_2Top, 2, 0);
			    	    	   	Base te2 = (Base) world.getTileEntity(x+1, y, z);
			    	    	   	te.alignment = 3;
			    	    	  	te2.alignment = 3;
		    	    	    	break;
		    	    		}
		    	    	}else if(te.alignment > 3)
		    	    	{
		    	    		if(te.alignment == 4 && world.getBlock(x+1, y, z) == Main.track225_2Top)
		    	    			world.setBlockToAir(x+1, y, z);
		    	    		if((world.getBlock(x, y+1, z) == Blocks.air || world.getBlock(x, y+1, z) == Main.track225_2Top))
		    	    		{
			    	    		world.setBlock(x, y+1, z, Main.track225_2Top, 2, 0);
			    	    	   	Base te2 = (Base) world.getTileEntity(x, y+1, z);
			    	    	  	te2.alignment = te.alignment;
		    	    	    	break;
		    	    		}
		    	    	}
		    	    
	    			}
	    			for(int k = 0; k < 10-1; k++)
	    			{
	    	    		p.addChatMessage(new ChatComponentText(""));  
	    			}
	    			p.addChatMessage(new ChatComponentText("alignment: "+(te.alignment+1)+"/8")); 
	    			world.markBlockForUpdate(x, y, z);
	    			return true;
	    		}
	    	}
			return super.onBlockActivated(world, x, y, z, p, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
	    }
	   
	   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z)
	    {   
	    	if(!((Base)world.getTileEntity(x, y, z)).locked)
	    	{
		    	Base te = (Base) world.getTileEntity(x, y, z);
	    		if(!world.isRemote && !player.capabilities.isCreativeMode)
	        		world.spawnEntityInWorld(new EntityItem(world, x+0.5F,y+0.5F, z+0.5F, new ItemStack(Main.base)));
   	    	if(te.alignment == 0)
   	    		world.setBlockToAir(x, y, z-1);
   	    	if(te.alignment == 1)
   	    		world.setBlockToAir(x-1, y, z);
   	    	if(te.alignment == 2)
   	    		world.setBlockToAir(x, y, z+1);
   	    	if(te.alignment == 3)
   	    		world.setBlockToAir(x+1, y, z);
      	    	if(te.alignment > 3)
      	    		world.setBlockToAir(x, y+1, z);
	    		return world.setBlockToAir(x, y, z);
	    	}
	    	else
	    		return false;
	    }
	   
}
