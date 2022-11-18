package DatabaseConnection;

import DatabaseConnection.dao.AuthorDAOImpl;
import DatabaseConnection.model.Author;

import java.sql.SQLException;

public class Test
{
  public static void main(String[] args)
  {
    try
    {
      AuthorDAOImpl instance = AuthorDAOImpl.getInstance();
      Author author = new Author(1,"Pramesh");
      instance.create(author);
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
}

