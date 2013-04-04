package frank.interview.strings;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShortestSnippetTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearch() throws Exception {
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\shenshi\\Documents\\doc1.txt"));
			buffer.append(reader.readLine());
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		List<String> keywords = new ArrayList<String>();
		keywords.add("google");
		keywords.add("automatic");
		keywords.add("drive");
		keywords.add("car");
		ShortestSnippet.search(buffer.toString(), keywords);
	}

}
