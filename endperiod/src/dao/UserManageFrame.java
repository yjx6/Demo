package dao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class UserManageFrame extends JFrame implements ActionListener {
    private JTextField idField, usernameField, passwordField;
    private JButton addButton, updateButton, deleteButton, searchButton,jiansuButton,fileButton;
    private DefaultTableModel tableModel;
    private JTable table;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "Yangjx729803";

    public UserManageFrame() {
        setTitle("用户管理");
        setSize(480, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);

        idField = new JTextField(10);
        usernameField = new JTextField(10);
        passwordField = new JTextField(10);

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
        JLabel idJLabel=new JLabel("ID:");
        idJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(idJLabel);
        inputPanel.add(idField);
        JLabel usernameJLabel=new JLabel("username:");
        usernameJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(usernameJLabel);
        inputPanel.add(usernameField);
        JLabel passwordJLabel=new JLabel("password:");
        passwordJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(passwordJLabel);
        inputPanel.add(passwordField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(searchButton);
        inputPanel.add(jiansuButton);
        inputPanel.add(fileButton);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(table.getFont().deriveFont(18f)); // 设置表格数据字体大小为16

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_table");
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
            String id=idField.getText();
            String name = usernameField.getText();
            String password = passwordField.getText();
            if (id.isEmpty()||name.isEmpty()||password.isEmpty()){
                JOptionPane.showMessageDialog(this, "请将信息填写完整", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                // 调用添加新员工的方法
                addUser(id,name, password);
                // 清空输入框
                idField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            }

        } else if (e.getSource() == updateButton) {
            // Implement update functionality
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Make sure a row is selected
                String idString = (String) table.getValueAt(selectedRow, 0); // Assuming the ID is in the first column
               if (!idString.equals(idField.getText())){
                   JOptionPane.showMessageDialog(this, "请输入要修改的正确的用户id", "Error", JOptionPane.ERROR_MESSAGE);
               }else {
                   int id = Integer.parseInt(idString);
                   String name = usernameField.getText();
                   String password = passwordField.getText();
                   updateUser(id, name, password);
               }

            } else {
                JOptionPane.showMessageDialog(this, "请选择一行数据进行修改");
            }
        } else if (e.getSource() == deleteButton) {
            // Implement delete functionality
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Make sure a row is selected
                String idString = (String) table.getValueAt(selectedRow, 0); // Assuming the ID is in the first column
                int confirm = JOptionPane.showConfirmDialog(this, "确定要删除id为 " + idString + " 的用户吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int id = Integer.parseInt(idString);
                    deleteUserById(id);
                }

            } else {
                JOptionPane.showMessageDialog(this, "请选择要删除的数据");
            }

        } else if (e.getSource() == searchButton) {
            searchUserById();
            table.repaint();
        }else if (e.getSource()==jiansuButton){
            refreshTable();
        }else if (e.getSource()==fileButton){
            exportTableToTXT();
        }
//        refreshTable();
    }
    //增
    private void addUser(String id,String name, String password) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO user_table (id,username, password) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, password);
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
    private void deleteUserById(int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM user_table WHERE id= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "删除成功", "Info", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //改
    private void updateUser(int id, String name, String password) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE user_table SET username = ?, password = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);
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
    private void searchUserById() {
        String idText = idField.getText().trim();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(idText);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM user_table WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
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
                JOptionPane.showMessageDialog(this, "没有找到ID为: " + id+"的用户", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请输入ID", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Ensure the table gets refreshed
        table.repaint();
    }
    //以文件保存
    private void exportTableToTXT() {
        try (FileWriter txtWriter = new FileWriter("D:\\Java作业\\user_table_export.txt")) {
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

