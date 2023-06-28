package Assignment1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.FilenameFilter;

public class TextFileReaderImpl extends AbstractFileReader {
	private static FilenameFilter filter;

	public TextFileReaderImpl(String dirPath) {
		super(FileType.TEXT, dirPath);

		filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.contains(".txt");
			}
		};
	}

	public String readFile(String fileName) throws Exception {

		if (!fileName.endsWith(".txt")) {
			throw new Exception("File type not supported ");
		}

		Scanner fileReader = null;
		try {
			File file = new File(this.getDirPath() + fileName);
			return readFile(file);

		} catch (Exception e) {
			System.out.println("An error occurred, File not found.");
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
		return "";
	}

	private String readFile(File file) throws Exception {

		Scanner fileReader = null;
		StringBuilder builder = new StringBuilder();
		try {
			fileReader = new Scanner(file);

			while (fileReader.hasNextLine()) {
				builder.append(" " + fileReader.nextLine());
			}

		} catch (Exception e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}

		return builder.toString();
	}

	public Map<String, String> readFilesFromDir() {
		Map<String, String> fileMap = new HashMap<String, String>();

		try {
			File folder = new File(this.getDirPath());
			for (File file : folder.listFiles(filter)) {
				System.out.println(file.getName());
				String content = readFile(file);
				fileMap.put(file.getName(), content);
			}
		} catch (Exception e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		return fileMap;
	}
}
