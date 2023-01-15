package jUnit;

/**
 * SignUpCredentials is a class that checks if the user can sign up to the
 * system or not.
 *
 */
public class SignUpCredentials
{
  private String username, password, repeatPassword;

  public SignUpCredentials(String username, String password,
      String repeatPassword)
  {
    this.username = username;
    this.password = password;
    this.repeatPassword = repeatPassword;
  }

  /**
   * The method checks if the username and password fields are empty, if the
   * username is a valid email, if the password and repeat password fields match,
   * if the password contains no white space, and if the password is between 6 and
   * 15 characters
   *
   * @return  if user can sign up, returns true otherwise returns false
   */
  public Boolean checkSignUp() throws CustomException
  {
    String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    String whiteSpace = "^\\S+";
    String passwordRegex = "^([a-zA-Z0-9@*#]{6,15})$";

    if (username != null && !username.equals("") && password != null
        && !password.equals("") && repeatPassword != null
        && !repeatPassword.equals("") && password.matches(whiteSpace)
        && password.equals(repeatPassword) && username.matches(regex)
        && password.matches(passwordRegex))
    {
      return true;
    }
    else
    {
      if (username == null || username.equals("") || password == null
          || password.equals("") || repeatPassword == null
          || repeatPassword.equals(""))
      {
        throw new CustomException("Fields cannot be empty");

      }
      else if (!username.matches(regex))
      {
        throw new CustomException("Invalid email");

      }
      else if (!password.equals(repeatPassword))
      {
        throw new CustomException("Password does not match");
      }
      else if (!password.matches(whiteSpace))
      {
        throw new CustomException("No white space allowed");
      }
      else if (!password.matches(passwordRegex))
      {
        throw new CustomException(
            "Password must be between 6 and 15 characters");
      }
    }
    return false;
  }
}

