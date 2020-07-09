package madgui;

public class Quad {
	float x,y,width,height;
	float[] mVertices = new float[24];
	
	public Quad(float x,float y,float width,float height,float textureSlot) {
		this(x,y,width,height);
		setTexture(textureSlot);
	};
	
	public Quad(float x,float y,float width,float height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		float[] tempVerts= {
			x,y,0.0f,0.0f,0.0f,0.0f,
			x+width,y,0.0f,1.0f,0.0f,0.0f,
			x,y-height,0.0f,0.0f,1.0f,0.0f,
			x+width,y-height,0.0f,1.0f,1.0f,0.0f
		};
		
	
		mVertices=tempVerts;
		
	}
	
	
	public float getXCord() {
		return x;
	}
	
	public float getYCord() {
		return y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	
	public void setTexture(float textureSlot) {
		mVertices[5]=mVertices[11]=mVertices[17]=mVertices[23]=textureSlot;
	}
	
	public void setCoordinates(float x,float y,float width, float height) {
		mVertices[3]=x; mVertices[4]=y;
		mVertices[3+6]=x+width; mVertices[4+6]=y;
		mVertices[3+12]=x; mVertices[4+12]=y+height;
		mVertices[3+18]=x+width; mVertices[4+18]=y+height;
	}
	
	public float[] getVertices() {
		for (int i = 0; i < mVertices.length; i++) {
			//System.out.println(mVertices[i]);
		}
//		System.out.println("\n\n");
		return mVertices;
	}
	
	
}
