package org.firstinspires.ftc.teamcode.hardwaresystems;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardwarewrap.DcMotorWrap;

public class IntakeRamp {

    // telemetry device for debugging
    public Telemetry tele;

    // reference to motors
    public DcMotorWrap intake;
    public DcMotorWrap deposit;

    // do intake motors move
    public boolean intakeOn = true;

    // init, get motor reference and measurements
    public IntakeRamp(Telemetry tele, DcMotorWrap intake, DcMotorWrap deposit) {
        this.tele = tele;
        this.intake = intake;
        this.deposit = deposit;
    }

    // run intake motor and deposit motor at constant speed
    public void run(boolean intakeGoes, boolean depositGoes) {
        intake.run(intakeOn ? (intakeGoes ? 1 : -1) : 0);
        deposit.run(depositGoes ? 1 : 0);
    }

    // turn intake motor on and off
    public void toggleOn() {
        intakeOn = !intakeOn;
    }
}
