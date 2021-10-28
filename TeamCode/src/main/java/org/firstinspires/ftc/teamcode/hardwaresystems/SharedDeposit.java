package org.firstinspires.ftc.teamcode.hardwaresystems;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardwarewrap.DcMotorWrap;

public class SharedDeposit {

    // telemetry device for debugging
    public Telemetry tele;

    // reference to motors
    public DcMotorWrap intake;
    public DcMotorWrap hinge;

    // init, get motor reference and measurements
    public SharedDeposit(Telemetry tele, DcMotorWrap intake, DcMotorWrap hinge) {
        this.tele = tele;
        this.intake = intake;
        this.hinge = hinge;
    }
}
