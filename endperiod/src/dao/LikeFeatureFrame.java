package dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LikeFeatureFrame {

    private int likeCount = 0; // 点赞计数
    private final String FILE_PATH = "D:\\例子\\like_count.txt"; // 保存点赞数的文件路径

    public  LikeFeatureFrame() {
        // 从文件加载点赞数
        loadLikeCount();
        // 创建主框架
        JFrame frame = new JFrame("点赞");
        frame.setDefaultCloseOperation(1);
        frame.setSize(400, 300);
        // 创建一个带缩放图标的按钮
        JButton likeButton = new JButton("点赞");
        likeButton.setFont(new Font("宋体", Font.BOLD, 26));
        // 调整图标的大小
        ImageIcon originalIcon = new ImageIcon("D:\\例子\\点赞.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        likeButton.setIcon(scaledIcon);
        likeButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        likeButton.setVerticalTextPosition(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(likeButton, BorderLayout.CENTER);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // 创建一个标签来显示点赞数
        JLabel likeLabel = new JLabel("您今日已累计点赞: " + likeCount, JLabel.CENTER);
       likeLabel.setFont(new Font("宋体", Font.BOLD, 22));
        frame.add(likeLabel, BorderLayout.CENTER);

        // 添加按钮的监听器
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                likeCount++;
                likeLabel.setText("您今日已累计点赞: " + likeCount);
                saveLikeCount(); // 每次点赞后保存点赞数
            }
        });
        // 显示框架
        frame.setLocationRelativeTo(null); // 居中显示
        frame.setVisible(true);
    }

    // 从文件加载点赞数
    private void loadLikeCount() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null) {
                    likeCount = Integer.parseInt(line);//parseInt 是 Integer 类的一个静态方法，用来将字符串转换为整数
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("加载点赞数失败：" + e.getMessage());
            }
        }
    }

    // 将点赞数保存到文件
    private void saveLikeCount() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(String.valueOf(likeCount));//转换成字符串
        } catch (IOException e) {
            System.err.println("保存点赞数失败：" + e.getMessage());
        }
    }
}
