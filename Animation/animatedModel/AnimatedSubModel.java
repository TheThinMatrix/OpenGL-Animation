package animatedModel;

import java.util.List;

import animation.Animation;

public class AnimatedSubModel {
	private List<AnimatedModel> animatedSubModels;
	private List<Animation> animations;
	private List<SubModelInfo>  subModelInfo;
	
	
	

	public AnimatedSubModel(List<AnimatedModel> animatedSubModels, List<Animation> animations,
			List<SubModelInfo> subModelInfo) {
		
		this.animatedSubModels = animatedSubModels;
		this.animations = animations;
		this.subModelInfo = subModelInfo;
	}



	public List<AnimatedModel> getAnimatedSubModels() {
		return animatedSubModels;
	}

	public List<Animation> getAnimations() {
		return animations;
	}



	public List<SubModelInfo> getSubModelInfo() {
		return subModelInfo;
	}
	
	
	
	
	
	
	

}
