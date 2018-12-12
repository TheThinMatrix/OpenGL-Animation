package colladaLoader;

import animatedModel.AnimationNode;
import animatedModel.SubModelInfo;
import dataStructures.AnimatedModelData;
import dataStructures.AnimationData;
import dataStructures.MeshData;
import dataStructures.SkeletonData;
import dataStructures.SkinningData;
import xmlParser.XmlNode;

public class ColladaLoader {

	public static AnimatedModelData loadColladaModel(SubModelInfo subModelInfo, int maxWeights) {
		//XmlNode node = XmlParser.loadXmlFile(colladaFile);

		SkinLoader skinLoader = new SkinLoader(subModelInfo.getSkinChildren(), maxWeights);
		SkinningData skinningData = skinLoader.extractSkinData();
		//skinningData.jointOrder all ordered joint names but we don't want for that not that is not present in skeleton node
		//add extra nodes on skeleton
		SkeletonLoader jointsLoader = new SkeletonLoader(subModelInfo.getSkeletonChildren(), skinningData.jointOrder);
		SkeletonData jointsData = jointsLoader.extractBoneData();

		GeometryLoader g = new GeometryLoader(subModelInfo.getGeometryChildren(), skinningData.verticesSkinData);
		MeshData meshData = g.extractModelData();

		return new AnimatedModelData(meshData, jointsData);
	}

	public static AnimationData loadColladaAnimation(AnimationNode animationNode) {
		
		XmlNode animNode = animationNode.getNodeAnimation().getChild("library_animations");
		XmlNode jointsNode = animationNode.getSkeletonNode();
		AnimationLoader loader = new AnimationLoader(animNode, jointsNode);
		AnimationData animData = loader.extractAnimation();
		return animData;
	}

}
