package madgui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.lwjgl.opengl.GL33;

public class Shader {
	
	private int shaderProgram;
	private String vertexShader,fragmentShader;
	
	
	public int getShaderProgram() {
		return shaderProgram;
	}

	public void load(String vertex, String fragment) throws IOException {
		vertexShader = loadFiles(vertex);
		fragmentShader = loadFiles(fragment);
		this.createShader();
		this.setUniform1iv();
	}
	
	public void setActive() {
		GL33.glUseProgram(shaderProgram);
	}
	
	public void delete() {
		GL33.glDeleteProgram(shaderProgram);
	}
	
	public void setUniform1iv() {
		this.setActive();
		int loc0 = GL33.glGetUniformLocation(shaderProgram, "TextureArray[0]");
		GL33.glUniform1i(loc0, 0);
		int loc1 = GL33.glGetUniformLocation(shaderProgram, "TextureArray[1]");
		GL33.glUniform1i(loc1, 1);
//		System.out.println("inside set uniform");
//		int location = GL33.glGetUniformLocation(shaderProgram, "TextureArray");
//		GL33.glUniform1i(location, 0);
	}
	
	
	private String loadFiles(String path) throws IOException {
		//String dataString = "";
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	private void createShader() {
		shaderProgram = GL33.glCreateProgram();
		int vs = compileShader(GL33.GL_VERTEX_SHADER,vertexShader);
		int fs = compileShader(GL33.GL_FRAGMENT_SHADER,fragmentShader);
		GL33.glAttachShader(shaderProgram,vs);
		GL33.glAttachShader(shaderProgram, fs);
		GL33.glLinkProgram(shaderProgram);
		GL33.glDeleteProgram(vs);
		GL33.glDeleteProgram(fs);
	}
	
	private int compileShader(int type,String source) {
		int shader = GL33.glCreateShader(type);
		GL33.glShaderSource(shader, source);
		return shader;
	}

}
