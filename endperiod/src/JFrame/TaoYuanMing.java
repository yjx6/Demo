package JFrame;

import javax.swing.*;
import java.awt.*;

public class TaoYuanMing {
    public TaoYuanMing() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-陶渊明");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\陶渊明.png"); // 替换为你的图片路径
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
        descriptionArea.setText("陶渊明（公元352年-公元427年），字元亮，号素隐，是中国东晋末期至南北朝时期著名的文学家、诗人和理学家。以下是对他的简要介绍：\n" +
                "生平与背景：\n" +
                "陶渊明出生于东晋末年的吴郡吴县（今江苏苏州），家境优越，早年即显出文学才华。\n" +
                "政治生涯与归隐：\n" +
                "陶渊明曾经历过辉煌的官场生涯，担任过郎中、尚书郎等官职，但他对时局的失望与厌恶使他最终选择了归隐田园，过起了隐居生活。\n" +
                "文学成就：\n" +
                "陶渊明的文学作品以田园诗最为著名，他通过描绘自然景物和田园生活，表达了对政治腐败和社会动荡的失望，同时寄托了对理想生活的向往和追求。代表作品包括《归园田居》、《桃花源记》等。\n" +
                "思想贡献：\n" +
                "陶渊明不仅在文学上有重大影响，他的理学思想也对后世产生了深远的影响。他提出了“清静无为”、“怀古伤今”等重要的理念，成为中国古代文人士大夫文化中的重要代表之一。\n" +
                "影响与传世：\n" +
                "陶渊明的作品流传广泛，对后代文人、诗人、书法家等有深远的影响。他被后人尊称为“田园诗之祖”，是中国文学史上不可或缺的重要人物之一。\n" +
                "综上所述，陶渊明以其卓越的文学才华和独特的理学思想，成为了中国文学史上的经典代表，对后世文化产生了深远影响。");
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


