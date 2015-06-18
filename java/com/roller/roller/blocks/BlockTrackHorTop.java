package com.roller.roller.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.roller.roller.tileEntity.EntityTrackHorTop;

public class BlockTrackHorTop extends BaseBlock{

	public BlockTrackHorTop(Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new EntityTrackHorTop();
	}

}

