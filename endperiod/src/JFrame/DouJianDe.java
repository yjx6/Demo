package JFrame;

import javax.swing.*;
import java.awt.*;

public class DouJianDe {
    public DouJianDe() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-窦建德");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\窦建德.png"); // 替换为你的图片路径
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
        descriptionArea.setText("窦建德（公元597年-公元618年），中国隋末唐初的农民起义领袖，也是历史上著名的农民起义军头目之一。以下是对他的简要介绍：\n" +
                "背景与起义：\n" +
                "窦建德是隋朝末年农民起义的主要领导者之一。起义初期，他在江南地区（今安徽、江苏一带）发动农民起义，号称“大秦王”，意图推翻隋朝的统治。\n" +
                "活动与影响：\n" +
                "窦建德的起义军在短时间内控制了广大地区，对隋朝的统治形成了威胁。他的起义虽然在军事上取得了一定的成功，但最终未能持久，面对唐朝的军事打击和政治压力，窦建德的力量逐渐衰败。\n" +
                "失败与结局：\n" +
                "公元618年，唐朝军队最终攻破了窦建德的主要据点，窦建德在战斗中被杀。其起义军随之瓦解，标志着他的起义失败告终。\n" +
                "历史评价与影响：\n" +
                "窦建德的起义虽然未能成功，但在当时反映了农民对隋朝政治、经济压迫的强烈反抗，具有一定的历史意义。他的起义也为后来唐朝的建立创造了一定的社会背景和条件。\n" +
                "总体来说，窦建德是中国历史上农民起义运动中的一个重要人物，虽然未能改变历史的进程，但其活动对当时社会政治局势产生了一定影响。");
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


