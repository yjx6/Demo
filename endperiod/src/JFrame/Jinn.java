package JFrame;

import javax.swing.*;
import java.awt.*;

public class Jinn {
    public Jinn() {
        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-晋朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\晋朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("晋朝（265年-420年）是中国历史上的一个朝代，分为西晋和东晋两个时期：\n" +
                "西晋（265年-316年）：\n" +
                "西晋由司马炎建立于公元265年，取代了曹魏，定都洛阳。司马炎篡位后，建立了中央集权的政治体制，实行了一系列改革措施，如重农抑商政策，尝试稳定国家局势和治理经济。\n" +
                "西晋初期国力复兴，文化较为繁荣，但后期由于统治者能力不足、外戚势力抬头以及各种内外因素影响，国家逐渐衰落。\n" +
                "东晋（317年-420年）：\n" +
                "东晋由晋愍帝于317年在建康（今南京）建立，定都南京。东晋时期经历了多次内乱和外患，北方少数民族的侵袭使得政权动荡不安。\n" +
                "尽管政治上不稳定，东晋时期文化艺术仍有显著成就，如王羲之、谢安等人物的活跃，留下了许多珍贵的文学作品和艺术品。\n" +
                "晋朝虽然存在时间不长，但其时期对中国历史文化的发展影响深远。其政治变革、文化繁荣和社会变迁，都为后世留下了重要的历史遗产。");
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


