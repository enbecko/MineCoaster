// Date: 24.07.2014 19:01:06
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.roller.roller.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrackCurve extends ModelBase
{
  //fields
    ModelRenderer aussen;
    ModelRenderer aussen2;
    ModelRenderer mitet;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shaussen;
    ModelRenderer mitte3;
    ModelRenderer aussen4;
  
  public ModelTrackCurve()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      aussen = new ModelRenderer(this, 0, 15);
      aussen.addBox(0F, 0F, 0F, 2, 2, 15);
      aussen.setRotationPoint(-8F, 22F, 7F);
      aussen.setTextureSize(64, 32);
      aussen.mirror = true;
      setRotation(aussen, 0F, 1.570796F, 0F);
      aussen2 = new ModelRenderer(this, 0, 7);
      aussen2.addBox(0F, 0F, 0F, 2, 2, 3);
      aussen2.setRotationPoint(-8F, 22F, -5F);
      aussen2.setTextureSize(64, 32);
      aussen2.mirror = true;
      setRotation(aussen2, 0F, 1.570796F, 0F);
      mitet = new ModelRenderer(this, 31, 0);
      mitet.addBox(0F, 0F, 0F, 4, 1, 10);
      mitet.setRotationPoint(-8F, 23F, 2F);
      mitet.setTextureSize(64, 32);
      mitet.mirror = true;
      setRotation(mitet, 0F, 1.570796F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape4.setRotationPoint(-4F, 23F, 1.5F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0.1151917F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 12, 0);
      Shape5.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape5.setRotationPoint(1.5F, 23F, -4F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, -0.122173F);
      Shape6 = new ModelRenderer(this, 12, 0);
      Shape6.addBox(-5F, 0F, 0F, 5, 1, 1);
      Shape6.setRotationPoint(-1.533333F, 23.2F, -2.133333F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, -0.7853982F, 0.122173F);
      Shaussen = new ModelRenderer(this, 0, 15);
      Shaussen.addBox(0F, 0F, 0F, 2, 2, 15);
      Shaussen.setRotationPoint(5F, 22F, -8F);
      Shaussen.setTextureSize(64, 32);
      Shaussen.mirror = true;
      setRotation(Shaussen, 0F, 0F, 0F);
      mitte3 = new ModelRenderer(this, 31, 0);
      mitte3.addBox(0F, 0F, 0F, 4, 1, 10);
      mitte3.setRotationPoint(-2F, 23F, -8F);
      mitte3.setTextureSize(64, 32);
      mitte3.mirror = true;
      setRotation(mitte3, 0F, 0F, 0F);
      aussen4 = new ModelRenderer(this, 0, 7);
      aussen4.addBox(0F, 0F, 0F, 2, 2, 3);
      aussen4.setRotationPoint(-7F, 22F, -8F);
      aussen4.setTextureSize(64, 32);
      aussen4.mirror = true;
      setRotation(aussen4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    aussen.render(f5);
    aussen2.render(f5);
    mitet.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shaussen.render(f5);
    mitte3.render(f5);
    aussen4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
  }

}