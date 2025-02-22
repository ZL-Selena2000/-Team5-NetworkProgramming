import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class game_file {

	BufferedWriter out = null;
	
	public game_file() {
		// TODO Auto-generated constructor stub
	}

	boolean winRecord(String nn) {
		String PathPointer = "./Server";
		File ServerPointer = null;
		Path path = Paths.get(PathPointer);

		if (!Files.exists(path) && !Files.isDirectory(path)) {
			ServerPointer = new File(PathPointer);
			ServerPointer.mkdir();
		}
		PathPointer = "./Server/Users";
		path = Paths.get(PathPointer);

		if (!Files.exists(path) && !Files.isDirectory(path)) {
			ServerPointer = new File(PathPointer);
			ServerPointer.mkdir();
		}
		String UserID = nn;
		File UID = new File(PathPointer + "/" + nn);
		UID.mkdir();
		try {

			UID = new File(PathPointer + "/" + nn + "/data.txt");
			UID.createNewFile();

			PrintWriter UWriter = new PrintWriter(new FileWriter(UID));
			
			UWriter.println(nn +"win");
			System.out.println(nn + "  win printed!");
			UWriter.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {

		}
		return true; // flag ��ȯ
	}

	boolean loseRecord(String nn) {
		String PathPointer = "./Server";
		File ServerPointer = null;
		Path path = Paths.get(PathPointer);

		if (!Files.exists(path) && !Files.isDirectory(path)) {
			ServerPointer = new File(PathPointer);
			ServerPointer.mkdir();
		}
		PathPointer = "./Server/Users";
		path = Paths.get(PathPointer);

		if (!Files.exists(path) && !Files.isDirectory(path)) {
			ServerPointer = new File(PathPointer);
			ServerPointer.mkdir();
		}
		String UserID = nn;
		File UID = new File(PathPointer + "/" + nn);
		UID.mkdir();
		try {

			UID = new File(PathPointer + "/" + nn + "/data.txt");
			UID.createNewFile();

			PrintWriter UWriter = new PrintWriter(new FileWriter(UID));
			
			UWriter.println(nn +"lose");
			System.out.println(nn + "  lose printed!");
			UWriter.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {

		}
		return true; // flag ��ȯ
	}
}
