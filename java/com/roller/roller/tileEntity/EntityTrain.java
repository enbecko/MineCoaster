package com.roller.roller.tileEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.roller.roller.Main;
import com.roller.roller.models.ModelTrain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTrain extends Entity {
	/** true if no player in boat */
	public boolean isBoatEmpty, gemeldet, transition, fucker;
	public double speedMultiplier;
	public int[] vek = new int[3];
	private int boatPosRotationIncrements;
	public float playerOffX, playerOffX2, transitionDisFull, transitionDisPart,
			prevTransitionDisPart;
	private float playerOffY, playerOffY2;
	private float playerOffZ, playerOffZ2;
	public double boatYaw;
	public int color, tik2, red = 32, green = 32, blue = 32;
	public Base act, prevAct, aim, transAim, transAct, screener;
	public int turn, turn2, rot, xTurn, yTurn, zTurn, offTicker, k;
	public float speed, yOff;
	private double boatPitch;
	@SideOnly(Side.CLIENT)
	private double velocityX;
	@SideOnly(Side.CLIENT)
	private double velocityY;
	@SideOnly(Side.CLIENT)
	private double velocityZ;
	public boolean move = true;
	public ModelTrain model;

	private static final String __OBFID = "CL_00001667";

	public EntityTrain(World par1World) {
		super(par1World);
		this.isBoatEmpty = true;
		this.preventEntitySpawning = true;
		this.setSize(1F, 1F);
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	protected boolean canTriggerWalking() {
		return false;
	}

	protected void entityInit() {
		this.dataWatcher.addObject(17, new Integer(0));
		this.dataWatcher.addObject(18, new Integer(1));
		this.dataWatcher.addObject(19, new Float(0.0F));
	}

	public void setSreenToTake(Base b) {
		this.screener = b;
	}

	/**
	 * Returns a boundingBox used to collide the entity with other entities and
	 * blocks. This enables the entity to be pushable on contact, like boats or
	 * minecarts.
	 */
	public AxisAlignedBB getCollisionBox(Entity par1Entity) {
		return par1Entity.boundingBox;
	}

	/**
	 * returns the bounding box for this entity
	 */
	public AxisAlignedBB getBoundingBox() {
		return this.boundingBox;
	}

	/**
	 * Returns true if this entity should push and be pushed by other entities
	 * when colliding.
	 */
	public boolean canBePushed() {
		return false;
	}

	public EntityTrain(World par1World, double par2, double par4, double par6,
			int c) {
		this(par1World);
		this.setPosition(par2, par4, par6);
		this.color = c;
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = par2;
		this.prevPosY = par4;
		this.prevPosZ = par6;
	}

	public EntityTrain(World par1World, double par2, double par4, double par6,
			boolean aha) {
		this(par1World, par2, par4, par6, 0);
		this.move = aha;
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding
	 * this one.
	 */

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource s, float par2) {
		EntityPlayer p = null;
		if(s instanceof EntityDamageSource && ((EntityDamageSource)s).getEntity() instanceof EntityPlayer)
			p = (EntityPlayer)((EntityDamageSource)s).getEntity();
		if(p != null)
		{
			if(!p.capabilities.isCreativeMode)
				this.setDead(p);
			else
				this.isDead = true;
		}else
			this.isDead = true;
		Main.trains.remove(this);
		return true;
	}

	public void setDead(EntityPlayer p) {
		{
			ItemStack stk = new ItemStack(Main.train);
			stk.stackTagCompound = new NBTTagCompound();
			stk.stackTagCompound.setInteger("red", this.red);
			stk.stackTagCompound.setInteger("gre", this.green);
			stk.stackTagCompound.setInteger("blu", this.blue);
			EntityItem it = new EntityItem(this.worldObj,p.posX, p.posY, p.posZ, stk);
			it.delayBeforeCanPickup = 0;
			if (!this.worldObj.isRemote)
				this.worldObj.spawnEntityInWorld(it);
		}
		this.isDead = true;
	}

	public void setDead() {
		{
			ItemStack stk = new ItemStack(Main.train);
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
	/**
	 * Setups the entity to do the hurt animation. Only used by packets in
	 * multiplayer.
	 */
	@SideOnly(Side.CLIENT)
	public void performHurtAnimation() {
		this.setForwardDirection(-this.getForwardDirection());
		this.setTimeSinceHit(10);
		this.setDamageTaken(this.getDamageTaken() * 11.0F);
	}

	/**
	 * Returns true if other Entities should be prevented from moving through
	 * this Entity.
	 */
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	/**
	 * Sets the position and rotation. Only difference from the other one is no
	 * bounding on the rotation. Args: posX, posY, posZ, yaw, pitch
	 */
	@SideOnly(Side.CLIENT)
	public void setPositionAndRotation2(double par1, double par3, double par5,
			float par7, float par8, int par9) {
		this.boatYaw = 90;
		this.boatPitch = 0;
		this.motionX = this.velocityX;
		this.motionY = this.velocityY;
		this.motionZ = this.velocityZ;
	}

	/**
	 * Sets the velocity to the args. Args: x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public void setVelocity(double par1, double par3, double par5) {
		this.velocityX = this.motionX = par1;
		this.velocityY = this.motionY = par3;
		this.velocityZ = this.motionZ = par5;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		if(model == null)
			model = new ModelTrain(this);
		if (!fucker) {
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

					PrintWriter bw = new PrintWriter(new FileWriter(new File("trains/"+
							xtmp2 + "_" + (int) this.posY + "_" + ztmp2
									+ ".tst")));
					bw.println(this.red);
					bw.println(this.green);
					bw.println(this.blue);
					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				fucker = true;
			}

		}
		if (tik2 < 2)
			tik2++;
		else if (!fucker) {
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
					&& new File("trains/"+xtmp2 + "_" + (int) this.posY + "_" + ztmp2
							+ ".tst").exists()) {
				try {
					BufferedReader bw = new BufferedReader(new FileReader(
							new File("trains/"+xtmp2 + "_" + (int) this.posY + "_"
									+ ztmp2 + ".tst")));
					this.red = Integer.parseInt(bw.readLine());
					this.green = Integer.parseInt(bw.readLine());
					this.blue = Integer.parseInt(bw.readLine());
					File f = new File("trains/"+xtmp2 + "_" + (int) this.posY + "_"
							+ ztmp2 + ".tst");
					bw.close();
					System.out.println(f.delete());
				} catch (Exception e) {
					e.printStackTrace();
				}
				fucker = true;
			}
		}
		if (move) {
			if (act != null && this.act.start
					&& this.act instanceof EntityTrackBase
					&& ((EntityTrackBase) this.act).powered) {
				if (speed <= 0)
					this.speed += 1;
			}
			if (aim != null) {
				float mul = 1;
				if (act != null
						&& (act instanceof EntityTrackHor
								|| act instanceof EntityTrackHorTop
								|| act instanceof EntityTrackQuer
								|| act instanceof EntityTrackQuerTop || act instanceof EntityTrackPitchedCurve))
					mul = (float) (1 / Math.sqrt(2));
				if (act != null
						&& (act instanceof EntityTrack225
								|| act instanceof EntityTrack225_2
								|| act instanceof EntityTrack225Top || act instanceof EntityTrack225_2Top))
					mul = (float) ((1 / Math.sqrt(1.25F)) / 2);

				int xtmp2 = (int) (this.posX + vek[0] * this.speedMultiplier
						* mul);
				int ztmp2 = (int) (this.posZ + vek[2] * this.speedMultiplier
						* mul);
				int ytmp2 = (int) (this.posY + vek[1] * this.speedMultiplier
						* mul);
				boolean xOff, yOff, zOff;

				if (xtmp2 < 0)
					xtmp2 -= 1;
				else if (xtmp2 == 0 && this.posX < 0)
					xtmp2 -= 1;
				if (ztmp2 < 0)
					ztmp2 -= 1;
				else if (ztmp2 == 0 && this.posZ < 0)
					ztmp2 -= 1;

				if (this.worldObj.getTileEntity(xtmp2, ytmp2, ztmp2) != act
						&& aim != null && this.worldObj.getTileEntity(xtmp2, ytmp2, ztmp2) instanceof EntityTrackCurve == false&& this.worldObj.getTileEntity(xtmp2, ytmp2, ztmp2) instanceof EntityTrackTurn == false) {
					xOff = (xtmp2 != act.xCoord);
					yOff = (ytmp2 != act.yCoord);
					zOff = (ztmp2 != act.zCoord);
					float dis = (float) (this.speedMultiplier * mul);
					if(aim instanceof EntityTrackQuer == false)
					{
						if (aim.yCoord < act.yCoord)
							this.posY = aim.yCoord + 0.999F;
						else if (aim.yCoord > act.yCoord)
							this.posY = aim.yCoord;
	
						if (aim.xCoord > act.xCoord)
							this.posX = aim.xCoord;
						else if (aim.xCoord < act.xCoord)
							this.posX = aim.xCoord + 0.999F;
	
						if (aim.zCoord > act.zCoord)
							this.posZ = aim.zCoord;
						else if (aim.zCoord < act.zCoord)
							this.posZ = aim.zCoord + 0.999F;
					}
					float disDiff = 0;
					if (xOff)
						disDiff = (float) (dis - Math.abs(this.posX
								- this.prevPosX)
								* mul);
					if (yOff)
						disDiff = (float) (dis - Math.abs(this.posY
								- this.prevPosY)
								* mul);
					if (zOff)
						disDiff = (float) (dis - Math.abs(this.posZ
								- this.prevPosZ)
								* mul);
					int xtmp = (int) this.posX;
					int ztmp = (int) this.posZ;

					if (xtmp < 0)
						xtmp -= 1;
					else if (xtmp == 0 && this.posX < 0)
						xtmp -= 1;
					if (ztmp < 0)
						ztmp -= 1;
					else if (ztmp == 0 && this.posZ < 0)
						ztmp -= 1;

					if (this.worldObj
							.getTileEntity(xtmp, (int) this.posY, ztmp) instanceof Base &&this.worldObj.getTileEntity(xtmp, (int) this.posY, ztmp) instanceof EntityTrackCurve == false ) {
							
						Base b = ((Base) this.worldObj.getTileEntity(xtmp,
								(int) this.posY, ztmp));
						float mul2 = 1;
						if (b != null
								&& (b instanceof EntityTrackHor
										|| b instanceof EntityTrackHorTop
										|| b instanceof EntityTrackQuer
										|| b instanceof EntityTrackQuerTop || b instanceof EntityTrackPitchedCurve))
							mul2 = (float) (1 / Math.sqrt(2));
						if (b != null
								&& (b instanceof EntityTrack225
										|| b instanceof EntityTrack225_2
										|| b instanceof EntityTrack225Top || b instanceof EntityTrack225_2Top))
							mul2 = (float) ((1 / Math.sqrt(1.25F)) / 2);
						int[] tmp = b.getVek(vek, this);
						if (tmp != null) {
							this.posX += tmp[0] * disDiff * mul2;
							this.posY += tmp[1] * disDiff * mul2;
							this.posZ += tmp[2] * disDiff * mul2;
						}
					}
				} else {
					this.posX += vek[0] * this.speedMultiplier * mul;

					this.posY += vek[1] * this.speedMultiplier * mul;

					this.posZ += vek[2] * this.speedMultiplier * mul;
				}

				if (act.HasHalfway() && aim.HasHalfway()) {
					float disAct = (float) act.getDisTillHalf(this);
					float disPrev = (float) act.getDisTillHalfPrev(this);
					if (!transition
							&& (act.getClass().equals(aim.getClass()) == false && ((act
									.getClass().toString().contains("225") && aim
									.getClass().toString().contains("225")) == false))) {
						if (disAct > disPrev) {
							transition = true;
							this.transitionDisFull = (float) (act
									.getDisTillOutFromHalf() + aim
									.getDisTillOutFromHalf());
							this.transAim = aim;
							transAct = act;
						}

					}
				}
				if (transition) {
					int xtmp = (int) this.posX;
					int ztmp = (int) this.posZ;

					if (xtmp < 0)
						xtmp -= 1;
					else if (xtmp == 0 && this.posX < 0)
						xtmp -= 1;
					if (ztmp < 0)
						ztmp -= 1;
					else if (ztmp == 0 && this.posZ < 0)
						ztmp -= 1;

					if (this.worldObj
							.getTileEntity(xtmp, (int) this.posY, ztmp) instanceof Base) {
						Base b = ((Base) this.worldObj.getTileEntity(xtmp,
								(int) this.posY, ztmp));
						float dis2;
						// if(transAim.getVek(vek, train))

						if (b == transAct)
							this.transitionDisPart = (float) (transAct
									.getDisTillOut(this) + transAim
									.getDisTillOutFromHalf());
						else if (b == transAim)
							this.transitionDisPart = (float) (transAim
									.getDisTillHalf(this));
						if (this.transitionDisPart > this.prevTransitionDisPart
								|| (this.act != this.transAct && this.act != this.transAim))
							this.transition = false;
						this.prevTransitionDisPart = this.transitionDisPart;

					}
				}
				this.setPosition(this.posX, this.posY, this.posZ);
			}
		}

		if (this.getTimeSinceHit() > 0) {
			this.setTimeSinceHit(this.getTimeSinceHit() - 1);
		}

		if (this.getDamageTaken() > 0.0F) {
			this.setDamageTaken(this.getDamageTaken() - 1.0F);
		}
		// this.posX+= 0.005F;
		byte b0 = 5;
		double d0 = 0.0D;

		int xtmp = (int) this.posX;
		int ztmp = (int) this.posZ;

		if (xtmp < 0)
			xtmp -= 1;
		else if (xtmp == 0 && this.posX < 0)
			xtmp -= 1;
		if (ztmp < 0)
			ztmp -= 1;
		else if (ztmp == 0 && this.posZ < 0)
			ztmp -= 1;
		// System.out.println(this.posZ+" "+this.posY);

		// System.out.println("cock2 "+" "+this.posX+" "+xtmp+" "+this.posZ+" "+ztmp);

		// System.out.println((int)(this.speedMultiplier*1200)
		// +" B/min ("+(float)(this.speedMultiplier*20)+" B/sec)");

		if (this.worldObj.getTileEntity(xtmp, (int) this.posY, ztmp) instanceof Base) {
			Base b = ((Base) this.worldObj.getTileEntity(xtmp, (int) this.posY,
					ztmp));
			// System.out.println(b);
			this.setSpeed(b);

			// this.speedMultiplier = 0.02F;
			if (b instanceof EntityTrackBaseWater) {
				if (b.next instanceof EntityTrackBaseWater) {
					if (this.yOff < 0.2F)
						this.yOff += 0.03F;
					if (this.worldObj
							.getBlock(b.xCoord, b.yCoord - 1, b.zCoord) == Blocks.water) {
						if (this.speed > 15) {
							if (this.worldObj.isRemote) {
								if (b.alignment == 0 || b.alignment == 2) {
									for (int i = 0; i < this.speed / 4; i++) {
										this.worldObj.spawnParticle(
												"splash",
												this.posX + 0.6F,
												this.posY,
												this.posZ + 0.2F
														- Math.random() * 0.2F,
												0, 0, 0);
										this.worldObj.spawnParticle(
												"splash",
												this.posX - 0.45F,
												this.posY,
												this.posZ + 0.2F + 0.2F
														- Math.random() * 0.2F,
												0, 0, 0);
										this.worldObj.spawnParticle(
												"splash",
												this.posX + 0.6F,
												this.posY,
												this.posZ - 0.2F + 0.2F
														- Math.random() * 0.2F,
												0, 0, 0);
										this.worldObj.spawnParticle(
												"splash",
												this.posX - 0.45F,
												this.posY,
												this.posZ - 0.2F + 0.2F
														- Math.random() * 0.2F,
												0, 0, 0);
									}
								} else {
									for (int i = 0; i < this.speed / 4; i++) {
										this.worldObj.spawnParticle(
												"splash",
												this.posX + 0.2F + 0.2F
														- Math.random() * 0.2F,
												this.posY, this.posZ + 0.6F, 0,
												0, 0);
										this.worldObj.spawnParticle(
												"splash",
												this.posX + 0.2F + 0.2F
														- Math.random() * 0.2F,
												this.posY, this.posZ - 0.45F,
												0, 0, 0);
										this.worldObj.spawnParticle(
												"splash",
												this.posX - 0.2F + 0.2F
														- Math.random() * 0.2F,
												this.posY, this.posZ + 0.6F, 0,
												0, 0);
										this.worldObj.spawnParticle(
												"splash",
												this.posX - 0.2F + 0.2F
														- Math.random() * 0.2F,
												this.posY, this.posZ - 0.45F,
												0, 0, 0);
									}
								}

							}
						}
					}
				} else if (yOff > 0)
					this.yOff -= 0.03F;
			} else
				this.yOff = 0;
			{
				if (b != act
						|| (b instanceof EntityTrackHor && ((EntityTrackHor) b).stop)
						|| (b instanceof EntityTrackBase && ((EntityTrackBase) b).start)) {
					if (b.acceptsTrain(this)
							|| (b instanceof EntityTrackHor && ((EntityTrackHor) b).stop)
							|| (b instanceof EntityTrackBase && ((EntityTrackBase) b).start)) {
						this.act = b;
						int[] tmp = b.getVek(vek, this);
						if (tmp != null)
							this.vek = b.getVek(vek, this);
						if (this.vek[2] == 0) {
							if (this.vek[0] > 0)
								this.turn = 0;
							else if (this.vek[0] < 0)
								this.turn = 180;

						} else if (this.vek[0] == 0) {
							if (this.vek[2] > 0)
								this.turn = 90;
							else if (this.vek[2] < 0)
								this.turn = 270;
						} else if (this.vek[0] > 0) {
							if (this.vek[2] > 0)
								this.turn = 45;
							else if (this.vek[2] < 0)
								this.turn = -45;
						} else if (this.vek[0] < 0) {
							if (this.vek[2] > 0)
								this.turn = 135;
							else if (this.vek[2] < 0)
								this.turn = -135;
						}
						if (vek[0] == 0 && vek[2] == 0 && vek[1] != 0) {
							if (vek[1] < 0 && act != null && act.alignment == 2)
								turn = 90;
							else if (vek[1] < 0 && act != null
									&& act.alignment == 0)
								turn = 270;
							if (vek[1] < 0 && act != null && act.alignment == 3)
								turn = 0;
							else if (vek[1] < 0 && act != null
									&& act.alignment == 1)
								turn = 180;
						}
						if (b.next != null) {
							this.aim = b.next;
							if (!gemeldet) {
								this.gemeldet = true;
								System.out.println("cock2 "
										+ Arrays.toString(vek));
							}
						}
					}
				}
			}
		}

		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

	}

	public void setSpeed(Base b)
	{
		if (this.speed * b.getSpeedMultiplier(this) <= 200)
			this.speed *= b.getSpeedMultiplier(this);
		else
			this.speed = 200;
		this.speedMultiplier = -0.00002F * Math.pow(speed - 200, 2) + 0.8F;
	}
	
	public float getAsBTick(float speed) {
		return (float) (((-0.00002F * Math.pow(speed - 200, 2) + 0.8F)));
	}

	public void updateRiderPosition() {
		if (this.riddenByEntity != null) {
			if (act != null) {

				float d0 = act.getPlayerZOff(), dX;
				float d2 = act.getPlayerYOff(), dY;
				float d1 = act.getPlayerXOff(), dZ;
				if (act instanceof EntityTrackUp) {
					// this.move = false;
				}
				if (prevAct != null && act != prevAct) {
					playerOffX = prevAct.getPlayerXOff();
					playerOffY = prevAct.getPlayerYOff();
					playerOffZ = prevAct.getPlayerZOff();
					offTicker = 0;
					prevAct = act;
				} else if (prevAct == null) {
					prevAct = act;
				}
				dX = (float) (d1 - playerOffX);
				dY = (float) (d2 - playerOffY);
				dZ = (float) (d0 - playerOffZ);
				float disX = 1, disY = 1, disZ = 1;
				if (act != null
						&& act instanceof EntityTrackUp == false
						&& ((act instanceof EntityTrack225
								|| act instanceof EntityTrack225_2
								|| act instanceof EntityTrack225_2Top || act instanceof EntityTrack225Top) && act.alignment > 3) == false) {

					if (vek[2] > 0) {
						disZ = (float) (act.zCoord + 1 - this.posZ);
						disY = disZ;
					}
					if (vek[0] > 0) {
						disX = (float) (act.xCoord + 1 - this.posX);
						disY = disX;
					}
					if (vek[2] < 0) {
						disZ = (float) (this.posZ - act.zCoord);
						disY = disZ;
					}
					if (vek[0] < 0) {
						disX = (float) (this.posX - act.xCoord);
						disY = disX;
					}
					if (act instanceof EntityTrackTransition)
						disX = disZ = disY;

				} else if (act != null) {
					if (vek[1] > 0)
						disY = (float) (act.yCoord + 1 - this.posY);
					if (vek[1] < 0)
						disY = (float) (this.posY - act.yCoord);
					disZ = disY;
					disX = disY;
				}
				if (act instanceof EntityTrackTransition == false) {
					if ((float) offTicker / 20 < 1)
						offTicker++;
					if (1 - (float) offTicker / 20 < disZ
							&& 1 - (float) offTicker / 20 < disX
							&& 1 - (float) offTicker / 20 < disY) {
						disY = 1 - (float) offTicker / 20;
						disZ = disY;
						disX = disY;
					}
				}
				// if(1 == 2)
				{
					playerOffX2 = d1 = d1 - dX * disX;
					playerOffY2 = d2 = d2 - dY * disY;
					playerOffZ2 = d0 = d0 - dZ * disZ;
				}

				// System.out.println(d0+" "+disZ);
				// System.out.println(d1+" "+playerOffX);
				// System.out.println(d2+" "+playerOffY);
				if (this.turn2 != this.turn
						&& act instanceof EntityTrackTurn == false) {
					int tmp = 0;
					tmp = this.turn;
					if (act.getClass().toString().contains("Top") == false
							&& act instanceof EntityTrackQuer)
						this.riddenByEntity.setPositionAndRotation(this.posX
								+ d1, this.posY + this.getMountedYOffset()
								+ this.riddenByEntity.getYOffset() + d2
								- this.yOff, this.posZ + d0, tmp - 90,
								this.riddenByEntity.rotationPitch);
					else
						this.riddenByEntity.setPositionAndRotation(this.posX
								+ d1, this.posY + this.getMountedYOffset()
								+ this.riddenByEntity.getYOffset() + d2
								- this.yOff, this.posZ + d0,
								this.riddenByEntity.rotationYaw,
								this.riddenByEntity.rotationPitch);

					this.turn2 = this.turn;
				} else
					this.riddenByEntity.setPositionAndRotation(this.posX + d1,
							this.posY + this.getMountedYOffset()
									+ this.riddenByEntity.getYOffset() + d2
									- this.yOff, this.posZ + d0,
							this.riddenByEntity.rotationYaw,
							this.riddenByEntity.rotationPitch);
			}
		}
	}

	public double getMountedYOffset() {
		return (double) this.height * 0.2D;
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	protected void writeEntityToNBT(NBTTagCompound k) {
		k.setInteger("red", this.red);
		k.setInteger("gre", this.green);
		k.setInteger("blu", this.blue);
		// super.writeToNBT(par1NBTTagCompound);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	protected void readEntityFromNBT(NBTTagCompound k) {
		this.red = k.getInteger("red");
		this.green = k.getInteger("gre");
		this.blue = k.getInteger("blu");
		// super.readFromNBT(par1NBTTagCompound);

	}

	@SideOnly(Side.CLIENT)
	public float getShadowSize() {
		return 0.0F;
	}

	/**
	 * First layer of player interaction
	 */

	/**
	 * Takes in the distance the entity has fallen this tick and whether its on
	 * the ground to update the fall distance and deal fall damage if landing on
	 * the ground. Args: distanceFallenThisTick, onGround
	 */
	protected void updateFallState(double par1, boolean par3) {
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);

		if (par3) {
			if (this.fallDistance > 3.0F) {
				this.fall(this.fallDistance);

				if (!this.worldObj.isRemote && !this.isDead) {
					this.setDead();
					int l;

					for (l = 0; l < 3; ++l) {
						this.func_145778_a(
								Item.getItemFromBlock(Blocks.planks), 1, 0.0F);
					}

					for (l = 0; l < 2; ++l) {
						this.func_145778_a(Items.stick, 1, 0.0F);
					}
				}

				this.fallDistance = 0.0F;
			}
		} else if (this.worldObj.getBlock(i, j - 1, k).getMaterial() != Material.water
				&& par1 < 0.0D) {
			this.fallDistance = (float) ((double) this.fallDistance - par1);
		}
	}

	/**
	 * Sets the damage taken from the last hit.
	 */
	public void setDamageTaken(float par1) {
		this.dataWatcher.updateObject(19, Float.valueOf(par1));
	}

	/**
	 * Gets the damage taken from the last hit.
	 */
	public float getDamageTaken() {
		return this.dataWatcher.getWatchableObjectFloat(19);
	}

	/**
	 * Sets the time to count down from since the last time entity was hit.
	 */
	public void setTimeSinceHit(int par1) {
		this.dataWatcher.updateObject(17, Integer.valueOf(par1));
	}

	/**
	 * Gets the time since the last hit.
	 */
	public int getTimeSinceHit() {
		return this.dataWatcher.getWatchableObjectInt(17);
	}

	/**
	 * Sets the forward direction of the entity.
	 */
	public void setForwardDirection(int par1) {
		this.dataWatcher.updateObject(18, Integer.valueOf(par1));
	}

	/**
	 * Gets the forward direction of the entity.
	 */
	public int getForwardDirection() {
		return this.dataWatcher.getWatchableObjectInt(18);
	}

	/**
	 * true if no player in boat
	 */
	@SideOnly(Side.CLIENT)
	public void setIsBoatEmpty(boolean par1) {
		this.isBoatEmpty = par1;
	}

}
