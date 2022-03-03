package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="NewWarehouseParkCarouselRed", group="FreightFrenzy")
public class NewWarehouseParkCarouselRed extends NewWarehouseParkCarouselBlue {

    // override warehouse park blue, but set side to red before running opMode
    @Override
    public void runOpMode() {
        isBlue = false;
        super.runOpMode();
    }
}
