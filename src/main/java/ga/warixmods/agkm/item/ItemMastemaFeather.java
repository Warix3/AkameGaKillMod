package ga.warixmods.agkm.item;

import ga.warixmods.agkm.entity.projectile.EntityMastemaFeather;
import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMastemaFeather extends ItemTeigu{

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(playerIn.getCurrentArmor(2) != null && playerIn.getCurrentArmor(2).getItem() == AkameItems.mastema && !worldIn.isRemote)
		{
			worldIn.spawnEntityInWorld(new EntityMastemaFeather(worldIn, playerIn));
		}
        return itemStackIn;
    }
	
}
