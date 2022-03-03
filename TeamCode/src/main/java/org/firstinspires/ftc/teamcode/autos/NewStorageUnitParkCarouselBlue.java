package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.botconfigs.MechRamp;

@Autonomous(name="NewStorageUnitParkCarouselBlue", group="FreightFrenzy")
public class NewStorageUnitParkCarouselBlue extends LinearOpMode {

    // robot reference
    public MechRamp bot;

    // time to wait between movements
    public long waitTime = 500;

    // which alliance the robot is on
    public boolean isBlue = true;

    @Override
    public void runOpMode() {

        // initialize robot
        bot = new MechRamp(this, telemetry, hardwareMap);
        bot.driveTrain.gyroCompOn = false;

        // wait for press play
        waitForStart();

        // move left/forward 0.25 feet (6 inches)
        bot.driveTrain.moveEncoders(isBlue ? -6 : 0, isBlue ? 0 : 6, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        // move forward/left 1.333 feet (16 inches)
        bot.driveTrain.moveEncoders(isBlue ? 0 : -16, isBlue ? 16 : 0, 0, 0.2);
        sleep(waitTime);

        // turn to touch carousel
        bot.driveTrain.normalizeGyro(0.2 * (isBlue ? 1 : -1), 0.2);
        sleep(waitTime);

        // spin carousel to drop duck
        bot.carouselWheel.spinDuck(isBlue ? 1 : -1);
        sleep(waitTime);

        // turn away from carousel
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        // move left/forward 2 feet + 1 inch (25 inches)
        bot.driveTrain.moveEncoders(isBlue ? -25 : 0, isBlue ? 0 : 25, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        if (!isBlue) {
            bot.driveTrain.moveEncoders(0, 0, -0.25, 0.2);
            sleep(waitTime);
            bot.driveTrain.normalizeGyro(-0.25, 0.2);
            sleep(waitTime);
        }

        // move forward 0.666 feet (8 inches)
        bot.driveTrain.moveEncoders(0, 8, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(isBlue ? 0 : -0.25, 0.2);
        sleep(waitTime);
    }
}
