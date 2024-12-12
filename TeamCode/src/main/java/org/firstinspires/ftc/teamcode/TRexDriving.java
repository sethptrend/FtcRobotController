package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TRex_Driving")
public class TRexDriving extends LinearOpMode{
//Wifi is WD92
    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor FLmotor;
        DcMotor BLmotor;
        DcMotor FRmotor;
        DcMotor BRmotor;
        DcMotor ATmotor;
        DcMotor LSmotor;
        Servo ClawServo;
        Servo Bucket;


        double FL;
        double BL;
        double FR;
        double BR;
        boolean Turbo=false;

        double Claw=0.5;
        double B=0.22;

        // 0
        FLmotor = hardwareMap.get(DcMotor.class, "FLmotor");
        // 1
        BLmotor = hardwareMap.get(DcMotor.class, "BLmotor");
        //2
        FRmotor = hardwareMap.get(DcMotor.class, "FRmotor");
        //3
        BRmotor = hardwareMap.get(DcMotor.class, "BRmotor");
        ATmotor = hardwareMap.get(DcMotor.class, "EH1");
        LSmotor = hardwareMap.get(DcMotor.class,"EH0");
        ClawServo = hardwareMap.get(Servo.class, "S-1");
        Bucket = hardwareMap.get(Servo.class, "S-0");

        //FLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FRmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BRmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //BLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        /*this is motor setup
        you will use ; to end lines unless otherwise stated
        this comment is a muli-line comment, there are also single line comments
         */
        //this is a single line comment

        /*BRmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //gives how far motor has turned*/

        if(isStopRequested()) return;

        while(!gamepad1.x)
        {
            if (gamepad1.b){
                Claw-=0.001;
                if (Claw <= 0.0) Claw = 0.0;
            } else if (gamepad1.a) {
                Claw+=0.001;
                if (Claw >= 1.0) Claw = 1.0;
            }
            ClawServo.setPosition(Claw);

            //Bucket code, flat with D up, tilt with D down

            if (gamepad1.dpad_up){
                B+=0.001;
                if (B >= 1.0) B = 1.0;
            } else if (gamepad1.dpad_down){
                B-=0.001;
                if (B<= 0.0) B = 0.0;
            }
            Bucket.setPosition(B);
            //B is the bucket servo variable.


            telemetry.addData("Press X before Start", ATmotor.getPower());
            telemetry.addData("Claw: A/B", ClawServo.getPosition());
            telemetry.addData("bucket: up/down", Bucket.getPosition());
            //creates data point to send

            telemetry.update();
        }
        telemetry.addData("Ready to start", ATmotor.getPower());
        telemetry.update();
        waitForStart();

        while(opModeIsActive()){

             //Turbo code

             if (gamepad1.y){
                Turbo=!Turbo;
             }

            FL=(-gamepad1.left_stick_y+gamepad1.left_stick_x+gamepad1.right_stick_x);
            BL=(-gamepad1.left_stick_y-gamepad1.left_stick_x+gamepad1.right_stick_x);
            FR=(-gamepad1.left_stick_y-gamepad1.left_stick_x-gamepad1.right_stick_x);
            BR=(-gamepad1.left_stick_y+gamepad1.left_stick_x-gamepad1.right_stick_x);
            if (FL>1){
            FL=1;
            } else if (FL<-1){
            FL=-1;
            }
            if (BL>1){
            BL=1;
            } else if (BL<-1){
            BL=-1;
            }
            if (FR>1){
            FR=1;
            } else if (FR<-1){
            FR=-1;
            }
            if (BR>1){
            BR=1;
            } else if (BR<-1){
            BR=-1;
            }
            if (Turbo){
                FLmotor.setPower(-FL);
                BLmotor.setPower(-BL);
                FRmotor.setPower(-FR);
                BRmotor.setPower(-BR);
            } else{
                FLmotor.setPower(-FL/2);
                BLmotor.setPower(-BL/2);
                FRmotor.setPower(-FR/2);
                BRmotor.setPower(-BR/2);
            }



            //mechana wheel 360 driving
            /*example if statement
            if (gamepad1.a==true) {
                FLmotor.setPower(.5);
            }
            else {
                FLmotor.setPower(0);
            }*/
            //always do curly brakets for if statements

            //arm code
            //use triggers to tilt arm forward (right) and back (left)
            if (gamepad1.right_trigger==1){
                ATmotor.setPower(.4);
            } else if (gamepad1.left_trigger==1) {
                ATmotor.setPower(-.4);
            } else {
                ATmotor.setPower(0);
            }

            //Linear Slide cod
            //Up=Lbumper down=Rbumper
            if (gamepad1.left_bumper){
                LSmotor.setPower(.4);
            } else if (gamepad1.right_bumper) {
                LSmotor.setPower(-.4);
            } else {
                LSmotor.setPower(0);
            }

            //claw code
            //close with b (right button) open with a (bottom button)

            if (gamepad1.b){
                Claw-=0.001;
                if (Claw <= 0.0) Claw = 0.0;
            } else if (gamepad1.a) {
                Claw+=0.001;
                if (Claw >= 1.0) Claw = 1.0;
            }
            ClawServo.setPosition(Claw);

            //Bucket code, flat with D up, tilt with D down

            if (gamepad1.dpad_up){
                B+=0.001;
                if (B >= 1.0) B = 1.0;
            } else if (gamepad1.dpad_down){
                B-=0.001;
                if (B<= 0.0) B = 0.0;
            }
            Bucket.setPosition(B);
            //B is the bucket servo variable.

            telemetry.addData("FL", FLmotor.getPower());
            telemetry.addData("FR", FRmotor.getPower());
            telemetry.addData("BL", BLmotor.getPower());
            telemetry.addData("BR", BRmotor.getPower());
            telemetry.addData("LinnearSlide", LSmotor.getPower());
            telemetry.addData("ArmTilt", ATmotor.getPower());
            telemetry.addData("Claw: A/B", ClawServo.getPosition());
            telemetry.addData("bucket: up/down", Bucket.getPosition());
            //creates data point to send

            telemetry.update();
            //sends data to driver station
        }

    }
}
