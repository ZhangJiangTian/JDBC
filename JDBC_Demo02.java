import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC_Demo02 {
    @Test
    public void testDML() throws Exception{
        //1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、建立连接 url,user,password
        String url = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        //3、定义sql
        String sql = "update user set password = 111 where username = 'zjt' ";

        //4、获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5、执行sql
        int count = stmt.executeUpdate(sql);//受影响的行数

        //6、处理结果
        System.out.print(count);

        //7、释放资源
        stmt.close();
        conn.close();
    }

    @Test
    public void testDML1() throws Exception{
        //1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、建立连接 url,user,password
        String url = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        //3、定义sql
        String sql = " select * from user ";

        //4、获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5、执行sql
        ResultSet result = stmt.executeQuery(sql);//获取结果集

        //6、处理结果
        while(result.next()){
            int id = result.getInt(1);
            System.out.println(id);
        }

        //7、释放资源
        result.close();
        stmt.close();
        conn.close();
    }
}
