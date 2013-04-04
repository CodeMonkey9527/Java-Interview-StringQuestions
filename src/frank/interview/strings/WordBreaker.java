package frank.interview.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import frank.interview.ds.trie.Node;
import frank.interview.ds.trie.Trie;

/**
 * Break a string with no spaces into a meaningful sentence
 * e.g.
 * Input:  whatdidyouhaveforbreakfast
 * Output: what did you have for breakfast
 * 
 * Algorithm:
 * 1. build a trie for dictionary
 * 2. for input string s, and all possible valid words from prefix of s
 *       for each word w, remove it from s to generate a new string, and
 *       recursively break the new string
 * @author shenshi
 *
 */
public class WordBreaker {
	
	Trie<String> dict;
	
	public WordBreaker() {
		dict = new Trie<String>();
	}
	
	public void buildDict(String dictFile) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(dictFile));
			String line = null;
			while((line = reader.readLine()) != null) {
				String key = line.trim();
				if(key.matches("[a-z|A-Z]+")) {
					dict.put(key, key);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}

	public List<String> split(String s) {
		 List<List<String>> candidates = doSplit(s);
		 if (candidates== null)
			 return null;
		 int minLength = Integer.MAX_VALUE;
		 List<String> shortestList = null;
		 for (List<String> list : candidates) {
//			 System.out.println(list);
			 if(list != null) {
				 if (list.size() < minLength) {
					 shortestList = list;
					 minLength = list.size();
				 }
			 }
		 }
		 return shortestList;
	}
	
	private List<List<String>> doSplit(String s) {
		List<List<String>> results = new LinkedList<List<String>>();
		if(s == null || s.length() == 0) {
			results.add(new LinkedList<String>());
			return results;
		}
		
		Node<String> node = dict.getRoot();
		for (int i = 0; i < s.length(); i++) {
			Node<String> next = node.getChild(s.charAt(i));
			if (next != null) {
				node = next;
				if (node.getValue() != null) {
					String word = node.getValue();
					List<List<String>> lists = doSplit(s.substring(i+1));
					if (lists != null) {
						for (List<String> list : lists) {
							// if the rest of the string can be splitted, return current word and the words
							// splitted for the rest of the string
							List<String> result = new LinkedList<String>();
							result.add(word);
							result.addAll(list);
							results.add(result);
						}
					} else {
						// the rest of the string cannot be splitted properly, do nothing, and try the next word
					}
				}
			} else {
				// There is no prefix going forward, so stop
				break;
			}
		}
		return results;
	}
}
