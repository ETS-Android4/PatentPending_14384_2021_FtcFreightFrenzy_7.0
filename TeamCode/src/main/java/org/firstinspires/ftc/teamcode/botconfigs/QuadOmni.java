package org.firstinspires.ftc.teamcode.botconfigs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardwaresystems.CarouselWheel;
import org.firstinspires.ftc.teamcode.hardwaresystems.GyroOrientDriveTrain;
import org.firstinspires.ftc.teamcode.hardwaresystems.MechDriveTrain;
import org.firstinspires.ftc.teamcode.hardwaresystems.SharedDeposit;
import org.firstinspires.ftc.teamcode.hardwarewrap.DcMotorWrap;
import org.firstinspires.ftc.teamcode.hardwarewrap.GyroWrap;

public class QuadOmni {

    // telemetry device for debugging
    public Telemetry tele;

    // drive train properties
    public GyroOrientDriveTrain driveTrain;
    public String[] driveTrainNames = {"rf", "rb", "lf", "lb"};
    public String gyroName = "gyro";
    public double driveLinearSpeed = 1;
    public double driveTurnSpeed = 1;

    // carousel wheel properties
    public CarouselWheel carouselWheel;
    public String carouselWheelName = "carousel";
    public double carouselWheelSpeed = 1;

    // shared deposit properties
    public SharedDeposit sharedDeposit;
    public String intakeName = "intake";
    public String hingeName = "hinge";
    public double intakeSpeed = -0.3;
    public double hingeSpeed = 0.5;

    // init, get drive train
    public QuadOmni(LinearOpMode op, Telemetry tele, HardwareMap map) {

        // telemetry debugging
        this.tele = tele;

        // initialize four motors for drive train
        DcMotorWrap[] motors = new DcMotorWrap[4];
        for (int i = 0; i < motors.length; i++) {motors[i] = new DcMotorWrap(tele, map, driveTrainNames[i], 3.5, Math.sqrt(2), 1, 420);}
        // initialize drive train
        MechDriveTrain mechTrain = new MechDriveTrain(tele, motors, driveLinearSpeed, driveTurnSpeed, 15.5, 1 / Math.sqrt(2));
        // initialize gyro sensor
        GyroWrap gyro = new GyroWrap(op, tele, map, gyroName, 0, true);
        // initialize gyro oriented drive train, using old drive train and gyro sensor
        driveTrain = new GyroOrientDriveTrain(mechTrain, gyro);


        // initialize motor for carousel wheel
        DcMotorWrap carouselMotor = new DcMotorWrap(tele, map, carouselWheelName, 4.25, 1, carouselWheelSpeed, 288);
        // initialize carousel wheel
        carouselWheel = new CarouselWheel(tele, carouselMotor, 15, 1.2);


        // initialize intake motor for depositing device
        DcMotorWrap intake = new DcMotorWrap(tele, map, intakeName, 1 / Math.PI, 2.778, intakeSpeed, 288);
        // initialize hinge motor for depositing device
        DcMotorWrap hinge = new DcMotorWrap(tele, map, hingeName, 1 / Math.PI, 0.625, hingeSpeed, 3500);
        // initialize depositing device
        sharedDeposit = new SharedDeposit(tele, intake, hinge);
    }
}
