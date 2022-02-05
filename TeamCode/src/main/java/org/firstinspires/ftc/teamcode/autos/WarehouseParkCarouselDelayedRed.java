package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="WarehouseParkCarouselDelayedRed", group="FreightFrenzy")
public class WarehouseParkCarouselDelayedRed extends WarehouseParkCarouselDelayedBlue {

    // override warehouse park blue, but set side to red before running opMode
    @Override
    public void runOpMode() {
        isBlue = false;
        super.runOpMode();
    }
}
