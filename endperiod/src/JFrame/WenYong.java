package JFrame;

import javax.swing.*;
import java.awt.*;

public class WenYong {
    public WenYong() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-文永之役");
        frame.setDefaultCloseOperation(1);
        frame.setSize(800, 480); // 调整窗口大小
        frame.setLocationRelativeTo(null);
        // 使用GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setBackground(new Color(240, 240, 0)); // 设置背景颜色，这里使用浅灰色
//        panel.setBackground(Color.white); // 设置背景颜色，这里使用浅灰色
        GridBagConstraints c = new GridBagConstraints();

        // 左侧放置图片
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\文永之役.png"); // 替换为你的图片路径
        Image image = imageIcon.getImage(); // 将ImageIcon转换为Image对象
        Image newImage = image.getScaledInstance(400, 410, Image.SCALE_SMOOTH); // 调整图片大小
        ImageIcon newImageIcon = new ImageIcon(newImage); // 将调整后的Image转换为ImageIcon
        imageLabel.setIcon(newImageIcon);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(imageLabel, c);

        // 右侧放置人物介绍
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;
        Font font = new Font("宋体", Font.PLAIN, 22); // 设置宋体字体，大小16
        JTextArea descriptionArea = new JTextArea(10, 30);
        descriptionArea.setText("文永之役发生于1274年，是日本幕府时代的一场重要战役。当时，蒙古帝国大汗忽必烈派遣元军舰队和蒙古藤四万户率领的军队侵略日本。这次侵略是为了惩罚日本未归附蒙古帝国的行为，以及寻求对日本实施进一步统治。蒙古军队计划通过海上进攻，进攻对象为九州岛。\n" +
                "然而，蒙古军队在进攻途中遭遇了突如其来的台风，这场台风被后人称为“神风”（即台风）。这场台风对蒙古舰队造成了巨大的破坏，许多船只沉没，大部分军队人员丧生。由于这场自然灾害，蒙古军队的侵略企图未能成功。这场事件在日本历史上留下了深远的影响，后人将此称为“神风救国”或“神风台风”。\n" +
                "文永之役是日本历史上第一次与蒙古帝国直接军事冲突，也是幕府时代日本国内政治和外交关系的重要转折点。");
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(font);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        panel.add(scrollPane, c);

        // 显示窗口
        frame.add(panel);
        frame.setVisible(true);
    }
}


