package com.roller.roller.guis;

	import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.roller.roller.tileEntity.TEWallpic;

	public class GuiWallpic extends GuiContainer
	{
		
		public EntityPlayer player;
		int slot;
		TEWallpic pic; 
		final int xSizeOfTexture = 252, ySizeOfTexture = 136;
		int yOff;
		List <File> fileList = new ArrayList<File>();
		List <PicChooseBtn> btnList2 = new ArrayList<PicChooseBtn>();
		GuiButton up, down, folder;
	
		public GuiWallpic(TEWallpic pic)
		{
			super(new ContainerWallpic(pic));
			this.pic = pic;
			this.fileList = pic.getFileList();
			System.out.println(Arrays.toString(this.fileList.toArray()));
		}
		
		@Override
		public void drawScreen(int x, int y, float f)
		{
			drawDefaultBackground();
			ResourceLocation var4 = new ResourceLocation("roller:textures/gui/trackstart.png");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.renderEngine.bindTexture(var4);			
			int posX = (this.width - xSizeOfTexture) / 2;
			int posY = (this.height - ySizeOfTexture) / 2;
            this.drawTexturedModalRect(20, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
			for(int k = 0; k < this.buttonList.size()-3; k++)
				((PicChooseBtn)this.buttonList.get(k)).yPosition = ((PicChooseBtn)this.buttonList.get(k)).centreY+yOff;
			super.drawScreen(x, y, f);

		}
		
		public void initGui()
		{
			super.initGui();
			this.buttonList.clear();
		
			int posX = (this.width - xSizeOfTexture) / 2;
			int posY = (this.height - ySizeOfTexture) / 2;
			for(int k = 0; k < this.fileList.size(); k++)
				this.buttonList.add(new PicChooseBtn(0, 21, posY+1+k*20, 250, 20, this.fileList.get(k).getName()));
			up = new GuiButton(0, 21+xSizeOfTexture, posY, 20, 20, "/\\");
			down = new GuiButton(0, 21+xSizeOfTexture, posY+this.ySizeOfTexture-20, 20, 20,"\\/");
			folder = new GuiButton(0, posX, posY+this.ySizeOfTexture, 100, 20,"Open folder");
			this.buttonList.add(up);
			this.buttonList.add(down);
			this.buttonList.add(folder);
		}
		
	    public boolean doesGuiPauseGame()
	    {
	        return false;
	    }
		
		
		public void actionPerformed(GuiButton button)
		{
			int posX = (this.width - xSizeOfTexture) / 2;
			int posY = (this.height - ySizeOfTexture) / 2;
			if(button instanceof PicChooseBtn)
			{
				pic.pic = new ResourceLocation("saves/"+Minecraft.getMinecraft().getIntegratedServer().getFolderName()+"/wallpics/"+((PicChooseBtn)button).name);
				for(int k = 0; k < this.buttonList.size(); k++)
					if(this.buttonList.get(k) == button)
						this.mc.playerController.sendEnchantPacket(this.inventorySlots.windowId, k);
				mc.displayGuiScreen(null);
			}
			if(button == up)
			{
				if(this.yOff-5 > this.ySizeOfTexture-(this.buttonList.size()-2)*20)
					this.yOff-=5;
				else
					this.yOff = this.ySizeOfTexture-(this.buttonList.size()-2)*20;
			}
			if(button == down)
			{
				if(yOff + 5 <= 0)
					yOff += 5;
				else
					yOff = 0;
			}
			
			if(button == folder)
			{
				try {
					Desktop.getDesktop().open(new File("saves/"+Minecraft.getMinecraft().getIntegratedServer().getFolderName()+"/wallpics"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
				int p_146976_2_, int p_146976_3_) {			
		}
	}


