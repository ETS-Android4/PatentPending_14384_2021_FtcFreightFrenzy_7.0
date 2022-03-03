package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="NewWarehouseParkCornerRed", group="FreightFrenzy")
public class NewWarehouseParkCornerRed extends NewWarehouseParkCornerBlue {

    // override warehouse park blue, but set side to red before running opMode
    @Override
    public void runOpMode() {
        isBlue = false;
        super.runOpMode();
    }
}
