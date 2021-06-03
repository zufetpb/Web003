package cn.edu.zufe.web003.bean;

import cn.edu.zufe.web003.database.DbUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {

    public static List<User> getUsers(String keyword) throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = "select * from t_users";
        if(!"".equals(keyword) && !(keyword == null)){
            sql = MessageFormat.format("select * from t_users where id like ''%{0}%'' or userName like ''%{1}%''", new Object[]{keyword, keyword});
        }
        users = runner.query(connection, sql, new BeanListHandler<>(User.class));
        DbUtil.closeConnection(connection);
        return users;
    }

    public static User getUserById(long id) throws SQLException {
        User user = new User();
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = MessageFormat.format("select * from t_users where id = ''{0}''",id);
        user = runner.query(connection, sql, new BeanHandler<>(User.class));
        DbUtil.closeConnection(connection);
        return user;
    }

    public static User login(String userName,String passWord) throws SQLException {
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = String.format("select * from t_users where userName = '%s' and passWord = '%s'",userName,passWord);
        User user = runner.query(connection, sql ,new BeanHandler<>(User.class));
        DbUtil.closeConnection(connection);
        return user;
    }

    public static void update(long id,User user) throws SQLException {
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = "update t_users set userName=?, passWord=?, sex=?, major=? where id=?;";
        System.out.println(sql);
        runner.update(connection, sql, user.getUserName(), user.getPassWord(), user.getSex(), user.getMajor(), id);
        DbUtil.closeConnection(connection);
    }

    public static User getUserFromRequest(HttpServletRequest request){
        User user = new User();

        user.setUserName(request.getParameter("userName"));
        user.setPassWord(request.getParameter("passWord"));
        user.setSex(request.getParameter("sex"));
        user.setMajor(request.getParameter("major"));
        return user;
    }

    public static void insert(User user) throws SQLException {
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = ("insert into t_users (userName, passWord, sex, major) values (?,?,?,?)");
        runner.update(connection, sql, user.getUserName(), user.getPassWord(), user.getSex(), user.getMajor());
        DbUtil.closeConnection(connection);
    }

    public static void main(String[] args) throws SQLException {
//        System.out.println(getUsers("1"));
//        System.out.println(getUserById(1));
    }
}
