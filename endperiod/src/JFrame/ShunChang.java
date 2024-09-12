package JFrame;

import javax.swing.*;
import java.awt.*;

public class ShunChang {
    public ShunChang() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-顺昌之战");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\顺昌之战.png"); // 替换为你的图片路径
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
        descriptionArea.setText("顺昌之战，发生于公元251年，是中国三国时期的一场重要战役，也是吴国与东吴之间的一次关键军事对抗。\n" +
                "在这场战役中，吴国的大将军孙峻率领吴军进攻东吴首都建业（今江苏南京）。当时，东吴的大将军孙权亲自率领军队防守建业。孙权派遣他的部将陆逊与朱桓等人在石头城（今江苏南京六合区一带）设伏，以阻击孙峻的进攻。\n" +
                "孙峻率领的吴军在进攻建业的途中，遭到了陆逊的伏击。陆逊等人出其不意地攻击了吴军，吴军在混乱中受到重创，孙峻也在战斗中被俘。这场战斗是孙权在建业成功防御吴军进攻的一个重要事件，也显示了东吴在陆逊等将领的指挥下的战斗能力和战略灵活性。\n" +
                "顺昌之战的结果加强了东吴的地位，并对吴国的威胁构成了有效的回应，同时也为东吴在三国时期的统治打下了坚实的基础。");
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


