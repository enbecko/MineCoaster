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
import net.minecraft.util.EnumChatFormatting;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.roller.roller.tileEntity.EntityTrain;

import cpw.mods.fml.client.config.GuiSlider;

	public class GuiTrainColor extends GuiContainer	
	{
		
		public EntityPlayer player;
		GuiButton ytb, dubli, update, save;
		boolean dubliBool;
		GuiSlider red, green, blue;
		EntityTrain train;
		
		public GuiTrainColor(EntityPlayer pl, EntityTrain train)
		{
			super(new ContainerTrainColor(train));
			this.player = pl;
			this.train = train;
		}
		
		@Override
		public void drawScreen(int x, int y, float f)
		{
			super.drawScreen(x, y, f);
			this.train.red = this.red.getValueInt();
			this.train.green = this.green.getValueInt();
			this.train.blue = this.blue.getValueInt();
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
            int k = (this.width) / 2;
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"If you have problems ", 30, 80, 14737632);
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"at building a coaster", 30, 90, 14737632);
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"or want to learn more ", 30, 100, 14737632);
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"about this mod, visit my", 30, 110, 14737632);
            fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"YouTube channel:", 30, 120, 14737632);
            if(dubliBool)
            {
            	this.dubli.visible = true;
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"If you want to support ", 230, 80, 14737632);
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"me AND receive up to", 230, 90, 14737632);
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"30% cashback in over", 230, 100, 14737632);
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"3000 online shops", 230, 110, 14737632);
                fontrenderer.drawStringWithShadow(EnumChatFormatting.WHITE+"visit this page:", 230, 120, 14737632);
            }else
            	this.dubli.visible = false;
            
            fontrenderer.drawStringWithShadow(EnumChatFormatting.GREEN+"Update available", k-65, 25, 14737632);

			int l = (this.height) / 2;

		}
		
		public void initGui()
		{
			super.initGui();
			this.buttonList.clear();
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
            int k = (this.width) / 2;
			int l = (this.height) / 2;
			ytb = new GuiYoutubeBtn(20,45, 135, 60,20,"");
            dubli = new GuiYoutubeBtn(21,245, 135, 60,20,"");
            update = new GuiButton(22,k+20, 20, 60,20,"Update");
            save = new GuiButton(23,k-30, l+50, 60,20,"save");
            red = new GuiSlider(75, k-155, l+75, 80, 20, "red ", "", 1, 32, train.red, false, true);
            green = new GuiSlider(76, k-40, l+75, 80, 20, "green ", "", 1, 32, train.green, false, true);
            blue = new GuiSlider(77, k+75, l+75, 80, 20, "blue ", "", 1, 32, train.blue, false, true);
            this.buttonList.add(ytb);
            this.buttonList.add(dubli);
            this.buttonList.add(update);
            this.buttonList.add(red);
            this.buttonList.add(green);
            this.buttonList.add(blue);
            this.buttonList.add(save);
            this.dubli.visible = false;

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
					br.close();
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				    parsedDate = dateFormat.parse(yourString);
				}catch(Exception e){//this generic but you can control another types of exception
				}
			}
			
			if((parsedDate == null || now.getMinutes() != parsedDate.getMinutes()))
			{
			      DemoThread2 demoThread;

			      demoThread = new DemoThread2();
			      demoThread.start();
			      System.out.println(demoThread.isAlive());
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
				try {
					this.openUrl("https://www.youtube.com/watch?v=ldOngkCfvdQ");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			if(button.id == 22)
			{
				try {
					this.openUrl("http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/wip-mods/2439505-1-7-10-wip-minecoaster-roller-coasters-working");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			if(button.id == 23)
			{
				String tmp = "";
				tmp += red.getValueInt() < 10 ? "0"+red.getValueInt() : red.getValueInt();
				tmp += green.getValueInt() < 10 ? "0"+green.getValueInt() : green.getValueInt();
				tmp += blue.getValueInt() < 10 ? "0"+blue.getValueInt() : blue.getValueInt();
				System.out.println(tmp);
				this.mc.playerController.sendEnchantPacket(this.inventorySlots.windowId, Integer.parseInt(tmp));
				this.mc.displayGuiScreen(null);
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
			// TODO Auto-generated method stub
			
		}
}
	

	  class DemoThread2 extends Thread {
		  
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
					{}
		      }
	}

