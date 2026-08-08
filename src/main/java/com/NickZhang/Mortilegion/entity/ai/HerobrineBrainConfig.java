package com.NickZhang.Mortilegion.entity.ai;

import com.NickZhang.Mortilegion.entity.Herobrine;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.player.Player;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.OneRandomBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableMeleeAttack;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.*;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.HurtBySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;

import java.util.List;

public class HerobrineBrainConfig
{
    public static List<ExtendedSensor<Herobrine>> sensors()
    {
        return ObjectArrayList.of(
                new HurtBySensor<>(),
                new NearbyLivingEntitySensor<>()
        );
    }

    public static BrainActivityGroup<Herobrine> coreTasks()
    {
        return BrainActivityGroup.coreTasks(
                new LookAtTarget<>(),
                new MoveToWalkTarget<>()
        );
    }

    public static BrainActivityGroup<Herobrine> idleTasks()
    {
        return BrainActivityGroup.idleTasks(
                new FirstApplicableBehaviour<>(
                        new SetPlayerLookTarget<>(),
                        new SetRandomLookTarget<>()
                ),
                new OneRandomBehaviour<>(
                        new SetRandomWalkTarget<>().setRadius(15),
                        new Idle<>()
                )
        );
    }


    public static BrainActivityGroup<Herobrine> fightTasks()
    {
        return BrainActivityGroup.fightTasks(
                new InvalidateAttackTarget(),
                new SetWalkTargetToAttackTarget<>(),
                new AnimatableMeleeAttack<>(20)
        );
    }
}
