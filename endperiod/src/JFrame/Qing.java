package JFrame;

import javax.swing.*;
import java.awt.*;

public class Qing {
    public Qing() {
        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-清朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\清朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("清朝（1644年-1912年）是中国历史上最后一个封建王朝，由女真族（后称满洲族）人所建立。清朝的建立始于明末清军推翻明朝政权，最终入主北京，建立起新的统治。清朝的建立者是努尔哈赤，他在位时称\"太祖\"，后继位者称\"清太宗\"。\n" +
                "清朝最早的首都是沈阳，后迁至北京，这一时期被称为顺治时期。其后历经康熙、雍正、乾隆等几位帝王的统治，清朝国力达到巅峰，领土包括今天的中国大陆绝大部分、台湾及蒙古、新疆等地。\n" +
                "清朝的政治体制以中央集权为基础，实行封建专制制度，将满洲族人作为统治核心，设立汉人和满人不同的政治地位。清朝的文化生活也有显著成就，如雍正时期的文化复兴、乾隆时期的文学艺术繁荣等。\n" +
                "然而，清朝晚期面临内忧外患的严重挑战。内部问题包括政治腐败、社会动荡和人口增长，外部则是西方列强的侵略和国内少数民族的反抗运动，如太平天国运动、戊戌变法等，最终导致清朝逐渐衰落。\n" +
                "1911年辛亥革命爆发后，清朝被推翻，清帝溥仪宣布退位，标志着封建王朝的终结，中国进入了共和民国时期。\n" +
                "清朝在中国历史上有着重要的地位，它不仅延续了中国的封建传统，也在政治、经济、文化等方面对后世产生了深远影响。");
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


