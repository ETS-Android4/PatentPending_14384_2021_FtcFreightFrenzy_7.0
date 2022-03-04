package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.botconfigs.MechRamp;

@Autonomous(name="NewStorageUnitParkBlue", group="FreightFrenzy")
public class NewStorageUnitParkBlue extends LinearOpMode {

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

        // move forward 2.25 feet (27 inches)
        bot.driveTrain.moveEncoders(isBlue ? 0 : 27, isBlue ? -27 : 0, 0, 0.2);
        bot.driveTrain.normalizeGyro(0, 0.2);

        // move sideways 2 feet (24 inches) into storage unit
        bot.driveTrain.moveEncoders(isBlue ? -24 : 0, isBlue ? 0 : 24, 0, 0.2);
        bot.driveTrain.normalizeGyro(0, 0.2);
    }
}
