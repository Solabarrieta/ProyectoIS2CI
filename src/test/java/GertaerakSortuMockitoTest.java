import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import exceptions.EventFinished;

@RunWith(MockitoJUnitRunner.class)
public class GertaerakSortuMockitoTest{
	
     DataAccess dao=Mockito.mock(DataAccess.class);
     
     //Event mockedEvent=Mockito.mock(Event.class);
	
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dao);
	
	//Clases de equivalencia validas
	@Test
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
	}
	
	@Test
	public void test2() { 
		System.out.println("Test 2");
		String description = "Barcelona-Real Sociedad";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("31/10/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sport = "Futbol";

		Mockito.doReturn(true).when(dao).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
		
		try {
			Boolean obtained = sut.gertaerakSortu(description, eventDate, sport);
			assertTrue(obtained);
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
	}
	
	@Test
	public void descriptionNullTest() {
		System.out.println("Test description null");
		String description = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("31/10/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sport = "Futbol";
		
		//Mockito.doReturn(false).when(dao).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
		
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
		
	}
	
	@Test
	public void sportNullTest() {
		System.out.println("Test sport null");
		String description = "Athletic-Real";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("31/10/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sport = null;
		
		//Mockito.doReturn(false).when(dao).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
		
		try {
			Boolean obtained = sut.gertaerakSortu(description, eventDate, sport);
			System.out.println(obtained + " Test sport null");
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
	}
	
	@Test
	public void eventDateLessThanTodayTest() {
		System.out.println("Test event date before today");
		String description = "Real-Barcelona";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("28/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sport = "Futbol";		
		try {
			Boolean obtained = sut.gertaerakSortu(description, eventDate, sport);
			System.out.println(obtained+" Test event Date less than today");
			assertFalse(obtained);
			ArgumentCaptor<String> descriptionCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<Date> dateCaptor = ArgumentCaptor.forClass(Date.class);
			ArgumentCaptor<String> sportCaptor = ArgumentCaptor.forClass(String.class);
			
			Mockito.verify(dao,Mockito.times(1)).gertaerakSortu(descriptionCaptor.capture(),dateCaptor.capture(), sportCaptor.capture());
			assertEquals(descriptionCaptor.getValue(),description);
			assertEquals(dateCaptor.getValue(),eventDate);
			assertEquals(sportCaptor.getValue(),sport);
			fail("Event finished");
		} catch (EventFinished e) {
			// TODO Auto-generated catch block
			assertEquals(e.getClass(),EventFinished.class);
		}
		
	}
	
	@Test
	public void sportNotInSportClassTest() {
		System.out.println("Test sport not in sport class");
		String description = "Athletic-Real";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;
		try {
			eventDate = sdf.parse("31/10/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sport = "patata";
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
	}
		
	
	
	
	
}
