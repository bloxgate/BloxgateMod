package mods.bloxgate.bloxgatemod.common;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class uraniumArmor extends ItemArmor
{
    public uraniumArmor(ArmorMaterial par2EnumArmorMaterial,
                        int par3, int par4)
    {
        super(par2EnumArmorMaterial, par3, par4);
        // TODO Auto-generated constructor stub
    }

    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
    {
        if (itemstack.getItem().equals(mod_bloxgatemod.uraniumChestplate) || itemstack.getItem().equals(mod_bloxgatemod.uraniumHelmet) || itemstack.getItem().equals(mod_bloxgatemod.uraniumBoots))
        {
            return "bloxgate:textures/models/armor/Uranium_1.png";
        }

        if (itemstack.getItem().equals(mod_bloxgatemod.uraniumLegs))
        {
            return "bloxgate:textures/models/armor/Uranium_2.png";
        }
        else
        {
            return null;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon("bloxgate:" + this.getUnlocalizedName().substring(5));
    }
}
