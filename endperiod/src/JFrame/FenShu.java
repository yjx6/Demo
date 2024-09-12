package JFrame;

import javax.swing.*;
import java.awt.*;

public class FenShu {
    public FenShu() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-焚书坑儒");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\焚书坑儒.png"); // 替换为你的图片路径
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
        descriptionArea.setText("焚书坑儒是指秦始皇时期的一起事件，当时秦始皇下令烧毁大量书籍并活埋许多儒士。这一事件成为中国历史上对知识和思想进行压制的著名事例。\n" + "在统一六国后，秦始皇为了加强中央集权、巩固统治，采取了一系列措施。他认为各地的典籍和儒生的思想有可能威胁到他的统治，于是在公元前213年，下令焚毁除医药、占卜、农业以外的所有书籍，以防止人们借古非今、批评当政者。\n" + "一年后，有儒生因议论时政而被揭发，秦始皇大怒，下令把这些儒生（主要是方士和术士）全部活埋，这就是所谓的“坑儒”事件。\n" + "焚书坑儒事件对中国的文化和思想造成了巨大的损害，使许多珍贵的典籍失传，同时也标志着秦朝对思想控制的极端手段。尽管如此，这一事件也激起了后世对言论自由和思想开放的重要思考。");
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


