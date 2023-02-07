package frc.robot.Subsystems;

import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// RADIANS

public class ArmSubsystemCAN extends SubsystemBase {
    AbsoluteEncoder lowEncoder;
    AbsoluteEncoder highEncoder;
    CANSparkMax bottom_left;
    CANSparkMax bottom_right;
    CANSparkMax top;


    // CONNECT USING the white, red, and black cable.
    // The WHITE cable is the signal wire.

    public ArmSubsystemCAN()
    {
        lowEncoder = new AbsoluteEncoder(0);
        highEncoder = new AbsoluteEncoder(9);
        bottom_left = new CANSparkMax(15);
        bottom_right = new CANSparkMax(13);
        bottom_right.setInverted(true);
        top = new CANSparkMax(12);
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
        return true;
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
