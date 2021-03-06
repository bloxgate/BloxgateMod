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
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.world.biome.BiomeGenBase;

/**
 *
 * @author Gregory
 */
@Mod(modid = "bloxmod", name = "Bloxgate's Mod", version = "0.0.2 (Alpha Test)")
public class mod_bloxgatemod
{
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
    public static Item compressedUnobtaniumSphere;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Logger.Logger("Loading");
        
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	uraniumOre = (new BlockUraniumOre()).setBlockName("uraniumOre").setBlockTextureName("bloxgate:BlockUraniumOre");
        GameRegistry.registerBlock(uraniumOre, uraniumOre.getUnlocalizedName().substring(5));
    	uranium = new ItemUranium().setUnlocalizedName("uraniumIngot").setTextureName("bloxgate:Uranium");
    	GameRegistry.registerItem(uranium, uranium.getUnlocalizedName().substring(5));
        //LanguageRegistry.addName(uranium, "Uranium");
        GameRegistry.registerFuelHandler(new BloxgatemodFuelHandler());
        Logger.Logger("Loaded Fuels");
        proxy.registerRenderThings();
        GameRegistry.addSmelting(uraniumOre, new ItemStack(uranium), 0.1F);
        uraniumBlock = new BlockUraniumBlock();
        //LanguageRegistry.addName(uraniumBlock, "Block of Uranium");
       // MinecraftForge.setBlockHarvestLevel(uraniumBlock, "pickaxe", 2);
        GameRegistry.registerBlock(uraniumBlock, "Block of Uranium");
        GameRegistry.addRecipe(new ItemStack(uraniumBlock), "xxx", "xxx", "xxx", 'x', uranium);
        ToolMaterial toolUranium = EnumHelper.addToolMaterial("URANIUM", 3, 10000, 10F, 20, 10);
        uraniumSword = (new uraniumSword(toolUranium)).setUnlocalizedName("uraniumSword").setTextureName("bloxgate:uraniumSword");
        GameRegistry.registerItem(uraniumSword, uraniumSword.getUnlocalizedName().substring(5));
        GameRegistry.addRecipe(new ItemStack(uraniumSword), " x ", " x ", " y ", 'x', uranium, 'y', Items.stick);
        ArmorMaterial armorUranium = EnumHelper.addArmorMaterial("URANIUM", 50, new int[] {5, 5, 5, 5}, 30);
        uraniumChestplate = new uraniumArmor(armorUranium, BloxgatemodClientProxy.addArmor("Uranium"), 1).setUnlocalizedName("uraniumChest");
        uraniumHelmet =  new uraniumArmor(armorUranium, BloxgatemodClientProxy.addArmor("Uranium"), 0).setUnlocalizedName("uraniumHelmet");
        uraniumBoots = new uraniumArmor(armorUranium, BloxgatemodClientProxy.addArmor("Uranium"), 3).setUnlocalizedName("uraniumBoots");
        uraniumLegs = new uraniumArmor(armorUranium, BloxgatemodClientProxy.addArmor("Uranium"), 2).setUnlocalizedName("uraniumLegs");
        uraniumPickaxe = (new UraniumPickaxe(toolUranium)).setUnlocalizedName("uraniumPickaxe").setTextureName("bloxgate:uraniumPickaxe");
        GameRegistry.registerItem(uraniumPickaxe, uraniumPickaxe.getUnlocalizedName().substring(5));
        GameRegistry.addRecipe(new ItemStack(uraniumPickaxe), "xxx", " y ", " y ", 'x', uranium, 'y', Items.stick);
        GameRegistry.registerWorldGenerator(new WorldGeneratorBlox(), 0);
        NetherUraniumOre = new BlockNetherUraniumOre();
        GameRegistry.registerBlock(NetherUraniumOre, "Nether Uranium Ore");
        //LanguageRegistry.addName(NetherUraniumOre, "Nether Uranium Ore");
        GameRegistry.addSmelting(NetherUraniumOre, new ItemStack(uraniumOre), 0F);
        uraniumHoe = (new UraniumHoe(toolUranium)).setUnlocalizedName("uraniumHoe").setTextureName("bloxgate:uraniumHoe");
        GameRegistry.registerItem(uraniumHoe, uraniumHoe.getUnlocalizedName().substring(5));
        GameRegistry.addRecipe(new ItemStack(uraniumHoe), "xx ", " y ", " y ", 'x', uranium, 'y', Items.stick);
        //Needs fixing: BlockDeployer = (new BlockDeployer()).setBlockName("blockDeployer");
        //See above GameRegistry.registerBlock(BlockDeployer, "Block Deployer");;
        //LanguageRegistry.addName(BlockDeployer, "Block Deployer");
        GameRegistry.addRecipe(new ItemStack(BlockDeployer), "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', Items.redstone);
        GameRegistry.registerTileEntity(TileEntityBlockDeployer.class, "BlockDeployerBlox");
        uraniumAxe = (new UraniumAxe(toolUranium)).setUnlocalizedName("uraniumAxe").setTextureName("bloxgate:uraniumAxe");
        GameRegistry.registerItem(uraniumAxe, uraniumAxe.getUnlocalizedName().substring(5));
        GameRegistry.addRecipe(new ItemStack(uraniumAxe), "xx ", "xy ", " y ", 'x', uranium, 'y', Items.stick);
        uraniumShovel = (new UraniumShovel(toolUranium)).setUnlocalizedName("uraniumShovel").setTextureName("bloxgate:uraniumShovel");
        GameRegistry.registerItem(uraniumShovel, uraniumShovel.getUnlocalizedName().substring(5));
        GameRegistry.addRecipe(new ItemStack(uraniumShovel), " x ", " y ", " y ", 'x', uranium, 'y', Items.stick);
        ToolMaterial toolUnobtanium = EnumHelper.addToolMaterial("UNOBTANIUM", 4, 20000, 20F, 40, 20);
        unobtanium = new BlockUnobtanium();
        GameRegistry.registerBlock(unobtanium, "Unobtanium Block");
        //LanguageRegistry.addName(unobtanium, "Unobtanium Block");
        compressedUnobtaniumSphere = (new CUnobtaniumSphere(910)).setUnlocalizedName("CUnobtaniumSphere");
        //LanguageRegistry.addName(compressedUnobtaniumSphere, "Compressed Unobtanium Sphere");
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
        //LanguageRegistry.instance().addStringLocalization("entity.instance.WalkingApple.name", "Walking Apple");
        EntityRegistry.registerGlobalEntityID(EntityEasterEgg1.class, "EasterEgg1", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
        EntityRegistry.registerModEntity(EntityEasterEgg1.class, "EasterEgg1", 3, this, 32, 3, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityEasterEgg1.class, new RenderEasterEgg1(new ModelEasterEgg1(), 0.5F));
        EntityRegistry.addSpawn(EntityEasterEgg1.class, 1, 1, 1, EnumCreatureType.creature, BiomeGenBase.desert, BiomeGenBase.desertHills);
        LanguageRegistry.instance().addStringLocalization("entity.EasterEgg1.name", "Bloxgate Mob");
        new GuiHandler();
        Logger.Logger("Mobs loaded succesfuly");
    }
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        Logger.Logger("Loaded Sucessfuly");
    }
}
