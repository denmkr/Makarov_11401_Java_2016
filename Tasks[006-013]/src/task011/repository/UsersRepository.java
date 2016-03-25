package task011.repository;

import ru.HexChars;
import ru.MyConnection;
import ru.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Denis on 28.12.15.
 */
public class UsersRepository {

    public static boolean signIn(User user) throws SQLException, ClassNotFoundException { // Вход

        if (loginExist(user.getLogin())) {
            if (passwordRight(user.getLogin(), user.getPassword())) {
                return true;
            }
        }

        return false;

    }

    public static boolean signUp(User user) throws SQLException, ClassNotFoundException { // Регистрация

        Connection connection = MyConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts VALUES (?, ?, ?, ?)");

        user.setPassword(HexChars.getHex(user.getPassword())); // Преобразуем пароль в Hex

        statement.setString(1, user.getLogin());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getType());
        statement.execute();

        connection.close();

        return true;

    }


    public static boolean loginExist(String login) throws SQLException, ClassNotFoundException {

        Connection connection = MyConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT login FROM accounts WHERE login='" + login + "'");
        ResultSet resultSet = statement.executeQuery();

        resultSet.last();
        int size = resultSet.getRow();
        resultSet.beforeFirst();

        connection.close();

        if (size != 0) { // Занят
            return true;
        }
        else { // Свободен
            return false;
        }

    }

    public static boolean passwordRight(String login, String password) throws SQLException, ClassNotFoundException {

        Connection connection = MyConnection.getConnection();
        password = HexChars.getHex(password);

        PreparedStatement statement = connection.prepareStatement("SELECT password from accounts WHERE login='" + login + "' and password='" + password + "'");
        ResultSet resultSet = statement.executeQuery();

        resultSet.last();
        int size = resultSet.getRow();
        resultSet.beforeFirst();

        connection.close();

        if (size != 0) { // Правильный пароль
            return true;
        }
        else { // Неправильный пароль
            return false;
        }

    }


}
