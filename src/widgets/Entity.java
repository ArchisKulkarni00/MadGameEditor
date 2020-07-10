package widgets;

import java.util.Vector;

import madgui.Quad;

public class Entity {
	
	protected Quad mQuad = null;
	private Entity mParEntity = null;
	private boolean isActive = true;
	private boolean isCursorOn = false;
	
	
//	########## getters and setters ########## 
	public Entity getParEntity() {
		return mParEntity;
	}
	
	protected void setParEntity(Entity mParEntity) {
		this.mParEntity = mParEntity;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isCursorOn() {
		return isCursorOn;
	}
	
//	set the size in percentage relative to its parent
	
	
//	########## positioning functions ##########
//	temporary function!
	public void setPercent(float x,float y,float width,float height) {
		if(mParEntity==null) {
			float tempX = (x*2)-1;
			float tempY = 1-(y*2);
			float tempW = (width*2);
			float tempH = (height*2);
			mQuad = new Quad(tempX, tempY, tempW, tempH);
		}
		else {
			float tX = mParEntity.mQuad.getXCord();
			float tY = mParEntity.mQuad.getYCord();
			float tW = mParEntity.mQuad.getWidth();
			float tH = mParEntity.mQuad.getHeight();
			
			
			float tempX = tX+(x*tW);
			float tempY = tY-(y*tH);
			float tempW = (width*tW);
			float tempH = (height*tH);
			System.out.println("X:"+tempX);
			System.out.println("Y:"+tempH);
			mQuad = new Quad(tempX, tempY, tempW, tempH);
		}	
		
	}
	
//	temporary function!
//	called by layouts for auto positioning of entities
	protected void setParentBasedPosition(float x,float y,float w,float h) {
		mQuad = new Quad(x, y, w, h);
	}
	
//	########## functions for texturing ##########
	
	public void setSubTexture(int row,int column,float tileWidth,float tileHeight) {
		float tempX = column*tileWidth;
		float tempY = row*tileHeight;
		mQuad.setCoordinates(tempX, tempY, tileWidth, tileHeight);
	}
	
	public void setTexture(int idx) {
		mQuad.setTexture((float)idx);
	}
	
//	push the entity to entity vector
	public void push(Vector<Quad> mQuadVector) {
		mQuadVector.add(mQuad);
	}
	
}
