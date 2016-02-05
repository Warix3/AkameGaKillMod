package ga.warixmods.agkm;

import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AkameTab extends CreativeTabs {

	public AkameTab(String label) {
		super(label);
		// TODO Auto-generated constructor stub
		this.setBackgroundImageName("akame.png");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return AkameItems.gc_helmet;
	}

}
