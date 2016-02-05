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

public class ItemgcArmor extends ItemArmor {

	public ItemgcArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!stack.hasTagCompound()) {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			nbt.setString("Type", "Teigu");
		}
		}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity,int slot,String type)
	{
		if(this.armorType == 2)
		{
		return "agkm:textures/models/armor/gc_layer_2.png";
		}
		return "agkm:textures/models/armor/gc_layer_1.png";
		
	}
	  @Override
	    @SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack stack, EntityPlayer playerIn,List toolTip,boolean advanced)
	    {
		  if(stack.hasTagCompound())
		  {
	    if(stack.getTagCompound().hasKey("HUsage"))
	    {
	    	NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("HUsage");
	    	int usage = nbt.getInteger("HD");
	    	toolTip.add("Durability: " + usage);
	    }	
		  }
	    }

}
