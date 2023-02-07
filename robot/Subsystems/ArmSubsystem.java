package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// RADIANS

public class ArmSubsystem extends SubsystemBase {
    AbsoluteEncoder lowEncoder;
    AbsoluteEncoder highEncoder;
    PWMSparkMax bottom_left;
    PWMSparkMax bottom_right;
    PWMSparkMax top;


    // CONNECT USING the white, red, and black cable.
    // The WHITE cable is the signal wire.

    public ArmSubsystem()
    {
        lowEncoder = new AbsoluteEncoder(0);
        highEncoder = new AbsoluteEncoder(9);
        bottom_left = new PWMSparkMax(15);
        bottom_right = new PWMSparkMax(12);
        bottom_right.setInverted(true);
        top = new PWMSparkMax(13);
    }


    // Getters and Setters
    public void setBottom(double speed) {
        bottom_left.set(speed);
        bottom_right.set(speed);
    }
    public void stopBottom() {
        bottom_left.stopMotor();
        bottom_right.stopMotor();
    }

    public boolean exist() {
        return bottom_left.isAlive() && bottom_right.isAlive();
    }
    public double getBottomSpeed() {
        return bottom_left.get();
    }
    public double getTopRotation() {
        return highEncoder.getRotation();
    }
    public double getBottomRotation() {
        return lowEncoder.getRotation();
    }
}
