package com.roller.roller.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.TEWallpic;

public class BlockWallpic extends BlockContainer{

	public BlockWallpic(Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TEWallpic();
	}

    public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase pla, ItemStack p_149689_6_)
    {
        int yaw = (int)pla.rotationYaw;
        if (yaw<0)              //due to the yaw running a -360 to positive 360
           yaw+=360;    //not sure why it's that way
        yaw+=22;     //centers coordinates you may want to drop this line
        yaw%=360;  //and this one if you want a strict interpretation of the zones
        int facing = yaw/90;   //  360degrees divided by 45 == 8 zones
        ((TEWallpic)w.getTileEntity(x, y, z)).turn = facing *90;
    }

    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	TEWallpic te = (TEWallpic) world.getTileEntity(x, y, z);
    	if(p.getHeldItem() != null)
    	{
    		if(p.getHeldItem().isItemEqual(new ItemStack(Main.alignWrench)))
    		{
    			if(te.turn < 360)
    				te.turn+= 90;
    			else
    				te.turn = 90;
    			return true;
    		}
    	}
    	p.openGui(Main.instance, 99, world, x, y, z);
    	return true;
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
    
    public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z) {
    	TEWallpic te = ((TEWallpic)w.getTileEntity(x, y, z));
    	if(te.turn == 180)
    		this.setBlockBounds(-0.5F, -0.5F, 0, 1.5F, 1.5F, 0.05F);
    	else if(te.turn == 90)
    		this.setBlockBounds(0, -0.5F, -0.5F, 0.05F, 1.5F, 1.5F);
    	else if(te.turn == 0)
    		this.setBlockBounds(-0.5F, -0.5F, 0.95F, 1.5F, 1.5F, 1);
    	else if(te.turn == 270)
    		this.setBlockBounds(0.95F, -0.5F, -0.5F, 1, 1.5F, 1.5F);
    }

    
}
