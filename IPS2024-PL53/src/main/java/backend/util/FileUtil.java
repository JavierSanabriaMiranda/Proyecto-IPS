package backend.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import backend.model.Producto;

public abstract class FileUtil {

	public static void loadFile(String fileName, List<Producto> listaCatalogo) {
		String line;
		String[] productInfo = null;
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			while (file.ready()) {
				line = file.readLine();
				productInfo = line.split("@");
				listaCatalogo.add(new Producto(productInfo[0],productInfo[1],productInfo[2],
						Float.parseFloat(productInfo[3]),0));
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
	}

	public static void saveToFile(String fileName, List<Producto> orderList) {
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("files/" + fileName + ".dat"));
			String line = orderList.toString();
			file.write(line);
			file.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("The file could not be saved.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
	}
}
