import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import dataAccess.DataAccess;
import test.dataAccess.TestDataAccess;
public class GertaerakSortuDAWTest {
	DataAccess dao = new DataAccess();
	
	TestDataAccess testDa = new TestDataAccess();
	
	/*@Test
	public void descriptionExistTest() {
		String description = "Athletic-Barcelona";
		String sport = "Futbol";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("17/11/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean obtained = dao.gertaerakSortu(description, eventDate, sport);
		assertFalse(obtained);
	}
	
	
	@Test
	public void sportNotInSportClassTest() {
		System.out.println("Test sport not in sport class");
		String description = "Athletic-Real";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("31/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sport = "patata";
		//boolean expected = false;
		boolean obtained = dao.gertaerakSortu(description, eventDate, sport);
		assertFalse(obtained);
	}
	
	@Test
	public void test1() { 
		System.out.println("Test 1");
		String description = "Athletic-Real Sociedad";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("31/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sport = "Futbol";
		//boolean expected = false;
		boolean obtained = dao.gertaerakSortu(description, eventDate, sport);
		assertFalse(obtained);
	}
	
	@Test
	public void test2() { 
		System.out.println("Test 2");
		String description = "Barcelona-Real Sociedad";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("31/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sport = "Futbol";
		testDa.open();
		boolean obtained = dao.gertaerakSortu(description, eventDate, sport);
		assertTrue(obtained);
		testDa.removeEvent(description);
		testDa.close();
	}*/
	
	

}
