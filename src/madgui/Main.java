package madgui;
import java.io.IOException;

import widgets.Layout;
import widgets.PushButton;

public class Main {

	public static void main(String[] args) throws IOException {
		Renderer renderer = new Renderer(1920,1080,"GameWindow");
		boolean isInitialized = renderer.init();
		
		renderer.initShader("Shaders/vs001", "Shaders/fs002");
		
//		craeting ui
		Layout layout = new Layout();
		layout.setPercent(0.0f, 0.0f, 0.1f, 1.0f);
		layout.push(renderer.mUIQuadVector);
		layout.setScalingFactor(0.05f);
		layout.setSubTexture(0, 0, 0.25f, 0.25f);
//		
		PushButton pushButton = new PushButton();
		layout.setChild(pushButton);
		pushButton.push(renderer.mUIQuadVector);
		pushButton.setSubTexture(0, 1, 0.25f, 0.25f);
		
		PushButton pushButton2 = new PushButton();
		layout.setChild(pushButton2);
		pushButton2.push(renderer.mUIQuadVector);
		pushButton2.setSubTexture(0, 1, 0.25f, 0.25f);
		
		Texture texture = new Texture("images/Theme.png",0);
		renderer.mTextureVector.add(texture);
		
//		craeting viewport
		
		
		Quad mQuad = new Quad(0.5f, 0.5f, 0.6f, 0.6f);
		renderer.mVQuadVector.add(mQuad);
		mQuad.setTexture(1.0f);
		
		Texture texture2 = new Texture("images/af32T.png",1);
		renderer.mTextureVector.add(texture2);
		
	
		
		if (isInitialized) {
			
			renderer.initVertexArray();
			renderer.runloop();
		}
		renderer.terminate();
	}

}
