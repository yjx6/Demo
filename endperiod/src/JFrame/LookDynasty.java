package JFrame;

import dao.LikeFeatureFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class LookDynasty extends JFrame implements ActionListener {
    private JTextField nameField;
    private JButton searchButton, jiansuButton, collectButton, likeButton;
    private DefaultTableModel tableModel;
    private JTable table;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "Yangjx729803";

    public LookDynasty() {
        setTitle("朝代表");
        setSize(480, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);

        nameField = new JTextField(10);
        searchButton = new JButton("查询");
        jiansuButton = new JButton("全部检索");
        collectButton = new JButton("收藏");
        likeButton = new JButton("点赞");
        searchButton.setFont(new Font("宋体", Font.BOLD, 20));
        jiansuButton.setFont(new Font("宋体", Font.BOLD, 20));
        collectButton.setFont(new Font("宋体", Font.BOLD, 20));
        likeButton.setFont(new Font("宋体", Font.BOLD, 20));
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel jLabel = new JLabel("朝代名称:");
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM dynasty_table");
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
        } else if (e.getSource() == jiansuButton) {
            refreshTable();
        } else if (e.getSource() == collectButton) {
            collectSelectedRow();
        } else if (e.getSource() == likeButton) {
            new LikeFeatureFrame();
        }
    }

    //查
    private void searchHistoricalByName() {
        String nameText = nameField.getText().trim();
        if (nameText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入要查询的朝代", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM dynasty_table WHERE name LIKE ?";
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
                JOptionPane.showMessageDialog(this, "没有找到包含: " + nameText + " 的朝代", "Info", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }

            rs.close();
            pstmt.close();
            conn.close();
            if (nameText.equals("唐朝")) {
                new Tang();
            } else if (nameText.equals("夏朝")) {
                new Xia();
            } else if (nameText.equals("商朝")) {

                new Shang();
            } else if (nameText.equals("周朝")) {
                new Zhou();
            } else if (nameText.equals("秦朝")) {
                new Qin();
            } else if (nameText.equals("汉朝")) {
                new Han();
            } else if (nameText.equals("隋朝")) {
                new Sui();
            }else if (nameText.equals("金朝")) {
                new Jin();
            }else if (nameText.equals("清朝")) {
                new Qing();
            }else if (nameText.equals("晋朝")) {
                new Jinn();
            }else if (nameText.equals("明朝")) {
                new Ming();
            }else if (nameText.equals("元朝")) {
                new Yuan();
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

        String dynastyName = tableModel.getValueAt(selectedRow, 0).toString(); // Assuming the second column is the name

        try {
            // 获取当前时间
            java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO collect_table ( collect_time,collect_type, collect_name) VALUES (?, ? ,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, username);
            pstmt.setTimestamp(1, currentTime);
            pstmt.setString(2, "朝代");
            pstmt.setString(3, dynastyName);


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



