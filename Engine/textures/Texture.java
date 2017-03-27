package textures;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import utils.MyFile;

public class Texture {

	public final int textureId;
	public final int size;
	private final int type;

	protected Texture(int textureId, int size) {
		this.textureId = textureId;
		this.size = size;
		this.type = GL11.GL_TEXTURE_2D;
	}

	protected Texture(int textureId, int type, int size) {
		this.textureId = textureId;
		this.size = size;
		this.type = type;
	}

	public void bindToUnit(int unit) {
		GL13.glActiveTexture(GL13.GL_TEXTURE0 + unit);
		GL11.glBindTexture(type, textureId);
	}

	public void delete() {
		GL11.glDeleteTextures(textureId);
	}

	public static TextureBuilder newTexture(MyFile textureFile) {
		return new TextureBuilder(textureFile);
	}

}
