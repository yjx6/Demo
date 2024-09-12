package JFrame;

import javax.swing.*;
import java.awt.*;

public class ZhuYuanZhang {
    public ZhuYuanZhang() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-朱元璋");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\朱元璋.png"); // 替换为你的图片路径
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
        descriptionArea.setText("朱元璋（1328年-1398年），明朝的开国皇帝，出身贫苦，经历了波折曲折的革命生涯，最终建立了明朝王朝。以下是对他的简要介绍：\n" +
                "早年经历：\n" +
                "朱元璋出生于今江苏省淮安市淮阴区，家境贫寒。少年时曾经历过卖油、捕鱼等苦工。\n" +
                "起义和统一：\n" +
                "朱元璋在14世纪末，率领起义军反抗元朝统治。他在天下大同、赤壁等地取得重要胜利，最终推翻元朝，建立起了以南京为首都的明朝。\n" +
                "统治时期：\n" +
                "朱元璋实行了一系列政治、军事和经济改革，重视农桑、兴修水利、发展文化教育，使得明朝在初期得到了相对稳定和繁荣的发展。\n" +
                "改革与文化政策：\n" +
                "他推行行省制，设立巡抚等中央地方官制度，削弱地方豪强势力，加强中央集权。同时，朱元璋还注重教育、文化的发展，推动了文人墨客的活跃。\n" +
                "晚年与继承：\n" +
                "朱元璋在位期间，对国家建设和社会秩序的维护都有重要贡献。他在1398年逝世，享年71岁。死后由长子朱标继位，即明太祖。\n" +
                "影响与遗产：\n" +
                "朱元璋建立的明朝，经过数百年的发展，成为了中国历史上一个重要的王朝，影响深远。他的统治理念和政治手段，对后世的政治文化产生了深远影响。");
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


