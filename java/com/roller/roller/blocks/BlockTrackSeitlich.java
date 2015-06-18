package com.roller.roller.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.roller.roller.tileEntity.EntityTrackSeitlich;

public class BlockTrackSeitlich extends BaseBlock{

	public BlockTrackSeitlich(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new EntityTrackSeitlich();
	}


}
