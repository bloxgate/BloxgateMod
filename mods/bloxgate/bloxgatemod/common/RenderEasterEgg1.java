package mods.bloxgate.bloxgatemod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderEasterEgg1 extends RenderLiving
{
    private static final ResourceLocation EE1Textures = new ResourceLocation("bloxgate", "textures/entities/EasterEgg1.png");

    public RenderEasterEgg1(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEE1Textures(EntityEasterEgg1 par1EntityEasterEgg1)
    {
        return EE1Textures;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEE1Textures((EntityEasterEgg1)entity);
    }
}
