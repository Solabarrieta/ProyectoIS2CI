import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import businessLogic.BLFacade;
import dataAccess.DataAccess;
import domain.Admin;
import domain.Registered;
import domain.User;
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
