package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class GamepadOpMode extends OpMode {

    @Override
    public void init(){

    }

    @Override
    public void loop(){
        telemetry.addData("Right stick x:", gamepad1.right_stick_x);
        telemetry.addData("Right stick y:", gamepad1.right_stick_y);
        telemetry.addData("B button: ", gamepad1.b);
        telemetry.addData("Difference: ", gamepad1.left_stick_y-gamepad1.right_stick_y);
        telemetry.addData("Sum: ", gamepad1.left_trigger+gamepad1.right_trigger);
        telemetry.update();

        if(gamepad1.left_stick_y<0){
            telemetry.addData("Left stick", "is negative");
            telemetry.update();
        }
        telemetry.addData("Left stick y", gamepad1.left_stick_y);

        if(!gamepad1.a){
            telemetry.addData("Forward Speed: ", gamepad1.left_stick_x*0.5);
        }else if(gamepad1.a){
            telemetry.addData("Forward Speed: ", gamepad1.left_stick_x*1);
        }

    }

}