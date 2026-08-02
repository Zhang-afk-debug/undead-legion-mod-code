package com.NickZhang.Mortilegion.entity.animations;

import com.NickZhang.Mortilegion.entity.Herobrine;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationProcessor.QueuedAnimation;

import java.util.Objects;
import java.util.Random;

public class HerobrineAnimationsManager{
    private static final RawAnimation idle_1 = RawAnimation.begin().thenPlay("idle_1");
    private static final RawAnimation idle_2 = RawAnimation.begin().thenPlay("idle_2");
    private static final RawAnimation idle_3 = RawAnimation.begin().thenPlay("idle_3");
    private static final RawAnimation idle_4 = RawAnimation.begin().thenPlay("idle_4");

    public static final Random random = new Random();

    public static long lastSwitchTime = 0;

    public static AnimationController<Herobrine> createIdleControl(Herobrine entity)
    {
        return new AnimationController<>(entity, "idle_control", 8, event ->
        {

                long currentTime = System.currentTimeMillis();
                if (currentTime - lastSwitchTime > (6000+ random.nextInt(9000)))
                {
                    lastSwitchTime = currentTime;
                    int randomNum = random.nextInt(4);
                    switch (randomNum)
                    {
                        case 0: return event.setAndContinue(idle_1);
                        case 1: return event.setAndContinue(idle_2);
                        case 2: return event.setAndContinue(idle_3);
                        case 3: return event.setAndContinue(idle_4);
                    }

            }
            RawAnimation current = event.getController().getCurrentRawAnimation();
            return event.setAndContinue(Objects.requireNonNullElse(current, idle_4));
        });
    }
}
