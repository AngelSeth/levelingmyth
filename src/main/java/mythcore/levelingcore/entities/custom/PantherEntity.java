package mythcore.levelingcore.entities.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class PantherEntity extends HostileEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    public PantherEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private void updateAnimations() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
    }

    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.STANDING /*&& !this.dashingAnimationState.isRunning()*/) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient){
            updateAnimations();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        //this.goalSelector.add(1, new AvoidSunlightGoal(this));
        //this.goalSelector.add(2, new TeleportToTargetGoal(this));
        //this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0));
        //this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));
        //this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        //this.targetSelector.add(2, new PantherEntity.TargetGoal(this, PlayerEntity.class));
        //this.targetSelector.add(2, new RevengeGoal(this, new Class[0]));
        //this.targetSelector.add(3, new ActiveTargetGoal(this, EndermiteEntity.class, true, false));
        //this.targetSelector.add(4, new UniversalAngerGoal(this, true));
    }

    public static DefaultAttributeContainer.Builder createPantherAttribute(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 25)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, .1)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
    }

    private static class TargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {
        public TargetGoal(PantherEntity panther, Class<T> targetEntityClass) {
            super(panther, targetEntityClass, true);
        }

    }




    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE;
    }



}
