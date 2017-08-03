package org.whs542.ftc.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.whs542.ftc.lib.Toggler;

/**
 * Created by Amar2 on 8/1/2017.
 */

public class Drivetrain {

    /*
    Windsor doubles up motor connections on the motor controller.
    Though the drivetrain has 4 physical motors,
    this is addressed in code as two motors
    (where each motor control port controls two physical motors).
    */
    DcMotor right;
    DcMotor left;

    Toggler orientationSwitch = new Toggler(2, 0);


    public Drivetrain(HardwareMap driveMap){

        right = driveMap.dcMotor.get("driveRight");
        left = driveMap.dcMotor.get("driveLeft");

        right.setDirection(DcMotorSimple.Direction.REVERSE);

    }


    public void setRightPower(double power){
        right.setPower(power);
    }

    public void setLeftPower(double power){
        left.setPower(power);
    }

    public void setRLPowerWithOrientation(double leftPower, double rightPower){
        switch(orientationSwitch.currentState())
        {
            case 0:
                setRightPower(rightPower);
                setLeftPower(leftPower);
                break;
            case 1:
                setRightPower(-rightPower);
                setLeftPower(-leftPower);
                break;
        }
    }

    public void setOrientation(boolean gamepadInput){
        orientationSwitch.changeState(gamepadInput);
    }

    public boolean getOrientationState(){
        if(orientationSwitch.currentState() == 0){
            return false;
        }
        else {
            return true;
        }
    }


}
