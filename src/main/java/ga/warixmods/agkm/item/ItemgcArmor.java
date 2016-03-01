package ga.warixmods.agkm.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemgcArmor extends ItemTeiguArmor {

	public ItemgcArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity,int slot,String type)
	{
		if(this.armorType == 2)
		return "agkm:textures/models/armor/gc_layer_2.png";
		return "agkm:textures/models/armor/gc_layer_1.png";
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn,List toolTip,boolean advanced)
	{
	    	toolTip.add("\u00A7b\u00A7oCarnage Incarnate: Grand Chariot");
	    	toolTip.add("\u00A79The Grand Chariot armor grants its user");
	    	toolTip.add("\u00A79increased physical strength,speed and the");
	    	toolTip.add("\u00A79ability to fly. The stance required to activate");
	    	toolTip.add("\u00A79Grand Chariot is exactly the same as Incursio's");
	    	toolTip.add("\u00A79in which the user will stab the key");
	    	toolTip.add("\u00A79into the ground and the Danger Beast within will");
	    	toolTip.add("\u00A79cover its wielder with armor.To take the armor off,");
	    	toolTip.add("\u00A79just pull the key out of the ground.");
	}

}
