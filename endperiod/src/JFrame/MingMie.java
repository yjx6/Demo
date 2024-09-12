package JFrame;

import javax.swing.*;
import java.awt.*;

public class MingMie {
    public MingMie() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-明灭元之战");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\明灭元之战.png"); // 替换为你的图片路径
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
        descriptionArea.setText("明灭元之战是明太祖朱元璋称帝后，派军北伐，结束元朝统治的一系列战争。\n" +
                "朱元璋大致扫平南方群雄后，为了彻底推翻元朝，乘红巾军基本摧毁元主力军的有利时机，于至正二十七年（1367年）十月，命徐达、常遇春率军25万人北伐。朱元璋军由淮河入黄河，连克淮安、寿光、临淄、高苑等地。山东诸州县尽为朱元璋军所有。\n" +
                "洪武元年（至正二十八年，1368年）正月，朱元璋称帝建明。四月，其北伐军队完全夺取中原，七月又克通州，元顺帝只得携带家眷及宫廷官僚北走上都，继续元室的统治，史称北元。八月二日，徐达师入大都，北伐取得了彻底胜利，元朝灭亡。");
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


