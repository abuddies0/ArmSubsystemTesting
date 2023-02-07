package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// RADIANS

public class ArmSubsystemTwo extends SubsystemBase {
    AbsoluteEncoder lowEncoder;
    AbsoluteEncoder highEncoder;
    Spark bottom_left;
    Spark bottom_right;
    Spark top;


    // CONNECT USING the white, red, and black cable.
    // The WHITE cable is the signal wire.

    public ArmSubsystemTwo()
    {
        lowEncoder = new AbsoluteEncoder(0);
        highEncoder = new AbsoluteEncoder(9);
        bottom_left = new Spark(15);
        bottom_right = new Spark(13);
        bottom_right.setInverted(true);
        top = new Spark(12);
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
