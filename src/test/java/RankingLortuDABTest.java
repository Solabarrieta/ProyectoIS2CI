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
	
	//static DataAccess sut=new DataAccess();

	/*@Test
	public void test1() {
		List<Registered> resultado = sut.rankingLortu();
		
		assertTrue(resultado.size() != 0);
	}*/
	
	/*@Test
	public void test2() {

		try {
			Mockito.doReturn(true)
			 .when(dao)
			 .rankingLortu();
			
			List<Registered> obtenido = sut.rankingLortu();
			List<Registered> esperado = null;
			assertEquals(esperado, obtenido);
			System.out.println(obtenido);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void registeredNullTest() {
		System.out.println("Test registered null");
	
		testDa.open();
		testDa.deleteUsers();
		testDa.close();
		
		List<Registered> obtained = dao.rankingLortu();
		assertTrue(obtained.size()==0);
		//assertEquals(null, obtained);
		
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
