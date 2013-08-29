/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods.bloxgate.bloxgatemod.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * @author Gregory
 */
class ItemUranium extends Item{

    public ItemUranium(int par1) {
        super(par1);
        this.setCreativeTab(CreativeTabs.tabMaterials);
         }
        
        @Override
        @SideOnly(Side.CLIENT)
        public EnumRarity getRarity(ItemStack par1ItemStack){
        return EnumRarity.rare;
    }
   
        @Override
        public boolean hasEffect(ItemStack par1ItemStack){
            return true;
        }
        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister iconRegister){
    		itemIcon = iconRegister.registerIcon("bloxgate:Uranium");
    	}
    
}
