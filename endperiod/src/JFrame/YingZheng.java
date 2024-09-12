package JFrame;

import javax.swing.*;
import java.awt.*;

public class YingZheng {
    public YingZheng() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-嬴政");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\嬴政.png"); // 替换为你的图片路径
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
        descriptionArea.setText("秦始皇嬴政（公元前259年－公元前210年），中国历史上的重要统治者之一，也是秦朝的建立者和第一位皇帝。嬴政在位时，通过对内割据诸侯、推行中央集权，对外征服六国，统一了中国大部分地区，实现了中国历史上第一个统一的封建王朝。他还推行了一系列重要的改革，包括统一货币、度量衡和文字，修筑了万里长城，推行了统一的法律制度等，为后世中国的发展奠定了基础。然而，他的统治也存在着严酷的政治手段和苛刻的统治制度，例如焚书坑儒和强迫劳役等措施，这些也导致了他在历史上受到争议。");
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


