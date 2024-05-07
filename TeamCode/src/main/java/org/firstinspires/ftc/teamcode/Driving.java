//some files and things that we need so that we can code for motors and stuff
package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="DrivingProgram")
public class Driving extends LinearOpMode {

    //Define drive motors
    public DcMotor FRSD0;
    public DcMotor BRSD1;
    public DcMotor FLSD2;
    //Define arm and claw motor/servos
    public Servo ArmSV;
    public Servo ClawSV;
    public DcMotor Hellavator;


    public double CLnum;
    public double AMnum;

       @Override
    public void runOpMode() {
        //define all the motors & setup the bot
        FRSD0 = hardwareMap.get(DcMotor.class,"FRSD0");
       BRSD1 = hardwareMap.get(DcMotor.class,"BRSD1");
        FLSD2 = hardwareMap.get(DcMotor.class, "FLSD2");
        Hellavator = hardwareMap.get(DcMotor.class,"BLSD3");
        ArmSV = hardwareMap.get(Servo.class, "ArmSV");
        ClawSV = hardwareMap.get(Servo.class, "ClawSV");

        FRSD0.setDirection(DcMotorSimple.Direction.FORWARD);
      FLSD2.setDirection(DcMotorSimple.Direction.REVERSE);
      Hellavator.setDirection(DcMotorSimple.Direction.REVERSE);

        FRSD0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      FLSD2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      Hellavator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FRSD0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
     FLSD2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      Hellavator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Starting servo positions
        AMnum=0.825;
        CLnum=.5;
        ArmSV.setPosition(.825);
        ClawSV.setPosition(.3);
        //Run stuff
        waitForStart();

        while (opModeIsActive()){
            //Drive the robot

            if (abs(gamepad1.right_stick_x)>abs(gamepad1.right_stick_y)) {
                FLSD2.setPower(gamepad1.right_stick_x);
                FRSD0.setPower(-gamepad1.right_stick_x);
            }
            else {
                FRSD0.setPower(gamepad1.right_stick_y);
                FLSD2.setPower(gamepad1.right_stick_y);
            }

            //arm and claw stuff

            //arm
            if (gamepad1.dpad_up^gamepad1.dpad_down){
                if (gamepad1.dpad_down){
                    if (AMnum>0.825){
                        AMnum=AMnum-0.001;
                    }
                } else if (AMnum<=1) {
                    AMnum=AMnum+0.001;
                }
                ArmSV.setPosition(AMnum);


            }

            //claw
            if (gamepad1.dpad_left^gamepad1.dpad_right){
                if (gamepad1.dpad_left){
                    if (CLnum!=0.3){
                        CLnum=CLnum-0.001;
                    }
                } else if (CLnum!=.45) {
                    CLnum=CLnum+0.001;
                }
                ClawSV.setPosition(CLnum);

            }

            //ellavation
            if (gamepad1.y^gamepad1.a) {
                if (gamepad1.y) {
                    Hellavator.setPower(0.5);
                } else {
                    Hellavator.setPower(-0.5);
                }
            }
                else{
                    Hellavator.setPower(0);
            }
            //Telemetry, send messages to the driver
            telemetry.addData("Arm", ArmSV.getPosition());
            telemetry.addData("Claw", ClawSV.getPosition());
            telemetry.addData("ArmElevation", Hellavator.getCurrentPosition());
            telemetry.addData("ArmElevationPower", Hellavator.getPower());
            telemetry.addData("FR0.", FRSD0.getPower());
            telemetry.addData("FL2.", FLSD2.getPower());
            telemetry.addData("left position", FLSD2.getCurrentPosition());
            telemetry.addData("right position", FRSD0.getCurrentPosition());
            telemetry.update();
        }

    }
    //motor stuff
    public void drive(double power){
        FRSD0.setPower(power);
       FLSD2.setPower(power);
       Hellavator.setPower(power);

    }

}

//
