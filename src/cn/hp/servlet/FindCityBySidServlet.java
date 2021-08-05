package cn.hp.servlet;

import cn.hp.dao.StreetDao;
import cn.hp.dao.StreetDaoImpl;
import cn.hp.model.Street;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findstreetbysid")
public class FindCityBySidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        StreetDao sid=new StreetDaoImpl();
        List<Street> slist = sid.findAllStreet(Integer.parseInt(id));
        response.getWriter().write(JSONObject.toJSONString(slist));
    }
}
