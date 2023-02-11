package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import subsystems.LEDSubsystem;

public class RobotMap {
    LEDSubsystem m_LEDSubsystem;
    Joystick m_Joystick;

    public RobotMap() {
        m_Joystick = new Joystick(0);
        m_LEDSubsystem = new LEDSubsystem(this, 0);

        m_LEDSubsystem.enableLEDs();
    }

    
    public Joystick getJoystick() {
        return m_Joystick;
    }
}
