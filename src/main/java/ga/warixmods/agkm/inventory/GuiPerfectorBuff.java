package ga.warixmods.agkm.inventory;

import java.io.IOException;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.SendPacketToServer;
import ga.warixmods.agkm.client.gui.GuiPerfectorButton0;
import ga.warixmods.agkm.client.gui.GuiPerfectorButton1;
import ga.warixmods.agkm.client.gui.GuiPerfectorButton2;
import ga.warixmods.agkm.client.gui.GuiPerfectorButton3;
import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiPerfectorBuff extends GuiScreen{
	public static final int GUI_ID = 22;
	public GuiPerfectorBuff () {}
    @Override
    public void initGui()
    {
    	buttonList.add(new GuiPerfectorButton0(0, width / 2 - 100 , height / 2 - 20,"1"));
    	buttonList.add(new GuiPerfectorButton1(1, width / 2 - 50, height / 2 - 20,"1"));
    	buttonList.add(new GuiPerfectorButton2(2, width / 2 + 0, height / 2 - 20,"1"));
    	buttonList.add(new GuiPerfectorButton3(3, width / 2  + 50, height / 2 - 20,"1"));
    }
    protected static final ResourceLocation buttonTextures1 = new ResourceLocation("agkm:textures/gui/demo_background.png");
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
		this.drawDefaultBackground(); 
        mc.getTextureManager().bindTexture(buttonTextures1);
        this.drawTexturedModalRect(width / 2 - 125, height / 2 - 75,0,0, 247, 125);
        this.fontRendererObj.drawString("Choose the power you want to use:", width / 2- 100, height / 2  - 50, 1);
        super.drawScreen(mouseX, mouseY, partialTicks);  
    }
    @Override
    public void actionPerformed(GuiButton button) throws IOException
    {
    	AkameGaKill.network.sendToServer(new SendPacketToServer("GUI0" +button.id));
		this.mc.displayGuiScreen((GuiScreen)null);
		this.mc.setIngameFocus();
    	this.updateScreen();
    }
}
