package ga.warixmods.agkm.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemErastone extends ItemTeigu
{

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn,List toolTip,boolean advanced)
	{
	    	toolTip.add("\u00A75\u00A7oAbsolute Limitation Erastone ");    
	    	toolTip.add("\u00A76Erastone is shaped as a golden ring of average");
	    	toolTip.add("\u00A76radius.When activated, a purple eye opened in its");
	    	toolTip.add("\u00A76center, with black branching patterns appearing");
	    	toolTip.add("\u00A76around the eye itself. Once itsuser chose their ");
	    	toolTip.add("\u00A76target, the ring shined a bright light towards ");
	    	toolTip.add("\u00A76adesignated Teigu, disabling and destroying the weapon.");
	    	toolTip.add("\u00A76aHowever, the weapon had a singular usage, as the ring's");
	    	toolTip.add("\u00A76eyeball would shatter once its effect had been utilized.");
	    	toolTip.add("\u00A76This Teigu will destroy itself and the Teigu ");
	    	toolTip.add("\u00A76other player is holding.");
	}
}
