package cn.hp.servlet;

import cn.hp.dao.CityInfoDao;
import cn.hp.dao.CityInfoDaoImpl;
import cn.hp.model.City;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findcitybypid")
public class FindCityByPidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        CityInfoDao cid=new CityInfoDaoImpl();
        List<City> list = cid.findAllCity(Integer.parseInt(id));
        //把城市的集合转换成json格式的字符串发送到前端页面
        response.getWriter().write(JSONObject.toJSONString(list));
    }

}
