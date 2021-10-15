package org.firstinspires.ftc.teamcode.hardwaresystems;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardwarewrap.DcMotorWrap;

public class CarouselWheel {

    // telemetry device for debugging
    public Telemetry tele;

    // reference to motor
    public DcMotorWrap motor;

    // wheel rotate distance to drop a duck
    public double carouselDistance;

    // init, get motor reference and measurements
    public CarouselWheel(Telemetry tele, DcMotorWrap motor, double carouselDiameter, double carouselRotations) {
        this.tele = tele;
        this.motor = motor;
        carouselDistance = carouselRotations * carouselDiameter * Math.PI;
    }

    // drop a single duck
    public void spinDuck(double speed) {
        motor.moveEncoders(carouselDistance, speed);
    }
}
