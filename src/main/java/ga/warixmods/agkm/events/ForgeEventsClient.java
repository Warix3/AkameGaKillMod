package ga.warixmods.agkm.events;

import org.lwjgl.opengl.GL11;

import ga.warixmods.agkm.events.extendedproperties.EntityExtendedProperties;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventsClient
{
	@SubscribeEvent
	public void RenderLivingEvent(RenderLivingEvent.Pre event)
	{
		if (EntityExtendedProperties.get(event.entity).isFrozen())
		{
			GlStateManager.pushMatrix();
			GL11.glColor3f(0.5f, 2.0f, 10.0f);
			 GlStateManager.popMatrix();
		}
	}

}