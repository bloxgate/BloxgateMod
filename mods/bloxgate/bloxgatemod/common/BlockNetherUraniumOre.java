package mods.bloxgate.bloxgatemod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNetherUraniumOre extends Block
{
    public BlockNetherUraniumOre()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(10F);
        this.setResistance(20F);
        this.setStepSound(this.soundTypeStone);
        this.setBlockName("netherUraniumOre");
        this.setHarvestLevel("pickaxe", 2);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("bloxgate:BlockNetherUraniumOre");
    }
}
