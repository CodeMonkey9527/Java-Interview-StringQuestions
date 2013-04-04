package frank.interview.strings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordBreakerTest {

	WordBreaker breaker;
	
	@Before
	public void setUp() throws Exception {
		breaker = new WordBreaker();
		breaker.buildDict("data\\dict.txt");
	}

	@Test
	public void testSplit() {
		System.out.println(breaker.split("youaregood"));
		System.out.println(breaker.split("washingtonisabeautifulstate"));
		System.out.println(breaker.split("whatdidyouhaveforbreakfast"));
		System.out.println(breaker.split("whatareyoudoing"));
	}

}
