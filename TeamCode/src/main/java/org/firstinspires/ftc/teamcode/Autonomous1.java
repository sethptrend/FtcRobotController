package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="NetZoneBlueAuto")
public class Autonomous1 extends LinearOpMode {

    // Declare Devices
    DcMotor FLmotor;
    DcMotor FRmotor;
    DcMotor BLmotor;
    DcMotor BRmotor;
    DcMotor LSmotor;
    Servo ArmServo;
    Servo ClawServo;
//    DcMotor LSmotor;
//    Servo ArmServo;
//    Servo ClawServo;

    // drive motor position variables
    int lfPos, rfPos, lrPos, rrPos;

    // operational constants
    double clicksPerMM = 3.59002622034; // empirically measured
    double clicksPerDeg = 2.34966666667; // empirically measured - if it is innacurate, try 33.5666666667 or 22.22
//    double LSfullyExtendedTicks; //measure out on Monday



    @Override
    public void runOpMode() {
        telemetry.setAutoClear(true);

        // Initialize the hardware variables.
        FLmotor = hardwareMap.dcMotor.get("FLmotor");
        FRmotor = hardwareMap.dcMotor.get("FRmotor");
        BLmotor = hardwareMap.dcMotor.get("BLmotor");
        BRmotor = hardwareMap.dcMotor.get("BRmotor");
        LSmotor = hardwareMap.dcMotor.get("LSmotor");
        ArmServo = hardwareMap.get(Servo.class, "ArmServo");
        ClawServo = hardwareMap.get(Servo.class, "ClawServo");
//        LSmotor = hardwareMap.dcMotor.get("LSmotor");
//        ArmServo = hardwareMap.get(Servo.class, "ArmServo");
//        ClawServo = hardwareMap.get(Servo.class, "ClawServo");

        // The right motors need reversing
        FLmotor.setDirection(DcMotor.Direction.REVERSE);
        FRmotor.setDirection(DcMotor.Direction.REVERSE);

        // Set the drive motor run modes:
        FLmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        LSmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

//        LSmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if(isStopRequested()) return;
        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        //Distances in millimeters, angles in degrees, moveForward(), moveRight(), turnClockwise() <-- negative values move the opposite way

//        {WRITE STEPS HERE!!!)
//--------------------------------------------------------------------------------------------------------------------------


        ClawServo.setPosition(0.6);
//        moveForward(310, 0.6);
        moveForward(607, 0.5);
        turnClockwise(270, 0.5);
        score();

        /*
        moveRight(-, 0.7);
        turnClockwise(-, 0.7);
        score();
        turnClockwise(, 0.7); //angle value should be absolute value of previous turnClockwise() angle value
        rightDiagonal(, 0.7);
        pickUp();
        rightDiagonal(-, 0.7); //distance value should be opposite of previous rightDiagonal() distance value
        turnClockwise(-, 0.7);
        score();
        turnClockwise(, 0.7); //angle value should be absolute value of previous turnClockwise() angle value
        moveForward(, 0.7);
        pickUp();
        moveForward(-, 0.7); //distance value should be opposite of previous moveForward() distance value
        turnClockwise(-, 0.7);
        score();
        turnClockwise(, 0.7); //angle value should be absolute value of previous turnClockwise() angle value
        leftDiagonal(, 0.7);
        pickUp();
        leftDiagonal(-, 0.7); //distance value should be opposite of previous rightDiagonal() distance value
        turnClockwise(-, 0.7);
        score();
        turnClockwise(, 0.7); //angle value should be absolute value of previous turnClockwise() angle value
        moveRight(, 0.7); //observation zone parking
*/
    }

    public void moveForward(int howMuch, double speed) {


        // howMuch is in inches. A negative howMuch moves backward.


        // fetch motor positions
        lfPos = FLmotor.getCurrentPosition();
        rfPos = FRmotor.getCurrentPosition();
        lrPos = BLmotor.getCurrentPosition();
        rrPos = BRmotor.getCurrentPosition();


        // calculate new targets
        lfPos += howMuch * clicksPerMM;
        rfPos += howMuch * clicksPerMM;
        lrPos += howMuch * clicksPerMM;
        rrPos += howMuch * clicksPerMM;


        // move robot to new position
        FLmotor.setTargetPosition(lfPos);
        FRmotor.setTargetPosition(rfPos);
        BLmotor.setTargetPosition(lrPos);
        BRmotor.setTargetPosition(rrPos);
        FLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLmotor.setPower(speed);
        FRmotor.setPower(speed);
        BLmotor.setPower(speed);
        BRmotor.setPower(speed);


        // wait for move to complete
        while (FLmotor.isBusy() && FRmotor.isBusy() &&
                BLmotor.isBusy() && BRmotor.isBusy()) {


            // Display it for the driver.
            telemetry.addLine("Move Foward");
            telemetry.addData("Target", "%7d :%7d", lfPos, rfPos, lrPos, rrPos);
            telemetry.addData("Actual", "%7d :%7d", FLmotor.getCurrentPosition(),
                    FRmotor.getCurrentPosition(), BLmotor.getCurrentPosition(),
                    BRmotor.getCurrentPosition());
            telemetry.update();
        }


        // Stop all motion;
        FLmotor.setPower(0);
        FRmotor.setPower(0);
        BLmotor.setPower(0);
        BRmotor.setPower(0);
    }


    public void moveRight(int howMuch, double speed) {


        // howMuch is in inches. A negative howMuch moves left.


        // fetch motor positions
        lfPos = FLmotor.getCurrentPosition();
        rfPos = FRmotor.getCurrentPosition();
        lrPos = BLmotor.getCurrentPosition();
        rrPos = BRmotor.getCurrentPosition();


        // calculate new targets
        lfPos += howMuch * clicksPerMM;
        rfPos -= howMuch * clicksPerMM;
        lrPos -= howMuch * clicksPerMM;
        rrPos += howMuch * clicksPerMM;


        // move robot to new position
        FLmotor.setTargetPosition(lfPos);
        FRmotor.setTargetPosition(rfPos);
        BLmotor.setTargetPosition(lrPos);
        BRmotor.setTargetPosition(rrPos);
        FLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLmotor.setPower(speed);
        FRmotor.setPower(speed);
        BLmotor.setPower(speed);
        BRmotor.setPower(speed);


        // wait for move to complete
        while (FLmotor.isBusy() && FRmotor.isBusy() &&
                BLmotor.isBusy() && BRmotor.isBusy()) {


            // Display it for the driver.
            telemetry.addLine("Strafe Right");
            telemetry.addData("Target", "%7d :%7d", lfPos, rfPos, lrPos, rrPos);
            telemetry.addData("Actual", "%7d :%7d", FLmotor.getCurrentPosition(),
                    FRmotor.getCurrentPosition(), BLmotor.getCurrentPosition(),
                    BRmotor.getCurrentPosition());
            telemetry.update();
        }


        // Stop all motion;
        FLmotor.setPower(0);
        FRmotor.setPower(0);
        BLmotor.setPower(0);
        BRmotor.setPower(0);


    }


    public void turnClockwise(int whatAngle, double speed) {


        // whatAngle is in degrees. A negative whatAngle turns counterclockwise.
        //50 mm corresponds to 1 degree


        // fetch motor positions
        lfPos = FLmotor.getCurrentPosition();
        rfPos = FRmotor.getCurrentPosition();
        lrPos = BLmotor.getCurrentPosition();
        rrPos = BRmotor.getCurrentPosition();


        // calculate new targets
        lfPos += whatAngle * clicksPerDeg;
        rfPos -= whatAngle * clicksPerDeg;
        lrPos += whatAngle * clicksPerDeg;
        rrPos -= whatAngle * clicksPerDeg;


        // move robot to new position
        FLmotor.setTargetPosition(lfPos);
        FRmotor.setTargetPosition(rfPos);
        BLmotor.setTargetPosition(lrPos);
        BRmotor.setTargetPosition(rrPos);
        FLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLmotor.setPower(speed);
        FRmotor.setPower(speed);
        BLmotor.setPower(speed);
        BRmotor.setPower(speed);


        // wait for move to complete
        while (FLmotor.isBusy() && FRmotor.isBusy() &&
                BLmotor.isBusy() && BRmotor.isBusy()) {


            // Display it for the driver.
            telemetry.addLine("Turn Clockwise");
            telemetry.addData("Target", "%7d :%7d", lfPos, rfPos, lrPos, rrPos);
            telemetry.addData("Actual", "%7d :%7d", FLmotor.getCurrentPosition(),
                    FRmotor.getCurrentPosition(), BLmotor.getCurrentPosition(),
                    BRmotor.getCurrentPosition());
            telemetry.update();
        }


        // Stop all motion;
        FLmotor.setPower(0);
        FRmotor.setPower(0);
        BLmotor.setPower(0);
        BRmotor.setPower(0);
    }

    public void rightDiagonal(int howMuch, double speed){
        // howMuch is in millimeters. A negative howMuch moves down LEFT diagonal.

        // fetch motor positions
        lfPos = FLmotor.getCurrentPosition();
        // rfPos = FRmotor.getCurrentPosition();
        // lrPos = BLmotor.getCurrentPosition();
        rrPos = BRmotor.getCurrentPosition();

        // calculate new targets
        lfPos += howMuch * clicksPerDeg;
        rrPos += howMuch * clicksPerDeg;

        // move robot to new position
        FLmotor.setTargetPosition(lfPos);
        // FRmotor.setTargetPosition(rfPos);
        // BLmotor.setTargetPosition(lrPos);
        BRmotor.setTargetPosition(rrPos);
        FLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLmotor.setPower(speed);
        // FRmotor.setPower(speed);
        // BLmotor.setPower(speed);
        BRmotor.setPower(speed);

        // wait for move to complete
        while (FLmotor.isBusy() && BRmotor.isBusy()) {

            // Display it for the driver.
            telemetry.addLine("Move Right Diagonal");
            telemetry.addData("Target", "%7d :%7d", lfPos, rrPos);
            telemetry.addData("Actual", "%7d :%7d", FLmotor.getCurrentPosition(),BRmotor.getCurrentPosition());
            telemetry.update();
        }

        // Stop all motion;
        FLmotor.setPower(0);
        // FRmotor.setPower(0);
        // BLmotor.setPower(0);
        BRmotor.setPower(0);
    }

    public void leftDiagonal(int howMuch, double speed){
        // howMuch is in millimeters. A negative howMuch moves down RIGHT diagonal.

        // fetch motor positions
        // lfPos = FLmotor.getCurrentPosition();
        rfPos = FRmotor.getCurrentPosition();
        lrPos = BLmotor.getCurrentPosition();
        // rrPos = BRmotor.getCurrentPosition();

        // calculate new targets
        // lfPos += whatAngle * clicksPerDeg;
        rfPos += howMuch * clicksPerDeg;
        lrPos += howMuch * clicksPerDeg;
        // rrPos -= whatAngle * clicksPerDeg;

        // move robot to new position
        // FLmotor.setTargetPosition(lfPos);
        FRmotor.setTargetPosition(rfPos);
        BLmotor.setTargetPosition(lrPos);
        FLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // BRmotor.setTargetPosition(rrPos);
        // FLmotor.setPower(speed);
        FRmotor.setPower(speed);
        BLmotor.setPower(speed);
        // BRmotor.setPower(speed);

        // wait for move to complete
        while (FRmotor.isBusy() && BLmotor.isBusy()) {

            // Display it for the driver.
            telemetry.addLine("Move Left Diagonal");
            telemetry.addData("Target", "%7d :%7d", rfPos, lrPos);
            telemetry.addData("Actual", "%7d :%7d", FRmotor.getCurrentPosition(), BLmotor.getCurrentPosition());
            telemetry.update();
        }

        // Stop all motion;
        // FLmotor.setPower(0);
        FRmotor.setPower(0);
        BLmotor.setPower(0);
        // BRmotor.setPower(0);
    }

//    public void score(){
//
//        //raise slides
//        LSmotor.setTargetPosition(300); //edit
//        LSmotor.setPower(0.8);
//
//        while(LSmotor.isBusy()){
//            telemetry.addData("Position", LSmotor.getCurrentPosition());
//            telemetry.update();
//        }
//        LSmotor.setPower(0);
//        //score sample
//        ClawServo.setPosition(0.5);
//        sleep(1000);
//        //lowers slides
//        LSmotor.setTargetPosition(0);
//        LSmotor.setPower(0.8);
//
//        while(LSmotor.isBusy()){
//            telemetry.addData("Position", LSmotor.getCurrentPosition());
//            telemetry.update();
//        }
//        LSmotor.setPower(0);
//
//    }
//
//    public void pickUp(){
//        //lower arm
//        ArmServo.setPosition(0.5);
//        sleep(500);
//        //grip sample
//        ClawServo.setPosition(0);
//        sleep(1000);
//        //raise arm
//        ArmServo.setPosition(0);
//        sleep(500);
//    }

    public void score(){

        //raise slides
        LSmotor.setTargetPosition(300); //edit
        LSmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LSmotor.setPower(0.8);

        while(LSmotor.isBusy()){
            telemetry.addData("Position", LSmotor.getCurrentPosition());
            telemetry.update();
        }
        LSmotor.setPower(0);
        //score sample
        ClawServo.setPosition(0.5);
        sleep(1000);
        //lowers slides
        LSmotor.setTargetPosition(0);
        LSmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LSmotor.setPower(0.8);

        while(LSmotor.isBusy()){
            telemetry.addData("Position", LSmotor.getCurrentPosition());
            telemetry.update();
        }
        LSmotor.setPower(0);

    }

    public void pickUp(){
        //lower arm
        ArmServo.setPosition(0.6);
        sleep(500);
        //grip sample
        ClawServo.setPosition(0);
        sleep(1000);
        //raise arm
        ArmServo.setPosition(0);
        sleep(500);
    }
}
