package ga.warixmods.agkm.inventory;

import java.io.IOException;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.SendPacketToServer;
import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GuiYatsufusa extends GuiScreen{
	
	 public static EntityPlayer playerIn;
	 public static int mobs = 0;
	 protected static final ResourceLocation buttonTextures1 = new ResourceLocation("agkm:textures/gui/demo_background2.png");
	 public static final int GUI_ID = 21;
	 NBTTagCompound nbt;
	 public GuiYatsufusa(EntityPlayer player) {
		 playerIn = player;
		 nbt = player.getHeldItem().getTagCompound();
	}

	@Override
	    public void initGui()
	    {
		mobs = 0;
		if(nbt.hasKey("id"))
		{
			int[] id = nbt.getIntArray("id");
			int low = 100;
			
			for(int i = 0; i <= id.length - 1; i++)
			{
			
			 if(id[i] != 0)
			 {
	    	 buttonList.add(new GuiButton(i, this.width / 2 - 100 , height/ 2 - low,EntityList.getStringFromID(id[i])));
	    	 
	    	 low = low-25;
	    	 if(mobs < 8) 
	    	  mobs++;
			 }
			}
		}
	    }
	
	 @Override
	 public void drawScreen(int mouseX, int mouseY, float partialTicks)
	    {
			this.drawDefaultBackground(); 
	        mc.getTextureManager().bindTexture(buttonTextures1);
	        this.drawTexturedModalRect(width / 2 - 125, height / 2 - 125,0,0, 247, 242);
	        if(mobs == 0)
	        this.fontRendererObj.drawString("You didn't kill any mobs with your Yatsufusa! ", width / 2- 120, height / 2  - 50, 1);
	        else
	        this.fontRendererObj.drawString("Select the creature you want to summon: ", width / 2- 115, height / 2  - 115, 1);
	        super.drawScreen(mouseX, mouseY, partialTicks);
	        mc.thePlayer.setCurrentItemOrArmor(4, new ItemStack(AkameItems.murasame,1));
	        this.fontRendererObj.drawString(mobs +  "/8", width / 2 + 75, height / 2   + 100, 1);
	        
	    }
	 @Override
	    public void actionPerformed(GuiButton button) throws IOException
	    {
	    	AkameGaKill.network.sendToServer(new SendPacketToServer("GUI2" + this.nbt.getIntArray("id")[button.id]));
    		AkameGaKill.network.sendToServer(new SendPacketToServer("GUI3" + button.id));
    		this.mc.displayGuiScreen((GuiScreen)null);
    		this.mc.setIngameFocus(); 
	    	this.updateScreen();
	    }
}
