package ga.warixmods.agkm.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMastema extends ItemArmor{

	public ItemMastema(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		player.capabilities.allowFlying = true;
	}
}
