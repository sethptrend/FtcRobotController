package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="NerdyNarwhalsCode")
public class SlupryDurpies extends LinearOpMode {

    //Drive motors
    public DcMotor frontyrightyslurpydurpy1;
    public DcMotor backyrightyslurpydurpy2;
    public DcMotor frontyleftyslurpydurpy3;
    public DcMotor backyrightyslurpydurpy4;

    @Override
    public void runOpMode() {
        //define all the motors & setup the bot
        frontyrightyslurpydurpy1 = hardwareMap.get(DcMotor.class,"frontyrightyslurpydurpy1");
        backyrightyslurpydurpy2 = hardwareMap.get(DcMotor.class,"backyrightyslurpydurpy2");
        frontyleftyslurpydurpy3 = hardwareMap.get(DcMotor.class,"frontyleftyslurpydurpy3");
        backyrightyslurpydurpy4 = hardwareMap.get(DcMotor.class,"backyrightyslurpydurpy4");

        frontyrightyslurpydurpy1.setDirection(DcMotorSimple.Direction.FORWARD);
        backyrightyslurpydurpy2.setDirection(DcMotorSimple.Direction.FORWARD);
        frontyleftyslurpydurpy3.setDirection(DcMotorSimple.Direction.REVERSE);
        backyrightyslurpydurpy4.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();


        while (opModeIsActive()){
            //Drive the robot
        }

    }
}
