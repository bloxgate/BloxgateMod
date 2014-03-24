/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods.bloxgate.bloxgatemod.common;

import mods.bloxgate.bloxgatemod.client.BloxgatemodClientProxy;
import mods.bloxgate.bloxgatemod.client.GuiHandler;
import mods.bloxgate.bloxgatemod.common.tileentity.TileEntityBlockDeployer;
import mods.bloxgate.bloxgatemod.server.BloxgatemodServerProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;

/**
 *
 * @author Gregory
 */
@Mod(modid = "bloxmod", name = "Bloxgate's Mod", version = "0.0.2 (Alpha Test)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_bloxgatemod {
	
	@Instance("bloxmod")
    public static mod_bloxgatemod instance;
    
    @SidedProxy(clientSide = "mods.bloxgate.bloxgatemod.client.BloxgatemodClientProxy", serverSide = "mods.bloxgate.bloxgatemod.common.BloxgatemodCommonProxy")
    public static BloxgatemodCommonProxy proxy;
    
    public static Block uraniumOre;
    public static Item uranium;
    public static Block uraniumBlock;
    public static Item uraniumSword;
    public static Item uraniumHelmet;
    public static Item uraniumChestplate;
    public static Item uraniumBoots;
    public static Item uraniumLegs;
    public static Item uraniumPickaxe;
    public static Block NetherUraniumOre;
    public static Item uraniumHoe;
    public static Block BlockDeployer;
    public static Item uraniumAxe;
    public static Item uraniumShovel;
    public static Block unobtanium;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        Logger.Logger("Loading");
        
    }
    @EventHandler
    public void init(FMLInitializationEvent event){
                uraniumOre = (new BlockUraniumOre(1551, 0)).setUnlocalizedName("UraniumOre");
        LanguageRegistry.addName(uraniumOre, "Uranium Ore");
        MinecraftForge.setBlockHarvestLevel(uraniumOre, "pickaxe", 2);
        GameRegistry.registerBlock(uraniumOre, "uraniumOre");
        
        uranium = (new ItemUranium(900)).setUnlocalizedName("uranium");
        LanguageRegistry.addName(uranium, "Uranium");
        
        GameRegistry.registerFuelHandler(new BloxgatemodFuelHandler());
        Logger.Logger("Loaded Fuels");
        
        proxy.registerRenderThings();
        
       GameRegistry.addSmelting(uraniumOre.blockID, new ItemStack(uranium), 0.1F);
       
       uraniumBlock = (new BlockUraniumBlock(1552, 1)).setUnlocalizedName("uraniumBlock");
       LanguageRegistry.addName(uraniumBlock, "Block of Uranium");
       MinecraftForge.setBlockHarvestLevel(uraniumBlock, "pickaxe", 2);
       GameRegistry.registerBlock(uraniumBlock, "Block of Uranium");
       GameRegistry.addRecipe(new ItemStack(uraniumBlock), "xxx", "xxx", "xxx", 'x', uranium);
       
       EnumToolMaterial toolUranium = EnumHelper.addToolMaterial("URANIUM", 3, 10000, 10F, 20, 10);
       uraniumSword = (new uraniumSword(901, toolUranium)).setUnlocalizedName("uraniumSword");
       LanguageRegistry.addName(uraniumSword, "Uranium Sword");
       GameRegistry.addRecipe(new ItemStack(uraniumSword), " x ", " x ", " y ", 'x', uranium, 'y', Item.stick);
       
       EnumArmorMaterial armorUranium = EnumHelper.addArmorMaterial("URANIUM", 50, new int[]{5, 5, 5, 5}, 30); 
       uraniumChestplate = new uraniumArmor(902, armorUranium, BloxgatemodClientProxy.addArmor("Uranium"), 1).setUnlocalizedName("uraniumChest");
       LanguageRegistry.addName(uraniumChestplate, "Uranium Chestplate");
       uraniumHelmet =  new uraniumArmor(903, armorUranium, BloxgatemodClientProxy.addArmor("Uranium"), 0).setUnlocalizedName("uraniumHelmet");
       uraniumBoots = new uraniumArmor(904, armorUranium, BloxgatemodClientProxy.addArmor("Uranium"), 3).setUnlocalizedName("uraniumBoots");
       LanguageRegistry.addName(uraniumHelmet, "Uranium Helmet");
       LanguageRegistry.addName(uraniumBoots, "Uranium Boots");
       uraniumLegs = new uraniumArmor(905, armorUranium, BloxgatemodClientProxy.addArmor("Uranium"), 2).setUnlocalizedName("uraniumLegs");
       LanguageRegistry.addName(uraniumLegs, "Uranium Leggings");
       
       uraniumPickaxe = (new UraniumPickaxe(906, toolUranium)).setUnlocalizedName("uraniumPickaxe");
       LanguageRegistry.addName(uraniumPickaxe, "Uranium Pickaxe");
       GameRegistry.addRecipe(new ItemStack(uraniumPickaxe), "xxx", " y ", " y ", 'x', uranium, 'y', Item.stick);
       
       GameRegistry.registerWorldGenerator(new WorldGeneratorBlox());
       
       NetherUraniumOre = (new BlockNetherUraniumOre(1553, 3)).setUnlocalizedName("netherUraniumOre");
       GameRegistry.registerBlock(NetherUraniumOre, "Nether Uranium Ore");
       LanguageRegistry.addName(NetherUraniumOre, "Nether Uranium Ore");
       GameRegistry.addSmelting(NetherUraniumOre.blockID, new ItemStack(uraniumOre), 0F);
       
       uraniumHoe = (new UraniumHoe(907, toolUranium)).setUnlocalizedName("uraniumHoe");
       LanguageRegistry.addName(uraniumHoe, "Uranium Hoe");
       GameRegistry.addRecipe(new ItemStack(uraniumHoe), "xx ", " y ", " y ", 'x', uranium, 'y', Item.stick);
       
       BlockDeployer = (new BlockDeployer(1554)).setUnlocalizedName("blockDeployer");
       GameRegistry.registerBlock(BlockDeployer, "Block Deployer");;
       LanguageRegistry.addName(BlockDeployer, "Block Deployer");
       GameRegistry.addRecipe(new ItemStack(BlockDeployer), "xxx", "xyx", "xxx", 'x', Item.ingotIron, 'y', Item.redstone);
       GameRegistry.registerTileEntity(TileEntityBlockDeployer.class, "BlockDeployerBlox");
       
       uraniumAxe = (new UraniumAxe(908, toolUranium)).setUnlocalizedName("uraniumAxe");
       LanguageRegistry.addName(uraniumAxe, "Uranium Axe");
       GameRegistry.addRecipe(new ItemStack(uraniumAxe), "xx ", "xy ", " y ", 'x', uranium, 'y', Item.stick);
       
       uraniumShovel = (new UraniumShovel(909, toolUranium)).setUnlocalizedName("uraniumShovel");
       LanguageRegistry.addName(uraniumShovel, "Uranium Shovel");
       GameRegistry.addRecipe(new ItemStack(uraniumShovel), " x ", " y ", " y ", 'x', uranium, 'y', Item.stick);
       
       EnumToolMaterial toolUnobtanium = EnumHelper.addToolMaterial("UNOBTANIUM", 4, 20000, 20F, 40, 20);
       unobtanium = (new BlockUnobtanium(1555)).setUnlocalizedName("unobtaniumBlock");
       GameRegistry.registerBlock(unobtanium, "Unobtanium Block");
       LanguageRegistry.addName(unobtanium, "Unobtanium Block");
       MinecraftForge.setBlockHarvestLevel(unobtanium, "pickaxe", 3);
       
       Logger.Logger("Loaded Items and Blocks");
       
       //Armor Recipes 
       GameRegistry.addRecipe(new ItemStack(uraniumHelmet), "xxx", "x x", "   ", 'x', uranium);
       GameRegistry.addRecipe(new ItemStack(uraniumChestplate), "x x", "xxx", "xxx", 'x', uranium);
       GameRegistry.addRecipe(new ItemStack(uraniumLegs), "xxx", "x x", "x x", 'x', uranium);
       GameRegistry.addRecipe(new ItemStack(uraniumBoots), "   ", "x x", "x x", 'x', uranium);
       Logger.Logger("Armor Recipes Loaded");
       
       //Mobs
      
       EntityRegistry.registerModEntity(EntityWalkingApple.class, "WalkingApple", 2, this, 80, 3, true);
       EntityRegistry.addSpawn(EntityWalkingApple.class, 20, 5, 10, EnumCreatureType.creature, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.forest, BiomeGenBase.plains);
       RenderingRegistry.registerEntityRenderingHandler(EntityWalkingApple.class, new RenderWalkingApple(new WalkingApple(), 0.5F));
       LanguageRegistry.instance().addStringLocalization("entity.instance.WalkingApple.name", "Walking Apple");
       
       EntityRegistry.registerGlobalEntityID(EntityEasterEgg1.class, "EasterEgg1", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
       EntityRegistry.registerModEntity(EntityEasterEgg1.class, "EasterEgg1", 3, this, 32, 3, true);
       RenderingRegistry.registerEntityRenderingHandler(EntityEasterEgg1.class, new RenderEasterEgg1(new ModelEasterEgg1(), 0.5F));
       EntityRegistry.addSpawn(EntityEasterEgg1.class, 1, 1, 1, EnumCreatureType.creature, BiomeGenBase.desert, BiomeGenBase.desertHills);
       LanguageRegistry.instance().addStringLocalization("entity.EasterEgg1.name", "Bloxgate Mob");
       
       new GuiHandler();
       
       Logger.Logger("Mobs loaded succesfuly");
        
    }
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        Logger.Logger("Loaded Sucessfuly");
        
    }
    
}
