package party.lemons.villagerhats.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class VillagerArmorMaterial implements ArmorMaterial
{
	public static final ArmorMaterial INSTANCE = new VillagerArmorMaterial();

	@Override
	public int getDurability(EquipmentSlot var1)
	{
		return 150;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot var1)
	{
		return 0;
	}

	@Override
	public int getEnchantability()
	{
		return 0;
	}

	@Override
	public SoundEvent getEquipSound()
	{
		return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
	}

	@Override
	public Ingredient getRepairIngredient()
	{
		return Ingredient.EMPTY;
	}

	@Override
	public String getName()
	{
		return "villager";
	}

	@Override
	public float getToughness()
	{
		return 0;
	}

	@Override
	public float getKnockbackResistance()
	{
		return 0;
	}
}