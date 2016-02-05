package ga.warixmods.agkm.inventory;

import java.io.IOException;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.SendPacketToServer;
import ga.warixmods.agkm.client.gui.GuiWandButton1;
import ga.warixmods.agkm.client.gui.GuiWandButton2;
import ga.warixmods.agkm.client.gui.GuiWandButton3;
import ga.warixmods.agkm.client.gui.GuiWandButton4;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiWand extends GuiScreen{
	public static final int GUI_ID = 20;
	public GuiWand () {}
    @Override
    public void initGui()
    {
    	buttonList.add(new GuiWandButton1(0, width / 2 - 100 , height / 2 - 20,"1"));
    	buttonList.add(new GuiWandButton2(1, width / 2 - 50, height / 2 - 20,"1"));
    	buttonList.add(new GuiWandButton3(2, width / 2 + 0, height / 2 - 20,"1"));
    	buttonList.add(new GuiWandButton4(3, width / 2  + 50, height / 2 - 20,"1"));
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
    	AkameGaKill.network.sendToServer(new SendPacketToServer("GUI1" + button.id));
		this.mc.displayGuiScreen((GuiScreen)null);
		this.mc.setIngameFocus(); 
    	this.updateScreen();
    }
	
	
	
	
	
	
}
