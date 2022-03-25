import lejos.hardware.Button;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.motor.EV3MediumRegulatedMotor;



//public class Calibrate {
//
//	EV3LargeRegulatedMotor paper = new EV3LargeRegulatedMotor(MotorPort.B);
//	EV3LargeRegulatedMotor belt = new EV3LargeRegulatedMotor(MotorPort.A);
//	EV3ColorSensor color = new EV3ColorSensor(SensorPort.S2);
//	EV3TouchSensor leftTouch = new EV3TouchSensor(SensorPort.S1);
//	Light light = new Light(paper, color);
//	
//	
//	public void lightDetect (EV3LargeRegulatedMotor paper) throws NullPointerException {
//		boolean lightdetect;
//		lightdetect =  light.takeControl();
//	    
//		if (!lightdetect) {
//			light.action();
//		} 
//		
//	}
//}

//public class Calibrate extends Pascal {
//	private static EV3LargeRegulatedMotor belt = Pascal.getBelt();
//	
//	public static void main(String[] args) {
//		belt.forward();
//		
//	}
//	
//	
//}
//
public class Calibrate implements Behavior{
	
	
	private State state;
	private EV3LargeRegulatedMotor belt;
	private EV3TouchSensor leftTouch;
	private NXTRegulatedMotor penadj;
	
	public Calibrate(State state, EV3LargeRegulatedMotor belt, EV3TouchSensor leftTouch, NXTRegulatedMotor penadj){
		this.state = state;
		this.belt = belt;
		this.leftTouch = leftTouch;
		this.penadj = penadj;
		belt.setSpeed(200);
		
	}
	
	public boolean takeControl() {
		return state.stage() == Stage.CALIBRATE;
	}
	
	

public void action() {
	System.out.println(penadj.getLimitAngle());
	while (penadj.getLimitAngle() != 0){
	penadj.rotateTo(0);
	}

	SampleProvider leftSample = leftTouch.getTouchMode();

	float[] leftVal = new float[1];

	belt.rotate(-2000, true);
	
	while (true) {
		
		leftTouch.fetchSample(leftVal, 0);
		
		if (leftVal[0] == 1) {
			belt.stop();
			belt.rotate(977, true);
			break;
		}
						       

	}
	
	state.setStage(Stage.PAPERDETECTOR);
	
}

@Override
public void suppress() {
	// TODO Auto-generated method stub
	
}
}
