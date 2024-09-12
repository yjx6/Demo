package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PasswordRecoveryGUI extends JFrame {
    private JTextField idField, passwordField;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "Yangjx729803";
    public PasswordRecoveryGUI () {
        super("找回密码"); // 设置窗口标题
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        panel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        // 创建顶部标签
        JLabel titleLabel = new JLabel("找回密码", JLabel.CENTER);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 30));
        panel.add(titleLabel, BorderLayout.NORTH);
        // 创建表单面板
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setPreferredSize(new Dimension(400, 200));
        JLabel idLabel = new JLabel("请输入您的ID：", JLabel.CENTER);

        idField = new JTextField(10);
        idLabel.setFont(new Font("宋体", Font.BOLD, 20));
        JLabel passwordLabel = new JLabel("您的密码为：", JLabel.CENTER);
        passwordField = new JTextField(10);
        passwordLabel.setFont(new Font("宋体", Font.BOLD, 20));


        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        panel.add(formPanel, BorderLayout.CENTER);

        // 创建底部按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton foundButton = new JButton("找回");
        foundButton.setSize(50,50);
        foundButton.setFont(new Font("宋体", Font.BOLD, 20));
        buttonPanel.add(foundButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        this.setContentPane(panel);//用于设置窗口的主要内容面板
        this.pack();//自动调整窗口的大小
        this.setLocationRelativeTo(null); // 居中显示
        this.setDefaultCloseOperation(1);
        this.setVisible(true);
        foundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPassword();
            }
        });
    }

    //查
    private void searchPassword() {
        String idText = idField.getText().trim();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入要找回密码的ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT password FROM user_table WHERE id= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idText);  // 模糊匹配
            ResultSet rs=pstmt.executeQuery();
//           String password=rs.toString();
//            passwordField.setText("您的密码为"+password);
            if(rs.next()) {
                String password = rs.getString("password");
                passwordField.setText("您的密码为 :" + password);
            } else {
                passwordField.setText("未找到匹配的密码");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Ensure the table gets refreshed

    }


    public static void main(String[] args) {
        new PasswordRecoveryGUI();
    }
}
