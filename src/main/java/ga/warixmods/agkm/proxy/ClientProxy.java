package ga.warixmods.agkm.proxy;


import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import ga.warixmods.agkm.Reference;
import ga.warixmods.agkm.client.renderer.entity.RenderBelvaac;
import ga.warixmods.agkm.client.renderer.entity.RenderIceShards;
import ga.warixmods.agkm.client.renderer.entity.RenderRocket;
import ga.warixmods.agkm.client.renderer.entity.RenderRocketLauncher;
import ga.warixmods.agkm.entity.projectile.EntityBelvaac;
import ga.warixmods.agkm.entity.projectile.EntityIceShards;
import ga.warixmods.agkm.entity.projectile.EntityMastemaFeather;
import ga.warixmods.agkm.entity.projectile.EntityRocket;
import ga.warixmods.agkm.entity.special.EntityRocketLauncher;
import ga.warixmods.agkm.events.ForgeEventsClient;
import ga.warixmods.agkm.init.AkameBlocks;
import ga.warixmods.agkm.init.AkameEntities;
import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
	public ClientProxy()
	{
		MinecraftForge.EVENT_BUS.register(new ForgeEventsClient());
		
	}
	
	public void registerRenders()
	{
		AkameItems.registerRenders();
		AkameBlocks.registerRenders();
		registerEntityRenders();
	}
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityIceShards.class, new RenderIceShards(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBelvaac.class, new RenderBelvaac(Minecraft.getMinecraft().getRenderManager(), AkameItems.belvaac_part_1, Minecraft.getMinecraft().getRenderItem() ));
		RenderingRegistry.registerEntityRenderingHandler(EntityRocketLauncher.class, new RenderRocketLauncher(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderRocket(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMastemaFeather.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(),Items.feather, Minecraft.getMinecraft().getRenderItem()));
	}
}
