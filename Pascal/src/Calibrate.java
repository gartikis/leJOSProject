import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.motor.EV3MediumRegulatedMotor;

// Behaviour that makes the program run
// Touches the left touch sensor
// Goes to the middle of the belt calibrated ensuring that every time it runs it is in the middle

public class Calibrate implements Behavior {
	
	private State state;
	private EV3LargeRegulatedMotor belt;
	private EV3TouchSensor leftTouch;
	private EV3MediumRegulatedMotor penadj;
	
	public Calibrate(State state, EV3LargeRegulatedMotor belt, EV3TouchSensor leftTouch, EV3MediumRegulatedMotor penadj){
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
		
	}
}
