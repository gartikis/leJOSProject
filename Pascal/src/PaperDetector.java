import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class PaperDetector implements Behavior {
	
	private State state;
	private EV3ColorSensor sensor;
	private EV3TouchSensor leftTouch;
	private NXTRegulatedMotor penadj;
	private EV3LargeRegulatedMotor paper;
	
	// Constructor for detecting paper
	
	public PaperDetector(State state, EV3ColorSensor sensor, EV3LargeRegulatedMotor paper){
		this.state = state;
		this.sensor = sensor;
		this.paper = paper;
		
	}
	
	// Method that makes sure paper detector is the current procedure in the arbitrator
	// It takes places when the arbitrator is on paper detector
	
	public boolean takeControl() {
		return state.stage() == Stage.PAPERDETECTOR;
	}

// Method that detects white and waits 10 seconds for the wheels to turn 30cm
	
	public void action() {
		SampleProvider measure = sensor.getRGBMode();
		paper.setSpeed(200);
	    float[] level = new float[3];
	
	    while (true) {
	    	if (sensor.getColorID() != 6) { Delay.msDelay(1000); }
	    	
	    	else {
	    		break;
	    		
	    	}
	    }
	    
	    Delay.msDelay(10000);
		paper.rotate(-2014, false);
		
		state.setStage(Stage.HELLOWORLD);
		
	}

	@Override
	public void suppress() {
		
	}
}	
