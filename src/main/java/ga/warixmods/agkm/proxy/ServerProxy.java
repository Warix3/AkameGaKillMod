package ga.warixmods.agkm.proxy;

import ga.warixmods.agkm.events.ForgeEvents;
import ga.warixmods.agkm.init.AkameEntities;
import ga.warixmods.agkm.inventory.GuiPerfectorBuff;
import ga.warixmods.agkm.inventory.GuiWand;
import ga.warixmods.agkm.inventory.GuiYatsufusa;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ServerProxy implements IGuiHandler {
	
	
	public ServerProxy()
	{
		MinecraftForge.EVENT_BUS.register(new ForgeEvents());

	}
    @Override
    public Object getClientGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z ) {
    	if ( ID == GuiWand.GUI_ID )
            return new GuiWand();
    	if ( ID == GuiYatsufusa.GUI_ID )
            return new GuiYatsufusa(player);
    	if ( ID == GuiYatsufusa.GUI_ID )
            return new GuiYatsufusa(player);
    	if ( ID == GuiPerfectorBuff.GUI_ID )
            return new GuiPerfectorBuff();
    	else
            return null;
    }

   public void registerRenders()
   {
	
   }

@Override
public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		return null;
	
}
}
