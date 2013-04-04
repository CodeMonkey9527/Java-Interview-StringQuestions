package frank.interview.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Find a shortest snippet of s paragraph, which have all keywords
 * @author shenshi
 *
 */
public class ShortestSnippet {
	
	static class Posting {
		static class Position {
			public final int index;
			public final int offset;
			public Position (int index, int offset) {
				this.index = index;
				this.offset = offset;
			}
			public String toString() {
				return String.format("%d", index);
			}
		}
		private List<Position> post;
		
		public Posting() {
			post = new LinkedList<Position>();
		}
		
		public void add(Position position) {
			post.add(position);
		}
		
		public String toString() {
			return post.toString();
		}
	}
	
	private static Map<String, Posting> buildIndex(String document) {
		Map<String, Posting> index = new HashMap<String, Posting>();
		StringTokenizer tokenizer = new StringTokenizer(document);
		String token = null;
		int tokenIndex = 0;
		while (tokenizer.hasMoreTokens()) {
			token=tokenizer.nextToken();
			Posting posting = index.get(token);
			if (posting == null) {
				index.put(token, new Posting());
				posting = index.get(token);
			}
			posting.add(new ShortestSnippet.Posting.Position(tokenIndex, 0));
			tokenIndex++;
		}
		return index;
	}
	
	private static void findWindow(List<Posting> postings) {
		
	}
	
	public static String search(String document, List<String> keywords) {
		Map<String, Posting> index = buildIndex(document);
		System.out.println(index);
		return document;
	}

}
