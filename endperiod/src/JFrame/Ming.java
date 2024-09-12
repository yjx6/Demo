package JFrame;

import javax.swing.*;
import java.awt.*;

public class Ming {
    public Ming() {
        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-明朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\明朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("明朝（1368年-1644年）是中国历史上一个重要的朝代，其建立者是朱元璋。以下是对明朝的简单介绍：\n" +
                "建立和初期（1368年-1402年）：\n" +
                "明朝由朱元璋于1368年推翻了元朝统治，建立首都南京。朱元璋经过数年的战乱和统一，确立了明朝的统治，采取了一系列改革措施，如实行重农抑商政策、设立行省制度等。\n" +
                "成熟与繁荣（1402年-1600年）：\n" +
                "明朝在永乐年间（1402年-1424年）达到了政治、经济和文化的鼎盛时期，明成祖朱棣在位期间进行了多次北伐和海外探险（郑和下西洋），使得明朝在国际上也有一定影响力。\n" +
                "社会经济在此期间较为繁荣，文化艺术也迎来了一段辉煌时期，如文学家唐寅、戏剧家汤显祖等都有重要贡献。\n" +
                "衰落和灭亡（1600年-1644年）：\n" +
                "明朝中后期，由于多种因素，如内部腐败、社会动荡、民族问题等，国家逐渐走向衰落。同时，外部的威胁如后金的崛起也加速了明朝的衰亡进程。\n" +
                "最终，明朝在1644年由李自成领导的农民起义军攻入北京，明思宗自杀，标志着明朝的灭亡。\n" +
                "总体来说，明朝在中国历史上是一个政治相对稳定、文化较为繁荣的朝代，对中国社会的发展和文化的传承有着重要的影响。");
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


