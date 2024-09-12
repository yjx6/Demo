package JFrame;

import javax.swing.*;
import java.awt.*;

public class Jin {
    public Jin() {


        // 创建主窗口
        JFrame frame = new JFrame("历史朝代介绍-金朝");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\金朝.png"); // 替换为你的图片路径
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
        descriptionArea.setText("金朝（1115年-1234年）是中国历史上的一个重要朝代，由契丹族人所建立。它的建立者是耶律阿保机，他改国号为金，定都中都（今北京附近），后迁都至汴京（今河南开封）。金朝是继北宋之后的中国北方政权，统治范围包括今天的中国东北、华北及黄河流域中部。\n" +
                "金朝的建立标志着中国历史上北方游牧民族的再次统治。金朝在其统治初期与北宋展开长达数十年的战争，最终于1127年攻破了北宋的都城汴京，俘虏了宋徽宗、宋钦宗，结束了北宋的统治。此后，南宋在南方建立，金朝与南宋之间保持了长期的对峙局面。\n" +
                "金朝的统治时期，政权强盛，国力强大，但也面临着与南宋的长期战争、边疆民族的压力以及内部社会经济问题等挑战。1234年，蒙古军队攻破金朝都城中都，金朝灭亡，结束了其约120年的统治。\n" +
                "金朝在中国历史上的地位复杂，它既继承了北方政权的传统，又与南宋展开了持久的对抗，对中国政治、文化及社会发展都有一定的影响和遗产。");
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


