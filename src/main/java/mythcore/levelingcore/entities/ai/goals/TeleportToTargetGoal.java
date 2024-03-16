package mythcore.levelingcore.entities.ai.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

public class TeleportToTargetGoal extends Goal {
    private final PathAwareEntity mob;
    private final double minTeleportDistance;
    private int cooldown;

    public TeleportToTargetGoal(PathAwareEntity mob, double minTeleportDistance) {
        this.mob = mob;
        this.minTeleportDistance = minTeleportDistance;
        this.setControls(EnumSet.of(Control.MOVE));
        this.cooldown = 0;
    }

    @Override
    public boolean canStart() {
        if (this.cooldown > 0) {
            --this.cooldown;
            return false;
        }

        if (this.mob.getTarget() == null || !(this.mob.getTarget() instanceof PlayerEntity)) {
            return false;
        }

        double distanceToTarget = this.mob.squaredDistanceTo(this.mob.getTarget().getX(), this.mob.getTarget().getY(), this.mob.getTarget().getZ());
        return distanceToTarget > minTeleportDistance;
    }

    @Override
    public void start() {
        Vec3d targetPos = this.mob.getTarget().getPos();
        // Implement teleport logic here
        // Example:
        this.mob.teleport(targetPos.x, targetPos.y, targetPos.z);

        this.cooldown = 100; // Cooldown period in ticks before this goal can be triggered again
    }
}
