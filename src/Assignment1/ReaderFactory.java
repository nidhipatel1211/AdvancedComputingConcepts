package Assignment1;

public class ReaderFactory {
	public ReaderFactory() {
		
	}
	
	public static AbstractFileReader getFileReader(FileType type, String dirPath) {
		if (FileType.TEXT.equals(type)) {
			return new TextFileReaderImpl(dirPath);
		}
		
		throw new UnsupportedOperationException();
	}
}
