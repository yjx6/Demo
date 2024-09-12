package JFrame;

import javax.swing.*;
import java.awt.*;

public class HuBiLie {
    public HuBiLie() {
        // 创建主窗口
        JFrame frame = new JFrame("历史人物介绍-忽必烈");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\忽必烈.png"); // 替换为你的图片路径
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
        descriptionArea.setText("忽必烈（1215年-1294年），元朝的第五位皇帝，蒙古帝国第四代大汗，也是成吉思汗的孙子。以下是对他的简要介绍：\n" +
                "早年生涯：\n" +
                "忽必烈出生于成吉思汗的第四子窝阔台之子，他在蒙古帝国的宫廷中长大，接受了丰富的教育和军事训练。\n" +
                "统治与建国：\n" +
                "1260年，忽必烈继位为大汗，开始统治蒙古帝国东部和中原地区。他在中国建立了元朝，定都大都（今北京），并采取了一系列措施推行中央集权的政治体制。\n" +
                "政治和文化政策：\n" +
                "忽必烈实施了多元文化的统治政策，吸纳了汉、契丹、西夏等各族人民，并且大力支持汉文化的复兴和发展，推动了元代文化的繁荣。\n" +
                "经济和社会政策：\n" +
                "他进行了一系列经济改革，如发行纸币、修筑大运河等，促进了经济的繁荣和贸易的发展。\n" +
                "外交与征战：\n" +
                "忽必烈在位期间，通过外交手段保持了与西方国家的联系，向南方的大理、宋朝、南宋等国家发动了多次征战，最终统一了中国南方。\n" +
                "晚年与逝世：\n" +
                "忽必烈晚年对政务逐渐疏忽，但在位期间对元朝政权的巩固和中国统一做出了重要贡献。他于1294年去世，享年80岁，死后由其孙泰定帝继位。");
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


