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
    public double carouselWheelSpeed = 0.8;

    // shared deposit properties
    public SharedDeposit sharedDeposit;
    public String intakeName = "intake";
    public String hingeName = "hinge";
    public double intakeSpeed = 1;
    public double hingeSpeed = 1;

    // init, get drive train
    public QuadOmni(LinearOpMode op, Telemetry tele, HardwareMap map) {

        this.tele = tele;

        DcMotorWrap[] motors = new DcMotorWrap[4];
        for (int i = 0; i < motors.length; i++) {motors[i] = new DcMotorWrap(tele, map, driveTrainNames[i], 3.5, Math.sqrt(2), 1, 420);}
        MechDriveTrain mechTrain = new MechDriveTrain(tele, motors, driveLinearSpeed, driveTurnSpeed, 15.5, 1 / Math.sqrt(2));
        GyroWrap gyro = new GyroWrap(op, tele, map, gyroName, 0, true);
        driveTrain = new GyroOrientDriveTrain(mechTrain, gyro);

        DcMotorWrap carouselMotor = new DcMotorWrap(tele, map, carouselWheelName, 4.25, 1, carouselWheelSpeed, 288);
        carouselWheel = new CarouselWheel(tele, carouselMotor, 15, 1.5);

        DcMotorWrap intake = new DcMotorWrap(tele, map, intakeName, 1, 1, intakeSpeed, 288);
        DcMotorWrap hinge = new DcMotorWrap(tele, map, hingeName, 1, 1, hingeSpeed, 560);
        sharedDeposit = new SharedDeposit(tele, intake, hinge);
    }
}
