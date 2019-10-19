package party.lemons.villagerhats.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.village.VillagerProfession;

public class VillagerHatItem extends ArmorItem
{
	private final VillagerProfession profession;


	public VillagerHatItem(VillagerProfession profession)
	{
		super(VillagerArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Settings().group(ItemGroup.COMBAT));

		this.profession = profession;
	}

	public VillagerProfession getProfession()
	{
		return profession;
	}

	public boolean hasRim()
	{
		if(profession == VillagerProfession.FARMER || profession == VillagerProfession.FISHERMAN)
			return true;

		return false;
	}
}
