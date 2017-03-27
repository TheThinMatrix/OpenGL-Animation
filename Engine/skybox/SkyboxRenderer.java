package skybox;

import org.lwjgl.opengl.GL11;

import openglObjects.Vao;
import scene.ICamera;
import utils.OpenGlUtils;

public class SkyboxRenderer {

	private static final float SIZE = 200;

	private SkyboxShader shader;
	private Vao box;

	public SkyboxRenderer() {
		this.shader = new SkyboxShader();
		this.box = CubeGenerator.generateCube(SIZE);
	}

	/**
	 * Renders the skybox.
	 * 
	 * @param camera
	 *            - the scene's camera.
	 */
	public void render(ICamera camera) {
		prepare(camera);
		box.bind(0);
		GL11.glDrawElements(GL11.GL_TRIANGLES, box.getIndexCount(), GL11.GL_UNSIGNED_INT, 0);
		box.unbind(0);
		shader.stop();
	}

	/**
	 * Delete the shader when the game closes.
	 */
	public void cleanUp() {
		shader.cleanUp();
	}

	/**
	 * Starts the shader, loads the projection-view matrix to the uniform
	 * variable, and sets some OpenGL state which should be mostly
	 * self-explanatory.
	 * 
	 * @param camera
	 *            - the scene's camera.
	 */
	private void prepare(ICamera camera) {
		shader.start();
		shader.projectionViewMatrix.loadMatrix(camera.getProjectionViewMatrix());
		OpenGlUtils.disableBlending();
		OpenGlUtils.enableDepthTesting(true);
		OpenGlUtils.cullBackFaces(true);
		OpenGlUtils.antialias(false);
	}

}
