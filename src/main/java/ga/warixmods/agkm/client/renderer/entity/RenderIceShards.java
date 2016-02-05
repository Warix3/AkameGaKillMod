package ga.warixmods.agkm.client.renderer.entity;


import org.lwjgl.opengl.GL11;

import ga.warixmods.agkm.client.model.ModelIceShards;
import ga.warixmods.agkm.entity.projectile.EntityIceShards;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderIceShards extends Render{

	


	
	public RenderIceShards(RenderManager renderManager)
	{
		super(renderManager);
		
	}
	public ModelBase model_ice_shard = new ModelIceShards();
	public static final ResourceLocation stoneRockTexture = new ResourceLocation("agkm:textures/entity/ice_shards_model.png");
	@Override
	public ResourceLocation getEntityTexture(Entity rock)
	{
		return stoneRockTexture;
	}
    @Override
	public void doRender(Entity rock, double p_180552_2_, double p_180552_4_, double p_180552_6_, float p_180552_8_, float p_180552_9_)
	{
		
		
		   GlStateManager.pushMatrix();
	        GlStateManager.translate((float)p_180552_2_, (float)p_180552_4_ + 0.25F, (float)p_180552_6_);
	        GlStateManager.rotate(180.0F - p_180552_8_, 0.0F, 1.0F, 0.0F);


	        float f4 = 0.75F;
	        GlStateManager.scale(f4, f4, f4);
	        GlStateManager.scale(1.0F / f4, 1.0F / f4, 1.0F / f4);
	        this.bindEntityTexture(rock);
	        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
	        this.model_ice_shard.render(rock, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GlStateManager.popMatrix();
	        super.doRender(rock, p_180552_2_, p_180552_4_, p_180552_6_, p_180552_8_, p_180552_9_);
		
	}
}
