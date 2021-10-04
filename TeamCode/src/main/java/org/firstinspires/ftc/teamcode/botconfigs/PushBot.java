package org.firstinspires.ftc.teamcode.botconfigs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardwaresystems.GyroOrientDriveTrain;
import org.firstinspires.ftc.teamcode.hardwaresystems.MechDriveTrain;
import org.firstinspires.ftc.teamcode.hardwarewrap.DcMotorWrap;
import org.firstinspires.ftc.teamcode.hardwarewrap.GyroWrap;

// simple push bot with mechanum drive train
public class PushBot {

    // telemetry device for debugging
    public Telemetry tele;

    // drive train properties
    public GyroOrientDriveTrain driveTrain;
    public String[] driveTrainNames = {"rf", "rb", "lf", "lb"};
    public String gyroName = "gyro";
    public double driveLinearSpeed = 1;
    public double driveTurnSpeed = 1;

    // init, get drive train
    public PushBot(LinearOpMode op, Telemetry tele, HardwareMap map) {
        this.tele = tele;
        DcMotorWrap[] motors = new DcMotorWrap[4];
        for (int i = 0; i < motors.length; i++) {motors[i] = new DcMotorWrap(tele, map, driveTrainNames[i], 3, 1, 1, 1680);}
        MechDriveTrain mechTrain = new MechDriveTrain(tele, motors, driveLinearSpeed, driveTurnSpeed, 20, 1);
        GyroWrap gyro = new GyroWrap(op, tele, map, gyroName, 0, true);
        driveTrain = new GyroOrientDriveTrain(mechTrain, gyro);
    }
}
