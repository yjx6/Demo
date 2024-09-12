package JFrame;

import javax.swing.*;
import java.awt.*;

public class Han {
    public Han(){


        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-汉朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\汉朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("汉朝（公元前202年—公元220年）是中国历史上最重要的朝代之一，分为西汉和东汉两个时期。以下是对汉朝的简要介绍：\n" +
                "\n" +
                "建立与开国皇帝：刘邦在楚汉战争中击败项羽，于公元前202年建立了汉朝，定都长安（今陕西西安）。\n" +
                "\n" +
                "政治制度与改革：刘氏宗亲或功臣治理封国，中央直接管辖郡县。\n" +
                "\n" +
                "汉武帝与大一统：汉武帝加强中央集权，推行“推恩令”削弱诸侯王的力量，并对外扩张。\n" +
                "\n" +
                "经济与文化：实行盐铁官营政策，促进儒家思想的发展。\n" +
                "\n" +
                "新朝：西汉灭亡后，王莽篡位建立新朝，但很快被推翻。\n" +
                "\n" +
                "光武中兴：刘秀恢复了汉朝的统治，定都洛阳。\n" +
                "\n" +
                "衰落与灭亡：东汉末年，黄巾起义导致地方军阀割据，汉朝正式终结，进入三国时期。\n" +
                "\n" +
                "汉朝对中国历史、文化和政治产生了深远影响，包括儒家思想的传承、中央集权制度的发展和丝绸之路的开辟等。");
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


