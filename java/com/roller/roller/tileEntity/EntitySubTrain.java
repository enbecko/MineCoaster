package com.roller.roller.tileEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;

import com.roller.roller.Main;
import com.roller.roller.models.ModelSubTrain;

public class EntitySubTrain extends EntityTrain{

	EntityMainTrain train;
	boolean fucker2;
	public ModelSubTrain model;;
	int abstand;
	int trainID;
	
	public EntitySubTrain(World w, double x, double y,
			double z, int k, int h, EntityMainTrain tr) {
		super(w, x, y, z, 0);
		this.train = tr;
		this.abstand = h;
	//	System.out.println(this.train+" "+w+" mutti");

		this.move = true;
	}
	
	public EntitySubTrain(World par1World) {
		super(par1World);
	}
	
	public void onUpdate()
	{
		if(model == null)
			model = new ModelSubTrain(this);
		if (!fucker2) {
			if (!this.worldObj.isRemote) {
				try {
					int xtmp2 = (int) (this.posX);
					int ztmp2 = (int) (this.posZ);
					if (xtmp2 < 0)
						xtmp2 -= 1;
					else if (xtmp2 == 0 && this.posX < 0)
						xtmp2 -= 1;
					if (ztmp2 < 0)
						ztmp2 -= 1;
					else if (ztmp2 == 0 && this.posZ < 0)
						ztmp2 -= 1;

					PrintWriter bw = new PrintWriter(new FileWriter(new File("trains/subs/"+
							xtmp2 + "_" + (int) this.posY + "_" + ztmp2
									+ ".tst")));
					bw.println(train.getEntityId());
					System.out.println("heyhey "+train.getEntityId());
					bw.println(this.abstand);
					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				fucker2 = true;
			}

		}
		if (tik2 < 2)
			tik2++;
		else if (!fucker2) {
			int xtmp2 = (int) (this.posX);
			int ztmp2 = (int) (this.posZ);
			if (xtmp2 < 0)
				xtmp2 -= 1;
			else if (xtmp2 == 0 && this.posX < 0)
				xtmp2 -= 1;
			if (ztmp2 < 0)
				ztmp2 -= 1;
			else if (ztmp2 == 0 && this.posZ < 0)
				ztmp2 -= 1;
			if (this.worldObj.isRemote
					&& new File("trains/subs/"+xtmp2 + "_" + (int) this.posY + "_" + ztmp2
							+ ".tst").exists()) {
				try {
					BufferedReader bw = new BufferedReader(new FileReader(
							new File("trains/subs/"+xtmp2 + "_" + (int) this.posY + "_"
									+ ztmp2 + ".tst")));
					System.out.println("heyhey "+this.trainID);
					this.trainID = Integer.parseInt(bw.readLine());
					this.abstand = Integer.parseInt(bw.readLine());
					this.train = (EntityMainTrain) this.getEntity(trainID);
					System.out.println("heyhey "+train);
					File f = new File("trains/subs/"+xtmp2 + "_" + (int) this.posY + "_"
							+ ztmp2 + ".tst");
					bw.close();
					System.out.println(f.delete());
				} catch (Exception e) {
					e.printStackTrace();
				}
				fucker2 = true;
			}
		}
		if(train != null && train.isDead)
		{
			this.setDead();
			Main.trains.remove(this);
		}
		super.onUpdate();
	}
	
	public Entity getEntity(int id)
	{
		for(int k = 0; k < this.worldObj.getLoadedEntityList().size(); k++)
		{
			if(((Entity)this.worldObj.getLoadedEntityList().get(k)).getEntityId() == id)
				return ((Entity)this.worldObj.getLoadedEntityList().get(k));
		}
		return null;
	}
	
	public void setDead() {
		{
			ItemStack stk = new ItemStack(Main.subTrain);
			stk.stackTagCompound = new NBTTagCompound();
			stk.stackTagCompound.setInteger("red", this.red);
			stk.stackTagCompound.setInteger("gre", this.green);
			stk.stackTagCompound.setInteger("blu", this.blue);
			EntityItem it = new EntityItem(this.worldObj,this.posX, this.posY, this.posZ, stk);
			it.delayBeforeCanPickup = 0;
			if (!this.worldObj.isRemote)
				this.worldObj.spawnEntityInWorld(it);
		}
		this.isDead = true;
	}
	
	public boolean attackEntityFrom(DamageSource s, float par2) {
		EntityPlayer p = null;
		if(s != null && s instanceof EntityDamageSource && ((EntityDamageSource)s).getEntity() instanceof EntityPlayer)
			p = (EntityPlayer)((EntityDamageSource)s).getEntity();	
		if(train != null && train.getLastIndex()-1 == this.abstand)
		{
			if(p != null)
			{
				if(!p.capabilities.isCreativeMode)
					this.setDead(p);
				else
					this.isDead = true;
			}else
				this.isDead = true;
			train.subCount--;
			Main.trains.remove(this);
		}else if(train != null && train.getLastIndex() != this.abstand)
		{
			for(int k = 0; k < 10-1; k++)
			{
	    		p.addChatMessage(new ChatComponentText(""));  
			}
			p.addChatMessage(new ChatComponentText("You can only destroy the last carriage"));
		}
		else if(this.train == null)
		{
			if(p != null)
			{
				if(!p.capabilities.isCreativeMode)
					this.setDead(p);
				else
					this.isDead = true;
			}else
				this.isDead = true;
		}
		return true;
	}
	
	public void setDead(EntityPlayer p) {
			ItemStack stk = new ItemStack(Main.subTrain);
			stk.stackTagCompound = new NBTTagCompound();
			stk.stackTagCompound.setInteger("red", this.red);
			stk.stackTagCompound.setInteger("gre", this.green);
			stk.stackTagCompound.setInteger("blu", this.blue);
			EntityItem it = new EntityItem(this.worldObj, p.posX, p.posY, p.posZ, stk);
			it.delayBeforeCanPickup = 0;
			if (!this.worldObj.isRemote)
				this.worldObj.spawnEntityInWorld(it);
			this.isDead = true;
	}
	
	public void setSpeed(Base b)
	{
		if(this.train != null)
		{
			System.out.println(this.train.speedMultiplier);
			if(this.getDisToMain() < 1.8F*(this.abstand+1))
				this.speedMultiplier = this.train.speedMultiplier*0.92F;
			else if(this.getDisToMain() > 1.8F*(this.abstand+1))
				this.speedMultiplier = this.train.speedMultiplier*1.08F;
			else
				this.speedMultiplier = this.train.speedMultiplier;
			if(this.train.isDead)
			{
				this.train = null;
				this.speedMultiplier = 0;
			}
		}
		
	}
	
	public void updateRiderPosition() {
		
		super.updateRiderPosition();
		if(this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
			((EntityPlayer)this.riddenByEntity).addPotionEffect(new PotionEffect(14, 3, 1,false));
		
	}

	public float getDisToMain()
	{
		return (float) Math.sqrt(Math.pow(train.posX-this.posX, 2)+Math.pow(train.posY-this.posY, 2)+Math.pow(train.posZ-this.posZ, 2));
	}
	
	public boolean interactFirst(EntityPlayer p) {

		if(p.inventory.getCurrentItem() != null && p.inventory.getCurrentItem().isItemEqual(new ItemStack(Main.paintBrush)))
		{
	    	p.openGui(Main.instance, 55, this.worldObj, this.getEntityId(), 0, 0);
	    	return true;
		}
		else{
			if (this.riddenByEntity != null
					&& this.riddenByEntity instanceof EntityPlayer
					&& this.riddenByEntity != p) {
				return true;
			} else {
				if (!this.worldObj.isRemote) {
					p.mountEntity(this);
				}
		
				return true;
			}
		}

	}
	
}
