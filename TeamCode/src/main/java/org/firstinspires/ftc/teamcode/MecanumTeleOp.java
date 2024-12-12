package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.opencv.core.Mat;
@TeleOp(name = "MecanumTeleOp2024-25")
public class MecanumTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor FLmotor;
        DcMotor BLmotor;
        DcMotor FRmotor;
        DcMotor BRmotor;
        Servo ArmServo;
        Servo ClawServo;

        FLmotor = hardwareMap.get(DcMotor.class, "FLmotor");
        BLmotor = hardwareMap.get(DcMotor.class, "BLmotor");
        FRmotor = hardwareMap.get(DcMotor.class, "FRmotor");
        BRmotor = hardwareMap.get(DcMotor.class, "BRmotor");
        ArmServo = hardwareMap.get(Servo.class, "ArmServo");
        ClawServo = hardwareMap.get(Servo.class, "ClawServo");
// biys 1 robit
//       // FLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
//       // BLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        FRmotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        BRmotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // girls 1 robit g3bk
        //FLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //FRmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BRmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        if(isStopRequested()) return;

        waitForStart();

        while(opModeIsActive()){
            double y = gamepad1.left_stick_y; //Remove negative next time
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;
            double denominator = Math.max((Math.abs(y)+Math.abs(x)+ Math.abs(rx)), 1.0);

            double FLpower = (y+x+rx)/denominator;
            double BLpower = (y-x+rx)/denominator;
            double FRpower = (y-x-rx)/denominator;
            double BRpower = (y+x-rx)/denominator;

            FLmotor.setPower(FLpower);
            BLmotor.setPower(BLpower);
            FRmotor.setPower(FRpower);
            BRmotor.setPower(BRpower);

            telemetry.addData("FL", FLmotor.getPower());
            telemetry.addData("FR", FRmotor.getPower());
            telemetry.addData("BL", BLmotor.getPower());
            telemetry.addData("BR", BRmotor.getPower());
            telemetry.addData("y", gamepad1.left_stick_y);
            telemetry.addData("x", gamepad1.left_stick_x);
            telemetry.addData("rx", gamepad1.right_stick_x);
            telemetry.update();

            if(gamepad1.x){
                ArmServo.setPosition(0.6);
            }
            if(gamepad1.y){
                ClawServo.setPosition(0.5);
            }

        }
    }
}