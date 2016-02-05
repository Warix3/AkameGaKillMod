package ga.warixmods.agkm.client.renderer.entity;

import ga.warixmods.agkm.client.model.ModelRocketLauncherRM;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderRocketLauncher extends Render{

	
	public RenderRocketLauncher(RenderManager rendermanagerIn) {
		super(rendermanagerIn);
		// TODO Auto-generated constructor stub
	}
	protected ModelBase modelRocketLauncher = new ModelRocketLauncherRM();
	

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return new ResourceLocation("agkm:textures/entity/rocket_launcher.png");
	}

	public void doRender(Entity boat, double p_180552_2_, double p_180552_4_, double p_180552_6_, float p_180552_8_, float p_180552_9_)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)p_180552_2_, (float)p_180552_4_ + 0.25F, (float)p_180552_6_);
        
        GlStateManager.rotate(180.0F, 1, 0, 0);
        
        ModelRenderer toRotate = (ModelRenderer) this.modelRocketLauncher.boxList.get(0);
        EntityLiving riding = (EntityLiving) boat.ridingEntity;
        this.bindEntityTexture(boat);
        if(riding != null)
         toRotate.rotateAngleY = (float) (riding.rotationYawHead / (180 / Math.PI));
        
        this.modelRocketLauncher.render(boat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GlStateManager.popMatrix();
        super.doRender(boat, p_180552_2_, p_180552_4_, p_180552_6_, p_180552_8_, p_180552_9_);
    }
}
