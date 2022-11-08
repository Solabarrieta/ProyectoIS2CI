import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Registered;
import exceptions.EventFinished;

@RunWith(MockitoJUnitRunner.class)
public class RankingLortuMockito{
	
     DataAccess dao=Mockito.mock(DataAccess.class);
     
     //Event mockedEvent=Mockito.mock(Event.class);
	
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dao);
	
	
	@Test
	public void registeredNullTest() {
		System.out.println("Test registered null");
		ArrayList<Registered> list = new ArrayList<Registered>();
		Mockito.doReturn(list).when(dao).rankingLortu();
		ArrayList<Registered> ranking = (ArrayList<Registered>) sut.rankingLortu();
		int expected = 0;
		int obtained = ranking.size();
		assertEquals(expected, obtained);
		//assertEquals(null, obtained)
	}
	
	@Test
	public void registeredNotNullTest() {

		System.out.println("Test registered not null");
		
		ArrayList<Registered> list = new ArrayList<Registered>();
		Registered r = new Registered("Oier","123",1234);
		list.add(r);
		Mockito.doReturn(list).when(dao).rankingLortu();

		List<Registered> obtained = sut.rankingLortu();
		
		assertTrue(obtained.size()>0);
		
	}
	
	
	//Clases de equivalencia validas
	/*@Test
	public void test1() {
		System.out.println("Test 1");
		String description = "Athletic-Real Sociedad";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;

		try {
			eventDate = sdf.parse("31/10/2023");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sport = "Futbol";
		Mockito.doReturn(false).when(dao).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
		
		try {
			Boolean obtained = sut.gertaerakSortu(description, eventDate, sport);
			assertFalse(obtained);
			ArgumentCaptor<String> descriptionCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<Date> dateCaptor = ArgumentCaptor.forClass(Date.class);
			ArgumentCaptor<String> sportCaptor = ArgumentCaptor.forClass(String.class);
			
			Mockito.verify(dao,Mockito.times(1)).gertaerakSortu(descriptionCaptor.capture(),dateCaptor.capture(), sportCaptor.capture());
			assertEquals(descriptionCaptor.getValue(),description);
			assertEquals(dateCaptor.getValue(),eventDate);
			assertEquals(sportCaptor.getValue(),sport);
		} catch (EventFinished e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
}
