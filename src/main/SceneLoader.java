package main;

import animatedModel.AnimatedModel;
import animation.Animation;
import loaders.AnimatedModelLoader;
import loaders.AnimationLoader;
import scene.ICamera;
import scene.Scene;
import utils.MyFile;

public class SceneLoader {

	/**
	 * Sets up the scene. Loads the entity, load the animation, tells the entity
	 * to do the animation, sets the light direction, creates the camera, etc...
	 * 
	 * @param resFolder
	 *            - the folder containing all the information about the animated entity
	 *            (mesh, animation, and texture info).
	 * @return The entire scene.
	 */
	public static Scene loadScene(MyFile resFolder) {
		ICamera camera = new Camera();
		AnimatedModel entity = AnimatedModelLoader.loadEntity(new MyFile(resFolder, GeneralSettings.MODEL_FILE),
				new MyFile(resFolder, GeneralSettings.DIFFUSE_FILE));
		Animation animation = AnimationLoader.loadAnimation(new MyFile(resFolder, GeneralSettings.ANIM_FILE));
		entity.doAnimation(animation);
		Scene scene = new Scene(entity, camera);
		scene.setLightDirection(GeneralSettings.LIGHT_DIR);
		return scene;
	}

}
