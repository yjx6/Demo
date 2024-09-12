package dao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CollectManageFrame extends JFrame implements ActionListener {
    private JTextField collect_typeField, collect_nameField;
    private JButton addButton, updateButton, deleteButton, searchButton,jiansuButton,fileButton;
    private DefaultTableModel tableModel;
//    DefaultTableModel 是 Swing 中用于管理表格数据的类之一。它可以存储和管理表格中的数据，并提供添加、删除、更新等操作的方法。
    private JTable table;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/endperiod?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "Yangjx729803";

    public CollectManageFrame() {
        setTitle("收藏管理");
        setSize(520, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);
//JFrame.DO_NOTHING_ON_CLOSE (值为 0): 当窗口关闭时，什么也不做，需要通过其他方式来处理窗口关闭事件。
//
//JFrame.HIDE_ON_CLOSE (值为 1): 当窗口关闭时，窗口会隐藏（即不可见），但是程序仍在运行。
//
//JFrame.DISPOSE_ON_CLOSE (值为 2): 当窗口关闭时，释放窗口所占的资源，并终止程序。
//
//JFrame.EXIT_ON_CLOSE (值为 3): 当窗口关闭时，终止程序（调用 System.exit(0)），退出应用程序。
        collect_typeField = new JTextField(10);
        collect_nameField = new JTextField(10);

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
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));//具有 5 行、2 列的网格布局
        JLabel typeJLabel=new JLabel("收藏类型:");
        typeJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(typeJLabel);
        inputPanel.add(collect_typeField);
        JLabel nameJLabel=new JLabel("收藏名称:");
        nameJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        inputPanel.add(nameJLabel);
        inputPanel.add(collect_nameField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(searchButton);
        inputPanel.add(jiansuButton);
        inputPanel.add(fileButton);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
//        JTable 用于显示 DefaultTableModel 中的数据，并提供用户交互界面。
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(table.getFont().deriveFont(16f)); // 设置表格数据字体大小为16

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
//        这两行代码分别清空表格模型中的所有列和所有行。这样做是为了确保表格在刷新时不会保留旧的数据和列结构。
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM collect_table");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
//            rs.getMetaData(): 获取 ResultSet 的元数据，包含关于列的信息。
//            metaData.getColumnCount(): 获取查询结果中的列数。
//            循环: 遍历每一列，从元数据中获取列的名称，并将其添加到表格模型中。
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
//            rs.next(): 移动 ResultSet 的光标到下一行。如果有更多行，则返回 true。
//            创建数组 row: 用于存储当前行的数据，长度为列数。
//            内部循环: 遍历每一列，使用 rs.getObject(i) 获取当前行、当前列的值，并将其放入 row 数组。
//            tableModel.addRow(row): 将当前行的数据作为新行添加到表格模型中。
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
            String type = collect_typeField.getText();
            String name = collect_nameField.getText();
            if (type.isEmpty()||name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请将信息输入完整", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // 调用添加新员工的方法
                addCollcet(type,name);
                // 清空输入框
                collect_typeField.setText("");
                collect_nameField.setText("");
            }

        } else if (e.getSource() == updateButton) {
            // Implement update functionality
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Make sure a row is selected
                    String type=collect_typeField.getText();
                    String name =collect_nameField.getText();
                String nameString = (String) table.getValueAt(selectedRow, 2); // Assuming the ID is in the first column
                if (nameString.equals(name)){
                    updateCollect(type, name);
                }else{
                    JOptionPane.showMessageDialog(this, "请输入要修改数据的正确收藏名称", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "请选择一行数据进行修改");
            }
        } else if (e.getSource() == deleteButton) {
            // Implement delete functionality
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Make sure a row is selected
                String name = (String) table.getValueAt(selectedRow, 2); // Assuming the name is in the second column
                int confirm = JOptionPane.showConfirmDialog(this, "确定要删除你所选中的收藏数据吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    deleteCollectByName(name);
                }
            } else {
                JOptionPane.showMessageDialog(this, "请选择要删除的数据");
            }

        } else if (e.getSource() == searchButton) {
            searchCollectByType();
            table.repaint();
        }else if (e.getSource()==jiansuButton){
            refreshTable();
        }else if (e.getSource()==fileButton){
            exportTableToTXT();
        }
//        refreshTable();
    }
    //增
    private void  addCollcet(String type,String name) {
        try {
            // 获取当前时间
            java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO collect_table (collect_time,collect_type, collect_name) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, currentTime);
            pstmt.setString(2, type);
            pstmt.setString(3, name);

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
    private void deleteCollectByName(String name) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM collect_table WHERE collect_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "成功删除此条收藏", "Info", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "未找到要删除的收藏名称", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库错误", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //改
    private void  updateCollect(String type, String name) {
        try {
            // 获取当前时间
            java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            String sql = "UPDATE collect_table SET collect_name=? WHERE collect_type = ?";
            String sql = "UPDATE collect_table SET collect_type = ?WHERE collect_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, name);
//            pstmt.setString(2, type);
           pstmt.setString(1, type);
           pstmt.setString(2, name);
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
    private void searchCollectByType() {
        String typeText = collect_typeField.getText().trim();
        if (typeText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入要查询的收藏类型", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM collect_table WHERE collect_type LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + typeText + "%");  // 模糊匹配
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();//首先通过 ResultSetMetaData 对象获取结果集的元数据，这样可以动态地获取列数和列名

            tableModel.setRowCount(0); // Clear all existing rows
            tableModel.setColumnCount(0);
            // Add column names
            for (int i = 1; i <= columnCount; i++) {//添加列名：遍历列数并使用元数据中的列名来设置表格的列名。
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
                JOptionPane.showMessageDialog(this, "没有找到类型为: " +typeText + " 的收藏数据", "Info", JOptionPane.INFORMATION_MESSAGE);
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
        try (FileWriter txtWriter = new FileWriter("D:\\Java作业\\collect_table_export.txt")) {
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
//            这一部分代码首先遍历表格模型的所有行（tableModel.getRowCount()），然后对每一行内的每一列（tableModel.getColumnCount()）进行遍历，
//            将其值通过 txtWriter.append()
//        方法写入文件。同样，每个单元格的值之间用制表符（\t）分隔，
//            每行结束时添加一个换行符（\n）。
            JOptionPane.showMessageDialog(this, "导出成功!", "信息", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "导出失败!", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

}


