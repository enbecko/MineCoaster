package com.roller.roller.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;

import com.roller.roller.ItemWrench;
import com.roller.roller.blocks.BaseBlock;
import com.roller.roller.tileEntity.EntityTrain;
import com.roller.roller.tileEntity.TEWallpic;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
    		if(id >= 0 && id <= 8)
        		return new ContainerWrench(player.inventory, (ItemWrench)player.inventory.getStackInSlot(id).getItem(), 20);
    		else if(id == 99)
            	return new ContainerWallpic(((TEWallpic)world.getTileEntity(x, y, z)));
    		else if(id >= 20 && id <= 28)
            	return new ContainerTracks(player.inventory, (BaseBlock)((ItemBlock) player.inventory.getStackInSlot(id-20).getItem()).field_150939_a, 20);
    		else if(id == 55)
             	return new ContainerTrainColor((EntityTrain) world.getEntityByID(x));
    		return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            if(id >= 0 && id <= 8)
            	return new GuiWrench(player, id);
            else if(id == 99)
            	return new GuiWallpic(((TEWallpic)world.getTileEntity(x, y, z)));
            else if(id >= 20 && id <= 28)
            	return new GuiTracks(player, id-20);
            else if(id == 55)
            	return new GuiTrainColor(player, (EntityTrain) world.getEntityByID(x));
            return null;

    }

}
