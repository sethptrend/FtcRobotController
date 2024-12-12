package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="controller")
public class Cntrolsfordemorobot_20240924 extends LinearOpMode {

    //Drive motors
    public DcMotor FRSD0;
    public DcMotor BRSD1;
    public DcMotor FLSD2;
    //public DcMotor BLSD3;

    public Servo ArmSV;
    public Servo ClawSV;
    public DcMotor Hellavator;


    public double CLnum;
    public double AMnum;

    /*public double Brazil;
    public double Korea;
    public double StepSize = 0.001;
    public double Brazil_Max = 1;
    public double Brazil_Min = 0;
    public double Korea_Max = 1;
    public double Korea_Min = 0;*/
    //Brazil is the randomServo position
    //Korea is the Sunghoontheservo position
    //stepsize = how far we move servo
    //Lasya, Google, and JOEY came up with the names
    @Override
    public void runOpMode() {
        //define all the motors & setup the bot
        FRSD0 = hardwareMap.get(DcMotor.class,"FRSD0");
       BRSD1 = hardwareMap.get(DcMotor.class,"BRSD1");
      FLSD2 = hardwareMap.get(DcMotor.class,"FLSD2");
        Hellavator = hardwareMap.get(DcMotor.class,"BLSD3");
        ArmSV = hardwareMap.get(Servo.class, "ArmSV");
        ClawSV = hardwareMap.get(Servo.class, "ClawSV");

        FRSD0.setDirection(DcMotorSimple.Direction.FORWARD);
      BRSD1.setDirection(DcMotorSimple.Direction.REVERSE);
      FLSD2.setDirection(DcMotorSimple.Direction.REVERSE);
      //BLSD3.setDirection(DcMotorSimple.Direction.REVERSE);

        FRSD0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      BRSD1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      FLSD2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      //BLSD3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FRSD0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      BRSD1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
     FLSD2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      //BLSD3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        ArmSV.setPosition(0);
        ClawSV.setPosition(0);

        waitForStart();

        while (opModeIsActive()){
            //Drive the robot

            if (gamepad1.right_stick_x>gamepad1.left_stick_y) {
                FLSD2.setPower(gamepad1.right_stick_x);
                //BLSD3.setPower(gamepad1.right_stick_x);
                FRSD0.setPower(-gamepad1.right_stick_x);
                BRSD1.setPower(-gamepad1.right_stick_x);
            }
            else {
                FRSD0.setPower(-gamepad1.right_stick_y);
                BRSD1.setPower(-gamepad1.right_stick_y);
                FLSD2.setPower(-gamepad1.right_stick_y);
                //BLSD3.setPower(-gamepad1.right_stick_y);
            }

            //arm and claw stuff

            //arm
            if (gamepad1.dpad_left^gamepad1.dpad_right){
                if (gamepad1.dpad_left){
                    if (AMnum!=0){
                        AMnum=AMnum+0.125;
                    }
                } else if (AMnum!=1) {
                    AMnum=AMnum-0.125;
                }
                ArmSV.setPosition(AMnum);


            }

            //claw
            if (gamepad1.dpad_left^gamepad1.dpad_right){
                if (gamepad1.dpad_left){
                    if (CLnum!=0){
                        CLnum=CLnum+0.25;
                    }
                } else if (CLnum!=1) {
                    CLnum=CLnum-0.25;
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

            /*if(gamepad1.a){
                Brazil+=StepSize;
                if(Brazil > Brazil_Max){Brazil=Brazil_Max;}
            }else if(gamepad1.b){
                Brazil-=StepSize;
                if(Brazil < Brazil_Min){Brazil=Brazil_Min;}
            }
            randomServo.setPosition(Brazil);
            if(gamepad1.x){
                Korea+=StepSize;
                if(Korea > Korea_Max){Korea=Korea_Max;}
            }else if(gamepad1.y){
                Korea-=StepSize;
                if(Korea < Korea_Min){Korea=Korea_Min;}
            }
            Sunghoontheservo.setPosition(Korea);
            //drive(gamepad1.left_stick_y);
            FRSD0.setPower(gamepad1.left_stick_y);
            BRSD1.setPower(gamepad1.right_stick_y);
            if(gamepad1.dpad_up){
                FLSD2.setPower(1);
            } else if(gamepad1.dpad_down){
                FLSD2.setPower(-1);
            } else { FLSD2.setPower(0);}*/
            telemetry.addData("Arm", ArmSV.getPosition());
            telemetry.addData("Claw", ClawSV.getPosition());
            telemetry.addData("ArmElevation", Hellavator.getCurrentPosition());
            telemetry.addData("ArmElevationPower", Hellavator.getPower());
            telemetry.addData("FR0.", FRSD0.getPower());
            telemetry.addData("BR1.", BRSD1.getPower());
            telemetry.addData("FL2.", FLSD2.getPower());
            //telemetry.addData("BL3.", BLSD3.getPower());
            telemetry.update();
        }

    }

    public void drive(double power){
        FRSD0.setPower(power);
        BRSD1.setPower(power);
       FLSD2.setPower(power);
        //BLSD3.setPower(power);

    }

}

//
