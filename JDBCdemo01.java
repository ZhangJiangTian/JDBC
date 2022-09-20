import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCdemo01 {
    public static void main(String[] args) throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、建立连接 url,user,password
        String url = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        //3、定义sql
        String sql = "DROP TABLE t_student";

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
}
