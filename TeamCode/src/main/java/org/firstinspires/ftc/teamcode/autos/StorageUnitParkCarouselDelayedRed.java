package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="StorageUnitParkCarouselDelayedRed", group="FreightFrenzy")
public class StorageUnitParkCarouselDelayedRed extends StorageUnitParkCarouselDelayedBlue {

    // override storage unit park blue, but set side to red before running opMode
    @Override
    public void runOpMode() {
        isBlue = false;
        super.runOpMode();
    }
}
