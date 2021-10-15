package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.botconfigs.QuadOmni;

@Autonomous(name="WarehouseParkCarouselBlue", group="FreightFrenzy")
public class WarehouseParkCarouselBlue extends LinearOpMode {

    // robot reference
    public QuadOmni bot;

    // time to wait between movements
    public long waitTime = 500;

    // which alliance the robot is on
    public boolean isBlue = true;

    // run the autonomous
    @Override
    public void runOpMode() {

        // initialize robot
        bot = new QuadOmni(this, telemetry, hardwareMap);
        bot.driveTrain.gyroCompOn = false;

        // wait for press play
        waitForStart();

        // move left/forward 0.25 feet (3 inches)
        bot.driveTrain.moveEncoders(isBlue ? -3 : 0, isBlue ? 0 : 3, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        // move forward/left 1.333 feet (16 inches)
        bot.driveTrain.moveEncoders(isBlue ? 0 : -16, isBlue ? 16 : 0, 0, 0.2);
        sleep(waitTime);

        // turn to touch carousel
        bot.driveTrain.normalizeGyro(0.125 * (isBlue ? 1 : -1), 0.2);
        sleep(waitTime);

        // spin carousel to drop duck
        bot.carouselWheel.spinDuck(isBlue ? 1 : -1);
        sleep(waitTime);

        // turn away from carousel
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        // move backward/right 5.5 feet (66 inches)
        bot.driveTrain.moveEncoders(isBlue ? 0 : 66, isBlue ? -66 : 0, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        // turn so thin side is facing gap
        if (!isBlue) {
            bot.driveTrain.moveEncoders(0, 0, -0.25, 0.2);
            sleep(waitTime);
            bot.driveTrain.normalizeGyro(-0.25, 0.2);
            sleep(waitTime);
        }

        // move backward and towards wall 1 feet (12 inches)
        bot.driveTrain.moveEncoders(12, -12, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        // move backward and towards wall 3 feet (36 inches)
        bot.driveTrain.moveEncoders(0, -36, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(0, 0.2);
    }
}
