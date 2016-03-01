package ga.warixmods.agkm.init;
import java.util.HashMap;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.Reference;
import ga.warixmods.agkm.item.ItemBelvaac;
import ga.warixmods.agkm.item.ItemBelvaacPart;
import ga.warixmods.agkm.item.ItemDemonsExtract;
import ga.warixmods.agkm.item.ItemDemonsExtractWand;
import ga.warixmods.agkm.item.ItemExtase;
import ga.warixmods.agkm.item.ItemErastone;
import ga.warixmods.agkm.item.ItemMastema;
import ga.warixmods.agkm.item.ItemMastemaFeather;
import ga.warixmods.agkm.item.ItemMurasame;
import ga.warixmods.agkm.item.ItemPerfector;
import ga.warixmods.agkm.item.ItemYatsufusa;
import ga.warixmods.agkm.item.ItemgcArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class AkameItems {

	public static Item gc_helmet;
	public static Item gc_body;
	public static Item gc_legs;
	public static Item gc_boots;
	public static Item gc_key1;
	public static Item gc_key2;
	public static Item murasame;
	public static Item demons_extract;
	public static Item demons_extract_wand;
	public static Item yatsufusa;
	public static Item belvaac;
	public static Item belvaac_part_1;
	public static Item belvaac_part_2;
	public static Item perfector;
	public static Item erastone;
	public static Item mastema;
	public static Item mastema_feather;
	public static Item extase;
	static ArmorMaterial grandc = EnumHelper.addArmorMaterial("gc", "diamond", 40, new int[]{3, 8, 6, 3} , 20);
	
	public static void init()
	{
		gc_helmet = new ItemgcArmor(grandc,1, 0).setUnlocalizedName("gc_helmet").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		gc_body = new ItemgcArmor(grandc, 1, 1).setUnlocalizedName("gc_body").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		gc_legs = new ItemgcArmor(grandc, 1, 2).setUnlocalizedName("gc_legs").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		gc_boots = new ItemgcArmor(grandc, 1, 3).setUnlocalizedName("gc_boots").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		murasame = new ItemMurasame(Item.ToolMaterial.EMERALD).setUnlocalizedName("murasame").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1).setFull3D();
		demons_extract = new ItemDemonsExtract(1, false).setAlwaysEdible().setUnlocalizedName("demons_extract").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		demons_extract_wand = new ItemDemonsExtractWand().setUnlocalizedName("demons_extract_wand").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1).setFull3D();
		yatsufusa = new ItemYatsufusa(ToolMaterial.EMERALD).setUnlocalizedName("yatsufusa").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1).setFull3D();
		belvaac = new ItemBelvaac(ToolMaterial.EMERALD).setUnlocalizedName("belvaac").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1).setFull3D();
		belvaac_part_1 = new ItemBelvaacPart().setUnlocalizedName("belvaac_part_1").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		belvaac_part_2 = new ItemBelvaacPart().setUnlocalizedName("belvaac_part_2").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		perfector = new ItemPerfector().setUnlocalizedName("perfector").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		erastone = new ItemErastone().setUnlocalizedName("erastone").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		mastema = new ItemMastema(ArmorMaterial.IRON,1,1).setUnlocalizedName("mastema").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		mastema_feather  = new ItemMastemaFeather().setUnlocalizedName("mastema_feather").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
		extase  = new ItemExtase(ToolMaterial.EMERALD).setUnlocalizedName("extase").setCreativeTab(AkameGaKill.tabAkame).setMaxStackSize(1);
	}
	
	
	public static void register()
	{
		GameRegistry.registerItem(gc_helmet, gc_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(gc_body, gc_body.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(gc_legs, gc_legs.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(gc_boots, gc_boots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(murasame, murasame.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demons_extract, demons_extract.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demons_extract_wand, demons_extract_wand.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(yatsufusa, yatsufusa.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(belvaac, belvaac.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(belvaac_part_1, belvaac_part_1.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(belvaac_part_2, belvaac_part_2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(perfector, perfector.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(erastone, erastone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(mastema, mastema.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(mastema_feather, mastema_feather.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(extase, extase.getUnlocalizedName().substring(5));
		
		GameRegistry.addRecipe(new ItemStack(AkameItems.murasame, 1), new Object[] {"#I#", "#I#", "#R#",'#',new ItemStack(Items.potionitem, 1, 8196),'I',Blocks.iron_block,'R',Blocks.redstone_block ,'E',Blocks.emerald_block});
	}
	
	public static void registerRenders()
	{
		registerRender(gc_body);
		registerRender(gc_helmet);
		registerRender(gc_legs);
		registerRender(gc_boots);
		registerRender(murasame);
		registerRender(demons_extract);
		registerRender(demons_extract_wand);
		registerRender(yatsufusa);
		registerRender(belvaac);
		registerRender(belvaac_part_1);
		registerRender(belvaac_part_2);
		registerRender(perfector);
		registerRender(erastone);
		registerRender(mastema);
		registerRender(mastema_feather);
		registerRender(extase);
	}
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
