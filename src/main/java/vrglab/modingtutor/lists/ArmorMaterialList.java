package vrglab.modingtutor.lists;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import vrglab.modingtutor.main;

public enum ArmorMaterialList implements IArmorMaterial
{
   Armor("ruby_armor", 400, new int[] {12, 12, 10, 9}, 25, ItemList.tutorial_item, "item.armor.equip_diamond", 1.0f);
	
	private static final int [] max_damage_array = new int[] {13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantablity;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	
	
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantablity, Item repairItem, String equipSound, float toughness) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantablity = enchantablity;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}




	@Override
	public int getDamageReductionAmount(EntityEquipmentSlot slot) {
		
		return this.damageReductionAmounts[slot.getSlotIndex()];
	}




	@Override
	public int getDurability(EntityEquipmentSlot slot) {
		
		return max_damage_array[slot.getIndex()]  * this.durability;
	}




	@Override
	public int getEnchantability() {
		
		return this.enchantablity;
	}




	@Override
	public String getName() {
		
		return main.modid + ":" + this.name;
	}




	@Override
	public Ingredient getRepairMaterial() {
		
		return Ingredient.fromItems(this.repairItem);
	}




	@Override
	public SoundEvent getSoundEvent() {
		
		return new SoundEvent(new ResourceLocation(equipSound));
	}




	@Override
	public float getToughness() {
		
		return this.toughness;
	}
	
}
