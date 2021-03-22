package Junit;

import junit.framework.TestCase;
import methods.Money;
import methods.MoneyBag;



public class MoneyBagTest extends TestCase {
	
	
	

	private MoneyBag eurUsd;
	private MoneyBag eurIls;
	private MoneyBag usdIls;


	private Money mpozitiveUSD;
	private Money mnegativeEUR;
	private Money mpozitiveILS;
	private Money mpozitiveEUR;
	private Money mzero;
	private Money equels_USD;
	
	

	protected void setUp() throws Exception {
		eurUsd=new MoneyBag(new Money(10,"EUR"),new Money(5,"USD"));
		eurIls=new MoneyBag(new Money(10,"EUR"),new Money(20,"ILS"));
		usdIls=new MoneyBag(new Money(5,"USD"),new Money(20,"ILS"));

		
		
	
		mpozitiveUSD=new Money(1,"USD");
		mnegativeEUR=new Money(-2,"EUR");
		mpozitiveILS=new Money(13,"ILS");
		mpozitiveEUR=new Money(5,"EUR");	
		mzero=new Money(0,"USD");
		equels_USD= new Money(5, "USD");

		
	}
	
	

	public void testAddMoney()  {
		
		
		  //check add negative value //
		MoneyBag expected1=new MoneyBag(new Money(8,"EUR"),new Money(5,"USD"));
		MoneyBag result1=(MoneyBag)eurUsd.addMoney(mnegativeEUR);      //add negative value
		assertTrue(expected1.equals(result1));
		
		
		
		
		//check add positive value//
		MoneyBag expected2=new MoneyBag(new Money(10,"EUR"),new Money(33,"ILS"));
		MoneyBag result2=(MoneyBag)eurIls.addMoney(mpozitiveILS);      //add positive value
		assertTrue(expected2.equals(result2));	
		
		
		
	//check add value that not exist//
	
		
		Money temp[]={mpozitiveEUR,mpozitiveILS,mpozitiveUSD};
		MoneyBag expected3=new MoneyBag(temp);    
	    Money temp2[]= {mpozitiveEUR,mpozitiveILS};
	    MoneyBag result3=new MoneyBag(temp2);
	    MoneyBag result= (MoneyBag)result3.addMoney(mpozitiveUSD);   
		assertTrue(expected3.equals(result));
		
		
		//check add value zero//
		MoneyBag expected4=new MoneyBag(new Money(5,"USD"),new Money(20,"ILS"));
		MoneyBag result4=(MoneyBag)usdIls.addMoney(mzero);             //add 0
		assertTrue(expected4.equals(result4));


		
		
	
	}
	
	
	 //@Test
	public void testContains() {
	
		assertTrue(eurUsd.contains(equels_USD));// check when acount and currency be in MoneyBag expect to a positive answer
		assertFalse(eurUsd.contains(mnegativeEUR));// check when acount not exist expect to a NOT positive answer expect to a Not positive answer
		assertFalse(usdIls.contains(mpozitiveUSD));//check when acount and currency  not exist  in MoneyBag  expect to a Not positive answer 

		try {
		assertTrue(usdIls.contains(mnegativeEUR)); //check when  currency  not in MoneyBag  expect to Null
		}
		catch (NullPointerException e) {
		assertTrue(true);
		}
		
	}

	
}
