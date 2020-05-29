package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.LaaneTilbud;

class LaaneTilbudTest {

	static LaaneTilbud laanetilbud;

	@BeforeEach
	void setUp() throws Exception {
		laanetilbud = new LaaneTilbud(10, 11111111, 30000, 5, true, 1, 5, 2, "28/04", 8.24, 5000, 50000);
	}

	@AfterEach
	void tearDown() throws Exception {
		laanetilbud = new LaaneTilbud(10, 11111111, 30000, 5, true, 1, 5, 2, "28/04", 8.24, 5000, 50000);
	}

	@Test
	public void Constructor() {
		assertEquals("11111111: 30000: 5: true: 1: 5: 2: 28/04", laanetilbud.getAllTilbud());
	}

	@Test
	public void GetTelefonnummer() {
		assertEquals(11111111, laanetilbud.getTelefonnummer());

	}

	@Test
	public void GetLaanestatus() {
		assertEquals(1, laanetilbud.getLaanestatus());

	}

	@Test
	public void GetDato() {
		assertEquals("28/04", laanetilbud.getRentedato());

	}

	@Test
	public void SetBilsaelgerID() {
		laanetilbud.setBilsaelgerid(15);
		assertEquals(15, laanetilbud.getBilsaelgerid());

	}

	@Test
	public void SetoverstigerGraense() {
		laanetilbud.setOverstigergraense(true);
		assertEquals(true, laanetilbud.getOverstigergraense());

	}

}