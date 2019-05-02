package party.lemons.villagerhats.client;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import party.lemons.villagerhats.item.VillagerHatItem;

public class PlayerVillagerHatRenderLayer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M>
{
	public PlayerVillagerHatRenderLayer(FeatureRendererContext<T, M> render)
	{
		super(render);
	}

	private Identifier findTexture(String string_1, Identifier identifier_1) {
		return new Identifier(identifier_1.getNamespace(), "textures/entity/villager/"+ string_1 + "/" + identifier_1.getPath() + ".png");
	}

	@Override
	public void render(T living, float x, float y, float z, float float_4, float float_5, float float_6, float delta)
	{
		if(!living.getEquippedStack(EquipmentSlot.HEAD).isEmpty() && living.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof VillagerHatItem)
		{
			VillagerHatItem hat = (VillagerHatItem) living.getEquippedStack(EquipmentSlot.HEAD).getItem();
			GlStateManager.scalef(1.01F, 1.01F, 1.01F);

			if(living.isSneaking())
			{
				GlStateManager.translated(0, 0.250D, 0);
			}

			VillagerResemblingModel<T> hatModel = new VillagerResemblingModel<>(0);
			hatModel.cuboidList.forEach(c -> c.visible = false);

			hatModel.setHatVisible(true);
			//((class_3884)hatModel).method_17150(true);

			this.bindTexture(this.findTexture("profession", Registry.VILLAGER_PROFESSION.getId(hat.getProfession())));

			hatModel.render(living, x, y, float_4, float_5, float_6, delta);
			GlStateManager.translatef(0, 0, 0F);
			GlStateManager.scalef(1F, 1F, 1F);
		}
	}

	@Override
	public boolean hasHurtOverlay()
	{
		return false;
	}
}