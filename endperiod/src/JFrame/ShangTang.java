package JFrame;

import javax.swing.*;
import java.awt.*;

public class ShangTang {
    public ShangTang() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-商汤灭夏");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\商汤灭夏.png"); // 替换为你的图片路径
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
        descriptionArea.setText("商汤灭夏是中国古代历史中的一个重要事件，标志着夏朝的终结和商朝的建立。据传说，夏朝的最后一位君主桀因暴虐无道，失去了民心和诸侯的支持。商汤，原本是夏朝的一个诸侯，在有贤臣伊尹的辅佐下，逐步积蓄力量。\n" + "汤在各地得到广泛支持后，于鸣条（今河南省境内）与桀进行决战，最终击败了桀的军队，推翻了夏朝。桀被流放，最终死在南巢（今安徽巢湖一带）。商汤随后建立了商朝，定都亳（今河南商丘），并成为商朝的开国君主。\n" + "这个故事反映了古代中国“天命”思想，即统治者必须有德行以获得天命，失去德行即失去统治的合法性。商汤灭夏也被后世视为正义战胜暴政的象征。");
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


