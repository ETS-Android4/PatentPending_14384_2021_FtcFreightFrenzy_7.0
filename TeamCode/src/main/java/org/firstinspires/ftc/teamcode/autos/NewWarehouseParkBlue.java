package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.botconfigs.MechRamp;

@Autonomous(name="NewWarehouseParkBlue", group="FreightFrenzy")
public class NewWarehouseParkBlue extends LinearOpMode {

    // robot reference
    public MechRamp bot;

    // which alliance the robot is on
    public boolean isBlue = true;

    // run the autonomous
    @Override
    public void runOpMode() {

        // initialize robot
        bot = new MechRamp(this, telemetry, hardwareMap);
        bot.driveTrain.gyroCompOn = false;

        // wait for press play
        waitForStart();

        // move backward 2 feet (24 inches)
        bot.driveTrain.moveEncoders(24 * (isBlue ? -1 : 1), 0, 0, 0.2);
        bot.driveTrain.normalizeGyro(0, 0.2);
    }
}
