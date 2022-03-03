package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="NewStorageUnitParkCarouselDelayedRed", group="FreightFrenzy")
public class NewStorageUnitParkCarouselDelayedRed extends NewStorageUnitParkCarouselDelayedBlue {

    // override storage unit park blue, but set side to red before running opMode
    @Override
    public void runOpMode() {
        isBlue = false;
        super.runOpMode();
    }
}
