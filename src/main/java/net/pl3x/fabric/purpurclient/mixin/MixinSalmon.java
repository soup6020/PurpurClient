package net.pl3x.fabric.purpurclient.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SalmonEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pl3x.fabric.purpurclient.entity.RidableEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SalmonEntity.class)
public abstract class MixinSalmon extends LivingEntity implements RidableEntity {
    private final Vec3d offset = new Vec3d(-0.1D, 0.5D, 0.0D);

    public MixinSalmon(EntityType<? extends SalmonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public double getMountedHeightOffset() {
        return (double) getHeight() * offset.y;
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        updatePassengerPosition(this, passenger, offset, bodyYaw);
    }
}
