package main;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import utils.MyFile;

/**
 * Just some configs. File locations mostly.
 * 
 * @author Karl
 *
 */
public class GeneralSettings {
	
	
	static List<MyFile> files;
	public static final MyFile RES_FOLDER = new MyFile("res");
	public static final String MODEL_FILE = "bob_lamp.dae";
	public static final String ANIM_FILE = "bob_lamp.dae";
	public static final String DIFFUSE_FILE = "bobBody.png";
	
	
	public static final int MAX_WEIGHTS = 3;
	
	public static final Vector3f LIGHT_DIR = new Vector3f(0.2f, -0.3f, -0.8f);
	
	
	//texturefiles are equal of Total geometry nodes
	public static final List<MyFile> texturefiles(){
		files= new ArrayList<>();
		files.add(new MyFile(RES_FOLDER,DIFFUSE_FILE));
		files.add(new MyFile(RES_FOLDER,"lantern_top.png"));
		files.add(new MyFile(RES_FOLDER,"lantern.png"));
		files.add(new MyFile(RES_FOLDER,"bob_helmet.png"));
		files.add(new MyFile(RES_FOLDER,"bob_head.png"));
		files.add(new MyFile(RES_FOLDER,DIFFUSE_FILE));
		
		return files;
	}

	
	
	
	
	
}
