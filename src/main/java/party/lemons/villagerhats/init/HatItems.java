package party.lemons.villagerhats.init;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerProfession;
import party.lemons.villagerhats.Reference;
import party.lemons.villagerhats.item.VillagerHatItem;

public class HatItems implements ModInitializer
{
	public static Item FARMER_HAT;
	public static Item ARMORER_HAT;
	public static Item BUTCHER_HAT;
	public static Item CARTOGRAPHER_HAT;
	public static Item FISHERMAN_HAT;
	public static Item FLETCHER_HAT;
	public static Item LIBRARIAN_HAT;
	public static Item SHEPHERD_HAT;
	public static Item WEAPONSMITH_HAT;

	public static Item registerItem(Item item, String name)
	{
		Registry.register(Registry.ITEM, new Identifier(Reference.MODID, name), item);
		return item;
	}

	@Override
	public void onInitialize()
	{
		FARMER_HAT = registerItem(new VillagerHatItem(VillagerProfession.FARMER), "farmer_hat");
		ARMORER_HAT = registerItem(new VillagerHatItem(VillagerProfession.ARMORER), "armorer_hat");
		BUTCHER_HAT = registerItem(new VillagerHatItem(VillagerProfession.BUTCHER), "butcher_hat");
		CARTOGRAPHER_HAT = registerItem(new VillagerHatItem(VillagerProfession.CARTOGRAPHER), "cartographer_hat");
		FISHERMAN_HAT = registerItem(new VillagerHatItem(VillagerProfession.FISHERMAN), "fisherman_hat");
		FLETCHER_HAT = registerItem(new VillagerHatItem(VillagerProfession.FLETCHER), "fletcher_hat");
		LIBRARIAN_HAT = registerItem(new VillagerHatItem(VillagerProfession.LIBRARIAN), "librarian_hat");
		SHEPHERD_HAT = registerItem(new VillagerHatItem(VillagerProfession.SHEPHERD), "shepherd_hat");
		WEAPONSMITH_HAT = registerItem(new VillagerHatItem(VillagerProfession.WEAPONSMITH), "weaponsmith_hat");
	}
}
