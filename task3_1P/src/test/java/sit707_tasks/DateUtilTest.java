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
		Assert.assertNotNull("Student ID is", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Mason";
		Assert.assertNotNull("Student name is", studentName);
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
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        // January min boundary area: min+1
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }
    
    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        // January min boundary area: decrement should go to previous year's December 31
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear()); // Ensuring year rolls back correctly
    }
	/*
	 * Write tests for rest months of year 2024.
	 */
    @Test
    public void testFeb27LeapYearShouldIncrementToFeb28() {
        DateUtil date = new DateUtil(27, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testFeb28LeapYearShouldIncrementToFeb29() {
        DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testFeb29LeapYearShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void testFeb1ShouldIncrementToFeb2() {
        DateUtil date = new DateUtil(1, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testFeb28NonLeapYearShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(28, 2, 2023); // 2023 is not a leap year
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void testFeb29LeapYear2020ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2020); // Leap year
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }
}
