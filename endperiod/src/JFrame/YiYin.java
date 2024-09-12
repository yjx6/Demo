package JFrame;

import javax.swing.*;
import java.awt.*;

public class YiYin {
    public YiYin() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-伊尹");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\伊尹.png"); // 替换为你的图片路径
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
        descriptionArea.setText("伊尹（约公元前1600年至公元前1549年）是中国古代商朝和西周初期的重要政治家和民族英雄。根据传说，伊尹曾是商朝的一位囚犯，后来被商纣王释放，并担任了商朝的重要官职。\n" + "伊尹以其高尚的品德和卓越的才能著称。他在商朝末期，纣王暴虐无道，天下大乱，伊尹倡导商汤起兵讨伐商纣王，最终推翻了商朝的统治，建立了西周。商汤登基后，伊尹成为了西周朝廷的重要宰相，负责辅佐商汤治理国家。\n" +
                "伊尹在政治上提倡礼乐文教，倡导仁政，致力于改革和治理国家。他奠定了周朝的基础制度和政治体系，对中国古代政治制度的发展产生了深远影响。\n" + "伊尹以其高尚的品德、卓越的政治才能和对国家的忠诚而闻名于世，被后人誉为忠良、谋士。他对中国古代历史和政治文化的影响深远，是中国古代政治史上一位杰出的人物。");
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


