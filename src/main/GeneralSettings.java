package main;

import org.lwjgl.util.vector.Vector3f;

import utils.MyFile;

/**
 * Just some configs. File locations mostly.
 * 
 * @author Karl
 *
 */
public class GeneralSettings {
	
	public static final MyFile RES_FOLDER = new MyFile("res");
	public static final String MODEL_FILE = "model.dae";
	public static final String ANIM_FILE = "model.dae";
	public static final String DIFFUSE_FILE = "diffuse.png";
	
	public static final int MAX_WEIGHTS = 3;
	
	public static final Vector3f LIGHT_DIR = new Vector3f(0.2f, -0.3f, -0.8f);
	
}
