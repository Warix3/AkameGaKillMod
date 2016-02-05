package ga.warixmods.agkm.entity.special;

import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityRocketLauncher extends EntityLivingBase{

	public EntityRocketLauncher(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getHeldItem() {
		// TODO Auto-generated method stub
		return new ItemStack(AkameItems.belvaac,1);
	}

	@Override
	public ItemStack getEquipmentInSlot(int slotIn) {
		// TODO Auto-generated method stub
		return new ItemStack(AkameItems.belvaac,1);
	}

	@Override
	public ItemStack getCurrentArmor(int slotIn) {
		// TODO Auto-generated method stub
		return new ItemStack(AkameItems.belvaac,1);
	}

	@Override
	public void setCurrentItemOrArmor(int slotIn, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack[] getInventory() {
		// TODO Auto-generated method stub
		ItemStack stack1 = new ItemStack(AkameItems.belvaac,1);
		ItemStack[] stack = {stack1};
		return stack;
	}

	
	



	



}
