package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="WarehouseParkRed", group="FreightFrenzy")
public class WarehouseParkRed extends WarehouseParkBlue {

    // override warehouse park blue, but set side to red before running opMode
    @Override
    public void runOpMode() {
        isBlue = false;
        super.runOpMode();
    }
}
