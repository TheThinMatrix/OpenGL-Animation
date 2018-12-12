package animatedModel;

import xmlParser.XmlNode;

/**
 * 
 * @author Kundan
 *
 */
public class SubModelInfo {
	
	private XmlNode geometryChild;
	private XmlNode skinChild;
	private XmlNode skeletonChild;
	public SubModelInfo(XmlNode geometryChildren, XmlNode skinChildren, XmlNode skeletonChildren) {
		
		this.geometryChild = geometryChildren;
		this.skinChild = skinChildren;
		this.skeletonChild = skeletonChildren;
	
	}
	
	public XmlNode getGeometryChildren() {
		return geometryChild;
	}
	public XmlNode getSkinChildren() {
		return skinChild;
	}
	public XmlNode getSkeletonChildren() {
		return skeletonChild;
	}
	
	

}
