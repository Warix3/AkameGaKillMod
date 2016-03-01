package ga.warixmods.agkm.item;


import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemDemonsExtract extends ItemTeiguFood{

	public ItemDemonsExtract(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);	
	}

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
    	ItemStack wand = new ItemStack(AkameItems.demons_extract_wand,1);
    	
    	if(player.inventory.getFirstEmptyStack() != -1)
        player.inventory.addItemStackToInventory(wand);
    	else
    	player.entityDropItem(wand, 0);
    }
}
