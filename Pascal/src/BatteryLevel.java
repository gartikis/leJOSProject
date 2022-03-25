import lejos.hardware.Battery;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BatteryLevel implements Behavior{
	
	public void action() {
		Button.LEDPattern(4);
		Sound.beepSequenceUp();
		LCD.clear();
		LCD.drawString("BATTERY LOW", 2, 2);
		Delay.msDelay(1000);
	}
	
	public void suppress() {}
	
	public boolean takeControl() {
		float level = Battery.getVoltage();
		if (level < 50) {
			return true;
		} else {
			return false;
		}
	}
}
