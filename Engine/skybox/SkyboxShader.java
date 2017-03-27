package skybox;

import shaders.ShaderProgram;
import shaders.UniformMatrix;
import utils.MyFile;

public class SkyboxShader extends ShaderProgram {

	private static final MyFile VERTEX_SHADER = new MyFile("skybox", "skyboxVertex.glsl");
	private static final MyFile FRAGMENT_SHADER = new MyFile("skybox", "skyboxFragment.glsl");

	protected UniformMatrix projectionViewMatrix = new UniformMatrix("projectionViewMatrix");

	public SkyboxShader() {
		super(VERTEX_SHADER, FRAGMENT_SHADER, "in_position");
		super.storeAllUniformLocations(projectionViewMatrix);
	}
}
