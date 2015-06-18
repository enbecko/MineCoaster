package com.roller.roller.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.Base;
import com.roller.roller.tileEntity.EntityTrack225;
import com.roller.roller.tileEntity.EntityTrack225Top;
import com.roller.roller.tileEntity.EntityTrack225_2;
import com.roller.roller.tileEntity.EntityTrack225_2Top;
import com.roller.roller.tileEntity.EntityTrackTransition;

public class BaseBlock extends BlockContainer{

	protected BaseBlock(Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}
	
    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     *
    public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase p, ItemStack p_149689_6_) 
    {
			if (p instanceof EntityPlayer && ((EntityPlayer)p).isSneaking())
			{
				w.setBlock(x, y, z, Blocks.air, 2, 0);
				w.markBlockForUpdate(x, y, z);
				((EntityPlayer)p).openGui(Main.instance, ((EntityPlayer)p).inventory.currentItem+20, w, x, y, z);
			}
    }*/
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	Base te = (Base) world.getTileEntity(x, y, z);
    	if(p.getHeldItem() != null)
    	{
    		if(p.getHeldItem().isItemEqual(new ItemStack(Main.alignWrench)))
    		{
    			if(!te.locked)
    			{
	    			if(te.alignment < 3)
	    				te.alignment++;
	    			else
	    				te.alignment = 0;
	    			int num;
	    			if(te instanceof EntityTrack225 || te instanceof EntityTrack225_2|| te instanceof EntityTrack225Top|| te instanceof EntityTrack225_2Top|| te instanceof EntityTrackTransition)
	    				num = 8;
	    			else
	    				num = 4;
	    			for(int k = 0; k < 10-1; k++)
	    			{
	    	    		p.addChatMessage(new ChatComponentText(""));  
	    			}
	    			p.addChatMessage(new ChatComponentText("alignment: "+(te.alignment+1)+"/"+num)); 
	    			world.markBlockForUpdate(x, y, z);
    			}else if(world.isRemote)
    			{
    				for(int k = 0; k < 10-1; k++)
    				{
    		    		p.addChatMessage(new ChatComponentText(""));  
    				}
    				p.addChatMessage(new ChatComponentText("Track locked")); 
    			}
    			return true;
    		}else if(p.getHeldItem().isItemEqual(new ItemStack(Main.tester)))
    		{
    			//if(!te.getWorldObj().isRemote)
    			{
    				te.next = null;
    				te.prev = null;
    				te.makeFirst(te);
    			}
    			world.markBlockForUpdate(x, y, z);
    			return true;
    		}else if(p.getHeldItem().isItemEqual(new ItemStack(Main.modeWrench)))
    		{
    			te.itemAction(p);
    			world.markBlockForUpdate(x, y, z);
    			return true;
    		}
    		else if(p.getHeldItem().isItemEqual(new ItemStack(Main.speedWrench)))
    		{
    			if (p.isSneaking())
    			{
        			te.itemAction2(false, p);
    			}else
        			te.itemAction2(true, p);
    			world.markBlockForUpdate(x, y, z);
    			return true;
    		}
    		else if(p.getHeldItem().isItemEqual(new ItemStack(Main.speedMWrench)))
    		{
    			if (p.isSneaking())
    			{
        			te.itemAction3(false, p);
    			}else
        			te.itemAction3(true, p);
    			world.markBlockForUpdate(x, y, z);
    			return true;
    		}else if(p.getHeldItem().getItem() instanceof ItemDye)
    		{
    			if(p.getHeldItem().getItemDamage() == 10 || p.getHeldItem().getItemDamage() == 2)
    				te.color = 2;
        		if(p.getHeldItem().getItemDamage() == 1)
    				te.color = 1;
        		if(p.getHeldItem().getItemDamage() == 4 || p.getHeldItem().getItemDamage() == 6|| p.getHeldItem().getItemDamage() == 12)
    				te.color = 3;
    			world.markBlockForUpdate(x, y, z);
    			return true;
    		}else if(p.getHeldItem().isItemEqual(new ItemStack(Main.key)))
    		{
    			if(te.locked)
    				te.locked = false;
    			else
    				te.locked = true;
    			if(world.isRemote)
    			{
	    			if(te.locked)
	    				p.addChatMessage(new ChatComponentText("Locked track in "+x+" "+y+" "+z)); 
	    			else
	    				p.addChatMessage(new ChatComponentText("Unlocked track in "+x+" "+y+" "+z)); 
    			}
    			world.markBlockForUpdate(x, y, z);
    			return true;
    		}
			return false;
    	}
    	else
    		return false;
    /**	if(te.alignment < 12)
    		te.alignment++;
    	else
    	{
    		if(te.neigungHor == 0)
    			te.neigungHor = 1;
    		else
    			te.neigungHor = 0;
        	te.alignment = 0;
    	}*/
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
    
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z)
    {   
    	if(world.getTileEntity(x, y, z) instanceof Base && !((Base)world.getTileEntity(x, y, z)).locked)
    	{
    		if(!world.isRemote && !player.capabilities.isCreativeMode)
        		world.spawnEntityInWorld(new EntityItem(world, x+0.5F,y+0.5F, z+0.5F, new ItemStack(Main.base)));
    		return world.setBlockToAir(x, y, z);
    	}
    	else
    		return false;
    }

}
