package JFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LookCollect extends JFrame implements ActionListener {
    private JTextField nameField;
    private JButton searchButton, jiansuButton, deleteButton;
    private DefaultTableModel tableModel;
    private JTable table;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "Yangjx729803";

    public LookCollect() {
        setTitle("收藏夹");
        setSize(520, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);

        nameField = new JTextField(10);
        searchButton = new JButton("查询");
        jiansuButton = new JButton("查看所有收藏");
        deleteButton = new JButton("移除收藏");
        searchButton.setFont(new Font("宋体", Font.BOLD, 20));
        jiansuButton.setFont(new Font("宋体", Font.BOLD, 20));
        deleteButton.setFont(new Font("宋体", Font.BOLD, 20));
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel jLabel = new JLabel("查询收藏类型:");
        jLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(jLabel);
        inputPanel.add(nameField);
        inputPanel.add(searchButton);
        inputPanel.add(jiansuButton);
        inputPanel.add(deleteButton);


        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(table.getFont().deriveFont(16f)); // 设置表格数据字体大小为16

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        searchButton.addActionListener(this);
        jiansuButton.addActionListener(this);
        deleteButton.addActionListener(this);


        refreshTable();
    }

    private void refreshTable() {
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM collect_table");
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
            searchCollectByName();
            table.repaint();
        } else if (e.getSource() == jiansuButton) {
            refreshTable();
        } else if (e.getSource() == deleteButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Make sure a row is selected
                Timestamp time = (Timestamp) table.getValueAt(selectedRow, 0); // Assuming the name is in the second column
                int confirm = JOptionPane.showConfirmDialog(this, "确定要删除收藏时间为 " + time + " 的收藏吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    deleteCollectByName(time);
                }
            }else {
                JOptionPane.showMessageDialog(this, "请选择要删除的收藏");
            }
        }
    }
    //删除
    private void deleteCollectByName(Timestamp time) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM collect_table WHERE collect_time = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, time);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "成功删除收藏时间为为 " + time + " 的收藏", "Info", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "未找到时间为 " + time + " 的收藏", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库错误", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //查
    private void searchCollectByName() {
        String nameText = nameField.getText().trim();
        if (nameText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入要查询的收藏类型", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM collect_table WHERE collect_type LIKE ?";
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
                JOptionPane.showMessageDialog(this, "没有找到姓名为: " + nameText + " 的名人", "Info", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Ensure the table gets refreshed
        table.repaint();
    }

    public static void main(String[] args) {
        new LookCollect().setVisible(true);
    }

}


