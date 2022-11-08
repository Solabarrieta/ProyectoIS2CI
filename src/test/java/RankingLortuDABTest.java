import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import dataAccess.DataAccess;
import domain.Registered;
import test.dataAccess.TestDataAccess;

public class RankingLortuDABTest {
	protected static EntityManager  db;
	
	DataAccess dao = new DataAccess();
	
	TestDataAccess testDa = new TestDataAccess();
	
	
	@Test
	public void registeredNullTest() {
		System.out.println("Test registered null");
	
		testDa.open();
		testDa.deleteUsers();
		testDa.close();
		
		List<Registered> ranking = dao.rankingLortu();
		int expected = 0;
		int obtained = ranking.size();
		
		assertEquals(expected, obtained);
		//assertEquals(null, obtained)
		
	}
	
	@Test
	public void registeredNotNullTest() {
		testDa.open();
		testDa.addRegistered();
		testDa.close();
		System.out.println("Test registered not null");

		List<Registered> obtained = dao.rankingLortu();
		
		assertTrue(obtained.size()>0);
		
	}
}
