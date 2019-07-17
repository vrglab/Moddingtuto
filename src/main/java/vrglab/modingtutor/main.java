package vrglab.modingtutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vrglab.modingtutor.items.ItemCustomAxe;
import vrglab.modingtutor.items.ItemCustomPickaxe;
import vrglab.modingtutor.lists.ArmorMaterialList;
import vrglab.modingtutor.lists.BlockList;
import vrglab.modingtutor.lists.ItemList;
import vrglab.modingtutor.lists.ToolMaterialList;
import vrglab.modingtutor.world.OreGeneration;

@Mod("modingtuto")
public class main 
{
	public static main instance;
	public static final String modid = "modingtuto";
	private static final Logger LOGGER = LogManager.getLogger(modid);
	
	public static final ItemGroup More_Items = new  RubyItemGroup();
	
    public main() 
    {
    	instance = this;
    	
      FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);	
      FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
      
      
      MinecraftForge.EVENT_BUS.register(this);
	}
    
    private void setup(final FMLCommonSetupEvent event) 
    {
    	OreGeneration.setupOreGeneration();
    	LOGGER.info("Setup method registered.");
    }
    private void clientRegistries(final FMLClientSetupEvent event) 
    {
    	LOGGER.info("clientRegistries method registered.");
    }
    
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegsitryEvents
    {
    	@SubscribeEvent
    	public static void registerItems(final RegistryEvent.Register<Item> event) 
    	{
    		event.getRegistry().registerAll
    		(
    			//items
    		     ItemList.tutorial_item = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("tutorial_item")),
    		     ItemList.ashes = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("ashes")),
    		     ItemList.ashes_on_fire = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("ashes_on_fire")),
    		    ItemList.ashes_on_fire1 = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("ashes_on_fire1")),
    		    ItemList.diamond_ashes = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("diamond_ashes")),
    		     ItemList.diamond_nugget = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("diamond_nugget")),
    		     ItemList.ruby_inggot = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("diamond_inggot")),
    		    ItemList.ore_furnec_front = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("ore_furnec_front")),
    		     ItemList.crafter = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("crafter")),
    		     ItemList.copper = new  Item(new Item.Properties().group(More_Items)).setRegistryName(location("copper")),
    		     
    		     //blocks 
    		     ItemList.ruby_block = new  ItemBlock(BlockList.ruby_block, new Item.Properties().group(More_Items)).setRegistryName(BlockList.ruby_block.getRegistryName()),
    		     ItemList.ruby_ore = new  ItemBlock(BlockList.ruby_ore, new Item.Properties().group(More_Items)).setRegistryName(BlockList.ruby_ore.getRegistryName()),
    		 
    		     
    		     
    		     //fucntional blocks
    		     
    		     ItemList.ore_furnec_front = new  ItemBlock(BlockList.ore_furnec_front, new Item.Properties().group(More_Items)).setRegistryName(BlockList.ore_furnec_front.getRegistryName()),
    		     ItemList.ore_furnec_fron_on = new  ItemBlock(BlockList.ore_furnec_front_on, new Item.Properties().group(More_Items)).setRegistryName(BlockList.ore_furnec_front_on.getRegistryName()),
    		     ItemList.diamond_maker = new  ItemBlock(BlockList.diamond_maker, new Item.Properties().group(More_Items)).setRegistryName(BlockList.diamond_maker.getRegistryName()),
    		     ItemList.crafter = new  ItemBlock(BlockList.crafter, new Item.Properties().group(More_Items)).setRegistryName(BlockList.crafter.getRegistryName()),     
    		     
    		     
    		     //tools
    		     ItemList.ruby_axe = new ItemCustomAxe(ToolMaterialList.tools,-1.0f, 6.0f, new Item.Properties().group(More_Items)).setRegistryName(location("ruby_axe")),
    		     ItemList.ruby_hoe = new ItemHoe(ToolMaterialList.tools, 6.0f, new Item.Properties().group(More_Items)).setRegistryName(location("ruby_hoe")),
    		     ItemList.ruby_pickaxe = new ItemCustomPickaxe(ToolMaterialList.tools,-2, 6.0f, new Item.Properties().group(More_Items)).setRegistryName(location("ruby_pickaxe")),
    		     ItemList.ruby_shovel = new ItemSpade(ToolMaterialList.tools,-3.0f, 6.0f, new Item.Properties().group(More_Items)).setRegistryName(location("ruby_shovel")),
    		     ItemList.ruby_sword = new ItemSword(ToolMaterialList.tools, 0, 6.0f, new Item.Properties().group(More_Items)).setRegistryName(location("ruby_sword")),
    		     
    		     
    		     
    		     //armor
    		     
    		     ItemList.ruby_helmet = new ItemArmor(ArmorMaterialList.Armor, EntityEquipmentSlot.HEAD , new Item.Properties().group(More_Items)).setRegistryName(location("ruby_helmet")),
    		     ItemList.ruby_chestplate = new ItemArmor(ArmorMaterialList.Armor, EntityEquipmentSlot.CHEST , new Item.Properties().group(More_Items)).setRegistryName(location("ruby_chestplate")),
    		     ItemList.ruby_leggings = new ItemArmor(ArmorMaterialList.Armor, EntityEquipmentSlot.LEGS , new Item.Properties().group(More_Items)).setRegistryName(location("ruby_leggings")),
    		     ItemList.ruby_boots = new ItemArmor(ArmorMaterialList.Armor, EntityEquipmentSlot.FEET , new Item.Properties().group(More_Items)).setRegistryName(location("ruby_boots"))
    		     
    		     
    		     
    		     
    		     
    		     
    		     
    		);
    		
    		//logger
    		LOGGER.info("Item registered.");
    	}
    	@SubscribeEvent
    	public static void registerBlocks(final RegistryEvent.Register<Block> event) 
    	{
    		event.getRegistry().registerAll
    		(
    		     BlockList.ruby_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("ruby_block"))
    		);
    		
    		LOGGER.info("Block registered.");
    	}
  private static ResourceLocation location(String name) 
  {
	  return new ResourceLocation(modid, name);
		

  }
    }   
 }
