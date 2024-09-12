package JFrame;

import javax.swing.*;
import java.awt.*;

public class ZhiShui {
    public ZhiShui() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-大禹治水");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\大禹治水.png"); // 替换为你的图片路径
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
        descriptionArea.setText("大禹治水是中国古代传说中一个著名的故事，讲述了大禹治理洪水的艰辛过程。相传在遥远的古代，中国大地上发生了一场严重的洪水灾害，水患肆虐，人民流离失所，生计受到严重威胁。\n" + "最初，由大禹的父亲鲧负责治水，但他采取了堵塞的方法，九年无功，反而加剧了灾情。后来，大禹接替父亲的任务。他总结教训，采用疏导的办法，即开凿河道、疏通河川，引导洪水流入大海。\n" + "为了完成治水任务，大禹不畏艰难，三过家门而不入，表现出非凡的毅力和奉献精神。他经过十三年的努力，终于成功地治服了洪水，恢复了土地的生产，人民得以安居乐业。\n" + "大禹治水的故事不仅体现了古代劳动人民与自然灾害顽强斗争的精神，也象征着智慧、毅力和无私奉献的美德。在后世，大禹被尊为“治水圣人”和中华民族的英雄。");
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


