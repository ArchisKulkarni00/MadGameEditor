package madgui;


public class Text extends QuadGrid{
	
	private String mString=null;
	private final float offset = 1.0f/16.0f;
	
	public Text(String pString,float x,float y, float width,float height) {
		mString = pString;
		mStartX = x;
		mStartY=y;
		scaleWidth=width;
		scaleHeight=height;
		mWidth = mString.length();
		mHeight = 1;
		computeDimensions();
		createGrid();
		createText();
	}
	
	private void createText() {
		int temp = 0;
		int row,col;
		for(int i=0;i<mString.length();i++){
			temp = (int)mString.charAt(i);
			row = (int)temp%16;
			col = (int)temp/16;
			mQuadGrid[i].setCoordinates(row*offset, col*offset, offset,offset);
		}
	}
}
