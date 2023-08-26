package sample.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sample.model.User;//necessário para chamar o User, aqui eu importo a Classe User crida na pasta model;

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

    public void signUpUser(User usuario){
        String insert = "INSERT "+Const.USERS_TABLE + "("+Const.USERS_FIRSTNAME
                +","+Const.USERS_LASTNAME+","+Const.USERS_USERNAME+","
                +Const.USERS_PASSWORD+","+Const.USERS_LOCATION+","
                +Const.USERS_GENDER+")" + "VALUES(?,?,?,?,?,?)";
        
        try{
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        
        preparedStatement.setString(1, usuario.getPrimeiroNome());
        preparedStatement.setString(2, usuario.getSobrenome());
        preparedStatement.setString(3, usuario.getNomeDeUsuario());
        preparedStatement.setString(4, usuario.getSenha());
        preparedStatement.setString(5, usuario.getLocal());
        preparedStatement.setString(6, usuario.getGenero());

        preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public ResultSet checarSeUsuarioExiste(User usuario){
        ResultSet resultSet = null;
        if(!usuario.getNomeDeUsuario().equals("") || !usuario.getSenha().equals("")){
            String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=?" + " AND " + Const.USERS_PASSWORD + "=?";

            // aqui eu estou passando para o banco de dados a seguinte frase: selecione tudo da tabela de usuarios onde o nome de usuario será igual ao nome de usuario passado e a senha igual a senha passada.

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                
                preparedStatement.setString(1, usuario.getNomeDeUsuario());
                preparedStatement.setString(2, usuario.getSenha());

                resultSet = preparedStatement.executeQuery();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

        }else{

        }

        return resultSet;
    }

    public ResultSet checarSeUsuarioJaExistePorNomeDeUsuario(User usuario) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=?";
        
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, usuario.getNomeDeUsuario());
            resultSet = preparedStatement.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    
        return resultSet;
    }
    
    public ResultSet checarSeUsuarioJaExistePorNomeCompleto(User usuario) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_FIRSTNAME + "=? AND " + Const.USERS_LASTNAME + "=?";
        
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, usuario.getPrimeiroNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            resultSet = preparedStatement.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    
        return resultSet;
    }


}
