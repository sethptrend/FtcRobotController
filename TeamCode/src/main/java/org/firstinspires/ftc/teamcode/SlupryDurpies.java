package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="NerdyNarwhalsCodeStep")
public class SlupryDurpies extends LinearOpMode {

    //Drive motors
    public DcMotor frontyrightyslurpydurpy1;
    public DcMotor backyrightyslurpydurpy2;
    public DcMotor frontyleftyslurpydurpy3;
    public DcMotor backyleftyslurpydurpy4;

    public Servo randomServo;

    public Servo Sunghoontheservo;

    public double Brazil;
    public double Korea;
    public double StepSize = 0.001;
    public double Brazil_Max = 1;
    public double Brazil_Min = 0;
    public double Korea_Max = .2;
    public double Korea_Min = 0;
    //Brazil is the randomServo position
    //Korea is the Sunghoontheservo position
    //stepsize = how far we move servo
    //Lasya, Google, and JOEY came up with the names
    @Override
    public void runOpMode() {
        //define all the motors & setup the bot
        frontyrightyslurpydurpy1 = hardwareMap.get(DcMotor.class,"frontyrightyslurpydurpy1");
        backyrightyslurpydurpy2 = hardwareMap.get(DcMotor.class,"backyrightyslurpydurpy2");
      frontyleftyslurpydurpy3 = hardwareMap.get(DcMotor.class,"frontyleftyslurpydurpy3");
      backyleftyslurpydurpy4 = hardwareMap.get(DcMotor.class,"backyrightyslurpydurpy4");
        randomServo = hardwareMap.get(Servo.class, "randomServo");
        Sunghoontheservo = hardwareMap.get(Servo.class, "Sunghoontheservo");

        frontyrightyslurpydurpy1.setDirection(DcMotorSimple.Direction.FORWARD);
      backyrightyslurpydurpy2.setDirection(DcMotorSimple.Direction.FORWARD);
      frontyleftyslurpydurpy3.setDirection(DcMotorSimple.Direction.REVERSE);
      backyleftyslurpydurpy4.setDirection(DcMotorSimple.Direction.REVERSE);

        frontyrightyslurpydurpy1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      backyrightyslurpydurpy2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      frontyleftyslurpydurpy3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      backyleftyslurpydurpy4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontyrightyslurpydurpy1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      backyrightyslurpydurpy2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
     frontyleftyslurpydurpy3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      backyleftyslurpydurpy4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        randomServo.setPosition(0);
        Sunghoontheservo.setPosition(0);

        waitForStart();

        while (opModeIsActive()){
            //Drive the robot

            if(gamepad1.a){
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
            drive(gamepad1.left_stick_y);

            telemetry.addData("slurpydurpy", randomServo.getPosition() );
            telemetry.addData("sErVo", Sunghoontheservo.getPosition() );
            telemetry.addData("rotoMpow.", frontyrightyslurpydurpy1.getPower());
            telemetry.addData("rotoMpos.", frontyrightyslurpydurpy1.getCurrentPosition());
            telemetry.update();
        }

    }

    public void drive(double power){
        frontyrightyslurpydurpy1.setPower(power);
        frontyleftyslurpydurpy3.setPower(power);
       backyrightyslurpydurpy2.setPower(power);
        backyleftyslurpydurpy4.setPower(power);

    }

}

//
