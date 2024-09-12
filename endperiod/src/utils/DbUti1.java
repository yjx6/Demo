package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUti1 {
    private static final String URL = "jdbc:mysql://localhost:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "Yangjx729803";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
        //这是JDBC提供的一个静态方法，用于建立与数据库的连接
    }

    public static boolean validateUser(String username, String password) {
        String query = "SELECT * FROM user_table WHERE username = ? AND password = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //如果在try块内发生异常或查询结果为空，此时将返回false。
    }

    public static boolean validateAdmin(String username, String password) {
        String query = "SELECT * FROM manage_table WHERE username = ? AND password = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            //SQL 语句在创建 PreparedStatement 对象时被预编译，这意味着相同的 SQL 语句可以被重复执行，而无需重新编译，从而提高了执行效率。
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean addUser(String id, String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8", "root", "Yangjx729803");

            // 创建插入语句
            String query = "INSERT INTO user_table (id, username, password) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);

            // 设置参数
            statement.setString(1, id);
            statement.setString(2, username);
            statement.setString(3, password);

            // 执行插入操作
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return true; // 注册成功
            } else {
                return false; // 注册失败
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // 注册失败

    }

}}