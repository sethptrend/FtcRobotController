package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="NerdyNawhalCode2")
public class Slurpydurpy extends LinearOpMode {

    //Drive motors
    public DcMotor BRmotor;
    public DcMotor BLmotor;
    public DcMotor FRmotor;
    public DcMotor FLmotor;

    public Servo droneLauncher;

    @Override
    public void runOpMode() {
        //define all the motors & setup the bot
        BRmotor = hardwareMap.get(DcMotor.class,"BRmotor");
        BLmotor = hardwareMap.get(DcMotor.class,"BLmotor");
        FRmotor = hardwareMap.get(DcMotor.class,"FRmotor");
        FLmotor = hardwareMap.get(DcMotor.class,"FLmotor");
        droneLauncher = hardwareMap.get(Servo.class, "droneLauncher");

        BRmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        BLmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FRmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FLmotor.setDirection(DcMotorSimple.Direction.REVERSE);

        BRmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        BRmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BLmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FLmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        droneLauncher.setPosition(0);

        waitForStart();

        while (opModeIsActive()){
            //Drive the robot

            while(gamepad1.a){
                droneLauncher.setPosition(1);
            }
            while(gamepad1.b){
                droneLauncher.setPosition(-1);
            }
            droneLauncher.setPosition(0);

            drive(gamepad1.left_stick_y);
            drive(gamepad1.left_stick_x);


        }
    }

    public void drive(double power){
        FRmotor.setPower(power);
        FLmotor.setPower(power);
        BRmotor.setPower(power);
        BLmotor.setPower(power);
    }
}