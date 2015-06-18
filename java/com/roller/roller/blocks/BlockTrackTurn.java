package com.roller.roller.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.roller.roller.Main;
import com.roller.roller.tileEntity.Base;
import com.roller.roller.tileEntity.EntityTrackTurn;

public class BlockTrackTurn extends BaseBlock{

	public BlockTrackTurn(Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setBlockBounds(0, 0, 0, 1, 3F/8F, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new EntityTrackTurn();
	}
	
	
	    

}
