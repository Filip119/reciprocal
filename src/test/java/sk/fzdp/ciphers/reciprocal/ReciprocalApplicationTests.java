package sk.fzdp.ciphers.reciprocal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.Assert;
import sk.fzdp.ciphers.reciprocal.ReciprocalService;

@SpringBootTest
class ReciprocalApplicationTests {

	@Autowired
	private ReciprocalService reciprocalService;
	
	@SuppressWarnings("deprecation")
	@Test
	void encode() {
		String text = reciprocalService.encode("Filip");
		Assert.assertEquals("Chyba", "Urork", text);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void decode() {
		String text = reciprocalService.decode("Urork");
		Assert.assertEquals("Chyba", "Filip", text);
	}

}
