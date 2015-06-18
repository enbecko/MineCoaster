package com.roller.roller.tileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EntitySupport extends TileEntity{
	
	public int form, turn;
	public boolean neighbourchange;
	
	public EntitySupport()
	{
		this.neighbourchange = true;
	}
	
	public void updateEntity()
	{
		World w = this.getWorldObj();
		int x = this.xCoord, y = this.yCoord, z = this.zCoord;
		if(this.turn == 4 || this.neighbourchange)
		{
			if(w.getTileEntity(x, y+1, z) instanceof Base && w.getTileEntity(x, y+1, z) instanceof EntityTrackHor)
			{
				this.form = 4;
				this.turn = ((Base)w.getTileEntity(x, y+1, z)).alignment;
				if(this.turn == 2)
					this.turn = 0;
				else if(this.turn== 0)
					this.turn = 2;
				this.neighbourchange = false;
			}
		}
		if(this.neighbourchange)
		{
			if(w.getTileEntity(x, y+1, z) instanceof EntitySupport && w.getTileEntity(x, y-1, z) instanceof EntitySupport)
				this.form = 3;
			else if(w.getTileEntity(x, y+1, z) instanceof EntitySupport == false && w.getTileEntity(x, y-1, z) instanceof EntitySupport)
				this.form = 2;
			else if(w.getTileEntity(x, y+1, z) instanceof EntitySupport && w.getTileEntity(x, y-1, z) instanceof EntitySupport == false)
				this.form = 1;
			else if(w.getTileEntity(x, y+1, z) instanceof EntitySupport == false && w.getTileEntity(x, y-1, z) instanceof EntitySupport == false)
				this.form = 0;
			this.neighbourchange = false;
		}

	}

}
