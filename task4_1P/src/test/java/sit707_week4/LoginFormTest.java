package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

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
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	
    @Test
    public void testEmptyUsernameAndEmptyPassword() {
        System.out.println("Running Test: testEmptyUsernameAndEmptyPassword");
        LoginStatus status = LoginForm.login(null, null);
        System.out.println("Expected: Login Failure, Error Message = Empty Username");
        System.out.println("Actual: " + status);
        
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndWrongPassword() {
        System.out.println("Running Test: testEmptyUsernameAndWrongPassword");
        LoginStatus status = LoginForm.login(null, "wrong_pass");
        System.out.println("Expected: Login Failure, Error Message = Empty Username");
        System.out.println("Actual: " + status);

        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndWrongPassword() {
        System.out.println("Running Test: testWrongUsernameAndWrongPassword");
        LoginStatus status = LoginForm.login("wrong_user", "wrong_pass");
        System.out.println("Expected: Login Failure, Error Message = Credential mismatch");
        System.out.println("Actual: " + status);

        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndEmptyPassword() {
        System.out.println("Running Test: testCorrectUsernameAndEmptyPassword");
        LoginStatus status = LoginForm.login("ahsan", null);
        System.out.println("Expected: Login Failure, Error Message = Empty Password");
        System.out.println("Actual: " + status);

        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndWrongPassword() {
        System.out.println("Running Test: testCorrectUsernameAndWrongPassword");
        LoginStatus status = LoginForm.login("ahsan", "wrong_pass");
        System.out.println("Expected: Login Failure, Error Message = Credential mismatch");
        System.out.println("Actual: " + status);

        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndCorrectPassword() {
        System.out.println("Running Test: testEmptyUsernameAndCorrectPassword");
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        System.out.println("Expected: Login Failure, Error Message = Empty Username");
        System.out.println("Actual: " + status);

        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndCorrectPassword() {
        System.out.println("Running Test: testWrongUsernameAndCorrectPassword");
        LoginStatus status = LoginForm.login("wrong_user", "ahsan_pass");
        System.out.println("Expected: Login Failure, Error Message = Credential mismatch");
        System.out.println("Actual: " + status);

        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndCorrectPassword() {
        System.out.println("Running Test: testCorrectUsernameAndCorrectPassword");
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        System.out.println("Expected: Login Success, Validation Code = 123456");
        System.out.println("Actual: " + status);

        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
    }

    @Test
    public void testValidationWithEmptyCode() {
        System.out.println("Running Test: testValidationWithEmptyCode");
        boolean isValid = LoginForm.validateCode(null);
        System.out.println("Expected: false");
        System.out.println("Actual: " + isValid);

        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidationWithWrongCode() {
        System.out.println("Running Test: testValidationWithWrongCode");
        boolean isValid = LoginForm.validateCode("wrong_code");
        System.out.println("Expected: false");
        System.out.println("Actual: " + isValid);

        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidationWithCorrectCode() {
        System.out.println("Running Test: testValidationWithCorrectCode");
        boolean isValid = LoginForm.validateCode("123456");
        System.out.println("Expected: true");
        System.out.println("Actual: " + isValid);

        Assert.assertTrue(isValid);
    }
}
