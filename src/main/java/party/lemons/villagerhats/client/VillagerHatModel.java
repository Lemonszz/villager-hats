package party.lemons.villagerhats.client;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHat;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.passive.AbstractTraderEntity;
import net.minecraft.util.math.MathHelper;

public class VillagerHatModel<T extends Entity> extends EntityModel<T> implements ModelWithHead, ModelWithHat {
	private Cuboid head;
	private Cuboid headOverlay;
	private Cuboid hat;

	public VillagerHatModel(float scale) {
		this(scale, 64, 64);
	}

	public VillagerHatModel(float scale, int u, int v) {
		this.head = (new Cuboid(this)).setTextureSize(u, v);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, scale);
		this.headOverlay = (new Cuboid(this)).setTextureSize(u, v);
		this.headOverlay.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headOverlay.setTextureOffset(32, 0).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, scale + 0.5F);
		this.head.addChild(this.headOverlay);
		this.hat = (new Cuboid(this)).setTextureSize(u, v);
		this.hat.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hat.setTextureOffset(30, 47).addBox(-8.0F, -8.0F, -6.0F, 16, 16, 1, scale);
		this.hat.pitch = -1.5707964F;
		this.headOverlay.addChild(this.hat);
	}

	@Override
	public void setHatVisible(boolean visible) {
		this.head.visible = visible;
		this.headOverlay.visible = visible;
		this.hat.visible = visible;
	}

	@Override
	public void render(T entity, float float_1, float float_2, float headRoll, float headYaw, float headPitch, float scale) {
		this.setAngles(entity, float_1, float_2, headRoll, headYaw, headPitch, scale);
		this.head.render(scale);
	}

	@Override
	public void setAngles(T entity, float float_1, float float_2, float headRoll, float headYaw, float headPitch, float scale)
	{
		boolean isRollingHead = false;
		if (entity instanceof AbstractTraderEntity)
		{
			isRollingHead = ((AbstractTraderEntity)entity).getHeadRollingTimeLeft() > 0;
		}

		if (entity instanceof ArmorStandEntity)
		{
			ArmorStandEntity stand = (ArmorStandEntity) entity;
			this.head.yaw = stand.getHeadRotation().getYaw() * 0.017453292F;
			this.head.pitch = stand.getHeadRotation().getPitch() * 0.017453292F;
			this.head.roll = stand.getHeadRotation().getRoll() * 0.017453292F;
		} else
			{
			this.head.yaw = headYaw * 0.017453292F;
			this.head.pitch = headPitch * 0.017453292F;
			if (isRollingHead)
			{
				this.head.roll = 0.3F * MathHelper.sin(0.45F * headRoll);
				this.head.pitch = 0.4F;
			} else
				{
				this.head.roll = 0.0F;
			}
		}


	}

	@Override
	public Cuboid getHead() {
		return head;
	}
}
