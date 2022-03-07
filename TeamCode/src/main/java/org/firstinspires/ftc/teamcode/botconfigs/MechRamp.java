package org.firstinspires.ftc.teamcode.botconfigs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardwaresystems.CarouselWheel;
import org.firstinspires.ftc.teamcode.hardwaresystems.GyroOrientDriveTrain;
import org.firstinspires.ftc.teamcode.hardwaresystems.IntakeRamp;
import org.firstinspires.ftc.teamcode.hardwaresystems.MechDriveTrain;
import org.firstinspires.ftc.teamcode.hardwarewrap.DcMotorWrap;
import org.firstinspires.ftc.teamcode.hardwarewrap.GyroWrap;

public class MechRamp {

    // telemetry device for debugging
    public Telemetry tele;

    // drive train properties
    public GyroOrientDriveTrain driveTrain;
    public String[] driveTrainNames = {"lf", "rb", "rf", "lb"};
    public String gyroName = "gyro";
    public double driveLinearSpeed = 1;
    public double driveTurnSpeed = 1;

    // carousel wheel properties
    public CarouselWheel carouselWheel;
    public String carouselWheelName = "carousel";
    public double carouselWheelSpeed = -0.5;

    // intake ramp properties
    public IntakeRamp intakeRamp;
    public String intakeName = "intake";
    public String depositName = "deposit";
    public double intakeSpeed = 0.5;
    public double depositSpeed = -0.5;

    // init, get drive train
    public MechRamp(LinearOpMode op, Telemetry tele, HardwareMap map) {

        // telemetry debugging
        this.tele = tele;

        // initialize four motors for drive train
        DcMotorWrap[] motors = new DcMotorWrap[4];
        for (int i = 0; i < motors.length; i++) {motors[i] = new DcMotorWrap(tele, map, driveTrainNames[i], 3, 1, 1, 560);}
        // initialize drive train
        MechDriveTrain mechTrain = new MechDriveTrain(tele, motors, driveLinearSpeed, driveTurnSpeed, 15, 1);
        // initialize gyro sensor
        GyroWrap gyro = new GyroWrap(op, tele, map, gyroName, 0, true);
        // initialize gyro oriented drive train, using old drive train and gyro sensor
        driveTrain = new GyroOrientDriveTrain(mechTrain, gyro);


        // initialize motor for carousel wheel
        DcMotorWrap carouselMotor = new DcMotorWrap(tele, map, carouselWheelName, 4.25, 1, carouselWheelSpeed, 560);
        // initialize carousel wheel
        carouselWheel = new CarouselWheel(tele, carouselMotor, 15, 1.2);

        // initialize intake motor for ramp
        DcMotorWrap intakeMotor = new DcMotorWrap(tele, map, intakeName, 1, 1, intakeSpeed, 1792);
        // initialize deposit motor for ramp
        DcMotorWrap depositMotor = new DcMotorWrap(tele, map, depositName, 1, 1, depositSpeed, 288);
        // initialize intake ramp with intake and deposit motors
        intakeRamp = new IntakeRamp(tele, intakeMotor, depositMotor);
    }
}
