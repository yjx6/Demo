package JFrame;

import javax.swing.*;
import java.awt.*;

public class WanYanAGuDa {
    public WanYanAGuDa() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-完颜阿骨打");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\完颜阿骨打.png"); // 替换为你的图片路径
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
        descriptionArea.setText("完颜阿骨打（1162年-1227年），蒙古帝国初期的重要军事领袖和政治家，也是成吉思汗的亲信和重要将领之一。以下是对他的简要介绍：\n" +
                "早年生涯：\n" +
                "完颜阿骨打出生于契丹人家庭，早年随父亲在蒙古部落中生活，后来成为成吉思汗的义子和重要将领。\n" +
                "军事才能：\n" +
                "阿骨打以勇猛善战著称，他在成吉思汗统一草原、征服西域和中原等战役中表现突出，尤其在西征方面成绩显著。\n" +
                "政治地位：\n" +
                "成吉思汗去世后，阿骨打继续为其子窝阔台和孙子蒙哥等统治者效力，担任军事和政治领导角色。\n" +
                "后续影响：\n" +
                "阿骨打在蒙古帝国的建立和扩展过程中发挥了重要作用，他的领导和战略才能为蒙古帝国的崛起奠定了基础。\n" +
                "逝世：\n" +
                "阿骨打于1227年去世，其死后对蒙古帝国的继续扩展和治理有一定影响，尽管他的子孙在后来的蒙古政治中逐渐边缘化。");
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


