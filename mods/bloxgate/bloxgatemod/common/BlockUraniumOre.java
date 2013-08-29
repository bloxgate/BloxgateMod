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
public class BlockUraniumOre extends Block{

    public BlockUraniumOre(int par1, int par2) {
        super(par1, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(10F);
        this.setResistance(20F);
        this.setStepSound(this.soundStoneFootstep);
        
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("bloxgate:BlockUraniumOre");
	}
    
}
