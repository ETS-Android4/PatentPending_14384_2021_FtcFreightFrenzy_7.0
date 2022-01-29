package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.GameController;
import org.firstinspires.ftc.teamcode.botconfigs.QuadOmni;
import org.firstinspires.ftc.teamcode.hardwarewrap.GyroWrap;
//hi
// quad omni drive train tele op for PushBot
@TeleOp(name="QuadOmniTele", group="FreightFrenzy")
public class QuadOmniTele extends OpMode {

    // robot reference
    public QuadOmni bot;

    // controller reference
    public GameController pad;

    // speed settings
    public double[] speedSettings = {1, 0.5, 0.25};
    public int currentSpeed = 0;
    public boolean willIntake = false;

    // init, get robot and controller
    @Override
    public void init() {
        bot = new QuadOmni(null, telemetry, hardwareMap);
        pad = new GameController(telemetry, new Gamepad[]{gamepad1, gamepad2});
    }

    // loop every frame
    @Override
    public void loop() {

        // update game controller input
        pad.update();

        // reorient gyro to current position upon A press
        if (pad.boolInputsThis[0][pad.buttonA]) {
            bot.driveTrain.gyro.startAngle = bot.driveTrain.gyro.getAngleRaw();
        }

        // toggle gyro compensate on B press
        if (pad.boolInputsThis[0][pad.buttonB]) {
            bot.driveTrain.gyroCompOn = !bot.driveTrain.gyroCompOn;
        }

        // increment speed selection on X press
        if (pad.boolInputsThis[0][pad.buttonX]) {
            currentSpeed++;

            // if selection is over limit, reset
            if (currentSpeed >= speedSettings.length){
                currentSpeed = 0;
            }
        }

        // begin spinning carousel wheel on bumper press
        if (pad.boolInputsThis[0][pad.bumperR]) {
            bot.carouselWheel.startSpinDuck(1);
        }
        if (pad.boolInputsThis[0][pad.bumperL]) {
            bot.carouselWheel.startSpinDuck(-1);
        }
        bot.carouselWheel.motor.loopMoveEncoders();

        // reverse intake direction on bumper press
        if (pad.boolInputsThis[1][pad.bumperR]) {

            bot.sharedDeposit.incrementDirection(willIntake ? 1 : -1);

            if (bot.sharedDeposit.direction != 0) {
                willIntake = bot.sharedDeposit.direction == -1;
            }
        }

        // get drive input from dpad and left stick
        double xInput = pad.doubleInputs[0][pad.stickLX] + (pad.boolInputs[0][pad.dpadL] ? -1 : 0) + (pad.boolInputs[0][pad.dpadR] ? 1 : 0);
        double yInput = pad.doubleInputs[0][pad.stickLY] + (pad.boolInputs[0][pad.dpadD] ? -1 : 0) + (pad.boolInputs[0][pad.dpadU] ? 1 : 0);

        // clamp input magnitude within unit circle
        double length = GyroWrap.vect2hype(xInput, yInput);
        if (length > 1) {
            xInput /= length;
            yInput /= length;
        }

        // set drive train power with controller x, y, and rotational input
        bot.driveTrain.run(
                xInput * speedSettings[currentSpeed],
                yInput * speedSettings[currentSpeed],
                pad.doubleInputs[0][pad.stickRX] * speedSettings[currentSpeed]);

        // set arm powers based on controller 2
        bot.sharedDeposit.run(pad.doubleInputs[1][pad.stickLY]);

        // give debug data
        telemetry.addData("gyro on", bot.driveTrain.gyroCompOn);

        // push telemetry debugging
        telemetry.update();
    }
}
