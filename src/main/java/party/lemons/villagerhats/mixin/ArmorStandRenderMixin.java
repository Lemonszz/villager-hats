package party.lemons.villagerhats.mixin;

import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.ArmorStandEntityModel;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import party.lemons.villagerhats.client.PlayerVillagerHatRenderLayer;

@Mixin(ArmorStandEntityRenderer.class)
public class ArmorStandRenderMixin extends LivingEntityRenderer<ArmorStandEntity, ArmorStandEntityModel> {
    public ArmorStandRenderMixin(EntityRenderDispatcher entityRenderDispatcher_1, ArmorStandEntityModel entityModel_1, float float_1)
    {
        super(entityRenderDispatcher_1, entityModel_1, float_1);
    }

    @Inject(at = @At("RETURN"), method = "<init>")
    public void onConstruct(EntityRenderDispatcher dispatcher, CallbackInfo info)
    {
        this.addFeature(new PlayerVillagerHatRenderLayer<>(this));
    }

    @Override
    protected Identifier getTexture(ArmorStandEntity armorStandEntity)
    {
        return null;
    }
}
