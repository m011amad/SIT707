package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "222514502";
		Assert.assertNotNull("Student ID is ", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Mason";
		Assert.assertNotNull("Student name is ", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	
	 @Test
	    public void testMaxFebruary28ShouldIncrementToMarch1NonLeapYear() {
	        DateUtil date = new DateUtil(28, 2, 2023); // Non-leap year
	        System.out.println("*******************");
	        System.out.println("february28ShouldIncrementToMarch1NonLeapYear > " + date);
	        date.increment();
	        System.out.println(date);
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(3, date.getMonth());
	    }

	    @Test
	    public void testMaxFebruary29ShouldIncrementToMarch1LeapYear() {
	        DateUtil date = new DateUtil(29, 2, 2024); // Leap year
	        System.out.println("february29ShouldIncrementToMarch1LeapYear > " + date);
	        date.increment();
	        System.out.println(date);
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(3, date.getMonth());
	    }

	    @Test
	    public void testMaxApril30ShouldIncrementToMay1() {
	        DateUtil date = new DateUtil(30, 4, 2024); // April has 30 days
	        System.out.println("april30ShouldIncrementToMay1 > " + date);
	        date.increment();
	        System.out.println(date);
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(5, date.getMonth());
	    }

	    @Test
	    public void testMaxApril30ShouldDecrementToApril29() {
	        DateUtil date = new DateUtil(30, 4, 2024);
	        System.out.println("april30ShouldDecrementToApril29 > " + date);
	        date.decrement();
	        System.out.println(date);
	        Assert.assertEquals(29, date.getDay());
	        Assert.assertEquals(4, date.getMonth());
	    }

	    @Test
	    public void testMaxDecember31ShouldIncrementToJanuary1NextYear() {
	        DateUtil date = new DateUtil(31, 12, 2024);
	        System.out.println("december31ShouldIncrementToJanuary1NextYear > " + date);
	        date.increment();
	        System.out.println(date);
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(1, date.getMonth());
	        Assert.assertEquals(2025, date.getYear());
	    }

	    @Test
	    public void testMinJanuary1ShouldDecrementToDecember31PreviousYear() {
	        DateUtil date = new DateUtil(1, 1, 2024);
	        System.out.println("january1ShouldDecrementToDecember31PreviousYear > " + date);
	        date.decrement();
	        System.out.println(date);
	        Assert.assertEquals(31, date.getDay());
	        Assert.assertEquals(12, date.getMonth());
	        Assert.assertEquals(2023, date.getYear());
	    }

	    @Test
	    public void testLeapYearRecognition() {
	        Assert.assertTrue("2024 should be a leap year", DateUtil.isLeapYear(2024));
	        Assert.assertFalse("2023 should not be a leap year", DateUtil.isLeapYear(2023));
	        Assert.assertTrue("2000 should be a leap year", DateUtil.isLeapYear(2000));
	        Assert.assertFalse("1900 should not be a leap year", DateUtil.isLeapYear(1900));
	    }
}
