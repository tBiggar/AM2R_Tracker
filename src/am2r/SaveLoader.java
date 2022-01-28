package am2r;

import java.io.IOException;

import org.am2r.ItemData;
import org.am2r.Save;
import org.am2r.gui.Names;

public class SaveLoader {
	private Save save;
	private String savePath;
	
	public SaveLoader() {
		setDir(getLocalAppdata());
		save = new Save();
	}
	
	public SaveLoader(String filename) throws IOException {
		setDir(getLocalAppdata());
		loadSave(filename);
	}

	private static String getLocalAppdata() {
		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.contains("win")) {
			return System.getenv("LOCALAPPDATA") + "/AM2R";
		} else if (OS.contains("nix")|| OS.contains("nux") || OS.contains("aix")) {
			return " ~/.config/AM2R";
		} else {
			System.out.println("OS is not supported, use at your own risk.");
			return null;
		}
	}
	
	private void setDir(String path) {
		savePath = path;
	}
	
	public void loadSave(String filename) throws IOException {
		save = new Save(savePath.toString() + "/" + filename);
	}

	public static void main(String[] args) {
		SaveLoader save = new SaveLoader();
		System.out.println("---(Default) Empty Save---");
		System.out.println("");
		save.showItems(); // Shows an empty save
		System.out.println();
		try {
			save.loadSave("save3");
			System.out.println("---Completed Save---");
			save.showItems();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void showItems() {
		ItemData data = save.getItems();
		
		for (int i = 0; i < data.size(); i++) {
			if (!Names.getItem(i).equals(String.format("item[%d]", i))) {
				System.out.println(i + " " + Names.getItem(i) + " | " + data.getItem(i));
			}
		}
	}
	
}

