package com.roller.roller.tileEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TEWallpic extends TileEntity{

	public int turn;
	public ResourceLocation pic = new ResourceLocation("roller:/textures/wallpics/base.png");
	String tmp2;
//	List<File> fileList = new ArrayList<File>();
	
	public void updateEntity()
	{
		File folder = new File("saves/"+Minecraft.getMinecraft().getIntegratedServer().getFolderName()+"/wallpics");
		if(!folder.exists())
		{
			folder.mkdir();
		}
	}
	
	public List getFileList()
	{
		List<File> fileList = new ArrayList<File>();
		File folder = new File("saves/"+Minecraft.getMinecraft().getIntegratedServer().getFolderName()+"/wallpics");
		File[] listOfFiles = folder.listFiles();

		if(listOfFiles != null)
		{
			for (File file : listOfFiles) {
			    if (file.isFile() && file.toString().endsWith(".png")) {
			    	fileList.add(file);
			        System.out.println(file.getName());
			    }
			}
		}
		return fileList;
	}
	
    
    @Override
    public void readFromNBT(NBTTagCompound k)
    {
        super.readFromNBT(k);
        String tmp = k.getString("loc");
        System.out.println("cockfuck3 "+tmp);
        if(tmp != null && tmp.length() > 5)
        	this.pic = new ResourceLocation(tmp);
        this.turn = k.getInteger("tur");
    }
    
    @Override
    public void writeToNBT(NBTTagCompound k)
    {
        super.writeToNBT(k);
        String tmp = this.pic.toString();
        System.out.println("cockfuck72 "+tmp);
        k.setString("loc", tmp);
        k.setInteger("tur", this.turn);
   }
    
	@Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		NBTTagCompound k = packet.func_148857_g();
        String tmp = k.getString("loc");
        System.out.println("cockfuck2 "+tmp);
        if(tmp != null && tmp.length() > 5)
        	this.pic = new ResourceLocation(tmp);
        this.turn = k.getInteger("tur");
    }
	
	public Packet getDescriptionPacket()
	{
		NBTTagCompound k = new NBTTagCompound();
	    String tmp = this.pic.toString();
	    System.out.println("cockfuck73 "+tmp);
        k.setString("loc", tmp);
        k.setInteger("tur", this.turn);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, k);
	}
	
}
