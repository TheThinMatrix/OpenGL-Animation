package main;

import org.lwjgl.opengl.Display;

import renderEngine.RenderEngine;
import scene.Scene;

public class AnimationApp {

	/**
	 * Initialises the engine and loads the scene. For every frame it updates the
	 * camera, updates the animated entity (which updates the animation),
	 * renders the scene to the screen, and then updates the display. When the
	 * display is close the engine gets cleaned up.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		RenderEngine engine = RenderEngine.init();

		Scene scene = SceneLoader.loadScene(GeneralSettings.RES_FOLDER);

		while (!Display.isCloseRequested()) {
			scene.getCamera().move();
			scene.getAnimatedModel().update();
			engine.renderScene(scene);
			engine.update();
		}

		engine.close();

	}

}
