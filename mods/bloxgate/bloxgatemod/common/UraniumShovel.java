package mods.bloxgate.bloxgatemod.common;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UraniumShovel extends ItemSpade
{
    public UraniumShovel(int par1, ToolMaterial par2EnumToolMaterial)
    {
        super(par2EnumToolMaterial);
        // TODO Auto-generated constructor stub
    }
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itmestack)
    {
        return EnumRarity.epic;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
    {
        this.itemIcon = iconregister.registerIcon("bloxgate:UraniumShovel");
    }
}
