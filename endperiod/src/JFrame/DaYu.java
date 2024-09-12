package JFrame;

import javax.swing.*;
import java.awt.*;

public class DaYu {
    public DaYu() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-大禹");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\大禹.png"); // 替换为你的图片路径
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
        descriptionArea.setText("大禹，传说中中国古代夏朝的创建者，是著名的治水英雄。他在公元前21世纪左右生活，被后世尊称为“禹王”。大禹因其卓越的治水功绩而闻名于世，他是中国古代神话和历史中一个重要的人物。\n" + "关于大禹的传说，最著名的是他治理洪水的故事。相传，在尧、舜时代，中国发生了严重的洪灾，水患泛滥，民不聊生。大禹接替其父鲧负责治水工作。与鲧采用筑堤堵塞不同，大禹采取了疏导的方法，开挖河道，引导洪水流入海洋。他带领人民历经13年的艰苦努力，终于成功治平了洪水，使土地恢复了正常的生产和生活条件。\n" +
                "在治水期间，大禹表现出非凡的毅力和决心。据说他“三过家门而不入”，即三次路过家门都没有回家，因为他全身心地投入到治水事业中。此外，他还组织民众修建了大量的水利工程，开凿了许多河道和渠道，为后来农业的发展创造了有利条件。");
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


