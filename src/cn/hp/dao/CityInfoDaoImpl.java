package cn.hp.dao;

import cn.hp.model.City;
import cn.hp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityInfoDaoImpl implements CityInfoDao {
    @Override
    public List<City> findAllCity(int pid) {
        Connection conn = DBHelper.getConn();
        List<City> list=new ArrayList<City>();
        String sql="select * from city where pid=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);//预编译当前的sql语句
            ps.setInt(1,pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                City c=new City();//实例化当前省份
                c.setCid(rs.getInt(1));
                c.setCname(rs.getString(2));
                c.setPid(rs.getInt(3));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
