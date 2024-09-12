package JFrame;

import javax.swing.*;
import java.awt.*;

public class ZengGuoFan {
    public ZengGuoFan() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-曾国藩");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\曾国藩.png"); // 替换为你的图片路径
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
        descriptionArea.setText("曾国藩（1811年-1872年），清朝末期著名的军事家、政治家和改革家，以其改革军制和提倡“己所不欲，勿施于人”的治国理政理念而著称。以下是对他的简要介绍：\n" +
                "早年经历：\n" +
                "曾国藩出生于湖南省浏阳县一个书香门第，早年接受了传统的儒学教育，尤其擅长经学。\n" +
                "军事生涯：\n" +
                "曾国藩在清朝军队中崭露头角，以其精湛的军事才能和战略眼光，多次在太平军起义和捻军起义等战役中立下赫赫战功，特别是在平定太平天国运动中表现突出。\n" +
                "政治贡献：\n" +
                "曾国藩主张“革故立新”，提倡实事求是的改革思想。他在江南一带实行精兵简政，推行教育改革，倡导勤政治国，积极推动地方官制度改革，使得当地政治和社会稳定并得到有效治理。\n" +
                "理学思想：\n" +
                "曾国藩深受程朱理学影响，主张“存天理，灭人欲”，强调修身、齐家、治国、平天下，主张儒家治国思想在实践中的应用。\n" +
                "影响与遗产：\n" +
                "曾国藩的改革成就和治国理政理念影响深远，他的“己所不欲，勿施于人”的治国原则被后人奉为经典。他的子孙也多为清朝官员和学者，延续了其家族的影响力。\n" +
                "逝世：\n" +
                "曾国藩于1872年去世，享年61岁。他被后人尊称为“曾文正公”，是中国近代史上一位卓越的政治家和改革家。");
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


