package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "NarwalsDriving_a_to_reset_encoder (Blocks to Java)")
public class NarwalsDriving_a_to_reset_encoder extends LinearOpMode {

    private DcMotor motor13;
    private Servo servo10;
    private Servo servo11;
    private ColorSensor color;
    private ColorSensor color3_REV_ColorRangeSensor;
    private DcMotor motor10;
    private DcMotor motor11;
    private DcMotor motor12;
    private DcMotor motor20;
    private DcMotor motor21;

    int BLmotor_1;
    int FRmotor_2;
    int BRmotor_3;
    double FLmotor_0;
    double big_arm_motor;
    double little_arm_motor;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        boolean nodpad;
        boolean up;
        boolean down;
        int handsy;
        double Big_arm1;
        boolean nobButton;
        double clawsies;
        int currentColor;
        float Right_x;
        float _7CRight_x_7C;
        float right_y;
        float _7CRight_y_7C;
        float left_x;
        float _7CLeft_x_7C;
        double Blue1 = 1;
        double Blue2 = 1;
        double Red1 = 1;
        double Green1 = 1;
        double Red2 = 1;
        double Green2 = 1;

        motor13 = hardwareMap.get(DcMotor.class, "motor1-3");
        servo10 = hardwareMap.get(Servo.class, "servo1-0");
        servo11 = hardwareMap.get(Servo.class, "servo1-1");
        color = hardwareMap.get(ColorSensor.class, "color");
        color3_REV_ColorRangeSensor = hardwareMap.get(ColorSensor.class, "color3");
        motor10 = hardwareMap.get(DcMotor.class, "motor1-0");
        motor11 = hardwareMap.get(DcMotor.class, "motor1-1");
        motor12 = hardwareMap.get(DcMotor.class, "motor1-2");
        motor20 = hardwareMap.get(DcMotor.class, "motor2-0");
        motor21 = hardwareMap.get(DcMotor.class, "motor2-1");

        waitForStart();
        BLmotor_1 = 0;
        FRmotor_2 = 0;
        BRmotor_3 = 0;
        FLmotor_0 = 0;
        do_something();
        do_something();
        nodpad = false;
        handsy = 3;
        Big_arm1 = 1;
        nobButton = false;
        clawsies = 0;
        currentColor = 0;
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                Right_x = gamepad1.right_stick_x;
                _7CRight_x_7C = Math.abs(gamepad1.right_stick_x);
                right_y = -gamepad1.right_stick_y;
                _7CRight_y_7C = Math.abs(gamepad1.right_stick_y);
                left_x = gamepad1.left_stick_x;
                _7CLeft_x_7C = Math.abs(gamepad1.left_stick_x);
                if (_7CRight_x_7C > _7CRight_y_7C) {
                    if (_7CRight_x_7C > _7CLeft_x_7C) {
                        if (Right_x < 0) {
                            BLmotor_1 = (int) -Right_x;
                            BRmotor_3 = (int) Right_x;
                            FLmotor_0 = (int) Right_x;
                            FRmotor_2 = (int) -Right_x;
                        } else {
                            BLmotor_1 = (int) -Right_x;
                            BRmotor_3 = (int) Right_x;
                            FLmotor_0 = (int) Right_x;
                            FRmotor_2 = (int) -Right_x;
                        }
                    } else {
                        BLmotor_1 = (int) left_x;
                        BRmotor_3 = (int) left_x;
                        FLmotor_0 = (int) -left_x;
                        FRmotor_2 = (int) -left_x;
                    }
                } else {
                    if (_7CRight_y_7C > _7CLeft_x_7C) {
                        BLmotor_1 = (int) right_y;
                        BRmotor_3 = (int) right_y;
                        FLmotor_0 = (int) right_y;
                        FRmotor_2 = (int) right_y;
                    } else {
                        BLmotor_1 = (int) left_x;
                        BRmotor_3 = (int) -left_x;
                        FLmotor_0 = (int) left_x;
                        FRmotor_2 = (int) -left_x;
                    }
                }
                if (gamepad1.dpad_up) {
                    if (gamepad1.dpad_up) {
                        big_arm_motor = 0.5;
                    }
                } else {
                    big_arm_motor = 0;
                    if (gamepad1.dpad_down) {
                        big_arm_motor = -0.5;
                    }
                }
                if (gamepad1.dpad_left) {
                    if (gamepad1.dpad_left) {
                        little_arm_motor = 0.5;
                    }
                } else {
                    little_arm_motor = 0;
                    if (gamepad1.dpad_right) {
                        little_arm_motor = -0.5;
                    }
                }
                do_something();
                up = gamepad1.dpad_up;
                down = gamepad1.dpad_down;
                if (nodpad) {
                    if (up) {
                        nodpad = false;
                        if (handsy == 3) {
                        } else {
                            handsy += 1;
                        }
                    } else if (down) {
                        nodpad = false;
                        if (handsy == 0) {
                        } else {
                            handsy += -1;
                        }
                    } else {
                    }
                } else {
                    if (!up && !down) {
                        nodpad = true;
                    }
                }
                if (handsy == 0) {
                    Big_arm1 = 0;
                }
                if (handsy == 1) {
                    Big_arm1 = 0.2;
                }
                if (handsy == 2) {
                    Big_arm1 = 0.4;
                }
                if (handsy == 3) {
                    Big_arm1 = 0.6;
                }
                if (gamepad1.a) {
                    motor13.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    motor13.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                } else {
                }
                servo10.setPosition(Big_arm1);
                if (gamepad1.b) {
                    if (nobButton) {
                        if (clawsies == 0) {
                            clawsies = 0.2;
                        } else {
                            clawsies = 0;
                        }
                    }
                    nobButton = false;
                } else {
                    nobButton = true;
                }
                servo11.setPosition(clawsies);
                if (Math.abs(color.blue() - Blue1) + Math.abs(color.red() - Red1) + Math.abs(color.green() - Green1) > Math.abs(color.blue() - Blue2) + Math.abs(color.red() - Red2) + Math.abs(color.green() - Green2)) {
                    currentColor = 2;
                } else {
                    currentColor = 1;
                }
                telemetry.addData("Color", currentColor);
                telemetry.addData("claw", handsy);
                telemetry.addData("FL", FLmotor_0);
                telemetry.addData("BL", BLmotor_1);
                telemetry.addData("FR", FRmotor_2);
                telemetry.addData("BR", BRmotor_3);
                telemetry.addData("v", down);
                telemetry.addData("^", up);
                telemetry.addData("noDpad", nodpad);
                telemetry.addData("BIGARM", Big_arm1);
                telemetry.addData("nobButton", nobButton);
                telemetry.addData("Clawsies", clawsies);
                telemetry.addData("light", ((OpticalDistanceSensor) color3_REV_ColorRangeSensor).getRawLightDetected());
                telemetry.addData("encoder_position", motor13.getCurrentPosition());
                telemetry.update();
                if (gamepad1.a) {
                    gamepad1.setLedColor(0.75, 1, 0.5, 10);
                }
                if (gamepad1.b) {
                    gamepad1.setLedColor(1, 0.5, 0.75, 10);
                }
                if (gamepad1.x) {
                    gamepad1.setLedColor(0.5, 0.75, 1, 10);
                }
                if (gamepad1.y) {
                    gamepad1.setLedColor(1, 0.75, 0.5, 10);
                }
            }
        }
    }

    /**
     * Describe this function...
     */
    private void do_something() {
        double Factor;

        Factor = 0.5;
        motor10.setPower(-(FLmotor_0 * Factor));
        motor11.setPower(-(BLmotor_1 * Factor));
        motor12.setPower(BRmotor_3 * Factor);
        motor13.setPower(FRmotor_2 * Factor);
        motor20.setPower(big_arm_motor);
        motor21.setPower(little_arm_motor);
    }
}
