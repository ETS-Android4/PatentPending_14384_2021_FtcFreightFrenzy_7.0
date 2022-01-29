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
    public int direction = 0;

    // init, get motor reference and measurements
    public SharedDeposit(Telemetry tele, DcMotorWrap intake, DcMotorWrap hinge) {
        this.tele = tele;
        this.intake = intake;
        this.hinge = hinge;
    }

    // run hinge motor at constant speed and intake in current direction
    public void run(double hingeSpeed) {
        tele.addData("intake direction", direction);
        intake.run(direction);
        hinge.run(hingeSpeed);
    }

    // cycle through direction for intake
    public void incrementDirection(int amount) {
        direction += amount;
        if (Math.abs(direction) > 1) {
            direction = -(int)Math.signum(direction);
        }
    }
}
