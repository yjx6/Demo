package JFrame;
import dao.LikeFeatureFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LookStory extends JFrame implements ActionListener {
    private JTextField nameField;
    private JButton  searchButton,jiansuButton, collectButton,likeButton;
    private DefaultTableModel tableModel;
    private JTable table;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "Yangjx729803";

    public LookStory () {
        setTitle("历史故事表");
        setSize(480, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);

        nameField = new JTextField(10);
        searchButton = new JButton("查询");
        jiansuButton=new JButton("全部检索");
        collectButton=new JButton("收藏");
        likeButton=new JButton("点赞");
        searchButton.setFont(new Font("宋体", Font.BOLD, 20));
        jiansuButton.setFont(new Font("宋体", Font.BOLD, 20));
        collectButton.setFont(new Font("宋体", Font.BOLD, 20));
        likeButton.setFont(new Font("宋体", Font.BOLD, 20));
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel jLabel=new JLabel("故事名称:");
        jLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(jLabel);
        inputPanel.add(nameField);
        inputPanel.add(searchButton);
        inputPanel.add(jiansuButton);
        inputPanel.add(collectButton);
        inputPanel.add(likeButton);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(table.getFont().deriveFont(16f)); // 设置表格数据字体大小为16

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        searchButton.addActionListener(this);
        jiansuButton.addActionListener(this);
        collectButton.addActionListener(this);
        likeButton.addActionListener(this);

        refreshTable();
    }

    private void refreshTable() {
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM story_table");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            searchHistoricalByName();
            table.repaint();
        }else if (e.getSource()==jiansuButton){
            refreshTable();
        }else if (e.getSource() == collectButton) {
            collectSelectedRow();
        }else if (e.getSource()==likeButton){
            new LikeFeatureFrame();
        }
    }
    //查
    private void searchHistoricalByName() {
        String nameText = nameField.getText().trim();
        if (nameText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入要查询的故事", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM story_table WHERE story_name LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + nameText + "%");  // 模糊匹配
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            tableModel.setRowCount(0); // Clear all existing rows
            tableModel.setColumnCount(0);
            // Add column names
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            boolean hasResults = false;
            // Add rows
            while (rs.next()) {
                hasResults = true;
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

            if (!hasResults) {
                JOptionPane.showMessageDialog(this, "没有找到包含: " + nameText + " 的故事", "Info", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }

            rs.close();
            pstmt.close();
            conn.close();
            if (nameText.equals("商汤灭夏")){
                new ShangTang();
            }else if (nameText.equals("大禹治水")){
                new ZhiShui();
            }else if (nameText.equals("安史之乱")){
                new AnShi();
            }else if (nameText.equals("楚汉之争")){
                new ChuHan();
            }else if (nameText.equals("烽火戏诸侯")){
                new FengHuo();
            }else if (nameText.equals("焚书坑儒")){
                new FenShu();
            }else if (nameText.equals("文永之役")){
                new WenYong();
            }else if (nameText.equals("明灭元之战")){
                new MingMie();
            }else if (nameText.equals("王敦之乱")){
                new WangDun();
            }else if (nameText.equals("辛亥革命")){
                new XinHai();
            }else if (nameText.equals("顺昌之战")){
                new ShunChang();
            }else if (nameText.equals("开凿大运河")){
                new KaiZao();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Ensure the table gets refreshed
        table.repaint();
    }
    //收藏
    private void collectSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请选择要收藏的行", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String storyName = tableModel.getValueAt(selectedRow, 0).toString(); // Assuming the second column is the name

        try {
            // 获取当前时间
            java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO collect_table (collect_time ,collect_type, collect_name) VALUES (?, ? ,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, username);
            pstmt.setTimestamp(1, currentTime);
            pstmt.setString(2, "故事");
            pstmt.setString(3, storyName);



            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "收藏成功", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "收藏失败", "Error", JOptionPane.ERROR_MESSAGE);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}


