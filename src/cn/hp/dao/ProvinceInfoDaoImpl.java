package cn.hp.dao;

import cn.hp.model.Province;
import cn.hp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//接口实现类
public class ProvinceInfoDaoImpl implements ProvinceInfoDao {
    @Override
    public List<Province> findAll() {
        Connection conn = DBHelper.getConn();
        List<Province> list=new ArrayList<Province>();
        String sql="select * from province";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);//预编译当前的sql语句
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Province p=new Province();//实例化当前省份
                p.setPid(rs.getInt(1));
                p.setPname(rs.getString(2));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
