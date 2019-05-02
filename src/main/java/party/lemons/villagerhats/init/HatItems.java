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
	public static final Item FARMER_HAT = registerItem(new VillagerHatItem(VillagerProfession.FARMER), "farmer_hat");
	public static final Item ARMORER_HAT = registerItem(new VillagerHatItem(VillagerProfession.ARMORER), "armorer_hat");
	public static final Item BUTCHER_HAT = registerItem(new VillagerHatItem(VillagerProfession.BUTCHER), "butcher_hat");
	public static final Item CARTOGRAPHER_HAT = registerItem(new VillagerHatItem(VillagerProfession.CARTOGRAPHER), "cartographer_hat");
	public static final Item FISHERMAN_HAT = registerItem(new VillagerHatItem(VillagerProfession.FISHERMAN), "fisherman_hat");
	public static final Item FLETCHER_HAT = registerItem(new VillagerHatItem(VillagerProfession.FLETCHER), "fletcher_hat");
	public static final Item LIBRARIAN_HAT = registerItem(new VillagerHatItem(VillagerProfession.LIBRARIAN), "librarian_hat");
	public static final Item SHEPHERD_HAT = registerItem(new VillagerHatItem(VillagerProfession.SHEPHERD), "shepherd_hat");
	public static final Item WEAPONSMITH_HAT = registerItem(new VillagerHatItem(VillagerProfession.WEAPONSMITH), "weaponsmith_hat");

	public static Item registerItem(Item item, String name)
	{
		Registry.register(Registry.ITEM, new Identifier(Reference.MODID, name), item);
		return item;
	}

	@Override
	public void onInitialize()
	{

	}
}
