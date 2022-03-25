import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;



public class PaperDetector implements Behavior{
	
	
	private State state;
	private EV3ColorSensor sensor;
	private EV3TouchSensor leftTouch;
	private NXTRegulatedMotor penadj;
	private EV3LargeRegulatedMotor paper;
	
	public PaperDetector(State state, EV3ColorSensor sensor, EV3LargeRegulatedMotor paper){
		this.state = state;
		this.sensor = sensor;
		this.paper = paper;
		
	}
	
	public boolean takeControl() {
		return state.stage() == Stage.PAPERDETECTOR;
	}
	
	

public void action() {
	SampleProvider measure = sensor.getRGBMode();
	paper.setSpeed(200);
    float[] level = new float[3];
//    if ((level[0] != 0.0) && (level[1] != 0.0) && (level[2] != 0.0)) {
//    	paper.rotate(720, true);
//    }
    
//	while (!(String.valueOf(level[0]).equals("0.0") && String.valueOf(level[0]).equals("0.0") && String.valueOf(level[0]).equals("0.0")))  {
//        measure.fetchSample(level, 0);
//        Delay.msDelay(3000);
//        }
    while (true) {
    	if (sensor.getColorID() != 6) { Delay.msDelay(1000); }
    	
    	else {
    		break;
    		
    	}
    }
//    while (sensor.getColorID() != 6) {
//		}
//    
    Delay.msDelay(10000);
	paper.rotate(-2014, true);
	
	state.setStage(Stage.HELLOWORLD);
	
	
}

@Override
public void suppress() {
	// TODO Auto-generated method stub
	
}
}	
