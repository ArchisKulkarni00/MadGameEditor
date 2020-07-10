package madgui;

import org.joml.Matrix4f;

public class CameraOrtho2d {
	
	private Matrix4f projection;
	int scale = 360;
	private boolean isEnabled;
	
	public CameraOrtho2d(int sWidth, int sHeight) {
		setProjection(sWidth, sHeight);
		isEnabled = true;
	}
	
	public void setProjection(int width,int height) {
		projection = new Matrix4f().ortho2D(-width/2, width/2, -height/2, height/2).scale(scale);
	}
	
	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public Matrix4f getProjection() {
		return projection;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}


}
