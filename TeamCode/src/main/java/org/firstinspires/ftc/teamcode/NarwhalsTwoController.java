package org.firstinspires.ftc.teamcode;

import static java.lang.Double.max;
import static java.lang.Double.min;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Narwhals2People")
public class NarwhalsTwoController extends LinearOpMode{
    //g3bK
    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor FL0;
        DcMotor BL1;
        DcMotor FR2;
        DcMotor BR3;

        FL0 = hardwareMap.get(DcMotor.class, "FLmotor");
        BL1 = hardwareMap.get(DcMotor.class, "BLmotor");
        FR2 = hardwareMap.get(DcMotor.class, "FRmotor");
        BR3 = hardwareMap.get(DcMotor.class, "BRmotor");

        double FL;
        double BL;
        double FR;
        double BR;
        boolean Turbo=false;



        if(isStopRequested()) return;

        waitForStart();

        while(opModeIsActive()){

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
                FL0.setPower(-FL);
                BL1.setPower(-BL);
                FR2.setPower(-FR);
                BR3.setPower(-BR);
            } else{
                FL0.setPower(-FL/2);
                BL1.setPower(-BL/2);
                FR2.setPower(-FR/2);
                BR3.setPower(-BR/2);
            }
            /*
            FL0.setPower(FL*(1-gamepad1.right_trigger));
            BL1.setPower(BL*(1-gamepad1.right_trigger));
            FR2.setPower(FR*(1-gamepad1.right_trigger));
            BR3.setPower(BR*(1-gamepad1.right_trigger));
            */


        }
    }
}