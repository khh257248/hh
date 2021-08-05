package cn.hp.dao;

import cn.hp.model.Street;
import cn.hp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreetDaoImpl implements StreetDao {
    @Override
    public List<Street> findAllStreet(int cid) {
        Connection conn= DBHelper.getConn();
        List<Street> list= new ArrayList<Street>();
        String sql="select * from street where cid =?";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1,cid);
            ResultSet rs=  ps.executeQuery();
            while (rs.next()){
                Street s= new Street();
                s.setSid(rs.getInt(1));
                s.setSname(rs.getString(2));
                s.setCid(rs.getInt(3));

                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
