package jUnit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * It's a test class for the SignUpCredentials class

 */
public class SignUpCredentialsTest
{
  private SignUpCredentials signUpCredentials;
  private String username;
  private String password;
  private String repeatPassword;

  private void initSignUpCredentials(){
    signUpCredentials = new SignUpCredentials(username,password,repeatPassword);
  }
  @Before
  public void setUp() {
    username = "pramesh@gmail.com";
    password = "pramesh";
    repeatPassword = "pramesh";


  }
  /**
   * This method tests the case where all fields are empty
   */
  @Test
  public void userLeavesAllFieldsEmpty()
  {
    username = "";
    password = "";
    repeatPassword = "";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch(CustomException e)
    {
      String message = "Fields cannot be empty";
      assertEquals(message, e.getMessage());
    }
  }

  /**
   * The method tests if the exception is thrown when one of the fields is empty
   */
  @Test
  public void userLeavesUsernameFieldsEmpty()
  {
    username = "";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch(CustomException e)
    {
      String message = "Fields cannot be empty";
      assertEquals(message, e.getMessage());
    }
  }
  @Test
  public void userLeavesPasswordFieldsEmpty()
  {
    password = "";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch(CustomException e)
    {
      String message = "Fields cannot be empty";
      assertEquals(message, e.getMessage());
    }
  }

  @Test
  public void userLeavesRepeatPasswordFieldsEmpty()
  {
    repeatPassword = "";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch(CustomException e)
    {
      String message = "Fields cannot be empty";
      assertEquals(message, e.getMessage());
    }
  }

  /**
   * The method tests if the user has entered a valid email and all fields are filled out
   */
  @Test
  public void userEntersEverythingAsExpected()
  {
    initSignUpCredentials();
    try {
      assertTrue(signUpCredentials.checkSignUp());
    }
    catch (CustomException e) {
      fail("This message must not be printed");
    }
  }

  /**
   * It tests that an exception is thrown when the email contains a whitespace
   */
  @Test
  public void testingInvalidEmailWithWhiteSpace()
  {
    username = "pram esh@gmail.com";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch (CustomException e)
    {
      String msg = "Invalid email";
      assertEquals(msg,e.getMessage());
    }
  }

  /**
   * The method tests that the SignUpException is thrown when the password and repeat password contains white space
   */
  @Test
  public void testingWhiteSpaceNotAllowedOnPasswordAndRepeatPassword()
  {
    username = "abc@gmail.dk";
    password = " a bcdef ";
    repeatPassword = " a bcdef ";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This should not be printed");
    }
    catch (CustomException e)
    {
      String msg = "No white space allowed";
      assertEquals(msg,e.getMessage());
    }
  }

  /**
   * It tests the case where the user enters an invalid email without a domain
   */
  @Test
  public void testingInvalidEmailWithoutDomain()
  {
    username = "pramesh@gmail";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch (CustomException e)
    {
      String msg = "Invalid email";
      assertEquals(msg,e.getMessage());
    }
  }

  /**
   * This method tests the case where the user enters an invalid email zipCode without an @ sign
   */
  @Test
  public void testingInvalidEmailWithoutAtSignSymbol()
  {
    username = "prameshgmail.com";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch (CustomException e)
    {
      String msg = "Invalid email";
      assertEquals(msg,e.getMessage());
    }
  }

  /**
   * The method tests that the exception is thrown when the password and repeat password are different
   */
  @Test
  public void passwordAndRepeatPasswordMisMatch()
  {
    password = "pramesh";
    repeatPassword = "pramesh12";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch (CustomException e)
    {
      String msg = "Password does not match";
      assertEquals(msg, e.getMessage());
    }
  }

  /**
   * The method tests if the password and repeat password matches
   */
  @Test
  public void testingMatchingPasswordAndRepeatPassword()
  {
    initSignUpCredentials();
    try {
      assertTrue(signUpCredentials.checkSignUp());
    }
    catch (CustomException e) {
      fail("This message must not be printed");
    }
  }

  @Test
  public void passwordAndRepeatPasswordWithFiveCharacters()
  {
    password = "abcde";
    repeatPassword = "abcde";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch (CustomException e)
    {
      assertEquals("Password must be between 6 and 15 characters", e.getMessage());
    }
  }

  @Test
  public void passwordAndRepeatPasswordWithSixCharacters()
  {
    password = "123456";
    repeatPassword = "123456";
    initSignUpCredentials();
    try
    {
      assertTrue(signUpCredentials.checkSignUp());
    }
    catch (CustomException e)
    {
      fail("Should not print: " + e.getMessage());
    }
  }

  @Test
  public void passwordAndRepeatPasswordWithSevenCharacters()
  {
    password = "1234567";
    repeatPassword = "1234567";
    initSignUpCredentials();
    try
    {
      assertTrue(signUpCredentials.checkSignUp());
    }
    catch (CustomException e)
    {
      fail("Should not print: " + e.getMessage());
    }
  }

  @Test
  public void passwordAndRepeatPasswordWithFourteenCharacters()
  {
    password = "123456789abcde";
    repeatPassword = "123456789abcde";
    initSignUpCredentials();
    try
    {
      assertTrue(signUpCredentials.checkSignUp());
    }
    catch (CustomException e)
    {
      fail("Should not print: " + e.getMessage());
    }
  }

  @Test
  public void passwordAndRepeatPasswordWithFifteenCharacters()
  {
    password = "123456789abcdef";
    repeatPassword = "123456789abcdef";
    initSignUpCredentials();
    try
    {
      assertTrue(signUpCredentials.checkSignUp());
    }
    catch (CustomException e)
    {
      fail("Should not print: " + e.getMessage());
    }
  }

  @Test
  public void passwordAndRepeatPasswordWithSixteenCharacters()
  {
    password = "123456789abcdefg";
    repeatPassword = "123456789abcdefg";
    initSignUpCredentials();
    try
    {
      signUpCredentials.checkSignUp();
      fail("This must not be printed");
    }
    catch (CustomException e)
    {
      assertEquals("Password must be between 6 and 15 characters", e.getMessage());
    }
  }

  @Test
  public void userEntersDetailsAsExpected(){
    try {
      initSignUpCredentials();
      assertTrue(signUpCredentials.checkSignUp());
    }
    catch (CustomException e) {
      fail("Should not print: " + e.getMessage());
    }
  }

  @Test
  public void anotherUserEntersDetailsAsExpected(){
    username = "via@gmail.dk";
    try {
      initSignUpCredentials();
      assertTrue(signUpCredentials.checkSignUp());
    }
    catch (CustomException e) {
      fail("Should not print: " + e.getMessage());
    }
  }




}
