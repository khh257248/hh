package cn.hp.servlet;

import cn.hp.dao.ProvinceInfoDao;
import cn.hp.dao.ProvinceInfoDaoImpl;
import cn.hp.model.Province;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findprovince")
public class FindProvinceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ProvinceInfoDao pid=new ProvinceInfoDaoImpl();
        List<Province> plist =pid.findAll();
        //把这个省份的集合转换成json格式的数据发送到前端页面
        response.getWriter().write(JSONObject.toJSONString(plist));
    }
}
