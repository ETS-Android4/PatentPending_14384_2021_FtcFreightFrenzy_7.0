package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

// game controller class, handles controller input
public class GameController {

    // telemetry device for debugging
    public Telemetry tele;

    // gamepad references
    public Gamepad[] pad;

    // double input indices
    public int stickLX = 0;
    public int stickLY = 1;
    public int stickRX = 2;
    public int stickRY = 3;

    // boolean input indices
    public int buttonA = 0;
    public int buttonB = 1;
    public int buttonX = 2;
    public int buttonY = 3;

    // double input data
    public double[][] doubleInputs = new double[2][4];

    // boolean input data
    public boolean[][] boolInputs = new boolean[2][4];
    public boolean[][] boolInputsLast = new boolean[2][4];
    public boolean[][] boolInputsThis = new boolean[2][4];

    // init, get controller references
    public GameController(Telemetry tele, Gamepad[] pad) {
        this.tele = tele;
        this.pad = pad;
    }

    // update input data
    public void update() {

        for (int i = 0; i < pad.length; i++) {

            // copy bool input values to bool inputs last
            for (int j = 0; j < boolInputs[i].length; j++) {
                boolInputsLast[i][j] = boolInputs[i][j];
            }

            // copy values from gamepad object to controller object
            doubleInputs[i][stickLX] = pad[i].left_stick_x;
            doubleInputs[i][stickLY] = -pad[i].left_stick_y;
            doubleInputs[i][stickRX] = pad[i].right_stick_x;
            doubleInputs[i][stickRY] = -pad[i].right_stick_y;
            boolInputs[i][buttonA] = pad[i].a;
            boolInputs[i][buttonB] = pad[i].b;
            boolInputs[i][buttonX] = pad[i].x;
            boolInputs[i][buttonY] = pad[i].y;

            // iterate through data, finding this-frame presses
            for (int j = 0; j < boolInputs[i].length; j++) {
                boolInputsThis[i][j] = boolInputs[i][j] && !boolInputsLast[i][j];
            }
        }
    }
}
