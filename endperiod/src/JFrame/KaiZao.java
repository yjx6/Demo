package JFrame;

import javax.swing.*;
import java.awt.*;

public class KaiZao {
    public KaiZao() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-开凿大运河");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\开凿大运河.png"); // 替换为你的图片路径
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
        descriptionArea.setText("开凿大运河是中国古代一项伟大的工程，指的是在隋朝时期（公元581年至618年）开始，通过人工劳动开凿、修建的京杭大运河，连接了中国北方的黄河流域和南方的长江流域，成为了中国古代最重要的水利工程之一。\n" +
                "大运河的主要目的是便于军事调动、粮食输送和商业贸易。它起始于隋朝的都城洛阳（今河南省洛阳市），沿途经过多个重要的城市和地区，最终抵达江南的扬州（今江苏省扬州市）。运河全长约1794公里，是世界上最早、最长的人工运河之一，也是连接南北交通的重要纽带。\n" +
                "隋朝开凿大运河的动机包括加强中央政府对全国各地的控制，促进经济发展，加强各地之间的联系。隋炀帝杨广下令修建大运河，历时多年，消耗了大量人力物力，但最终成功建成并运行良好。大运河的开通，极大地促进了中国社会的经济发展和文化交流，对后世的交通运输和城市发展产生了深远影响。\n" +
                "大运河在中国历史上具有重要的地位，直到今天仍然是中国水运文化的象征之一，被联合国教科文组织列为世界文化遗产。");
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


