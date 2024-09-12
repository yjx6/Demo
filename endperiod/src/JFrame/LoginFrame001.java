package JFrame;

import dao.UserDetailsFrame;
import model.User;
import utils.DbUti1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame001 extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton userLoginButton;
    private JButton adminLoginButton;
    private JButton registerButton;
    private JButton forgetButton;
    private JLabel backgroundLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel loginLabel;
    private JCheckBox showPasswordCheckBox;

    public  LoginFrame001() {
        // 设置窗口标题
        setTitle("登录页面");
        // 设置窗口大小
        setSize(800, 600);
        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置布局管理器为null
        setLayout(null);
        setLocationRelativeTo(null);
        // 加载背景图片
        ImageIcon backgroundIcon = new ImageIcon("D:\\例子\\登录2.png");
        backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());

        loginLabel=new JLabel("欢迎登录");
        loginLabel.setBounds(320, 100, 160, 30);
        loginLabel.setFont(new Font("宋体", Font.BOLD, 35));
        loginLabel.setForeground(Color.white);
        // 创建用户名提示文字
        usernameLabel = new JLabel("用户名:");
        usernameLabel.setBounds(200, 200, 80, 30);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("宋体", Font.BOLD, 20));
        // 创建用户名输入文本域
        usernameField = new JTextField();
        usernameField.setBounds(300, 200, 200, 30);

        // 创建密码提示文字
        passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(200, 250, 80, 30);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("宋体", Font.BOLD, 20));
        // 创建密码输入文本域
        passwordField = new JPasswordField();
        passwordField.setBounds(300, 250, 200, 30);

        // 创建"用户登录"按钮
        userLoginButton = new JButton("用户登录");
        userLoginButton.setBounds(300, 320, 100, 30);
        userLoginButton.setFont(new Font("宋体", Font.BOLD, 14));

        // 创建"管理员登录"按钮
        adminLoginButton = new JButton("管理员登录");
        adminLoginButton.setBounds(400, 320, 100, 30);
        adminLoginButton.setFont(new Font("宋体", Font.BOLD, 12));


        // 创建"注册"按钮
        registerButton = new JButton("注册");
        registerButton.setBounds(300, 370, 100, 30);
        registerButton.setFont(new Font("宋体", Font.BOLD, 18));
        // 创建"忘记密码密码"按钮
        forgetButton = new JButton("忘记密码");
        forgetButton.setBounds(400, 370, 100, 30);
        forgetButton.setFont(new Font("宋体", Font.BOLD, 14));



        // 创建"显示密码"复选框
        showPasswordCheckBox = new JCheckBox("显示密码");
        showPasswordCheckBox.setBounds(300, 285, 150, 30);
        showPasswordCheckBox.setForeground(Color.white);
        showPasswordCheckBox.setFont(new Font("宋体", Font.BOLD, 14));
        showPasswordCheckBox.setOpaque(false); // 使复选框背景透明

        // 将组件添加到窗口中
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginLabel);

        add(userLoginButton);
        add(adminLoginButton);
        add(registerButton);
        add(forgetButton);
        add(showPasswordCheckBox);
        // 将背景标签添加到窗口的内容面板中
        getContentPane().add(backgroundLabel);
        //添加按钮动作事件
        userLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLogin();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                //passwordField.getPassword() 返回的是一个字符数组 (char[])，而不是一个字符串 (String)。
                // 这是出于安全性考虑，因为字符数组在Java中是可变的，而字符串是不可变的。
                // 使用字符数组而不是字符串可以更容易地擦除密码的内存副本，从而增强安全性。
                if (authenticateUser(username, password)) {
                    User user = getUserDetails(username);
                    new UserDetailsFrame(user).setVisible(true);
                }
            }
        });

        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminLogin();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        forgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PasswordRecoveryGUI();
            }
        });
        // 添加复选框动作事件
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField.setEchoChar((char) 0); // 显示密码
                    //符型变量可以用来表示Unicode编码的字符，而0对应的Unicode编码是空字符（NULL）
                    //设置密码字段中的回显字符
                    //将回显字符设置为 '\0'，即空字符。这样做的效果是取消密码字段的回显字符，使用户在输入密码时能够看到实际输入的字符。
                } else {
                    passwordField.setEchoChar('\u2022'); // 隐藏密码
                }
            }
        });
    }
    private boolean authenticateUser(String username, String password) {
        try (Connection connection = DbUti1.getConnection()) {
            String query = "SELECT * FROM user_table WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private User getUserDetails(String username) {
        try (Connection connection = DbUti1.getConnection()) {
            String query = "SELECT * FROM user_table WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                return new User(id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void userLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (username.isEmpty()||password.isEmpty()){
            JOptionPane.showMessageDialog(this, "用户名密码不能为空");
            return;
        }
        if (DbUti1.validateUser(username, password)) {
            JOptionPane.showMessageDialog(this, "用户登录成功");
            Main2Frame.showMainFrame();
        } else {
            JOptionPane.showMessageDialog(this, "用户名或密码不正确");
        }
    }

    private void adminLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (username.isEmpty()||password.isEmpty()){
            JOptionPane.showMessageDialog(this, "用户名密码不能为空");
            return;
        }
        if (DbUti1.validateAdmin(username, password)) {
            JOptionPane.showMessageDialog(this, "管理员登录成功");
            MainFrame.showMainFrame();
        } else {
            JOptionPane.showMessageDialog(this, "用户名或密码不正确");
        }
    }
    private void register(){
        new RegisterFrame();
    }

    public static void main(String[] args) {
        // 创建并显示登录窗口
        LoginFrame001 loginFrame = new LoginFrame001();
        loginFrame.setVisible(true);
    }
}

