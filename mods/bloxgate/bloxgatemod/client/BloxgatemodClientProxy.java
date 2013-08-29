/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods.bloxgate.bloxgatemod.client;

import mods.bloxgate.bloxgatemod.common.BloxgatemodCommonProxy;
import mods.bloxgate.bloxgatemod.common.EntityWalkingApple;
import mods.bloxgate.bloxgatemod.common.RenderWalkingApple;
import mods.bloxgate.bloxgatemod.common.WalkingApple;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * @author Gregory
 */
public class BloxgatemodClientProxy extends BloxgatemodCommonProxy{
    @Override
    public void registerRenderThings(){

    }
    @SideOnly(Side.CLIENT)
    public static int addArmor(String armor){
    	return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    public void registerRenderInformation(){
    	 EntityRegistry.registerGlobalEntityID(EntityWalkingApple.class, "WalkingApple", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
    }
}
