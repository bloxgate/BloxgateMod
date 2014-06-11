package mods.bloxgate.bloxgatemod.common;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityWalkingApple extends EntityAnimal
{
    public EntityWalkingApple(World par1World)
    {
        super(par1World);
        this.getNavigator().setAvoidsWater(true);
        this.setSize(1.5F, 1.0F);
        this.isImmuneToFire = false;
        float var2 = 0.25F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(2, new EntityAIMate(this, var2));
        this.tasks.addTask(3, new EntityAITempt(this, 0.3F, mod_bloxgatemod.uranium, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 0.28F));
        this.tasks.addTask(5, new EntityAIWander(this, var2));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    public boolean isAIEnabled()
    {
        return true;
    }
    protected Item getDropItemId()
    {
        return Items.apple;
    }
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
    }  /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityWalkingApple spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityWalkingApple(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.getItem() instanceof ItemUranium;
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
}
