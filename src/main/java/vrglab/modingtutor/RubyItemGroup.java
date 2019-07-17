package vrglab.modingtutor;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import vrglab.modingtutor.lists.ItemList;

public class RubyItemGroup extends ItemGroup
{

	public RubyItemGroup() 
	{
		
		super("More_Items");
		
	}

	@Override
	public ItemStack createIcon() {
		
		return new  ItemStack(ItemList.tutorial_item);
		
	}



}
