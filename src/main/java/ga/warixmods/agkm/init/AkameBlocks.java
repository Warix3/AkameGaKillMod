package ga.warixmods.agkm.init;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.Reference;
import ga.warixmods.agkm.blocks.BlockInit;
import ga.warixmods.agkm.blocks.GcKeyBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AkameBlocks {

	public static Block test_block;
	public static Block gckey_stab;
	public static void init()
	{
		gckey_stab = new GcKeyBlock(Material.sand).setUnlocalizedName("gckey_stab").setCreativeTab(AkameGaKill.tabAkame);
	}
	public static void register()
	{
		GameRegistry.registerBlock(gckey_stab, gckey_stab.getUnlocalizedName().substring(5));
		GameRegistry.addRecipe(new ItemStack(AkameBlocks.gckey_stab, 1), new Object[] {"###", "#E#", "###",'#', Blocks.diamond_block,'E',Blocks.emerald_block});
		
	}
	public static void registerRenders()
	{
	registerRender(gckey_stab);
	}
	public static void registerRender(Block block)
	{
	Item item = Item.getItemFromBlock(block);
	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
