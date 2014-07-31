package mods.bloxgate.bloxgatemod.common;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UraniumAxe extends ItemAxe
{
    public UraniumAxe(ToolMaterial ToolMaterial)
    {
        super(ToolMaterial);
        // TODO Auto-generated constructor stub
    }
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
    {
        itemIcon = iconregister.registerIcon("bloxgate:UraniumAxe");
    }
}
