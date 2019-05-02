package party.lemons.villagerhats.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import party.lemons.villagerhats.client.PlayerVillagerHatRenderLayer;

@Mixin(PlayerEntityRenderer.class)
public class PlayerRenderMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>>
{
	public PlayerRenderMixin(EntityRenderDispatcher entityRenderDispatcher_1, PlayerEntityModel<AbstractClientPlayerEntity> entityModel_1, float float_1)
	{
		super(entityRenderDispatcher_1, entityModel_1, float_1);
	}

	@Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/client/render/entity/EntityRenderDispatcher;Z)V")
	public void onConstruct(EntityRenderDispatcher dispatcher, boolean smallarms, CallbackInfo info)
	{
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");
		System.out.println("RENDERING LOLOLOL");

		this.addFeature(new PlayerVillagerHatRenderLayer<>(this));
	}

	@Override
	protected Identifier getTexture(AbstractClientPlayerEntity var1)
	{
		return null;
	}
}
