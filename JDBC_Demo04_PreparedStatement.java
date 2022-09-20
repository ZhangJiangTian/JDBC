import org.testng.annotations.Test;

import java.sql.*;

public class JDBC_Demo04_PreparedStatement {
    @Test
    public void testDML1() throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、建立连接 url,user,password
        String url = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8&useServerPrepStmts=true";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        //3、定义sql
        String sql = "SELECT * FROM user where username = ? and password = ?";

        //4、获取执行sql的对象 PreparedStatement
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置？的值
        pstmt.setString(1,"zjt");
        pstmt.setString(2,"111");

        //5、执行sql
        ResultSet result = pstmt.executeQuery();//获取结果集

        //6、处理结果
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("username");
            String pw = result.getString("password");

            System.out.println(Integer.toString(id) + ' ' + name + ' ' + pw);
            System.out.println("------------------------");
        }

        //7、释放资源
        result.close();
        pstmt.close();
        conn.close();
    }
}
