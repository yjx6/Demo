package JFrame;

import javax.swing.*;
import java.awt.*;

public class ZhouGongDan {
    public ZhouGongDan() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-周公旦");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\周公旦.png"); // 替换为你的图片路径
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
        descriptionArea.setText("周公旦（生卒年不详）是中国古代历史上著名的政治家和军事家，他是周朝的创立者周武王的弟弟。周公旦在周武王去世后，辅佐幼年的周成王，为国家的政治、军事和社会发展做出了重要贡献。\n"+"作为周成王的宰相，周公旦致力于巩固周朝的统治和推行一系列政治改革。他提倡“礼乐文教”，重视仁义道德的培养，并通过制定礼制来规范人们的行为举止。他还积极引进外来的文化与技术，推动周朝的发展。\n" +
                "周公旦在军事方面也表现出色，他组织了多次征伐，巩固了周朝的地位并保护了国家的安全。他还制定了一套完善的军事制度，加强了军队的组织和管理。\n" + "周公旦是中国古代政治家的典范之一，他的政治才能和智慧被后世所称赞。他的贡献使得周朝在中国历史上扮演了重要角色，并对后世产生了深远影");
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


