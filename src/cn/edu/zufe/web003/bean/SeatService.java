package cn.edu.zufe.web003.bean;

import cn.edu.zufe.web003.database.DbUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class SeatService {
    public static List<Seat> getSeats() throws SQLException {
        List<Seat> seats = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = "select * from t_seats";
        seats = runner.query(connection, sql, new BeanListHandler<>(Seat.class));
        DbUtil.closeConnection(connection);
        return seats;
    }

    public static boolean isUsingSeat(int id) throws SQLException {
        List<Seat> seats = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = MessageFormat.format("select * from t_users where id = ''{0}'' and usingSeat = false",id);
        seats = runner.query(connection, sql, new BeanListHandler<>(Seat.class));
        if(seats.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean orderSeat(User user,int id) throws SQLException {
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = "update t_users set usingSeat=?, seatId=? where id=?;";
        runner.update(connection, sql, true, id, user.getId());
        sql = "update t_seats set beUsing=?, userId=?, userName=? where id=?;";
        runner.update(connection, sql, true, user.getId(), user.getUserName(), id);
        DbUtil.closeConnection(connection);
        return false;
    }

    public static boolean returnSeat(User user,int id) throws SQLException {
        Connection connection = DbUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = "update t_users set usingSeat=?, seatId=? where id=?;";
        runner.update(connection, sql, false, null, user.getId());
        sql = "update t_seats set beUsing=?, userId=?, userName=? where id=?;";
        runner.update(connection, sql, false, null, null, id);
        DbUtil.closeConnection(connection);
        return false;
    }
}
