package JFrame;

import javax.swing.*;
import java.awt.*;

public class Xia {
    public Xia() {


        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-夏朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\夏朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("夏朝是中国历史上第一个王朝，约公元前21世纪至公元前17世纪，具体的起止时间和历史细节多有争议，但一般认为其存在于公元前2070年至公元前1600年左右。\n" +
                "\n" +
                "起源与建立\n" +
                "夏朝的建立者是大禹，他在治水有功后被推举为部落联盟首领，继而建立了夏朝。大禹的儿子启继承王位，开启了中国历史上首次世袭制的王朝统治。\n" +
                "\n" +
                "历史记载\n" +
                "夏朝的历史主要来自《史记》、《竹书纪年》等古籍的记载。由于缺乏实物证据，夏朝的存在以及其具体的历史事件长期以来一直存在争议。但考古发现，如河南二里头遗址等，被认为可能与夏朝有关，为其存在提供了一些支持。\n" +
                "\n" +
                "经济与社会\n" +
                "夏朝以农业为主，原始的畜牧业和手工业也有所发展。社会结构较为简单，以氏族部落为单位，贵族、平民、奴隶等阶层已初步形成。夏朝的宗教生活以祭祀祖先和自然神灵为主，礼仪制度逐渐形成。\n" +
                "\n" +
                "灭亡\n" +
                "夏朝历经了数代君主，最后一位君主桀因暴虐无道，导致民怨四起。商部落首领汤起兵推翻了夏朝，建立了商朝。\n" +
                "\n" +
                "重要意义\n" +
                "尽管关于夏朝的具体历史细节尚存诸多谜团，夏朝作为中国第一个王朝，标志着中华文明进入了早期国家阶段。它的传说和历史对后来的中国文化和政治制度产生了深远影响。");
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


