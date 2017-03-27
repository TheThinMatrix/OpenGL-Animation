package shaders;

import org.lwjgl.opengl.GL20;

public class UniformFloat extends Uniform{
	
	private float currentValue;
	private boolean used = false;
	
	public UniformFloat(String name){
		super(name);
	}
	
	public void loadFloat(float value){
		if(!used || currentValue!=value){
			GL20.glUniform1f(super.getLocation(), value);
			used = true;
			currentValue = value;
		}
	}

}
