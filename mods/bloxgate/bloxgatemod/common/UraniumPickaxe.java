package mods.bloxgate.bloxgatemod.common;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;

public class UraniumPickaxe extends ItemPickaxe{

	public UraniumPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.epic;
	}
         @Override
   @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("bloxgate:UraniumPickaxe");
	}
	}

