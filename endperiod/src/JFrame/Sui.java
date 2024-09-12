package JFrame;

import javax.swing.*;
import java.awt.*;

public class Sui {
    public Sui() {


        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-隋朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\隋朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("隋朝（581年-618年）是中国历史上的一个朝代，是继南北朝时期之后统一中国的第一个朝代，也是中国历史上短暂而重要的一个时期。\n" +
                "隋朝的建立者是隋文帝杨坚，他在统一北方之后，又消灭了南方的陈朝，统一了全国。隋朝的首都设在长安（今西安），后迁都至洛阳。在隋文帝和隋炀帝（杨广）的统治下，隋朝推行了一系列改革措施，包括修筑大运河、推行均田制、改革官制等，对中国社会政治经济都产生了深远影响。\n" +
                "然而，隋朝的统治也面临着内外多种问题，如频繁的战争、高额的徭役赋税以及大规模的工程建设消耗了大量人力物力，加之自然灾害频发，最终导致社会动荡和民怨积聚。618年，隋炀帝被部下李渊所杀，隋朝灭亡，开启了唐朝的建立。\n" +
                "总的来说，隋朝虽然短暂，但在中国历史上却留下了深远的影响，尤其是对后世政治制度和文化发展的影响。");
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


