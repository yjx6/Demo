package JFrame;

import javax.swing.*;
import java.awt.*;

public class Shang {
    public Shang() {


        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-商朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\商朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("商朝是中国历史上第二个王朝，大约存在于公元前1600年至公元前1046年。商朝在许多方面对后来的中华文明产生了深远的影响，尤其是在文字、宗教和社会结构等领域。\n" +
                "\n" +
                "起源与建立\n" +
                "商朝的建立者是商汤，他推翻了夏朝的暴君桀，建立了商朝。商汤的成功不仅标志着一个新的王朝的开始，也展示了“天命”思想的雏形，即统治者的合法性与其德行相连。\n" +
                "\n" +
                "商朝的文化与贡献\n" +
                "甲骨文：商朝最显著的文化成就是甲骨文，它是中国已知最早的成体系的文字，为后来的汉字奠定了基础。甲骨文主要用于占卜活动，刻在龟甲或兽骨上，记录了大量的政治、经济、军事及宗教信息。\n" +
                "\n" +
                "青铜器：商朝的青铜器制作工艺达到了很高的水平。青铜器不仅用于日常生活和宗教祭祀，还象征着权力和地位。现存许多精美的青铜器都是商朝时期的遗物。\n" +
                "\n" +
                "宗教与祭祀：商朝的宗教生活以祭祀祖先和崇拜自然神灵为中心。商王被视为神的代言人，拥有至高无上的宗教权威。祭祀活动在政治和社会生活中占有重要地位，甲骨文中记录了大量的占卜和祭祀行为。\n" +
                "\n" +
                "社会与经济\n" +
                "商朝的社会结构较为复杂，分为王族、贵族、平民和奴隶四个主要阶层。农业是经济的基础，手工业也有较大发展，特别是青铜铸造业。商朝还进行了一定程度的商业活动，有证据表明当时已有较为发达的贸易网络。\n" +
                "\n" +
                "都城与疆域\n" +
                "商朝初期的都城为亳（今河南商丘）。后来，商王盘庚迁都至殷（今河南安阳），因此商朝又被称为“殷商”。商朝的疆域较为广阔，包括今天的河南、山东、河北、山西、陕西等地区。\n" +
                "\n" +
                "灭亡\n" +
                "商朝的最后一位君主是纣王，他因暴虐无道、奢靡放纵而失去了民心。在周武王姬发的领导下，周部落联合其他部落起兵讨伐商朝，最终在牧野之战中击败商军，商朝灭亡，周朝建立。\n" +
                "\n" +
                "影响与意义\n" +
                "商朝是中国古代文明发展的重要阶段，其文字、青铜器、宗教礼仪等方面的成就对后来的中华文化产生了深远影响。商朝的历史不仅丰富了中国古代史的内容，也为理解中国早期国家的形成");
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


