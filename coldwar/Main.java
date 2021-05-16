package coldwar;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		PanelCarga window = new PanelCarga();
		window.setVisible(true);
		
		Thread.sleep(3500);
		window.setVisible(false);
	}
		
}
