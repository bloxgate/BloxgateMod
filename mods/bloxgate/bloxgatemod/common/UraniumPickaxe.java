package mods.bloxgate.bloxgatemod.common;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UraniumPickaxe extends ItemPickaxe
{
    public UraniumPickaxe(ToolMaterial ToolMaterial)
    {
        super(ToolMaterial);
        // TODO Auto-generated constructor stub
    }
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon("bloxgate:UraniumPickaxe");
    }
}
