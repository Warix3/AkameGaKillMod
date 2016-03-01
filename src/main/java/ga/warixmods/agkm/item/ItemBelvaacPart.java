package ga.warixmods.agkm.item;

import ga.warixmods.agkm.entity.projectile.EntityBelvaac;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemBelvaacPart extends ItemTeigu{


	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if (!playerIn.capabilities.isCreativeMode)
            --itemStackIn.stackSize;
		playerIn.inventory.mainInventory[playerIn.inventory.currentItem] = null;
		if(!worldIn.isRemote)
		{
			EntityBelvaac belvac = new EntityBelvaac(worldIn, playerIn);
			worldIn.spawnEntityInWorld(belvac);
        }	
        return itemStackIn;
    }
}
