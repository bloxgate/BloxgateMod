package mods.bloxgate.bloxgatemod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderWalkingApple extends RenderLiving
{
    public RenderWalkingApple(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
        // TODO Auto-generated constructor stub
    }

    private static final ResourceLocation WalkingAppleTextures = new ResourceLocation("bloxgate", "textures/entities/ApplePig.png");

    protected ResourceLocation getWalkingAppleTextures(EntityWalkingApple par1EntityWalkingAppple)
    {
        return WalkingAppleTextures;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        // TODO Auto-generated method stub
        return this.getWalkingAppleTextures((EntityWalkingApple)entity);
    }
}
