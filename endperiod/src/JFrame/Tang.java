package JFrame;

import javax.swing.*;
import java.awt.*;

public class Tang {
    public Tang() {


        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-唐朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\唐朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("唐朝（618年—907年）是中国历史上一个重要且辉煌的朝代，以下是对唐朝的简要介绍：\n" +
                "\n" +
                "建立与开国皇帝\n" +
                "建立：唐朝由李渊于618年建立，定都长安（今陕西西安）。\n" +
                "开国皇帝：李渊即唐高祖，在其子李世民（唐太宗）的协助下稳固了政权。\n" +
                "贞观之治\n" +
                "唐太宗李世民：通过“玄武门之变”即位，推行了一系列改革措施，促进了社会稳定和经济发展。\n" +
                "贞观之治：这一时期的政治清明、社会安定、经济繁荣，被誉为“贞观之治”。\n" +
                "武则天与盛唐时期\n" +
                "武则天：中国历史上唯一的女皇帝，通过一系列手段掌握实权，改国号为周（690年—705年），后恢复唐朝。\n" +
                "开元盛世：唐玄宗李隆基统治前期（713年—741年），政治清明、经济繁荣，史称“开元盛世”。\n" +
                "经济与文化\n" +
                "经济繁荣：农业、手工业和商业高度发达，丝绸之路使中外贸易更加繁荣。\n" +
                "文化开放：唐朝文化多样且包容，吸收外来文化，出现了大量文化交流和艺术成就，如诗歌、绘画和音乐。\n" +
                "对外关系与军事\n" +
                "对外扩张：唐朝对外实行积极的外交和军事政策，疆域达到鼎盛时期，包括今新疆、中亚等地。\n" +
                "军事力量：设立府兵制，形成强大的军事实力。\n" +
                "衰落与灭亡\n" +
                "安史之乱：755年爆发的安史之乱严重削弱了唐朝的国力，导致中央权威下降，地方割据势力崛起。\n" +
                "后期动荡：唐朝后期，藩镇割据严重，宦官专权，社会矛盾加剧。\n" +
                "灭亡：907年，朱温篡位，建立后梁，唐朝正式灭亡。\n" +
                "影响\n" +
                "文化遗产：唐朝在文学、绘画、音乐、舞蹈等方面取得了辉煌成就，特别是唐诗影响深远。\n" +
                "国际影响：唐朝与周边国家和地区的广泛交往促进了文化、经济的交流，对东亚乃至世界历史产生了重要影响。\n" +
                "唐朝是中国历史上的一个黄金时代，其开放包容的文化政策、强大的经济和军事力量使其成为当时世界上最强大的帝国之一。");
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


