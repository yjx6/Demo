package JFrame;

import javax.swing.*;
import java.awt.*;

public class Zhou {
    public Zhou() {


        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-周朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\周朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("周朝是中国历史上的一个重要王朝，存在于公元前1046年至公元前256年。周朝分为西周和东周两个时期，其中西周时期从公元前1046年开始，到公元前771年，然后是东周时期，从公元前770年一直延续到公元前256年。\n" +
                "\n" +
                "西周\n" +
                "西周建立者是周武王，他推翻了商朝的暴虐统治，建立了西周王朝。周武王实行了许多改革措施，提出了“王道”思想，即君主以仁德治国，顺天应时，这一思想成为中国古代政治文化的重要组成部分。\n" +
                "\n" +
                "在西周时期，封建制度得到进一步发展，周王将大片领土封赏给亲信的贵族，形成了诸侯分封制度。同时，铸造青铜器达到了鼎盛时期，青铜礼器和青铜乐器成为了西周文明的代表。\n" +
                "\n" +
                "东周\n" +
                "东周时期分为春秋时代和战国时代两个阶段。\n" +
                "\n" +
                "春秋时代：春秋时期是一个诸侯割据、战国纷争的时期。《春秋》是东周时期的一部史书，记载了鲁国史官左丘明编写的历史，成为了中国古代第一部编年体史书。春秋时期逐渐形成了分封诸侯、争霸称王的局面，也是儒家学派的发源地，提出了“仁义礼智信”等重要思想。\n" +
                "\n" +
                "战国时代：战国时期是中国历史上战争最频繁、变化最剧烈的时期之一。七雄争霸，相互征战，但同时也促进了各种思想文化的交流和碰撞。儒家、道家、墨家、法家等诸子百家的思想开花结果，在这一时期相继形成。\n" +
                "\n" +
                "结束\n" +
                "周朝在列国纷争和内部腐败的情况下，最终被秦国所灭，结束了约800年的统治。秦始皇统一六国后建立秦朝，开创了中国封建时代的新纪元。\n" +
                "\n" +
                "周朝的历史对后世影响深远，其政治制度、文化传统对后来的中国历史产生了深刻影响，而周文化中一些核心价值观和思想也一直延续至今，成为了中国传统文化的重要组成部分。");
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


