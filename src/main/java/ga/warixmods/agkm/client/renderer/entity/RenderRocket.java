package ga.warixmods.agkm.client.renderer.entity;
import static org.lwjgl.opengl.GL11.*;
import ga.warixmods.agkm.client.model.ModelRocket;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.*;;
@SideOnly(Side.CLIENT)
public class RenderRocket extends Render{
	
	public ModelBase model_rocket= new ModelRocket();
	
	public RenderRocket(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return new ResourceLocation("agkm:textures/entity/rocket.png");
	}
	
	@Override
	public void doRender(Entity rock, double p_180552_2_, double p_180552_4_, double p_180552_6_, float p_180552_8_, float p_180552_9_)
	{
		
		    GlStateManager.pushMatrix();
	        GlStateManager.translate((float)p_180552_2_, (float)p_180552_4_ + 0.25F, (float)p_180552_6_);
	        GlStateManager.rotate(-p_180552_8_, 0.0F, 1.0F, 0.0F);
	        this.bindEntityTexture(rock);
	        this.model_rocket.render(rock, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GlStateManager.popMatrix();
	        super.doRender(rock, p_180552_2_, p_180552_4_, p_180552_6_, p_180552_8_, p_180552_9_);
	       
	}
}
