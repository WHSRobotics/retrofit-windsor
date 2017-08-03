package org.whs542.ftc.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Amar2 on 8/2/2017.
 */

public class Arm {

    DcMotor leftArm;
    DcMotor rightArm;

    public final double ARM_UP_POWER = 0.6;
    public final double ARM_DOWN_POWER = -0.1;

    public final double JOY_TRIGGER_THRESHOLD = 0.1;

    public Arm(HardwareMap armMap){
        leftArm = armMap.dcMotor.get("leftArm");
        rightArm = armMap.dcMotor.get("rightArm");

    }

    public void move(boolean armUp, float armDown){
        if(armUp){
            setArmPower(ARM_UP_POWER);
        }
        else if (armDown > JOY_TRIGGER_THRESHOLD){
            setArmPower(ARM_DOWN_POWER);
        }
        else {
            setArmPower(0.0);
        }
    }

    public void setArmPower(double armPower){
        leftArm.setPower(armPower);
        rightArm.setPower(armPower);
    }

}
