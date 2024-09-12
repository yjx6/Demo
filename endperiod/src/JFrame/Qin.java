package JFrame;

import javax.swing.*;
import java.awt.*;

public class Qin {
    public Qin() {


        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-秦朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\秦朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("秦朝，是中国历史上第一个中央集权的封建王朝，存在于公元前221年至公元前206年。虽然秦朝的统治时间较短，但其在中国历史上的影响深远。以下是关于秦朝的详细介绍：\n" +
                "\n" +
                "建立与统一\n" +
                "始皇帝与统一：秦朝由嬴政建立，他在灭掉六国（韩、赵、魏、楚、燕、齐）之后，于公元前221年自称始皇帝，即秦始皇。秦始皇统一了中国，结束了春秋战国时期的分裂局面，建立了第一个多民族的中央集权国家。\n" +
                "\n" +
                "政治制度\n" +
                "中央集权：秦朝建立了高度集权的政治体制，将全国划分为三十六郡，实行郡县制，官员由中央直接任命，这一制度为后来的历代王朝所沿用。\n" +
                "\n" +
                "法家思想：秦朝依靠法家思想治国，重视法治，制定了一系列严苛的法律，用以巩固统治。法家代表人物李斯是秦始皇的重要辅佐者，推动了许多改革。\n" +
                "\n" +
                "经济与文化\n" +
                "统一度量衡与货币：秦朝统一了度量衡、货币和文字，促进了全国的经济交流和文化融合。统一的货币是圆形方孔钱，方便交易和商业活动的发展。\n" +
                "\n" +
                "修筑基础设施：秦朝修建了许多重要的基础设施，包括驰道（通往各地的道路系统）、灵渠（连接湘江和漓江的运河）和著名的长城，用来防御北方的匈奴入侵。\n" +
                "\n" +
                "秦朝的衰落与灭亡\n" +
                "暴政与反抗：秦朝的法律过于严苛，劳役繁重，引起了广大人民的不满。农民起义频繁发生，其中陈胜吴广起义是最著名的一次，揭开了秦朝覆灭的序幕。\n" +
                "\n" +
                "胡亥与赵高：秦始皇死后，其子胡亥即位，即秦二世。在宦官赵高的操纵下，秦二世施行更加严厉的统治，导致民怨沸腾。最终，秦朝在公元前206年被刘邦领导的起义军推翻，建立了汉朝。\n" +
                "\n" +
                "影响\n" +
                "尽管秦朝统治时间短暂，但它在中国历史上具有深远的影响。秦朝奠定了中国中央集权制度的基础，统一的度量衡、货币和文字促进了全国的经济文化交流。秦始皇作为中国历史上第一位皇帝，他的功绩和过失都成为后世不断讨论的话题。");
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


