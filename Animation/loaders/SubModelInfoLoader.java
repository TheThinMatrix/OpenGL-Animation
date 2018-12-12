package loaders;

import java.util.ArrayList;
import java.util.List;

import animatedModel.AnimatedModel;
import animatedModel.AnimatedSubModel;
import animatedModel.AnimationNode;
import animatedModel.SubModelInfo;
import animation.Animation;
import main.GeneralSettings;
import utils.MyFile;
import xmlParser.XmlNode;
import xmlParser.XmlParser;

/**
 * 
 * @author Kundan
 *
 */

public class SubModelInfoLoader {
	
	private static List<SubModelInfo> subModelInfo = new ArrayList<SubModelInfo>();

	public static AnimatedSubModel loadSubModels(MyFile collada,MyFile texturefile) {
		
		XmlNode node = XmlParser.loadXmlFile(collada);
	/*
		AnimatedModel entity = AnimatedModelLoader.loadEntity(,
				new MyFile(resFolder, GeneralSettings.DIFFUSE_FILE));
		Animation animation = AnimationLoader.loadAnimation(new MyFile(resFolder, GeneralSettings.ANIM_FILE));
		*/
		
		List<AnimatedModel> animatedModels = getAnimatedModels(node,texturefile);
		
		
		//each animated model has its animation
		List<Animation> animations = getAnimations(node);
		
		
		return new AnimatedSubModel(animatedModels,animations,subModelInfo);
	}
	
	
	private static List<AnimatedModel> getAnimatedModels(XmlNode node,MyFile texture){
		
		List<XmlNode> geometryNodes = node.getChild("library_geometries").getChildren("geometry");
		
		//each geometry node has its own skin node
		List<XmlNode> skinNodes = node.getChild("library_controllers").getChildren("controller");
		//one node is main node in skeleton and others are info of root
		List<XmlNode> skeletonNodes = node.getChild("library_visual_scenes").getChild("visual_scene").getChildren("node");
		
		List<AnimatedModel> animatedModels = new ArrayList<AnimatedModel>();
		
		
		for(XmlNode geometryNode : geometryNodes) {
			
			XmlNode skinNode = getSkinNodeFromGeometryNode(geometryNode,skinNodes);
			XmlNode skeletonNode =	getSkeletonNodeFromGeometryNode(skinNode,skeletonNodes);
			
			animatedModels.add(AnimatedModelLoader.loadEntity(new SubModelInfo(geometryNode,skinNode,skeletonNode),texture));
			subModelInfo.add(new SubModelInfo(geometryNode,skinNode,skeletonNode));
		}
		
		return animatedModels;
		
	}
	
	private static List<Animation> getAnimations(XmlNode node){
		
		List<Animation> animations = new ArrayList<Animation>();
		//AnimationLoader.loadAnimation(new MyFile(resFolder, GeneralSettings.ANIM_FILE));
		
		for(SubModelInfo submodelinfo :subModelInfo) {
			animations.add(AnimationLoader.loadAnimation(new AnimationNode(node,submodelinfo.getSkeletonChildren())));
		}
		return animations;
		
	}
	
	
	
	private static XmlNode getSkinNodeFromGeometryNode(XmlNode geometry,List<XmlNode> skinNodes) {
		XmlNode skinNodeForGeometryNode =null;
		
		for(XmlNode skinNode :skinNodes) {
			print(geometry.getAttribute("id"));
			//System.out.println("getSkinNodeFromGeometryNode " + skinNode.getChild("skin").getAttribute("source").substring(1));
			if(skinNode.getChild("skin").getAttribute("source").substring(1).equals(geometry.getAttribute("id"))) {
				print("called");
				skinNodeForGeometryNode =skinNode;
				break;
			}
			
		}
		return skinNodeForGeometryNode ;
		
	}
	
	
	private static XmlNode getSkeletonNodeFromGeometryNode(XmlNode skinNode,List<XmlNode> skeletonNodes){
		XmlNode skeletonNodeForGeometryNode = null;
		
		for(XmlNode skeletonNode :skeletonNodes) {
			//System.out.println(skeletonNode.getAttribute("name"));
			//System.out.println(skinNode.getAttribute("name"));
			if(skinNode.getAttribute("name").replace(".","_").equals( skeletonNode.getAttribute("name")) ) {
				
				skeletonNodeForGeometryNode = getRootNode(skeletonNode,skinNode,skeletonNodes);			
				break;
			}
			
			
		}
		return skeletonNodeForGeometryNode;
				
	}
	
	private static XmlNode getRootNode(XmlNode skeletonNode , XmlNode skinNode,List<XmlNode> skeletonNodes) {
		XmlNode rootNode = null;
		for(XmlNode skeletonN : skeletonNodes) {
			//try{
			if(skeletonN.getChild("instance_controller")!=null) {
				if(skeletonN.getChild("instance_controller").getAttribute("url").substring(1).equals(skinNode.getAttribute("id"))) {
					
				String rootName = skeletonN.getChild("instance_controller").getChild("skeleton").getData().substring(1);
				rootNode = skeletonNode.getChildWithAttribute("node","id",rootName);
				print("getRootNode " +rootNode.getAttribute("name"));
				break;
				}
		
			}
		}
		return rootNode;
	}
	
	
//	private List<XmlNode> getChildren
	
	
	private static void print(String s) {
		System.out.println(s+" \n");
		
		
	}
	
	
}
