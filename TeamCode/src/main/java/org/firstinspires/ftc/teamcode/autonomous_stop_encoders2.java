package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "autonomous_stop_encoders2 (Blocks to Java)")
public class autonomous_stop_encoders2 extends LinearOpMode {

    private DcMotor motor13;
    private ColorSensor color;
    private ColorSensor color3_REV_ColorRangeSensor;
    private ColorSensor color2_REV_ColorRangeSensor;
    private DcMotor motor10;
    private DcMotor motor11;
    private DcMotor motor12;

    double FLmotor_0;
    double BLmotor_1;
    double BRmotor_3;
    double FRmotor_2;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        int Green2;
        ElapsedTime myElapsedTime;
        int Red1;
        int Blue1;
        int Green1;
        int Red2;
        int Blue2;
        int turn_direction;
        ElapsedTime time_used;
        int currentColor = 1;
        int CurrentMotor;

        motor13 = hardwareMap.get(DcMotor.class, "motor1-3");
        color = hardwareMap.get(ColorSensor.class, "color");
        color3_REV_ColorRangeSensor = hardwareMap.get(ColorSensor.class, "color3");
        color2_REV_ColorRangeSensor = hardwareMap.get(ColorSensor.class, "color2");
        motor10 = hardwareMap.get(DcMotor.class, "motor1-0");
        motor11 = hardwareMap.get(DcMotor.class, "motor1-1");
        motor12 = hardwareMap.get(DcMotor.class, "motor1-2");

        // Put initialization blocks here.
        motor13.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor13.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Red1 = 0;
        Blue1 = 0;
        Green1 = 0;
        Red2 = 0;
        Blue2 = 0;
        Green2 = 0;
        turn_direction = 1;
        while (Red1 == 0 || Red2 == 0) {
            if (gamepad1.dpad_up) {
                turn_direction = 0;
            }
            if (gamepad1.dpad_left) {
                turn_direction = 1;
            }
            if (gamepad1.dpad_right) {
                turn_direction = -1;
            }
            if (gamepad1.x) {
                Red1 = color.red();
                Blue1 = color.blue();
                Green1 = color.green();
            }
            if (gamepad1.y) {
                Red2 = color.red();
                Blue2 = color.blue();
                Green2 = color.green();
            }
            if (turn_direction != 0) {
                if (turn_direction < 0) {
                    telemetry.addLine("Right");
                } else {
                    telemetry.addLine("Left");
                }
            } else {
                telemetry.addLine("DontTurn");
            }
            telemetry.addData("red_current", color.red());
            telemetry.addData("blue_current", color.blue());
            telemetry.addData("green_current", color.green());
            telemetry.addData("red1", Red1);
            telemetry.addData("blue1", Blue1);
            telemetry.addData("green1", Green1);
            telemetry.addData("red2", Red2);
            telemetry.addData("blue2", Blue2);
            telemetry.addData("green2", Green2);
            telemetry.addData("position", motor13.getCurrentPosition());
            telemetry.update();
        }
        myElapsedTime = new ElapsedTime();
        time_used = new ElapsedTime();
        waitForStart();
        time_used.reset();
        while (!(currentColor == 1)) {
            if (Math.abs(color.blue() - Blue1) + Math.abs(color.red() - Red1) + Math.abs(color.green() - Green1) > Math.abs(color.blue() - Blue2) + Math.abs(color.red() - Red2) + Math.abs(color.green() - Green2)) {
                currentColor = 2;
            } else {
                currentColor = 1;
            }
            FLmotor_0 = 0.4;
            BLmotor_1 = 0.4;
            FRmotor_2 = 0.4;
            BRmotor_3 = 0.4;
            do_something();
            if (time_used.seconds() >= 20) {
                break;
            }
        }
        while (!(((OpticalDistanceSensor) color3_REV_ColorRangeSensor).getRawLightDetected() > 100)) {
            telemetry.addData("light", ((OpticalDistanceSensor) color3_REV_ColorRangeSensor).getRawLightDetected());
            telemetry.update();
            FLmotor_0 = -0.5;
            BLmotor_1 = -0.5;
            FRmotor_2 = -0.5;
            BRmotor_3 = -0.5;
            do_something();
            if (time_used.seconds() >= 20) {
                break;
            }
        }
        myElapsedTime.reset();
        while (!(myElapsedTime.seconds() > 0.2)) {
            BLmotor_1 = 0.4;
            FLmotor_0 = 0.4;
            FRmotor_2 = 0.4;
            BRmotor_3 = 0.4;
            do_something();
            if (time_used.seconds() >= 20) {
                break;
            }
        }
        if (turn_direction != 0) {
            CurrentMotor = motor13.getCurrentPosition() + 730 * turn_direction;
            while (!(motor13.getCurrentPosition() * turn_direction >= CurrentMotor * turn_direction)) {
                FLmotor_0 = -0.5 * turn_direction;
                BLmotor_1 = -0.5 * turn_direction;
                FRmotor_2 = 0.5 * turn_direction;
                BRmotor_3 = 0.5 * turn_direction;
                do_something();
                if (time_used.seconds() >= 20) {
                    break;
                }
            }
            FLmotor_0 = 0;
            BLmotor_1 = 0;
            FRmotor_2 = 0;
            BRmotor_3 = 0;
            do_something();
            while (!(((OpticalDistanceSensor) color2_REV_ColorRangeSensor).getRawLightDetected() > 100)) {
                telemetry.addData("light", ((OpticalDistanceSensor) color2_REV_ColorRangeSensor).getRawLightDetected());
                telemetry.update();
                FLmotor_0 = 0.5;
                BLmotor_1 = 0.5;
                FRmotor_2 = 0.5;
                BRmotor_3 = 0.5;
                do_something();
                if (time_used.seconds() >= 20) {
                    break;
                }
            }
            FLmotor_0 = 0;
            BLmotor_1 = 0;
            FRmotor_2 = 0;
            BRmotor_3 = 0;
            do_something();
        }
    }

    /**
     * Describe this function...
     */
    private void do_something() {
        motor10.setPower(-FLmotor_0);
        motor11.setPower(-BLmotor_1);
        motor12.setPower(BRmotor_3);
        motor13.setPower(FRmotor_2);
    }
}