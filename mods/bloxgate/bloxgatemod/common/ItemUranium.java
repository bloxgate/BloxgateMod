/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods.bloxgate.bloxgatemod.common;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;

/**
 *
 * @author Gregory
 */
class ItemUranium extends Item
{
    public ItemUranium()
    {
        super();
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.rare;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
    @Override
    public void registerIcons(IIconRegister par1Iconregister){
    	itemIcon = par1Iconregister.registerIcon("bloxgate" + (this.getUnlocalizedName().substring(5)));
    }
}
