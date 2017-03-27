package utils;

public class SmoothFloat {
	
	private final float agility;
	
	private float target;
	private float actual;
	
	public SmoothFloat(float initialValue, float agility){
		this.target = initialValue;
		this.actual = initialValue;
		this.agility = agility;
	}
	
	public void update(float delta){
		float offset = target - actual;
		float change = offset * delta * agility;
		actual += change;
	}
	
	public void increaseTarget(float dT){
		this.target += dT;
	}
	
	public void setTarget(float target){
		this.target = target;
	}
	
	public float get(){
		return actual;
	}
	
	public float getTarget(){
		return target;
	}

}
