/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods.bloxgate.bloxgatemod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * @author Gregory
 */
class BlockUraniumBlock extends Block{

    public BlockUraniumBlock(int par1, int par2) {
        super(par1, Material.iron);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(90F);
        this.setResistance(180F);
        this.setStepSound(this.soundMetalFootstep);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("bloxgate:BlockUraniumBlock");
	}
    
}
