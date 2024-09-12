package JFrame;
import dao.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainFrame {

    public static void showMainFrame() {
        JFrame frame = new JFrame("历史故事应用程序");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(1);

        // 创建带背景图的自定义面板
        BackgroundPanel mainPanel = new BackgroundPanel("D:\\例子\\管理界面.jpg");

        // 设置布局为边界布局，方便控制组件位置
        mainPanel.setLayout(new BorderLayout());

        // 创建标签
        JLabel label = new JLabel("欢迎进入历史故事应用程序", SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 30));
        label.setForeground(Color.WHITE); // 设置文字颜色为白色

        // 添加标签到面板中心
        mainPanel.add(label, BorderLayout.CENTER);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10)); // 两行三列，间距为10

        // 创建按钮并添加到按钮面板
        JButton button1 = new JButton("用户管理");
        button1.setFont(new Font("宋体", Font.BOLD, 24));
        JButton button2 = new JButton("朝代管理");
        button2.setFont(new Font("宋体", Font.BOLD, 24));
        JButton button3 = new JButton("历史故事管理");
        button3.setFont(new Font("宋体", Font.BOLD, 22));
        JButton button4 = new JButton("历史名人管理");
        button4.setFont(new Font("宋体", Font.BOLD, 22));
        JButton button5 = new JButton("收藏管理");
        button5.setFont(new Font("宋体", Font.BOLD, 24));
        JButton button6 = new JButton("应用获赞次数");
        button6.setFont(new Font("宋体", Font.BOLD, 20));

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserManageFrame us=  new UserManageFrame();
                us.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DynastyManageFrame dy=  new DynastyManageFrame();
                dy.setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoryManageFrame sm=  new StoryManageFrame();
                sm.setVisible(true);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoricalManageFrame hs=  new HistoricalManageFrame();
                hs.setVisible(true);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CollectManageFrame cm=  new CollectManageFrame();
                cm.setVisible(true);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("D:\\例子\\like_count.txt");
                int likeCount = 0;
                if (file.exists()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line = reader.readLine();
                        if (line != null) {
                            likeCount = Integer.parseInt(line);
                        }
                    } catch (IOException | NumberFormatException ex) {
                        System.err.println("加载点赞数失败：" + ex.getMessage());
                    }
                }
                JOptionPane.showMessageDialog(null, "当前应用程序共获赞：" + likeCount + "  次");
            }
        });

        // 设置按钮面板背景为半透明白色
        buttonPanel.setOpaque(false); // 设置面板透明
        buttonPanel.setBackground(new Color(255, 255, 255, 100)); // 白色，透明度100

        // 添加按钮面板到主面板底部
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 添加主面板到框架
        frame.add(mainPanel);

        // 居中显示窗口
        frame.setLocationRelativeTo(null);

        // 显示窗口
        frame.setVisible(true);
    }

    // 自定义JPanel类，用于绘制背景图
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String filePath) {
            try {
                backgroundImage = new ImageIcon(filePath).getImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // 绘制背景图，填充整个面板区域
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                showMainFrame();
//            }
//        });
//    }
}


