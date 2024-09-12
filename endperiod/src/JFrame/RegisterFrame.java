package JFrame;

import utils.DbUti1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private JTextField idField, nameField;
    private JPasswordField passwordField, confirmPasswordField;
    public RegisterFrame() {
        super("用户注册"); // 设置窗口标题
        JPanel panel = new JPanel(new BorderLayout(5, 5))
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 绘制背景图
                Image bgImage = new ImageIcon("D:\\例子\\注册.png").getImage();
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
                //drawImage() 方法用于在指定的位置和大小绘制图像。这里将背景图像绘制到了整个 panel 的区域内，
                // 即从 (0, 0) 到 (getWidth(), getHeight())，使用的是当前 panel 的宽度和高度。
            }
        };
        panel.setBorder(BorderFactory.createEmptyBorder(70, 10, 10, 10));
        // 创建顶部标签
        JLabel titleLabel = new JLabel("欢迎注册", JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);
        // 创建表单面板
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setPreferredSize(new Dimension(400, 200));
        formPanel.setOpaque(false); // 使表单面板透明
        JLabel idLabel = new JLabel("ID：", JLabel.CENTER);
        idLabel.setForeground(Color.white);
        idField = new JTextField(10);
        idLabel.setFont(new Font("宋体", Font.BOLD, 20));
        JLabel nameLabel = new JLabel("用户名：", JLabel.CENTER);
        nameLabel.setForeground(Color.white);
        nameField = new JTextField(10);
        nameLabel.setFont(new Font("宋体", Font.BOLD, 20));

        JLabel passwordLabel = new JLabel("密码：", JLabel.CENTER);
        passwordLabel.setForeground(Color.white);
        passwordField = new JPasswordField(10);
        passwordLabel.setFont(new Font("宋体", Font.BOLD, 20));
        JLabel confirmPasswordLabel = new JLabel("确认密码：", JLabel.CENTER);
        confirmPasswordLabel.setForeground(Color.white);
        confirmPasswordField = new JPasswordField(10);
        confirmPasswordLabel.setFont(new Font("宋体", Font.BOLD, 20));
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(confirmPasswordLabel);
        formPanel.add(confirmPasswordField);

        panel.add(formPanel, BorderLayout.CENTER);

        // 创建底部按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton registerButton = new JButton("注册");
        buttonPanel.setOpaque(false); // 使按钮面板透明
        registerButton.setSize(50,50);
        registerButton.setFont(new Font("宋体", Font.BOLD, 20));
        buttonPanel.add(registerButton);
         registerButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 register();
             }
         });
        panel.add(buttonPanel, BorderLayout.SOUTH);

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null); // 居中显示
        this.setDefaultCloseOperation(1);
        this.setVisible(true);
    }

    private void register() {
        String id = idField.getText();
        String username = nameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());


        if (id.isEmpty()||username.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "请将内容补充完整");
            return;
        }
        // 检查密码和确认密码是否一致
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "密码和确认密码不一致");
            return;
        }

        // 将注册信息添加到数据库
        boolean success = DbUti1.addUser(id, username, password);
        if (success) {
            JOptionPane.showMessageDialog(this, "注册成功");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "注册失败,该ID已被占用");
        }
    }

}
