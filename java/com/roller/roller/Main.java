package com.roller.roller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.roller.roller.blocks.BlockLoopX;
import com.roller.roller.blocks.BlockLoopZ;
import com.roller.roller.blocks.BlockSupport;
import com.roller.roller.blocks.BlockTrack225;
import com.roller.roller.blocks.BlockTrack225Top;
import com.roller.roller.blocks.BlockTrack225_2;
import com.roller.roller.blocks.BlockTrack225_2Top;
import com.roller.roller.blocks.BlockTrackBase;
import com.roller.roller.blocks.BlockTrackBaseTop;
import com.roller.roller.blocks.BlockTrackBaseWater;
import com.roller.roller.blocks.BlockTrackCurve;
import com.roller.roller.blocks.BlockTrackHor;
import com.roller.roller.blocks.BlockTrackHorTop;
import com.roller.roller.blocks.BlockTrackPitched;
import com.roller.roller.blocks.BlockTrackPitchedCurve;
import com.roller.roller.blocks.BlockTrackQuer;
import com.roller.roller.blocks.BlockTrackQuerTop;
import com.roller.roller.blocks.BlockTrackSeitlich;
import com.roller.roller.blocks.BlockTrackTransition;
import com.roller.roller.blocks.BlockTrackTurn;
import com.roller.roller.blocks.BlockTrackUp;
import com.roller.roller.blocks.BlockWallpic;
import com.roller.roller.guis.GuiHandler;
import com.roller.roller.renderer.RenderServer;
import com.roller.roller.tileEntity.EntityMainTrain;
import com.roller.roller.tileEntity.EntitySubTrain;
import com.roller.roller.tileEntity.EntitySupport;
import com.roller.roller.tileEntity.EntityTrack225;
import com.roller.roller.tileEntity.EntityTrack225Top;
import com.roller.roller.tileEntity.EntityTrack225_2;
import com.roller.roller.tileEntity.EntityTrack225_2Top;
import com.roller.roller.tileEntity.EntityTrackBase;
import com.roller.roller.tileEntity.EntityTrackBaseTop;
import com.roller.roller.tileEntity.EntityTrackBaseWater;
import com.roller.roller.tileEntity.EntityTrackCurve;
import com.roller.roller.tileEntity.EntityTrackHor;
import com.roller.roller.tileEntity.EntityTrackHorTop;
import com.roller.roller.tileEntity.EntityTrackPitched;
import com.roller.roller.tileEntity.EntityTrackPitchedCurve;
import com.roller.roller.tileEntity.EntityTrackQuer;
import com.roller.roller.tileEntity.EntityTrackQuerTop;
import com.roller.roller.tileEntity.EntityTrackSeitlich;
import com.roller.roller.tileEntity.EntityTrackTransition;
import com.roller.roller.tileEntity.EntityTrackTurn;
import com.roller.roller.tileEntity.EntityTrackUp;
import com.roller.roller.tileEntity.EntityTrain;
import com.roller.roller.tileEntity.TEWallpic;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.modid, name = "rollercoaster", version = "1.0")


public class Main {

	
	public static String version = "0.0.211";
	
	
    public static final String modid = "rollercoaster";
    Random rand = new Random();
    
    public static Block base;
    public static Block baseWater;
    public static Block up;
    public static Block curve;
    public static Block up90;
    public static Block hortop;
    public static Block basetop;
    public static Block quer;
    public static Block quertop;
    public static Block turn;
    public static Block wallPic;
    public static Block transition;
    public static Block pitched;
    public static Block seitlich;
    public static Block pitchedCurve;
    public static Block track225;
    public static Block track225_2;
    public static Block track225Top;
    public static Block track225_2Top;
    public static Block support;
    public static Block loopX, loopZ;
    public static Item train;
    public static Item multiTool;
    public static Item alignWrench;
    public static Item modeWrench;
    public static Item speedWrench;
    public static Item speedMWrench;
    public static Item tester;
    public static Item key;
    public static Item gear;
    public static Item subTrain;
    public static Item paintBrush;
    public static List<EntityTrain> trains = new ArrayList<EntityTrain>();

    @Instance("rollercoaster")
    public static Main instance;
    
    @SidedProxy(clientSide="com.roller.roller.renderer.RenderClient", serverSide="com.roller.roller.renderer.RenderServer")
    public static RenderServer proxy;
    
    public static CreativeTabs tabRoller = new CreativeTabs("MineCoaster")
    {
    	public Item getTabIconItem()
    	{
    		return Main.train;
    	}
    };

    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	File f = new File("trains");
    	if(!f.exists())
    		f.mkdir();
    	f = new File("trains/subs");
    	if(!f.exists())
    		f.mkdir();
    	else
    	{
    		f.delete();
    		f.mkdir();
    	}
 	   proxy.registerThings();
 	   NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
 	  
 	   File file = new File("wallpics");
 	   if(!file.exists())
 		   file.mkdir();
 	   
	   GameRegistry.registerTileEntity(EntityTrackBase.class, "base");   
	   GameRegistry.registerTileEntity(EntityTrackHor.class, "up");   
	   GameRegistry.registerTileEntity(EntityTrackCurve.class, "curve"); 
	   GameRegistry.registerTileEntity(EntityTrackUp.class, "up90"); 
	   GameRegistry.registerTileEntity(EntityTrackHorTop.class, "hortop"); 
	   GameRegistry.registerTileEntity(EntityTrackBaseTop.class, "basetop"); 
	   GameRegistry.registerTileEntity(EntityTrackQuer.class, "quer"); 
	   GameRegistry.registerTileEntity(EntityTrackQuerTop.class, "quertop"); 
	   GameRegistry.registerTileEntity(EntityTrackBaseWater.class, "water"); 
	   GameRegistry.registerTileEntity(EntityTrackTurn.class, "turn"); 
	   GameRegistry.registerTileEntity(TEWallpic.class, "wallpic"); 
	   GameRegistry.registerTileEntity(EntityTrackTransition.class, "trans"); 
	   GameRegistry.registerTileEntity(EntityTrackPitched.class, "pitch"); 
	   GameRegistry.registerTileEntity(EntityTrackSeitlich.class, "seitl"); 
	   GameRegistry.registerTileEntity(EntityTrackPitchedCurve.class, "pitchCurve"); 
	   GameRegistry.registerTileEntity(EntityTrack225.class, "track225"); 
	   GameRegistry.registerTileEntity(EntityTrack225_2.class, "track225_2"); 
	   GameRegistry.registerTileEntity(EntityTrack225Top.class, "track225Top"); 
	   GameRegistry.registerTileEntity(EntityTrack225_2Top.class, "track225_2Top");	  
	   GameRegistry.registerTileEntity(EntitySupport.class, "support");	  
	  /** int id = EntityRegistry.findGlobalUniqueEntityId();
       EntityRegistry.registerModEntity(EntityTrain.class, "train", 3, this, 80, 1, true);
       EntityRegistry.registerGlobalEntityID(EntityTrain.class, "train", 3);*/
       int id3 = EntityRegistry.findGlobalUniqueEntityId();
       EntityRegistry.registerModEntity(EntityMainTrain.class, "mainTrain", 4, this, 80, 1, true);
      // EntityRegistry.registerGlobalEntityID(EntityMainTrain.class, "mainTrain", 4);
       int id2 = EntityRegistry.findGlobalUniqueEntityId();
       EntityRegistry.registerModEntity(EntitySubTrain.class, "subTrain", 5, this, 80, 1, true);
      // EntityRegistry.registerGlobalEntityID(EntitySubTrain.class, "subTrain", 5);
       
       this.base = new BlockTrackBase(Material.rock).setCreativeTab(this.tabRoller).setBlockName("straight").setBlockTextureName("roller:straight");
	   this.up = new BlockTrackHor(Material.rock).setCreativeTab(this.tabRoller).setBlockName("up").setBlockTextureName("roller:horup");
	   this.curve = new BlockTrackCurve(Material.rock).setCreativeTab(this.tabRoller).setBlockName("curve").setBlockTextureName("roller:curve");
	   this.up90 = new BlockTrackUp(Material.rock).setCreativeTab(this.tabRoller).setBlockName("up90").setBlockTextureName("roller:up");
	   this.hortop = new BlockTrackHorTop(Material.rock).setCreativeTab(this.tabRoller).setBlockName("hortop").setBlockTextureName("roller:hortop");
	   this.basetop = new BlockTrackBaseTop(Material.rock).setCreativeTab(this.tabRoller).setBlockName("basetop").setBlockTextureName("roller:straighttop");
	   this.quer = new BlockTrackQuer(Material.rock).setCreativeTab(this.tabRoller).setBlockName("quer").setBlockTextureName("roller:quer");
	   this.quertop = new BlockTrackQuerTop(Material.rock).setCreativeTab(this.tabRoller).setBlockName("quertop").setBlockTextureName("roller:quertop");
	   this.baseWater = new BlockTrackBaseWater(Material.rock).setCreativeTab(this.tabRoller).setBlockName("water").setBlockTextureName("roller:straightwater");
	   this.turn = new BlockTrackTurn(Material.rock).setCreativeTab(this.tabRoller).setBlockName("turn").setBlockTextureName("roller:turn");
	   this.wallPic = new BlockWallpic(Material.rock).setCreativeTab(this.tabRoller).setBlockName("wallpic").setBlockTextureName("roller:wallPic");
	   this.transition = new BlockTrackTransition(Material.rock).setCreativeTab(this.tabRoller).setBlockName("trans").setBlockTextureName("roller:trans");
	   this.pitched = new BlockTrackPitched(Material.rock).setCreativeTab(this.tabRoller).setBlockName("pitch").setBlockTextureName("roller:tilted");
	   this.seitlich = new BlockTrackSeitlich(Material.rock).setCreativeTab(this.tabRoller).setBlockName("seitl").setBlockTextureName("roller:transition");
	   this.pitchedCurve = new BlockTrackPitchedCurve(Material.rock).setCreativeTab(this.tabRoller).setBlockName("pitchedCurve").setBlockTextureName("roller:tiltedcurve");
	   this.track225 = new BlockTrack225(Material.rock).setCreativeTab(this.tabRoller).setBlockName("Track225").setBlockTextureName("roller:225up");
	   this.track225_2 = new BlockTrack225_2(Material.rock).setCreativeTab(this.tabRoller).setBlockName("Track225_2").setBlockTextureName("roller:225up");
	   this.track225Top = new BlockTrack225Top(Material.rock).setCreativeTab(this.tabRoller).setBlockName("Track225Top").setBlockTextureName("roller:225top");
	   this.track225_2Top = new BlockTrack225_2Top(Material.rock).setCreativeTab(this.tabRoller).setBlockName("Track225_2Top").setBlockTextureName("roller:225top");
	   this.loopX = new BlockLoopX(Material.rock).setCreativeTab(this.tabRoller).setBlockName("loopX").setBlockTextureName("roller:loopX");
	   this.loopZ = new BlockLoopZ(Material.rock).setCreativeTab(this.tabRoller).setBlockName("loopZ").setBlockTextureName("roller:loopZ");
	   this.support = new BlockSupport(Material.rock).setCreativeTab(this.tabRoller).setBlockName("support").setBlockTextureName("roller:support");
	   this.train = new ItemTrain().setMaxStackSize(1).setCreativeTab(this.tabRoller).setUnlocalizedName("Train").setTextureName("roller:train");
	   this.subTrain = new ItemSubTrain().setMaxStackSize(1).setCreativeTab(this.tabRoller).setUnlocalizedName("Sub Train").setTextureName("roller:subTrain");
	   this.alignWrench = new ItemWrench().setCreativeTab(this.tabRoller).setUnlocalizedName("Alignment Wrench").setTextureName("roller:alignWrench");
	   this.modeWrench = new ItemWrench().setCreativeTab(this.tabRoller).setUnlocalizedName("Mode Wrench").setTextureName("roller:modeWrench");;
	   this.speedWrench = new ItemWrench().setCreativeTab(this.tabRoller).setUnlocalizedName("Speed Wrench").setTextureName("roller:speedWrench");;
	   this.speedMWrench = new ItemWrench().setCreativeTab(this.tabRoller).setUnlocalizedName("Speed Multiplier Wrench").setTextureName("roller:speedMWrench");;
	   this.multiTool = new ItemWrench().setCreativeTab(this.tabRoller).setUnlocalizedName("multi tool").setTextureName("roller:multiTool");;
	   this.tester = new ItemWrench().setCreativeTab(this.tabRoller).setUnlocalizedName("tester").setTextureName("roller:tester");;
	   this.key = new ItemWrench().setCreativeTab(this.tabRoller).setUnlocalizedName("key").setTextureName("roller:key");;
	   this.gear = new Item().setCreativeTab(this.tabRoller).setUnlocalizedName("gear").setTextureName("roller:gear");;
	   this.paintBrush = new ItemWrench().setCreativeTab(this.tabRoller).setUnlocalizedName("paintbrush").setTextureName("roller:paintbrush");;

	   GameRegistry.registerBlock(this.base,BaseItemBlock.class, "towerr");
	   GameRegistry.registerBlock(this.curve, BaseItemBlock.class,"curve");
	   GameRegistry.registerBlock(this.up,BaseItemBlock.class, "uper");
	   GameRegistry.registerBlock(this.up90,BaseItemBlock.class, "up90");
	   GameRegistry.registerBlock(this.hortop,BaseItemBlock.class, "hortopi");
	   GameRegistry.registerBlock(this.basetop,BaseItemBlock.class, "basetopi");
	   GameRegistry.registerBlock(this.quer,BaseItemBlock.class, "quer");
	   GameRegistry.registerBlock(this.quertop,BaseItemBlock.class, "quertopi");
	   GameRegistry.registerBlock(this.baseWater,BaseItemBlock.class, "water");
	   GameRegistry.registerBlock(this.turn,BaseItemBlock.class, "turn");
	   GameRegistry.registerBlock(this.wallPic, "wallPic");
	   GameRegistry.registerBlock(this.transition,BaseItemBlock.class, "transe");
	   GameRegistry.registerBlock(this.pitched,BaseItemBlock.class, "pitche");
	   GameRegistry.registerBlock(this.pitchedCurve,BaseItemBlock.class, "pitchecurve");
	   GameRegistry.registerBlock(this.seitlich, "seitl");
	   GameRegistry.registerBlock(this.track225,BaseItemBlock.class, "track225");
	   GameRegistry.registerBlock(this.track225_2,BaseItemBlock.class, "track225_2");
	   GameRegistry.registerBlock(this.track225Top,BaseItemBlock.class, "track225Top");
	   GameRegistry.registerBlock(this.track225_2Top,BaseItemBlock.class, "track225_2Top");
	   GameRegistry.registerBlock(this.support, "support");
	   GameRegistry.registerBlock(this.loopX, BaseItemBlock.class, "loopX");
	   GameRegistry.registerBlock(this.loopZ, BaseItemBlock.class, "loopZ");
	   GameRegistry.registerItem(this.train, "train");
	   GameRegistry.registerItem(this.alignWrench, "Alignment Wrench");
	   GameRegistry.registerItem(this.modeWrench, "Mode Wrench");
	   GameRegistry.registerItem(this.speedMWrench, "Speed Wrench");
	   GameRegistry.registerItem(this.speedWrench, "Speed Multiplier Wrench");
	   GameRegistry.registerItem(this.multiTool, "Multi Tool");
	   GameRegistry.registerItem(this.tester, "Tester");
	   GameRegistry.registerItem(this.key, "Key");
	   GameRegistry.registerItem(this.gear, "Gear");
	   GameRegistry.registerItem(this.subTrain, "SubTrain");
	   GameRegistry.registerItem(this.paintBrush, "paintbrush");

    	GameRegistry.addRecipe(new ItemStack(this.base,  2), new Object[]{
    	"N N",
    	"GAG",
    	" B ",
    	'A', Blocks.rail, 'G', this.gear, 'B', Items.redstone, 'N', Items.gold_nugget
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(this.gear, 8), new Object[]{
    	" A ",
    	"A A",
    	" A ",
    	'A', Items.iron_ingot
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(this.wallPic, 2), new Object[]{
    	" A ",
    	"ABA",
    	" A ",
    	'A', Items.iron_ingot, 'B', Items.painting
    	});
		
		GameRegistry.addShapelessRecipe(new ItemStack(this.train), new Object[]
		{
		    	new ItemStack(Items.minecart), new ItemStack(Items.redstone)
		});
		
		
    	GameRegistry.addRecipe(new ItemStack(this.multiTool), new Object[]{
    	"  A",
    	"AA ",
    	"  A",
    	'A', Items.iron_ingot
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(this.support, 16), new Object[]{
        	"AAA",
        	" A ",
        	"AAA",
        	'A', Items.iron_ingot
        	});
    }

}
