package JFrame;

import javax.swing.*;
import java.awt.*;

public class XinHai {
    public XinHai() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-辛亥革命");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\辛亥革命.png"); // 替换为你的图片路径
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
        descriptionArea.setText("辛亥革命，即辛亥中国革命，是中国近代史上一场重要的政治革命，发生于1911年（辛亥年）。这场革命最终导致了清朝统治的终结，开辟了中国近代化的新篇章。\n" +
                "革命的直接导火线是1911年10月10日（农历辛亥年九月十日）武昌起义爆发。起义由新军革命党人领导，主要起义领导人包括孙中山、黄兴等。武昌起义迅速蔓延到湖北省各地以及长江流域的其他地区，大部分新军和地方武装纷纷响应，反对清朝统治。\n" +
                "革命的主要目标是推翻清朝满族统治，建立一个民主共和的新中国。起义军主张“驱逐鞑虏，恢复中华”，提倡国民革命，反对封建专制和外国侵略。在起义的推动下，许多省份相继宣布独立，并成立临时政府或临时议会，如南京临时政府、广州临时政府等。\n" +
                "革命的高潮是1912年2月12日，清朝最后一位皇帝溥仪宣布退位，清朝灭亡。此后，孙中山于同年1月1日在南京就任临时大总统，建立中华民国，标志着中国历史上近两千年封建帝制的终结，开启了民主共和国家的新时代。\n" +
                "辛亥革命不仅改变了中国政治制度，还对中国社会文化、经济结构产生了深远影响，奠定了中国近代化的基础。");
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


