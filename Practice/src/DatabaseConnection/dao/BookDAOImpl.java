package DatabaseConnection.dao;

import DatabaseConnection.model.Author;
import DatabaseConnection.model.Book;
import DatabaseConnection.model.BookDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO
{
  private static BookDAOImpl instance;

  private BookDAOImpl() throws SQLException{
    //loading the  JDBC driver
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized BookDAOImpl getInstance() throws SQLException{
    if(instance == null)
      instance = new BookDAOImpl();
    return instance;
  }

  //connection method
  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema = jdbc", "postgres", "admin");
  }


  @Override
  public Book create(String isbn, String title, int yearOfPublishing, Author author) throws SQLException
  {
    //connecting to the database with auto close
    try (Connection connection = getConnection())
    {
      //preparing the statement
      PreparedStatement statement = connection.prepareStatement("INSERT INTO Book(isbn, title, yearOfPublishing, author) VAlUES (?,?,?,?);");
      //setting up the ?
      statement.setString(1, isbn);
      statement.setString(2, title);
      statement.setInt(3, yearOfPublishing);
      statement.setInt(4, author.getId());
      //execute using executeUpdate
      statement.executeUpdate();
      return new Book(isbn, title, yearOfPublishing, author); //we return a book that is just created
    }
  }

  //Use of JOIN
  @Override
  public Book readByISBN(String isbn) throws SQLException
  {
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM Book JOIN Author ON author = id WHERE isbn = ?");
      statement.setString(1,isbn);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String title = resultSet.getString("title");
        int year = resultSet.getInt("yearOfPublishing");
        int author_id = resultSet.getInt("author");
        String authorName = resultSet.getString("name");
        Author author = new Author(author_id,authorName);
        return new Book(isbn,title,year,author);
      }
      else
      {
        return null;
      }
    }
  }

  @Override
  public List<Book> readByTitle(String searchString) throws SQLException
  {
    ArrayList<Book> books = new ArrayList<>();
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM Book JOIN Author ON author = id WHERE title LIKE ? ");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()){
        String isbn = resultSet.getString("isbn");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("yearOfPublishing");
        int author_id = resultSet.getInt("author");
        String authorName = resultSet.getString("name");
        Author author = new Author(author_id,authorName);
        Book book = new Book(isbn, title,year,author);
        books.add(book);
      }
      return books;
    }
  }

  @Override
  public void update(Book book) throws SQLException
  {
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("UPDATE Book SET title = ?, yearOfPublishing = ?, author = ? WHERE isbn = ?");
      statement.setString(1, book.getTitle());
      statement.setInt(2,book.getYearOfPublishing());
      statement.setInt(3,book.getAuthor().getId());
      statement.setString(4,book.getIsbn());
      statement.executeUpdate();
    }

  }

  @Override
  public void delete(Book book) throws SQLException
  {
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("DELETE FROM Book WHERE isbn = ?");
      statement.setString(1, book.getIsbn());
      statement.executeUpdate();
    }
  }

}
