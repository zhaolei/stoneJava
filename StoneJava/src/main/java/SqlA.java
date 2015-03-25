package org.stone;
import java.sql.*;

public class SqlA 
{
  public static void main(String[] args)
  {
    try
    {
      String url="jdbc:mysql://localhost/blog";
      String user="root";
      String pwd="329818";
      
      //加载驱动，这一句也可写为：Class.forName("com.mysql.jdbc.Driver");
     Class.forName("com.mysql.jdbc.Driver").newInstance();
      //建立到MySQL的连接
       Connection conn = DriverManager.getConnection(url,user, pwd);
      
      //执行SQL语句
       Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
      //ResultSet rs = stmt.executeQuery("select * from blog_users where id=1");
      ResultSet rs = stmt.executeQuery("select * from blog_comments");
     
       //处理结果集
      while (rs.next())
      {
        String name = rs.getString("comment_author_url");
        System.out.println(name);
      }
       System.out.println( "1.****************************" );
      //rs.close();//关闭数据库
      //conn.close();
       System.out.println( "2.****************************" );
    }
    catch (Exception ex)
    {
      System.out.println("Error : " + ex.toString());
    }

       System.out.println( "3.****************************" );
	System.exit(0);
	//return;
  }
}
