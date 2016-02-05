package ga.warixmods.agkm.client.model;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class ModelIceShards extends ModelBase{


	    ModelRenderer Shape1;
	    ModelRenderer Shape21;
	    ModelRenderer Shape31;
	    ModelRenderer Shape3;
	    ModelRenderer Shape2;
	    ModelRenderer Shape4;
	  
	  public ModelIceShards()
	  {
	    textureWidth = 10;
	    textureHeight = 5;
	    
	      Shape1 = new ModelRenderer(this, 0, 0);
	      Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
	      Shape1.setRotationPoint(0F, 0F, 0F);
	      Shape1.setTextureSize(10, 5);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);
	      Shape21 = new ModelRenderer(this, 0, 0);
	      Shape21.addBox(0F, 0F, 0F, 1, 3, 1);
	      Shape21.setRotationPoint(0F, 0F, 1F);
	      Shape21.setTextureSize(10, 5);
	      Shape21.mirror = true;
	      setRotation(Shape21, 0F, 0F, 0F);
	      Shape31 = new ModelRenderer(this, 0, 0);
	      Shape31.addBox(0F, 0F, 0F, 3, 1, 1);
	      Shape31.setRotationPoint(-1F, 1F, 0F);
	      Shape31.setTextureSize(10, 5);
	      Shape31.mirror = true;
	      setRotation(Shape31, 0F, 0F, 0F);
	      Shape31 = new ModelRenderer(this, 0, 0);
	      Shape31.addBox(0F, 0F, 0F, 3, 1, 1);
	      Shape31.setRotationPoint(-1F, 1F, 1F);
	      Shape31.setTextureSize(10, 5);
	      Shape31.mirror = true;
	      setRotation(Shape31, 0F, 0F, 0F);
	      Shape21 = new ModelRenderer(this, 0, 0);
	      Shape21.addBox(0F, 0F, 0F, 1, 3, 1);
	      Shape21.setRotationPoint(0F, 0F, 0F);
	      Shape21.setTextureSize(10, 5);
	      Shape21.mirror = true;
	      setRotation(Shape21, 0F, 0F, 0F);
	      Shape4 = new ModelRenderer(this, 0, 0);
	      Shape4.addBox(0F, 0F, 0F, 1, 1, 4);
	      Shape4.setRotationPoint(0F, 1F, -1F);
	      Shape4.setTextureSize(10, 5);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	    Shape1.render(f5);
	    Shape21.render(f5);
	    Shape31.render(f5);
	    Shape31.render(f5);
	    Shape21.render(f5);
	    Shape4.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	  }
	}
	
	

