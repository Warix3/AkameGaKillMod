package ga.warixmods.agkm.item;


import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemDemonsExtract extends ItemFood{

	public ItemDemonsExtract(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!stack.hasTagCompound()) {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			nbt.setString("Type", "Food");
		}
		}
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
    	ItemStack wand = new ItemStack(AkameItems.demons_extract_wand,1);
    	
    	
		
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("id", 0);
		wand.setTagCompound(nbt);
    	
    	if(player.inventory.getFirstEmptyStack() != -1)
    	{
        player.inventory.addItemStackToInventory(wand);
    	}
    	else
    	{
    	player.entityDropItem(wand, 0);
    	}
        
    }
	
	
}
