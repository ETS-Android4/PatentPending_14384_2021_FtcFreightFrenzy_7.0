package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="NewWarehouseParkCarouselDelayedRed", group="FreightFrenzy")
public class NewWarehouseParkCarouselDelayedRed extends NewWarehouseParkCarouselDelayedBlue {

    // override warehouse park blue, but set side to red before running opMode
    @Override
    public void runOpMode() {
        isBlue = false;
        super.runOpMode();
    }
}
