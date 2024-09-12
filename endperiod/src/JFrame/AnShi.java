package JFrame;

import javax.swing.*;
import java.awt.*;

public class AnShi {
    public AnShi() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-安史之乱");
        frame.setDefaultCloseOperation(1);
        frame.setSize(800, 480); // 调整窗口大小
        frame.setLocationRelativeTo(null);
        // 使用GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setBackground(new Color(240, 240, 0)); // 设置背景颜色，这里使用浅灰色
//        panel.setBackground(Color.white); // 设置背景颜色，这里使用浅灰色
        GridBagConstraints c = new GridBagConstraints();
//GridBagConstraints是用来控制GridBagLayout布局管理器中组件布局的一个约束条件类。
//通过设置GridBagConstraints的属性（例如gridx、gridy、weightx、weighty等），可以控制组件在网格中的行为，如位置、大小、对齐方式等。
        // 左侧放置图片
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\安史之乱.png"); // 替换为你的图片路径
        //ImageIcon是一个Swing组件，用于加载和显示图像。
        Image image = imageIcon.getImage(); // 将ImageIcon转换为Image对象
        Image newImage = image.getScaledInstance(400, 410, Image.SCALE_SMOOTH); // 调整图片大小
        //image.getScaledInstance(width, height, hints)根据指定的宽度和高度调整图像大小。Image.SCALE_SMOOTH是一个图像缩放的提示，表示缩放过程中使用平滑缩放算法
        ImageIcon newImageIcon = new ImageIcon(newImage); // 将调整后的Image转换为ImageIcon
        imageLabel.setIcon(newImageIcon);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(imageLabel, c);
//c.gridx和c.gridy指定了组件在GridBagLayout布局中的列和行索引。
//c.insets设置了组件与其周围组件的间距，这里是上、左、下、右各为10个像素。
//panel.add(imageLabel, c)将imageLabel添加到panel面板中，并应用GridBagConstraints对象c来指定其位置和布局方式。
        // 右侧放置人物介绍
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;
        //c.gridx = 1表示该组件将放置在第1列。
        //c.weightx = 1.0表示在布局过程中，该列将占据额外的水平空间。
        //c.fill = GridBagConstraints.BOTH表示组件应该在水平和垂直方向上填充可用空间，以确保其占据了整个空间。
        Font font = new Font("宋体", Font.PLAIN, 22); // 设置宋体字体，大小16
        JTextArea descriptionArea = new JTextArea(10, 30);
        descriptionArea.setText("安史之乱是中国历史上发生在唐朝时期的一场重大政治动乱。这场动乱由唐朝末年宦官安禄山和史思明领导的叛乱引发。\n" + "安禄山是唐朝后宫的一个宦官，他积累了大量势力和财富，对朝廷产生了野心。于755年，安禄山起兵叛乱，自称帝号，史称“安史之乱”。他在中原地区聚集了大量的军队，占领了洛阳等重要城市，并向东南方向扩张势力。\n" + "唐朝皇帝李隆基被迫逃离长安，向西北地区的藩镇寻求支援。而安禄山的叛乱也得到了回纥、吐蕃等少数民族的支持。然而，叛乱持续了将近8年，期间发生了许多战斗和政治变动。\n" + "最终，唐朝皇帝李亨（唐肃宗）亲自领军，与安禄山的儿子安慰山展开激战。安禄山的军队内部也发生了分裂，导致了他的失败和死亡。安史之乱最终在763年平定，唐朝重新恢复了稳定。\n" + "安史之乱造成了巨大的人员伤亡和经济破坏，对唐朝的统治造成了严重的影响，使唐朝的中央集权逐渐削弱，地方势力得以崛起。这场动乱也被视为中国古代历史上最大规模的内乱之一。");
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);//文本是否自动换行的属性。
        descriptionArea.setEditable(false);
        descriptionArea.setFont(font);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        panel.add(scrollPane, c);

        // 显示窗口
        frame.add(panel);
        frame.setVisible(true);
    }
}


