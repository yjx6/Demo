package JFrame;

import javax.swing.*;
import java.awt.*;

public class LiBai {
    public LiBai() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-李白");
        frame.setDefaultCloseOperation(1);
        frame.setSize(800, 480); // 调整窗口大小
        frame.setLocationRelativeTo(null);
        // 使用GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // 左侧放置图片
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\李白.png"); // 替换为你的图片路径
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
        descriptionArea.setText("李白（701年－762年），唐代著名诗人，字太白，号青莲居士。他是中国古代最伟大的浪漫主义诗人之一，被誉为“诗仙”。李白的诗作以豪放、奔放、豪迈著称，表达了对自然、酒、友谊和人生的热爱与向往。他的诗风开阔奔放，富有想象力，擅长描绘壮丽的山水景色和豪放的情感，留下了许多脍炙人口的经典之作。\n" +  "李白的诗歌作品流传甚广，包括《将进酒》、《庐山谣》、《行路难》等，其中《将进酒》中的“举杯邀明月，对影成三人”和“天生我材必有用，千金散尽还复来”等诗句至今仍被人津津乐道。李白的诗歌对后世的诗歌创作产生了深远的影响，被誉为中国古典诗歌史上的杰出代表之一。");
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


