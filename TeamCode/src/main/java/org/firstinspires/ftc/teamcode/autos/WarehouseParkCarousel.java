package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.botconfigs.QuadOmni;

@Autonomous(name="WarehouseParkCarousel", group="FreightFrenzy")
public class WarehouseParkCarousel extends LinearOpMode {

    // robot reference
    public QuadOmni bot;

    // time to wait between movements
    public long waitTime = 500;

    // run the autonomous
    @Override
    public void runOpMode() {

        // initialize robot
        bot = new QuadOmni(this, telemetry, hardwareMap);

        // wait for press play
        waitForStart();

        // move left 0.25 feet (3 inches)
        bot.driveTrain.moveEncoders(-3, 0, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        // move forward 1.333 feet (16 inches)
        bot.driveTrain.moveEncoders(0, 16, 0, 0.2);
        sleep(waitTime);

        // turn to touch carousel
        bot.driveTrain.normalizeGyro(0.125, 0.2);
        sleep(waitTime);

        // spin carousel to drop duck
        bot.carouselWheel.spinDuck(1);
        sleep(waitTime);

        // turn away from carousel
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

        // move backward 5.5 feet (66 inches)
        bot.driveTrain.moveEncoders(0, -66, 0, 0.2);
        sleep(waitTime);
        bot.driveTrain.normalizeGyro(0, 0.2);
        sleep(waitTime);

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
