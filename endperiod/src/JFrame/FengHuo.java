package JFrame;

import javax.swing.*;
import java.awt.*;

public class FengHuo {
    public FengHuo() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-烽火戏诸侯");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\烽火戏诸侯.png"); // 替换为你的图片路径
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
        descriptionArea.setText("烽火戏诸侯是中国历史上的一个著名故事，发生在西周时期，讲述了周幽王为博取宠妃褒姒一笑而点燃烽火台的事件。\n" + "周幽王宠爱褒姒，却发现她很少笑。为了让她开心，周幽王想出了一个荒唐的办法。他命人点燃烽火台，这本是用来传递敌人入侵信号的装置。看到烽火台燃起，周围的诸侯们以为有敌人入侵，便纷纷带兵前来救援。然而，当他们赶到时才发现没有敌情，只是周幽王在作戏。\n" + "虽然褒姒因此开怀大笑，但这次虚假的警报导致诸侯们对周幽王失去了信任。当真正的敌人犬戎入侵时，诸侯们不再响应援助，最终导致周幽王被杀、西周灭亡。\n" + "这个故事常被用来警示统治者不可滥用权力和资源，以免失去臣民和盟友的信任。");
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


