package party.lemons.villagerhats.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
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

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float customAngle, float headYaw, float headPitch)
	{
		if(!entity.getEquippedStack(EquipmentSlot.HEAD).isEmpty() && entity.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof VillagerHatItem)
		{
			matrices.push();
			if(entity.isSneaking())
			{
				RenderSystem.translatef(0, 0.250F, 0);
			}

			VillagerHatModel<T> hatModel = new VillagerHatModel<>(0);
			((ModelWithHead)this.getContextModel()).getHead().rotate(matrices);

			VertexConsumer vertexConsumer = vertexConsumers.getBuffer(hatModel.getLayer(this.getTexture(entity)));
			hatModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);

			if(entity.isSneaking())
				RenderSystem.translatef(0, -0.25F, 0F);
			matrices.pop();
		}
	}

	private Identifier findTexture(String string_1, Identifier identifier_1) {
		return new Identifier(identifier_1.getNamespace(), "textures/entity/villager/"+ string_1 + "/" + identifier_1.getPath() + ".png");
	}

	@Override
	protected Identifier getTexture(T entity)
	{
		if(!entity.getEquippedStack(EquipmentSlot.HEAD).isEmpty() && entity.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof VillagerHatItem)
		{
			VillagerHatItem hat = (VillagerHatItem) entity.getEquippedStack(EquipmentSlot.HEAD).getItem();
			return this.findTexture("profession", Registry.VILLAGER_PROFESSION.getId(hat.getProfession()));
		}
		return super.getTexture(entity);
	}
}
