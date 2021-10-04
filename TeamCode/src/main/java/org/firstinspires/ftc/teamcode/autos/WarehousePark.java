package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.botconfigs.QuadOmni;

@Autonomous(name="WarehousePark", group="FreightFrenzy")
public class WarehousePark extends LinearOpMode {

    // robot reference
    public QuadOmni bot;

    // run the autonomous
    @Override
    public void runOpMode() {

        // initialize robot
        bot = new QuadOmni(this, telemetry, hardwareMap);

        // wait for press play
        waitForStart();

        // move forward 2 feet (24 inches)
        bot.driveTrain.moveEncoders(0, 24, 0, 0.2);
        bot.driveTrain.normalizeGyro(0, 0.2);

        sleep(2000);
    }
}
