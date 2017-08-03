package org.whs542.ftc;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;
import org.firstinspires.ftc.teamcode.R;
import org.whs542.ftc.lib.Toggler;
import org.whs542.ftc.subsys.Arm;
import org.whs542.ftc.subsys.Drivetrain;

/**
 * Created by Amar2 on 8/1/2017.
 */
@TeleOp(name = "DemoOp", group = "demo")
public class WHSTeleOp extends OpMode {

    Drivetrain drivetrain;
    Arm arm;
    TouchSensor touchSensor;

    static final double SLOWDOWN_MULTIPLIER = 0.33;

    //Toggler musicTog = new Toggler(2);
    //MediaPlayer mediaPlayer = MediaPlayer.create(FtcRobotControllerActivity, R.raw.sound_file_1);

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap);
        arm = new Arm(hardwareMap);
        touchSensor = hardwareMap.touchSensor.get("touch");
    }

    @Override
    public void loop() {

        drivetrain.setOrientation(gamepad1.a);
        if(gamepad1.left_bumper){
            drivetrain.setRLPowerWithOrientation(SLOWDOWN_MULTIPLIER*gamepad1.left_stick_y, SLOWDOWN_MULTIPLIER*gamepad1.right_stick_y);
        }
        else {
            drivetrain.setRLPowerWithOrientation(gamepad1.left_stick_y, gamepad1.right_stick_y);
        }

        arm.move(gamepad1.right_bumper, gamepad1.right_trigger);

        /*
        if(touchSensor.isPressed()){
            drivetrain.setRLPowerWithOrientation(0.3, 0.3);
        }
        else{
            drivetrain.setRLPowerWithOrientation(0.0, 0.0);
        }
        */

        //telemetry.addData("Music State (b): ", musicTog.currentState() == 1 ? "On" : "Off");
        telemetry.addData("Orientation Switched? (a): ", drivetrain.getOrientationState());



    }
}
