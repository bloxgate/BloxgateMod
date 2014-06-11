/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods.bloxgate.bloxgatemod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * @author Gregory
 */
class BlockUraniumBlock extends Block
{
    public BlockUraniumBlock()
    {
        super(Material.iron);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(90F);
        this.setResistance(180F);
        this.setStepSound(this.soundTypeMetal);
        this.setBlockName("blockUranium");
        this.setHarvestLevel("pickaxe", 2);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("bloxgate:BlockUraniumBlock");
    }
}
