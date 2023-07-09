import java.sql.*;
import java.util.Arrays;

public class ToConnectDatabase {

    public static void main(String[] args) throws InterruptedException {
        int k = 0;
        boolean mysqlStatus;
        // MySQL数据库连接信息
        String url = "jdbc:mysql://localhost:3306/mysql"; // 数据库URL
        String username = "root"; // 数据库用户名
        String password = "123456"; // 数据库密码

        // 连接数据库
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("成功连接到数据库！");
            DatabaseMetaData metaData = connection.getMetaData();
            Statement statement = connection.createStatement();
            //查询指定列的行数据
            System.out.println("指定列的行数据：");
            ResultSet resultSet = statement.executeQuery("select * From db ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Host"));
            }
            ResultSet resultSet1 = metaData.getTables(null, null, "%",
                    new String[]{"TABLE"});
            System.out.println("指定数据库的数据表集：");
            while (resultSet1.next()) {
                System.out.print(Arrays.toString(resultSet1.getString("TABLE_NAME").split(" "))
                        + " ");
                k++;
                if (k == 5) {
                    System.out.println(" ");
                    k = 0;
                }
            }
            System.out.println(" ");
            //线程休眠3秒
            Thread.sleep(3000);

            //获取当前驱动信息
            String resultSet2 = metaData.getDriverVersion();
            System.out.println("当前驱动及版本为：" + resultSet2);

            // 关闭相关进程
            resultSet.close();
            resultSet1.close();
            connection.close();
            mysqlStatus = connection.isClosed();
            System.out.println("数据库是否关闭：" + mysqlStatus);


            //捕获异常
        } catch (SQLException e) {
            System.err.println("ERROR：" + e.getMessage());
            System.out.println("连接数据库时出现错误。");
        }
    }
}
