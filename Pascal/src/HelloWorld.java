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

public class HelloWorld implements Behavior {

	private State state;
	private NXTRegulatedMotor penadj;
	private EV3LargeRegulatedMotor paper;
	private EV3LargeRegulatedMotor belt;
	
	public 	HelloWorld(State state, EV3ColorSensor sensor, EV3LargeRegulatedMotor paper, NXTRegulatedMotor belt, BaseRegulatedMotor penadj) {
		this.state = state;
		this.paper = paper;
		this.belt = belt;
		this.penadj = penadj;
		
		belt.setSpeed(200);
		paper.setSpeed(100);
		
	}
	public boolean takeControl() {
		return state.stage() == Stage.HELLOWORLD;
	
	}
	
	

public void action() {
	while (penadj.getLimitAngle() != 180){
	penadj.rotateTo(90);
	}
	
	belt.rotate((int) -186.2);
	belt.rotate((int) 93.104);		
	paper.rotate((int) -80.597);
	state.setStage(Stage.CONTINUE);
	}

@Override
public void suppress() {
	// TODO Auto-generated method stub
	
}

	
}
