package sample.Database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                +dbPort + "/"
                +dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String primeiroNome, String sobrenome, String nomeUsuario, String senha, String local, String genero){
        String insert = "INSERT "+Const.USERS_TABLE + "("+Const.USERS_FIRSTNAME
                +","+Const.USERS_LASTNAME+","+Const.USERS_USERNAME+","
                +Const.USERS_PASSWORD+","+Const.USERS_LOCATION+","
                +Const.USERS_GENDER+")" + "VALUES(?,?,?,?,?,?)";
        
        try{
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        
        preparedStatement.setString(1, primeiroNome);
        preparedStatement.setString(2, sobrenome);
        preparedStatement.setString(3, nomeUsuario);
        preparedStatement.setString(4, senha);
        preparedStatement.setString(5, local);
        preparedStatement.setString(6, genero);

        preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
