package JFrame;
import dao.LikeFeatureFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LookHistorical extends JFrame implements ActionListener {
    private JTextField nameField;
    private JButton  searchButton,jiansuButton, collectButton,likeButton;
    private DefaultTableModel tableModel;
    private JTable table;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "Yangjx729803";

    public LookHistorical () {
        setTitle("历史名人表");
        setSize(820, 350);
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
        JLabel jLabel=new JLabel("名人姓名:");
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM historical_table");
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
            JOptionPane.showMessageDialog(this, "请输入要查询的名人", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM historical_table WHERE name LIKE ?";
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
            //调用函数方法
            if (!hasResults) {
                JOptionPane.showMessageDialog(this, "没有找到姓名为: " + nameText + " 的名人", "Info", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }

            rs.close();
            pstmt.close();
            conn.close();
            if (nameText.equals("李白")){
                new LiBai();
            }else if (nameText.equals("伊尹")){
                new YiYin();
            }else if (nameText.equals("嬴政")){
                new YingZheng();
            }else if (nameText.equals("大禹")){
                new DaYu();
            }else if (nameText.equals("周公旦")){
                new ZhouGongDan();
            }else if (nameText.equals("韩信")){
                new HanXin();
            }else if (nameText.equals("完颜阿骨打")){
                new WanYanAGuDa();
            }else if (nameText.equals("忽必烈")){
                new HuBiLie();
            }else if (nameText.equals("曾国藩")){
                new ZengGuoFan();
            }else if (nameText.equals("朱元璋")){
                new ZhuYuanZhang();
            }else if (nameText.equals("窦建德")){
                new DouJianDe();
            }else if (nameText.equals("陶渊明")){
                new TaoYuanMing();
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

        String historicalName = tableModel.getValueAt(selectedRow, 0).toString(); // Assuming the second column is the name

        try {
            // 获取当前时间
            java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO collect_table ( collect_time,collect_type, collect_name) VALUES (?, ? ,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, username);
            pstmt.setTimestamp(1, currentTime);
            //设置 SQL 查询或更新语句中的参数
            pstmt.setString(2, "名人");
            pstmt.setString(3, historicalName);
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
            //用来打印异常堆栈信息的方法。
            JOptionPane.showMessageDialog(this, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}


