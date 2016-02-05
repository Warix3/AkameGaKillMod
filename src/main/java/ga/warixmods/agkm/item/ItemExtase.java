package ga.warixmods.agkm.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemExtase extends ItemSword{

	public ItemExtase(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}
	 @Override
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	 {
		 
		
	        return itemStackIn;
	 }
}
