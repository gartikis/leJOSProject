import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.motor.NXTRegulatedMotor;

public class Pascal {
	private static EV3LargeRegulatedMotor paper = new EV3LargeRegulatedMotor(MotorPort.B);
	private static EV3LargeRegulatedMotor belt = new EV3LargeRegulatedMotor(MotorPort.A);
	private static EV3TouchSensor leftTouch = new EV3TouchSensor(SensorPort.S1);
	private static EV3TouchSensor rightTouch = new EV3TouchSensor(SensorPort.S3);
	private static NXTRegulatedMotor penadj = new NXTRegulatedMotor(MotorPort.D);
	private static EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S2);// colour sensor
	
	public static void main(String[] args) {
	
		//Battery level behaviour
		BatteryLevel b = new BatteryLevel();
		b.takeControl();		
				
		Button.LEDPattern(4); // Start the LEDs flashing Green
		Sound.beepSequenceUp();
		LCD.clear();
		LCD.drawString("Pascal the Printer", 0, 2);
		LCD.drawString("Georgios",0,3);
		LCD.drawString("Akshay",0,4);
		LCD.drawString("Ellie",0,5);
		LCD.drawString("Ismail",0,6);
		
		Button.ENTER.waitForPressAndRelease();
		
		LCD.clear();
					       
		SampleProvider leftSample = leftTouch.getTouchMode();
		SampleProvider rightSample = rightTouch.getTouchMode();
		float[] leftVal = new float[1];
		float[] rightVal = new float[1];		 
		
		State state = new State(Stage.CALIBRATE);
		
		Arbitrator arb = new Arbitrator(new Behavior[] {
				new Calibrate(state, belt, leftTouch, penadj), new PaperDetector(state, sensor, paper), new HelloWorld(state, sensor, paper, belt, penadj)
		});
		arb.go();
		
		EmergencyStop es = new EmergencyStop(paper, belt);
		es.takeControl();
	 
	}
	
	public static EV3LargeRegulatedMotor getBelt() {
		return belt;
	}

}
