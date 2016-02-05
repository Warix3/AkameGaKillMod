package ga.warixmods.agkm.item;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.entity.projectile.EntityRocket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemPerfector extends Item{
	
	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {

   if(!stack.hasTagCompound())
   {
	   NBTTagCompound nbt = new NBTTagCompound();
	   stack.setTagCompound(nbt);
	   nbt.setInteger("id",0);
	   nbt.setString("Type","Teigu");
   }	
    }
	@Override
	  public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {
		if(playerIn.isSneaking())
		{
			playerIn.openGui(AkameGaKill.instance, 22, worldIn, 0, 0, 0);
		}
	        return itemStackIn;
	    }



}
