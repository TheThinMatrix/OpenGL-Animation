package animatedModel;

import xmlParser.XmlNode;

public class AnimationNode {
	
	private XmlNode nodeAnimation;
	private XmlNode skeletonNode ;

	public AnimationNode(XmlNode nodeAnimation, XmlNode skeletonNode) {
		
		this.nodeAnimation = nodeAnimation;
		this.skeletonNode = skeletonNode;
	}

	public XmlNode getNodeAnimation() {
		return nodeAnimation;
	}

	public XmlNode getSkeletonNode() {
		return skeletonNode;
	}
	
	

}
