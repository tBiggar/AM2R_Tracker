package sandbox;

import java.io.File;
import java.io.IOException;

import org.am2r.ItemData;
import org.am2r.Save;
import org.am2r.gui.Names;


public class Sandbox {
	private static Save save;
	
	public Sandbox() {
		save = new Save();
		
	}
	
	public static void main(String[] args) {
		
		showItems();
	}


	public void read(String filename) throws IOException {
		if(System.getProperty("os.name").contains("Windows")) {
			String appdata = System.getenv("LOCALAPPDATA");
			if(appdata != null) {
				File path = new File(appdata + "/AM2R");
				if(path.exists()) {
					path.
					this.save = new Save(filename);
				}
					
			}
		}
	}

	private static void showItems() {
		ItemData data = save.getItems();
		System.out.println(data.size());
		System.out.println(data.toString() + "\n");
		int temp = 0;
		
		for (int i = 0; i < data.size(); i++) {
			System.out.println(Names.getItem(i) + "|" + data.getItem(i));
			temp += data.getItem(i) ? 1 : 0;
		}
		
		System.out.println(temp);
	}
	
}

