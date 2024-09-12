package dao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class HistoricalManageFrame extends JFrame implements ActionListener {
    private JTextField nameField, dynastyField, accomplishmentField;
    private JButton addButton, updateButton, deleteButton, searchButton,jiansuButton,fileButton;
    private DefaultTableModel tableModel;
    private JTable table;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "Yangjx729803";

    public HistoricalManageFrame() {
        setTitle("历史名人管理");
        setSize(820, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);

        nameField = new JTextField(10);
        dynastyField = new JTextField(10);
        accomplishmentField = new JTextField(10);
        addButton = new JButton("增加");
        updateButton = new JButton("修改");
        deleteButton = new JButton("删除");
        searchButton = new JButton("查询");
        jiansuButton=new JButton("全部检索");
        fileButton=new JButton("将内容以文件形式保存");
        addButton.setFont(new Font("宋体", Font.BOLD, 20));
        updateButton.setFont(new Font("宋体", Font.BOLD, 20));
        deleteButton.setFont(new Font("宋体", Font.BOLD, 20));
        searchButton.setFont(new Font("宋体", Font.BOLD, 20));
        jiansuButton.setFont(new Font("宋体", Font.BOLD, 20));
        fileButton.setFont(new Font("宋体", Font.BOLD, 18));
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        JLabel nameJLabel=new JLabel("人物名称:");
        nameJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(nameJLabel);
        inputPanel.add(nameField);
        JLabel dynastyJLabel=new JLabel("所属朝代:");
        dynastyJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(dynastyJLabel);
        inputPanel.add(dynastyField);
        JLabel accomplishmentJLabel=new JLabel("历史成就:");
        accomplishmentJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(accomplishmentJLabel);
        inputPanel.add(accomplishmentField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(searchButton);
        inputPanel.add(jiansuButton);
        inputPanel.add(fileButton);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(table.getFont().deriveFont(17f)); // 设置表格数据字体大小为16

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        jiansuButton.addActionListener(this);
        fileButton.addActionListener(this);

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
        if (e.getSource() == addButton) {
            // Implement add functionality
            String name = nameField.getText();
            String dynasty = dynastyField.getText();
            String accomplishment = accomplishmentField.getText();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请至少输入名人的姓名", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // 调用添加新员工的方法
                addHistorical(name,dynasty, accomplishment);
                // 清空输入框
                nameField.setText("");
                dynastyField.setText("");
                accomplishmentField.setText("");
            }

        } else if (e.getSource() == updateButton) {
            // Implement update functionality
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Make sure a row is selected
                String nameString = (String) table.getValueAt(selectedRow, 0); // Assuming the ID is in the first column
                if (!nameString.equals(nameField.getText())){
                    JOptionPane.showMessageDialog(this, "请输入要修改的正确的名人姓名", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    String name=nameField.getText();
                    String dynasty =dynastyField.getText();
                    String accomplishment= accomplishmentField.getText();
                    updateHistorical(name, dynasty, accomplishment);
                }

            } else {
                JOptionPane.showMessageDialog(this, "请选择一行数据进行修改");
            }
        } else if (e.getSource() == deleteButton) {
//            // Implement delete functionality
//            int selectedRow = table.getSelectedRow();
//            if (selectedRow != -1) { // Make sure a row is selected
//                String name = (String) table.getValueAt(selectedRow, 0); // Assuming the name is in the second column
//                int confirm = JOptionPane.showConfirmDialog(this, "确定要删除名为 " + name + " 的历史名人吗？", "确认删除", JOptionPane.YES_NO_OPTION);
//                if (confirm == JOptionPane.YES_OPTION) {
//                    deleteHistoricalByName(name);
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "请选择要删除的数据");
//            }
            //批量删除
            int[] selectedRows = table.getSelectedRows();
            if (selectedRows.length > 0) {
                int confirm = JOptionPane.showConfirmDialog(this, "确定要删除选定的历史名人吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    for (int i = selectedRows.length - 1; i >= 0; i--) {
                        String name = (String) table.getValueAt(selectedRows[i], 0);
                        deleteHistoricalByName(name);
                        tableModel.removeRow(selectedRows[i]);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "请选择要删除的数据");
            }
        } else if (e.getSource() == searchButton) {
            searchHistoricalByName();
            table.repaint();
        }else if (e.getSource()==jiansuButton){
            refreshTable();
        }else if (e.getSource()==fileButton){
            exportTableToTXT();
        }
//        refreshTable();
    }
    //增
    private void  addHistorical(String name,String time, String dynasty) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO historical_table (name,dynasty, accomplishment) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, time);
            pstmt.setString(3, dynasty);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            JOptionPane.showMessageDialog(this, "增加成功", "Info", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删
    private void deleteHistoricalByName(String name) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM historical_table WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "成功删除名为 " + name + " 的历史名人", "Info", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "未找到名为 " + name + " 的历史名人", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库错误", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //改
    private void  updateHistorical(String name, String dynasty, String accomplishment) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE historical_table SET dynasty= ? ,accomplishment=? WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dynasty);
            pstmt.setString(2, accomplishment);
            pstmt.setString(3, name);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            JOptionPane.showMessageDialog(this, "修改成功", "Info", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
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

            if (!hasResults) {
                JOptionPane.showMessageDialog(this, "没有找到包含: " + nameText + " 的名人", "Info", JOptionPane.INFORMATION_MESSAGE);
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
    //以文件保存
    private void exportTableToTXT() {
        try (FileWriter txtWriter = new FileWriter("D:\\Java作业\\historical_table_export.txt")) {
            // Write column names
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                txtWriter.append(tableModel.getColumnName(i));
                if (i < tableModel.getColumnCount() - 1) {
                    txtWriter.append("\t"); // Use a tab to separate columns
                }
            }
            txtWriter.append("\n");

            // Write rows
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    txtWriter.append(tableModel.getValueAt(i, j).toString());
                    if (j < tableModel.getColumnCount() - 1) {
                        txtWriter.append("\t"); // Use a tab to separate columns
                    }
                }
                txtWriter.append("\n");
            }

            JOptionPane.showMessageDialog(this, "导出成功!", "信息", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "导出失败!", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

}


