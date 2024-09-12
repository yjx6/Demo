package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2Frame {
    public static void showMainFrame() {
        JFrame frame = new JFrame("历史故事应用程序");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(1);
        // 创建面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        // 创建标签
        // 加载图片文件
        ImageIcon icon = new ImageIcon("D:\\例子\\历史课堂.jpg");
        // 获取原始图像
        Image image = icon.getImage();
        // 调整图像大小，例如将宽度和高度都设置为200像素
        int width = 800;
        int height = 460;
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // 创建一个新的ImageIcon并将其设置到JLabel
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imaglabel = new JLabel(scaledIcon);


        // 添加标签到面板中心
        mainPanel.add(imaglabel, BorderLayout.CENTER);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 两行三列，间距为10

        // 创建按钮并添加到按钮面板
        JButton button1 = new JButton("浏览朝代");
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        JButton button2 = new JButton("浏览历史故事");
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        JButton button3 = new JButton("浏览历史名人");
        button3.setFont(new Font("宋体", Font.BOLD, 20));
        JButton button4 = new JButton("我的收藏夹");
        button4.setFont(new Font("宋体", Font.BOLD, 20));

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new LookDynasty().setVisible(true);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LookStory().setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LookHistorical().setVisible(true);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new LookCollect().setVisible(true);
            }
        });

        // 添加按钮面板到主面板底部
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 添加主面板到框架
        frame.add(mainPanel);

        // 居中显示窗口
        frame.setLocationRelativeTo(null);

        // 显示窗口
        frame.setVisible(true);
    }
}




