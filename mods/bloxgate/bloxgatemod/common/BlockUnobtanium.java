package mods.bloxgate.bloxgatemod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockUnobtanium extends Block
{
    public BlockUnobtanium()
    {
        super(Material.iron);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(180F);
        this.setResistance(360F);
        this.setStepSound(soundTypeMetal);
        this.setHarvestLevel("pickaxe", 3);
        this.setBlockName("unobtaniumBlock");
    }
}
