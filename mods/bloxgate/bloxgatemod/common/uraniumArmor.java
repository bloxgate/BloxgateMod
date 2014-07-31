package mods.bloxgate.bloxgatemod.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
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
        if (stack.getItem().equals(mod_bloxgatemod.uraniumChestplate) || itemstack.itemID == mod_bloxgatemod.uraniumHelmet.itemID || itemstack.itemID == mod_bloxgatemod.uraniumBoots.itemID)
        {
            return "bloxgate:textures/models/armor/Uranium_1.png";
        }

        if (Item == mod_bloxgatemod.uraniumLegs)
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
