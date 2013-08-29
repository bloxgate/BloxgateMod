package mods.bloxgate.bloxgatemod.common;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityEasterEgg1 extends EntityMob{


	public EntityEasterEgg1(World par1World) {
		super(par1World);
		this.getNavigator().setAvoidsWater(true);
		this.setSize(0.6F, 1.8F);
		this.isImmuneToFire = false;
		float var2 = 0.25F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.699D, true));
		this.tasks.addTask(1, new EntityAITempt(this, 0.3F, Item.slimeBall.itemID, false));
		this.tasks.addTask(5, new EntityAIWander(this, var2));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		// TODO Auto-generated constructor stub
	}
	public void func_110147_ax(){
		 super.func_110147_ax();
		 //field_111267_* a-Health , B-Follow Range, c - Knockback resistance, d-Movement speed, e - Attack damage
		 this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(72.0D);
		 this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0D);
		 this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.699D);
	}
public boolean isAIEnabled(){
	return true;
}
protected int getDropItemId(){
	return Item.slimeBall.itemID;
}
protected void dropFewItems(){
	this.dropItem(Item.slimeBall.itemID, 1);
}
}
