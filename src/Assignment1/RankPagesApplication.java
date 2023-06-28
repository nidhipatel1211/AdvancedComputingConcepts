package Assignment1;

public class RankPagesApplication {
	public static void main(String[] args) {
		final var fileReader = ReaderFactory.getFileReader(FileType.TEXT, "/Users/sagarkpr/eclipse-workspace/Tech_Right/src/W3C Web Pages/Text/");
		PageRanker pageRanker = new PageRanker(fileReader);
		pageRanker.rankPages();
	}

}
