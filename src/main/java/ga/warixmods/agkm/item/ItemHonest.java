package ga.warixmods.agkm.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemHonest extends Item{
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!stack.hasTagCompound()) {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			nbt.setString("Type", "Teigu");
		}
		}
}
