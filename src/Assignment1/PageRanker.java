package Assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import Assignment1.Utils.StringUtils;

public class PageRanker {
	private final AbstractFileReader fileReader;
	private static Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
	 
    public static boolean isAlphaNumeric(String s) {
        return p.matcher(s).find();
    }
	
	public PageRanker(AbstractFileReader fileReader) {
		this.fileReader = fileReader;
	}
	
	public void rankPages(String[] keyWords) {
		final var filesContent = this.fileReader.readFilesFromDir();
		final var filesMatchScoreMap = getFilesMatchScoreMap(filesContent, keyWords);
		
	}
	
	private Map<String, Integer> getFilesMatchScoreMap(Map<String, String> filesContent, String[] keywords) {
		final var scoreMap = new HashMap<String, Integer>();
		
		for(String fileName : filesContent.keySet()) {
			final var wordsFreqMap = getPageWordsFreq(filesContent.get(fileName));
			final var score = getMatchScore(wordsFreqMap, keywords);
			scoreMap.put(fileName, score);
		}
		
		return scoreMap;
	}
	
	private Integer getMatchScore(Map<String, Integer> wordsFreqMap, String[] keywords) {
		int score = 0;
		for(String keyword : keywords) {
			score+=wordsFreqMap.getOrDefault(keyword, 0);
		}
		return score;
	}
	
	private Map<String, Integer> getPageWordsFreq(String pageText) {
		final var words = StringUtils.tokenTextAndClean(pageText, " ");
		
		final var wordsFreqMap = new HashMap<String, Integer>();
		words.stream()
		.filter(word -> isAlphaNumeric(word.toLowerCase()))
		.map(word -> wordsFreqMap.put(word.toLowerCase(), wordsFreqMap.getOrDefault(word, 0)))
		.collect(null);
		
		return wordsFreqMap;
	}
}