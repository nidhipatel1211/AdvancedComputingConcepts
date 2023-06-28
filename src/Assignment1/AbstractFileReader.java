package Assignment1;

import java.util.Map;

public abstract class AbstractFileReader {
	private final FileType fileType;
	private final String dirPath;
	
	public AbstractFileReader(FileType fileType, String dirPath) {
		this.fileType = fileType;
		this.dirPath = dirPath;
	}
	
	public abstract String readFile(String fileName) throws Exception;
	public abstract Map<String, String> readFilesFromDir();
	
	public FileType getFileType() {
		return this.fileType;
	}
	
	public String getDirPath() {
		return this.dirPath;
	}
}
