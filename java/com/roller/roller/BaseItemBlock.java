package com.roller.roller;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BaseItemBlock extends ItemBlock{

	public BaseItemBlock(Block p_i45328_1_) {
		super(p_i45328_1_);
	}

    public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer p)
    {
    	p.openGui(Main.instance, p.inventory.currentItem+20, w, 0, 0, 0);
       return stack;
    }
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
		list.add(EnumChatFormatting.RED+"right click");
		list.add(EnumChatFormatting.RED+"in the sky to change");
			
		if(this.field_150939_a == Main.track225 || this.field_150939_a == Main.track225Top || this.field_150939_a == Main.transition)
			list.add(EnumChatFormatting.AQUA+"Has 8 alignments");
		
		if(this.field_150939_a == Main.baseWater)
			list.add(EnumChatFormatting.AQUA+"Build this on water");

		if(this.field_150939_a == Main.turn)
		{
			list.add(EnumChatFormatting.AQUA+"Change aim with mode wrench");
			list.add(EnumChatFormatting.AQUA+"Track turns when train is on top");
		}
		
		if(this.field_150939_a == Main.pitched)
		{
			list.add(EnumChatFormatting.AQUA+"To get from straight to this");
			list.add(EnumChatFormatting.AQUA+"use transition");
	}

	}
	
}
