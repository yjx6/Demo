package JFrame;

import javax.swing.*;
import java.awt.*;

public class Yuan {
    public Yuan() {
        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-元朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\元朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("元朝（1271年-1368年）是中国历史上由蒙古人建立的一个重要朝代，以下是对元朝的简要介绍：\n" +
                "建立和统治者：\n" +
                "元朝由成吉思汗的孙子忽必烈于1271年正式建立，取代了宋朝和南宋的统治，定都大都（今北京）。\n" +
                "忽必烈是元朝的建立者和第一位皇帝，他实行了中央集权的政治制度，并且采用了一系列蒙古和汉族相结合的政策来统治广大的中原地区。\n" +
                "政治和社会制度：\n" +
                "元朝采取了严格的官僚制度和行省制度，设立行省、道、州、县等行政区划，实行九品官人制度，并推行蒙古法统治汉地，导致汉人社会地位下降。\n" +
                "经济和文化：\n" +
                "元朝实行的重要政策包括设立了由汉人和蒙古人组成的官僚阶层，并且许多进行。");
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


