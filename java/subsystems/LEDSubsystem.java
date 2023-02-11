
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotMap;

public class LEDSubsystem extends SubsystemBase {
  // Create an instance of the RobotMap class
  RobotMap m_RobotMap;
  // LED Specific information:
  int led_PORT;         // The port connected to the LED strip
  int led_HEIGHT = 16;      // The height of the LED strip
  int led_WIDTH = 32;       // The width of the LED strip
  int led_NumOfBuffers = 4; // The number of preloaded buffers

  Joystick m_Joystick;
  AddressableLED m_led = new AddressableLED(led_PORT);
  AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(led_HEIGHT * led_WIDTH);
  AddressableLEDBuffer[] m_ledBuffers = new AddressableLEDBuffer[led_NumOfBuffers];

  JoystickButton b1;
  JoystickButton b2;
  JoystickButton b3;
  JoystickButton b4;


  public LEDSubsystem(RobotMap robotMap, int portPWM) {
    super();
    // Essentially copy the OG RobotMap
    this.led_PORT = portPWM;
		m_RobotMap = robotMap;
    
    // Joysticks
    m_Joystick = robotMap.getJoystick();
    b1 = new JoystickButton(m_Joystick, 1);
    b2 = new JoystickButton(m_Joystick, 2);
    b3 = new JoystickButton(m_Joystick, 3);
    b4 = new JoystickButton(m_Joystick, 4);

    // Functionality
    loadBuffers();
    m_led.setLength(m_ledBuffer.getLength());
    setLEDs(1);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (b1.get()) {
      setLEDs(0);
    }
    if (b2.get()) {
      setLEDs(1);
    }
    if (b3.get()) {
      setLEDs(2);
    }
    if (b4.get()) {
      setLEDs(3);
    }
  }


  public void enableLEDs () {
    m_led.start();
  }

  public void disableLEDs () {
      m_led.stop();
  }

  private void loadBuffers () {
    for (int buffer = 0; buffer < led_NumOfBuffers; buffer++)
      m_ledBuffers[buffer] = new AddressableLEDBuffer(led_HEIGHT * led_WIDTH);

    for (int i = 0; i < led_HEIGHT * led_WIDTH; i++)
      m_ledBuffers[0].setRGB(i,200,0,0);
    for (int i = 0; i < led_HEIGHT * led_WIDTH; i++)
      m_ledBuffers[1].setRGB(i,0,200,0);
      for (int i = 0; i < led_HEIGHT * led_WIDTH; i++)
      m_ledBuffers[2].setRGB(i,0,0,200);
      for (int i = 0; i < led_HEIGHT * led_WIDTH; i++)
      m_ledBuffers[3].setRGB(i,200,200,0);
  }

  public void setLEDs (int pattern) {
      m_led.setData(m_ledBuffers[pattern]);
  }

  public void setLEDs (AddressableLEDBuffer bufferToUse) {
    m_led.setData(bufferToUse);
  }
}
