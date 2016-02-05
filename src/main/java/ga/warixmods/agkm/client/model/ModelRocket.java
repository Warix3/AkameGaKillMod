package ga.warixmods.agkm.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRocket extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer head4;
    ModelRenderer back1;
    ModelRenderer back2;
    ModelRenderer back3;
    ModelRenderer back4;
  
  public ModelRocket()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 17, 11);
      body.addBox(0F, 0F, 0F, 1, 1, 5);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      head = new ModelRenderer(this, 12, 0);
      head.addBox(0F, 0F, 0F, 1, 0, 2);
      head.setRotationPoint(0F, -1F, 4F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, -0.7853982F, 0F, 0F);
      head2 = new ModelRenderer(this, 29, 0);
      head2.addBox(0F, 0F, 0F, 1, 0, 2);
      head2.setRotationPoint(0F, 2F, 4F);
      head2.setTextureSize(64, 32);
      head2.mirror = true;
      setRotation(head2, 0.7853982F, 0F, 0F);
      head3 = new ModelRenderer(this, 22, 0);
      head3.addBox(0F, 0F, 0F, 2, 1, 0);
      head3.setRotationPoint(1F, 0F, 5.2F);
      head3.setTextureSize(64, 32);
      head3.mirror = true;
      setRotation(head3, 0F, 0.7853982F, 0F);
      head4 = new ModelRenderer(this, 22, 0);
      head4.addBox(0F, 0F, 0F, 2, 1, 0);
      head4.setRotationPoint(0F, 0F, 5.2F);
      head4.setTextureSize(64, 32);
      head4.mirror = true;
      setRotation(head4, 0F, 2.356194F, 0F);
      back1 = new ModelRenderer(this, 12, 0);
      back1.addBox(0F, 0F, 0F, 1, 0, 2);
      back1.setRotationPoint(0.5F, 0F, -1F);
      back1.setTextureSize(64, 32);
      back1.mirror = true;
      setRotation(back1, 0F, 0F, -1.570796F);
      back2 = new ModelRenderer(this, 12, 0);
      back2.addBox(0F, 0F, 0F, 1, 0, 2);
      back2.setRotationPoint(0.5F, 2F, -1F);
      back2.setTextureSize(64, 32);
      back2.mirror = true;
      setRotation(back2, 0F, 0F, -1.570796F);
      back3 = new ModelRenderer(this, 12, 0);
      back3.addBox(0F, 0F, 0F, 1, 0, 2);
      back3.setRotationPoint(1F, 0.5F, -1F);
      back3.setTextureSize(64, 32);
      back3.mirror = true;
      setRotation(back3, 0F, 0F, 0F);
      back4 = new ModelRenderer(this, 12, 0);
      back4.addBox(0F, 0F, 0F, 1, 0, 2);
      back4.setRotationPoint(-1F, 0.5F, -1F);
      back4.setTextureSize(64, 32);
      back4.mirror = true;
      setRotation(back4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(entity,f, f1, f2, f3, f4, f5);
    body.render(f5);
    head.render(f5);
    head2.render(f5);
    head3.render(f5);
    head4.render(f5);
    back1.render(f5);
    back2.render(f5);
    back3.render(f5);
    back4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(Entity entity,float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }

}
