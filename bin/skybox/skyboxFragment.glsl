#version 150

const vec4 colour1 = vec4(0.88, 0.67, 0.219, 1.0);
const vec4 colour2 = vec4(0.2, 0.6, 0.7, 1.0);

in float pass_height;

out vec4 out_colour;

//I want to use the glsl smoothstep function, but for some unknown reason it doesn't work on my laptop when exported as a jar. But always works fine in Eclipse!
float smoothlyStep(float edge0, float edge1, float x){
    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);
    return t * t * (3.0 - 2.0 * t);
}

void main(void){

	float fadeFactor = 1.0 - smoothlyStep(-50.0, 70.0, pass_height);
	out_colour = mix(colour2, colour1, fadeFactor);
	
}