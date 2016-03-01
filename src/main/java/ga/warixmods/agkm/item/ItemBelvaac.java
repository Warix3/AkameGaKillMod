package ga.warixmods.agkm.item;

import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBelvaac extends ItemTeiguSword{

	public ItemBelvaac(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}

	 @Override
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {
		 ItemStack belvaac1 = new ItemStack(AkameItems.belvaac_part_1,1);
		 ItemStack belvaac2 = new ItemStack(AkameItems.belvaac_part_2,1);
		 if(playerIn.isSneaking())
		 {
			 
			 InventoryPlayer inv = playerIn.inventory;
			 
		
			 
			 
			
			 if(inv.getFirstEmptyStack() == -1  )
		    	{
		        
		        playerIn.entityDropItem(belvaac2, 0);
		    	}
		    	else
		    	{
		    		inv.addItemStackToInventory(belvaac2);
		    		
		    	}
			 
			 return belvaac1;
		 }else
		 {
			 return itemStackIn;
		 }
	        
	        
	    }
	
}
