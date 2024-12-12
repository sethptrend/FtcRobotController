
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="position getter")

public class PositionGetter extends LinearOpMode{


    DcMotor FLmotor = hardwareMap.dcMotor.get("FLmotor");
    DcMotor FRmotor = hardwareMap.dcMotor.get("FRmotor");
    DcMotor BLmotor = hardwareMap.dcMotor.get("BLmotor");
    DcMotor BRmotor = hardwareMap.dcMotor.get("BRmotor");
    DcMotor LSmotor = hardwareMap.dcMotor.get("LSmotor");
    Servo ArmServo = hardwareMap.get(Servo.class, "ArmServo");
    Servo ClawServo = hardwareMap.get(Servo.class, "ClawServo");
    @Override
    public void runOpMode(){
        while (opModeIsActive())
        {
            FRmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FRmotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            telemetry.addData("front right position", FRmotor.getCurrentPosition());
            telemetry.update();
        }
    }
}
