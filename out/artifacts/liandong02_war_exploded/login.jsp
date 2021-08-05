<%--
  Created by IntelliJ IDEA.
  User: 24648
  Date: 2021/6/19
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>

</head>
<body>
<script>
    $(function () {
        $.ajax({
            type:"get",//类型
            url:"findprovince",//地址
            dataType:"json",//数据类型
            success:function (data) {//回调函数 data的值就是从后端发送过来的json格式的字符串
                //拿到当前省份的元素对象
                var obj=$("#province");
                for ( var  i = 0; i < data.length;i++){
                    var ob="<option value='"+data[i].pid+"'>"+data[i].pname+"</option>";
                    obj.append(ob);

                }

            }
        });
    });
</script>

<select name="province" id="province">
    <option value="0">请选择</option>
</select>省
<select name="city" id="city">
    <option value="0">请选择</option>
</select>市
<select name="street" id="street">
    <option value="0">请选择</option>
</select>区
<script>
    $("#province").change(function () {
        $("#city option").remove();
        $.ajax({
            type: "get",
            url: "findcitybypid?id="+$("#province").val(),
            dataType: "json",
            success:function (data) {
                var obj=  $("#city");
                for (var i=0;i<data.length;i++){
                    var  ob= "<option value='"+data[i].cid+"'>"+data[i].cname+"</option>"
                    obj.append(ob)
                }
            }
        });
    });
</script>
<script>
        $("#city").change(function () {
            $("#street option").remove();
            $.ajax({
                type:"get",
                url:"findstreetbysid?id="+$("#city").val(),
                dataType: "json",
            success:function (data) {
                var obj=  $("#street");
                for (var i=0;i<data.length;i++){
                    var  ob= "<option value='"+data[i].sid+"'>"+data[i].sname+"</option>"
                    obj.append(ob)
                }
            }
        });
    });
</script>

</body>
</html>
