package DatabaseConnection.dao;

import DatabaseConnection.model.Author;
import DatabaseConnection.model.AuthorDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO
{
  private static AuthorDAOImpl instance;

  public static synchronized AuthorDAOImpl getInstance() throws SQLException {
    if (instance == null) {
      instance = new AuthorDAOImpl();
    }
    return instance;
  }

  public AuthorDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema = jdbc", "postgres", "Prmssanusth22");
  }

  @Override
  public Author create(Author name) throws SQLException
  {
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("INSERT INTO author(id,name) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setInt(1,name.getId());
      statement.setString(2,name.getName());
      statement.executeUpdate();
      //Author needs id and name, but we don't have id, it is auto-generated using  PreparedStatement.RETURN_GENERATED_KEYS in PreparedStatement
      //PreparedStatement.RETURN_GENERATED_KEYS does not give the key, so we must get it
      ResultSet keys = statement.getGeneratedKeys();
      if (keys.next()) {
        return new Author(keys.getInt(1), name.getName()); //In jdbc index starts at 1
      } else {
        throw new SQLException("No keys generated");
      }
    }
  }

  @Override
  public Author readById(int id) throws SQLException
  {
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM Author WHERE id = ?");
      statement.setInt(1,id);

      ResultSet resultSet = statement.executeQuery(); //This gives us the ResultSet i.e., a table with rows and columns
      //The next() method of the ResultSet object moves the point in the current row to the next row in the result set
      if(resultSet.next()){
        String name = resultSet.getString("name");
        return new Author(id, name);
      }else {
        return null;
      }
    }
  }

  @Override
  public List<Author> readByName(String searchString) throws SQLException
  {
    ArrayList<Author> authors = new ArrayList<>();
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM Author WHERE name LIKE ?");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()){
        //getting ids and names of the result set
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        //we add this author to the array list
        authors.add(new Author(id, name));
      }
      return authors; //returns all the authors of the array list
    }
  }

  @Override
  public void update(Author author) throws SQLException
  {
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("UPDATE Author SET name = ? WHERE id = ?");
      statement.setString(1, author.getName());
      statement.setInt(2, author.getId());
      statement.executeUpdate();
    }
  }

  @Override
  public void delete(Author author) throws SQLException
  {
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("DELETE FROM Author WHERE id = ?");
      statement.setInt(1, author.getId());
      statement.executeUpdate();
    }
  }
}
