package databaseStorage;

import java.sql.*;

public class StorageDAO implements PersonStorageDAO {

  public StorageDAO() throws SQLException {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/postgres?currentSchema = public",
        "postgres", "Prmssanusth22");
  }

  @Override public void addPerson(Person person) {
    try (Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO person(fullName, dob, ssn) VALUES (?,?,?)");
      statement.setString(1, person.getName());
      statement.setString(2, person.getDateOfBirth());
      statement.setInt(3, person.getSocialSecurityNumber());
      statement.executeUpdate();
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override public Person getPerson(int ssn) {
    try (Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM person WHERE ssn = ?");
      statement.setInt(1, ssn);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
        String name = resultSet.getString("fullName");
        String dob = resultSet.getString("dob");
        return new Person(name, dob, ssn);
      }
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
   return null;
  }
}
