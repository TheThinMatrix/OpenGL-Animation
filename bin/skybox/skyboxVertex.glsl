#version 150

in vec3 in_position;
out float pass_height;

uniform mat4 projectionViewMatrix;

void main(void){
	
	gl_Position = projectionViewMatrix * vec4(in_position, 1.0);
	pass_height = in_position.y;
	
}