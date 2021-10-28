package org.firstinspires.ftc.teamcode.hardwaresystems;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardwarewrap.DcMotorWrap;

public class SharedDeposit {

    // telemetry device for debugging
    public Telemetry tele;

    // reference to motors
    public DcMotorWrap intake;
    public DcMotorWrap hinge;

    // current direction of intake
    boolean in = true;
    boolean on = true;

    // init, get motor reference and measurements
    public SharedDeposit(Telemetry tele, DcMotorWrap intake, DcMotorWrap hinge) {
        this.tele = tele;
        this.intake = intake;
        this.hinge = hinge;
    }

    public void run(double hingeSpeed) {
        intake.run(on ? (in ? 1 : -1) : 0);
        hinge.run(hingeSpeed);
    }

    public void reverse() {
        in = !in;
    }

    public void toggleOn() {
        on = !on;
    }
}
