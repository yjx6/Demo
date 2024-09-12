package JFrame;

import javax.swing.*;
import java.awt.*;

public class WangDun {
    public WangDun() {

        // 创建主窗口
        JFrame frame = new JFrame("历史故事介绍-王敦之战");
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
        ImageIcon imageIcon = new ImageIcon("D:\\例子\\王敦之战.png"); // 替换为你的图片路径
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
        descriptionArea.setText("王敦之战，又称为“王敦之乱”，发生于公元吴永安三年（公元313年），是中国晋朝晋愍帝时期的一场内战。王敦，本为晋朝大将军、荆州刺史，因野心勃勃而谋划叛乱，试图篡位称帝。他在扬州发动兵变，逼迫晋愍帝司马衷（后来的晋穆帝）逃往建康（今南京），并自立为大将军、大都督、荆州牧、南中郎将、扬州牧，号称“楚王”。\n" +
                "王敦篡位后，控制了江南和中原的大部分地区，并试图与北方的晋廷对抗。然而，他的野心引起了其他地方豪强的反对和抵抗。当时的益州刺史桓温与司马睿等人联合起来，发动了北伐，旨在恢复晋朝中央政权的统一。桓温率领的晋军先后攻占了江陵（今湖北荆州）、建平（今安徽合肥）、武昌（今湖北武汉）等城市，最终逼迫王敦在淝水之战（公元317年）中战败。\n" +
                "淝水之战是王敦之战的决定性战役，晋军在此次战役中击败了王敦军，王敦本人也被部下所杀，其势力迅速瓦解。此后，晋朝恢复了中央政权的统一，结束了王敦之乱，晋愍帝司马衷重新确立了皇权，继续统治晋朝。\n" +
                "王敦之战不仅是一场内部权力斗争，也是晋朝历史上重要的政治危机和军事斗争，对晋朝政权和社会产生了深远影响。");
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


