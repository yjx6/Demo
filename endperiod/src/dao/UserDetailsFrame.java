package dao;

import model.User;
import utils.DbUti1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDetailsFrame extends JFrame {
    private JTextField usernameField,passwordField;
//    private JPasswordField passwordField;
    private User user;

    public UserDetailsFrame(User user) {
        this.user = user;

        setTitle("用户信息");
        setSize(600, 350);
        setDefaultCloseOperation(1);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel jLabel1 = new JLabel("欢迎ID为：" + user.getId() + " 的用户");
        usernameField = new JTextField(user.getUsername(), 20);
        usernameField.setEditable(false);
        passwordField = new JTextField(user.getPassword(), 20);
        JButton saveButton = new JButton("保存修改");
        jLabel1.setBounds(170, 30, 300, 30);
        jLabel1.setFont(new Font("宋体", Font.BOLD, 24));
        JLabel jLabel2=new JLabel("您当前用户名为：");
        jLabel2.setFont(new Font("宋体", Font.BOLD, 16));
        JLabel jLabel3=new JLabel("当前密码为：");
        jLabel3.setFont(new Font("宋体", Font.BOLD, 16));
        jLabel2.setBounds(200, 60, 200, 30);
        usernameField.setBounds(200, 90, 200, 30);
        jLabel3.setBounds(200, 130, 200, 30);
        passwordField.setBounds(200, 160, 200, 30);
        saveButton.setBounds(200, 220, 200, 30);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = usernameField.getText();
//                String newPassword = new String(passwordField.getPassword());
                String newPassword = passwordField.getText();
                if (newPassword.isEmpty()){
                    JOptionPane.showMessageDialog(null, "密码不可为空");
                    return;
                }else {
                    updateUserDetails(user.getId(), newUsername, newPassword);
                }

            }
        });

        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(saveButton);
        add(usernameField);
        add(passwordField);
    }

    private void updateUserDetails(int id, String username, String password) {
        try (Connection connection = DbUti1.getConnection()) {
            String query = "UPDATE user_table SET username = ?, password = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "个人账号信息修改成功!");
            } else {
                JOptionPane.showMessageDialog(this, "账号信息修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
