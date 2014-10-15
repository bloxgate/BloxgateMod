package mods.bloxgate.bloxgatemod.client.gui;

import mods.bloxgate.bloxgatemod.client.container.ContainerBlockDeployer;
import mods.bloxgate.bloxgatemod.common.tileentity.TileEntityBlockDeployer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiBlockDeployer extends GuiContainer
{
    public static final ResourceLocation texture = new ResourceLocation("bloxgate", "textures/gui/deployer.png");
    public GuiBlockDeployer(InventoryPlayer invPlayer, TileEntityBlockDeployer entity)
    {
        super(new ContainerBlockDeployer(invPlayer, entity));
        xSize = 176;
        ySize = 165;
    }
    @Override
    public void drawGuiContainerBackgroundLayer(float f, int j, int i)
    {
        GL11.glColor4f(1f, 1f, 1f, 1f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
