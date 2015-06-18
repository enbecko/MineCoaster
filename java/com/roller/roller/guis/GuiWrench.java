package com.roller.roller.guis;

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.lwjgl.opengl.GL11;

import com.roller.roller.ItemWrench;
import com.roller.roller.Main;

	public class GuiWrench extends GuiContainer
	{
		
		public EntityPlayer player;
		GuiButton ytb, dubli, update;
		boolean dubliBool, updateBool;
		String dubliStr;
		int slot;
		
		public GuiWrench(EntityPlayer pl, int slot)
		{
			super(new ContainerWrench(pl.inventory, (ItemWrench) pl.inventory.getStackInSlot(slot).getItem(), slot*20-40));
			this.player = pl;
			this.slot = slot;
		}
		
		@Override
		public void drawScreen(int x, int y, float f)
		{
			for(int k = 0; k < 4; k++)
			{
				mouseOver:
				if(this.isMouseOverSlot(this.inventorySlots.getSlot(k), x, y))
				{
					Item tmp = this.inventorySlots.getSlot(k).inventory.getStackInSlot(k).getItem();
					break mouseOver;	
				}
			}
			super.drawScreen(x, y, f);
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
            int k = (this.width - this.xSize) / 2;
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"If you have problems ", k-6-47, 80, 14737632);
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"at building a coaster", k-6-47, 90, 14737632);
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"or want to learn more ", k-6-47, 100, 14737632);
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"about this mod, visit my", k-6-47, 110, 14737632);
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"YouTube channel:", k-6-47, 120, 14737632);
            if(dubliBool)
            {
            	if(dubliStr == null && new File("true.true").exists())
    			{
    				try{
    					BufferedReader br = new BufferedReader(new FileReader(new File("true.true")));
    					String yourString = br.readLine();
    					this.dubliStr = br.readLine();
    					br.close();
    				}catch(Exception e){//this generic but you can control another types of exception
    				}
    			}
            	this.dubli.visible = true;
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"If you want to support ", k-6-47+200, 80, 14737632);
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"me AND receive up to", k-6-47+200, 90, 14737632);
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"30% cashback in over", k-6-47+200, 100, 14737632);
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"9000 online shops", k-6-47+200, 110, 14737632);
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"visit this page:", k-6-47+200, 120, 14737632);
            }else
            	this.dubli.visible = false;
            if(this.updateBool)
            {
            	this.update.visible = true;
	            fontrenderer.drawStringWithShadow(EnumChatFormatting.GREEN+"Update available", k+25, 25, 14737632);
            }else
            	this.update.visible = false;

			int l = (this.height - ySize) / 2;

            fontrenderer.drawStringWithShadow(EnumChatFormatting.RED+"choose your tool",k-6+this.slot*20-140, l+165, 14737632);
		}
		
	    private boolean isMouseOverSlot(Slot p_146981_1_, int p_146981_2_, int p_146981_3_)
	    {
	        return this.func_146978_c(p_146981_1_.xDisplayPosition, p_146981_1_.yDisplayPosition, 16, 16, p_146981_2_, p_146981_3_);
	    }
		
		public void initGui()
		{
			super.initGui();
			this.buttonList.clear();
			int posX = (this.width - xSize) / 2;
			int posY = (this.height - ySize) / 2;
            int k = (this.width - this.xSize) / 2;
            ytb = new GuiYoutubeBtn(20,k-6-47, 135, 60,20,"");
            dubli = new GuiYoutubeBtn(21,k-6-47+200, 135, 60,20,"");
            update = new GuiButton(22,k-6-47+165, 20, 60,20,"Update");
            this.buttonList.add(ytb);
            this.buttonList.add(dubli);
            this.buttonList.add(update);
            this.dubli.visible = false;
        	this.update.visible = false;
        	if(new File("update.lol").exists())
        	{
        		this.update.visible = true;
        		this.updateBool = true;
        	}else
        	{
        		this.update.visible = false;
        		this.updateBool = false;
        	}

			Date parsedDate = null;
	    	Calendar calendar = Calendar.getInstance();
	 		java.util.Date now = calendar.getTime();
			if(new File("true.true").exists())
			{
				if(new File("false.false").exists())
					new File("false.false").delete();
				try{
					BufferedReader br = new BufferedReader(new FileReader(new File("true.true")));
					String yourString = br.readLine();
					br.close();
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				    parsedDate = dateFormat.parse(yourString);
				}catch(Exception e){//this generic but you can control another types of exception
				}
				this.dubliBool = true;
				dubli.visible = true;
			}else
				dubli.visible = false;
			if(new File("false.false").exists())
			{
				if(new File("true.true").exists())
					new File("true.true").delete();
				try{
					BufferedReader br = new BufferedReader(new FileReader(new File("false.false")));
					String yourString = br.readLine();
					this.dubliStr = br.readLine();
					br.close();
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				    parsedDate = dateFormat.parse(yourString);
				}catch(Exception e){//this generic but you can control another types of exception
				}
			}
			
			if((parsedDate == null || now.getDate() != parsedDate.getDate()))
			{
				if(new File("true.true").exists())
					new File("true.true").delete();
				if(new File("false.false").exists())
					new File("false.false").delete();
				  this.dubliBool = false;
			      DemoThread demoThread;
			      demoThread = new DemoThread(this);
			      demoThread.start();
			      updateThread up;
			      up = new updateThread(this);
			      up.start();
			      /**
				CloseableHttpClient cl3 = new DefaultHttpClient();
				try{
					HttpGet post = new HttpGet("https://www.youtube.com/channel/UCIqmSmKiq23rx2eQTyYMfPw?view_as=subscriber");
					HttpResponse response2 = cl3.execute(post);
					BufferedReader rd2 = new BufferedReader(new InputStreamReader(response2.getEntity().getContent()));
					StringBuffer result2 = new StringBuffer();
					String line2 = "";
					while ((line2 = rd2.readLine()) != null) {
					    result2.append(line2);
					    if(line2.contains("turn up the pace"))
					    {
					    	PrintWriter wr = new PrintWriter(new FileWriter(new File("true.true")));
					    	wr.println(new java.sql.Timestamp(now.getTime()));
					    	wr.close();
							cl3.close();
							break;
					    }
					}
					if(!new File("true.true").exists())
					{
				    	PrintWriter wr = new PrintWriter(new FileWriter(new File("false.false")));	
				    	java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
				    	wr.println(currentTimestamp);
				    	wr.close();
					}
					cl3.close();
				}catch(Exception e)
				{}*/
			}
		}
		
	    public boolean doesGuiPauseGame()
	    {
	        return false;
	    }
		
		
		public void actionPerformed(GuiButton button)
		{
			if(button.id == 20)
			{
				try {
					this.openUrl("https://www.youtube.com/channel/UCIqmSmKiq23rx2eQTyYMfPw");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			if(button.id == 21)
			{
				if(this.dubliStr != null)
				{
					try {
						this.openUrl(this.dubliStr);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}
			if(button.id == 22)
			{
				try {
					this.openUrl("http://www.planetminecraft.com/mod/minecoaster-3336972/");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		public void openUrl(String url) throws IOException, URISyntaxException {
			  if(java.awt.Desktop.isDesktopSupported() ) {
			        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			        if(desktop.isSupported(java.awt.Desktop.Action.BROWSE) ) {
			          java.net.URI uri = new java.net.URI(url);
			              desktop.browse(uri);
			        }
			      } 
			}

		@Override
		protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
				int p_146976_2_, int p_146976_3_) {
			
			ResourceLocation texture = new ResourceLocation("roller:textures/gui/widgets.png");
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture(texture);
            int k = (this.width - this.xSize) / 2;
            int l = (this.height - this.ySize) / 2;
            this.drawTexturedModalRect(k-3, l+181, 0, 0, 182, 22);
            this.drawTexturedModalRect(k-6+this.slot*20-57, l+160, 0, 23, 141, 21);
			
		}
	}

	  class DemoThread extends Thread {
		  
		  GuiWrench gu;
		  GuiTracks gu2;
		  
		  DemoThread(GuiWrench g)
		  {
			  this.gu = g;
		  }
		  
		    public DemoThread(GuiTracks guiTracks) {
		    	this.gu2 = guiTracks;
		    }

			public void run() {
			    	Calendar calendar = Calendar.getInstance();
			 		java.util.Date now = calendar.getTime();
		        	CloseableHttpClient cl3 = new DefaultHttpClient();
					try{
						HttpGet post = new HttpGet("https://www.youtube.com/channel/UCIqmSmKiq23rx2eQTyYMfPw?view_as=subscriber");
						HttpResponse response2 = cl3.execute(post);
						BufferedReader rd2 = new BufferedReader(new InputStreamReader(response2.getEntity().getContent()));
						StringBuffer result2 = new StringBuffer();
						String line2 = "";
						while ((line2 = rd2.readLine()) != null) {
						    result2.append(line2);
						    if(line2.contains("Support me and receive up to 30% cashback in over 9000 online shops"))
						    {
						    	PrintWriter wr = new PrintWriter(new FileWriter(new File("true.true")));
						    	wr.println(new java.sql.Timestamp(now.getTime()));
						    	wr.println(line2.substring(line2.indexOf("Support me and receive up to 30% cashback in over 9000 online shops")+"Support me and receive up to 30% cashback in over 9000 online shops".length()+1, line2.indexOf('#', line2.indexOf("Support me and receive up to 30% cashback in over 9000 online shops"))));
						    	wr.close();
						    	if(gu != null)
						    		gu.dubliBool = true;
						    	else if(gu2 != null)
						    		gu2.dubliBool = true;
								cl3.close();
								break;
						    }
						}
						if(!new File("true.true").exists())
						{
					    	PrintWriter wr = new PrintWriter(new FileWriter(new File("false.false")));	
					    	java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
					    	wr.println(currentTimestamp);
					    	wr.close();
						}
						cl3.close();
					}catch(Exception e)
					{}
		      }
	  }
		    
		    class updateThread extends Thread {
				  
				  GuiWrench gu;
				  GuiTracks gu2;

				  updateThread(GuiWrench g)
				  {
					  this.gu = g;
				  }
				  
				    public updateThread(GuiTracks guiTracks) {
				    	this.gu2 = guiTracks;
				    }

					public void run() {
					    	Calendar calendar = Calendar.getInstance();
					 		java.util.Date now = calendar.getTime();
				        	CloseableHttpClient cl3 = new DefaultHttpClient();
							try{
								HttpGet post = new HttpGet("https://www.youtube.com/channel/UCIqmSmKiq23rx2eQTyYMfPw?view_as=subscriber");
								HttpResponse response2 = cl3.execute(post);
								BufferedReader rd2 = new BufferedReader(new InputStreamReader(response2.getEntity().getContent()));
								StringBuffer result2 = new StringBuffer();
								String line2 = "";
								while ((line2 = rd2.readLine()) != null) {
								    result2.append(line2);
								    if(line2.contains("Newest MineCoaster version:"))
								    {
								    	String tmp = line2.substring(line2.indexOf("Newest MineCoaster version:")+28, line2.indexOf('#', line2.indexOf("Newest MineCoaster version:")+28));
								    	System.out.println(tmp);
								    	if(!tmp.equals(Main.version))
								    	{
								    		if(!new File("update.lol").exists())
								    			new File("update.lol").createNewFile();
									    	if(gu != null)
									    		gu.updateBool = true;
									    	else if(gu2 != null)
									    		gu2.updateBool = true;			
									    }else
									    {
								    		if(new File("update.lol").exists())
								    			new File("update.lol").delete();
									    	if(gu != null)
									    		gu.updateBool = false;
									    	else if(gu2 != null)
									    		gu2.updateBool = false;
									    }
										cl3.close();
										break;
								    }
								}
								cl3.close();
							}catch(Exception e)
							{}
				      }
		    }
	

