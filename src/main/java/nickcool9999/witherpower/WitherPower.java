package nickcool9999.witherpower;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import nickcool9999.witherpower.base.*;
import nickcool9999.witherpower.block.*;
import nickcool9999.witherpower.network.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "WitherPower", name = "Wither Power", version = "1")
public class WitherPower {

	public static Item itemWitheredWrench,
					   itemConstructionPlating,
					   itemStarCore;
	public static Block blockWitherPowerController;
	public void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	public void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	public void ItemRecipe(Item item, Object[] recipe) {
		GameRegistry.addRecipe(new ItemStack(item), recipe);
	}
	public void BlockRecipe(Block block, Object[] recipe) {
		GameRegistry.addRecipe(new ItemStack(block), recipe);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Item/Block init registering
		//CFG handling
		//Items
			itemWitheredWrench = new WitheredWrench()
				.setUnlocalizedName("WitheredWrench")
				.setTextureName("WitherPower:witheredwrench")
				.setCreativeTab(tabWitherPower);
			itemConstructionPlating = new ConstructionPlating()
				.setUnlocalizedName("ConstructionPlating")
				.setTextureName("WitherPower:ConstructionPlating")
				.setCreativeTab(tabWitherPower);
			itemStarCore = new WitherStarCore()
				.setUnlocalizedName("StarStructureCore")
				.setTextureName("WitherPower:StarStructureCore")
				.setCreativeTab(tabWitherPower);
		//Blocks
			blockWitherPowerController = new BlockWPController()
			.setBlockName("WPController")
			.setBlockTextureName("WitherPower:wpowercontroller")
			.setCreativeTab(tabWitherPower);
		//Registry
			registerItem(itemWitheredWrench);
			registerItem(itemConstructionPlating);
			registerItem(itemStarCore);
			registerBlock(blockWitherPowerController);
			GameRegistry.registerTileEntity(nickcool9999.witherpower.network.WPowerController.class, "WPController");
		System.out.println("Wither Power Version 1 Loaded.");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		//Proxy, TileEntity, entity, GUI and Packet Registering
		ItemRecipe(itemWitheredWrench, new Object[]{" C "," SC","C  ",'C',itemConstructionPlating,'S',itemStarCore});
		ItemRecipe(itemStarCore, new Object[]{" C ","CSC"," C ",'C',itemConstructionPlating,'S',Items.nether_star});
		ItemRecipe(itemConstructionPlating, new Object[]{" I ","IGI"," I ",'G',Blocks.glass,'I',Items.iron_ingot});
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
	
	public static CreativeTabs tabWitherPower = new CreativeTabs("tabWitherPower"){
		@Override
		public Item getTabIconItem(){
			return new ItemStack(itemConstructionPlating).getItem();
		}
	};
}
