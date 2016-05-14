<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/static/css/semantic.css">
    <link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
</head>
<body>
<section class="content-header">
    <h1>
        情感分析
        <small>骨朵情感分析引擎</small>
    </h1>
    <ol class="breadcrumb">
        <li><a onclick="loadPage('dashboard')"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active" onclick="loadPage('sentiment/semantic')">情感分析</li>
    </ol>
</section>
<div class="row">
    <div class="col-lg-6">
        <form role="form">
            <div class="box-body">
                <div class="form-group">
                    <textarea type="text" class="form-control" id="text" placeholder="请输入文本..."
                              style="height: 300px"></textarea>
                </div>
                <div class="box-footer">
                    <butto class="btn btn-primary" onclick="getSemantic()">提交文本</butto>
                </div>
            </div>
        </form>
    </div>
    <div class="single_face_plan col-lg-4">
	<span class="plan_l" style="width: 50%;">
		<b class="line_l"><em class="txt_l">负面 50%</em></b>
	</span>
	<span class="plan_r" style="width: 50%;">
		<b class="line_r"><em class="txt_r">正面 50%</em></b>
	</span>
        <i class="icon_face_l"></i>
        <i class="icon_face_r"></i>
    </div>
    <div id="classify" class="bg-success" style="  position: relative;margin-top: 215px;margin-left: 806px;">

    </div>
    <p style="  position: relative;margin-top: 25px;margin-left: 735px;"> "妆容" "场景" "导演" "服装" "剧情" "演员" "背景音乐"</p>
</div>
<div class="box-header with-border">
    <h3 class="box-title"><i class="fa fa-tag"></i>关键字分析</h3>
</div>
<div class="row">
    <div class="col-lg-6">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="taskName" class="col-sm-2 control-label">任务名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="taskName" placeholder="请填写英文">
                </div>
            </div>
            <div class="form-group">
                <label for="tv_show" class="col-sm-2 control-label">电视剧名称</label>
                <div class="col-sm-9">
                <input type="text" class="form-control" id="tv_show" placeholder="最好的我们">
                </div>
            </div>
            <div class="form-group">
                <label for="sets" class="col-sm-2 control-label">前N集</label>
                <div class="col-sm-9">
                <input type="text" class="form-control" id="sets" placeholder="1..2..3">
                </div>
            </div>
            <div class="form-group row">
                <label for="keyword" class="col-sm-2 control-label">关于</label>
                <div class="col-sm-9">
                <textarea type="text" class="form-control" id="keyword"
                          style="height: 200px" placeholder="关键词','分割"></textarea>
                </div>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
            <div class="btn btn-success" onclick="getsem()" >处理数据</div>
            </div>
        </form>
    </div>
    <div class="col-lg-5">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">文件列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
                <table class="table table-hover">
                    <thead>
                    <tr>

                        <th>文件</th>
                        <th>功能</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>nian_sentiment.csv</td>
                        <td class="btn btn-danger"><a href="${ctx}/sentiment/download?fileName=nian_sentiment.csv">下载</a></td>
                    </tr>
                    <tr>
                        <td>nian_sentiment.csv</td>
                        <td class="btn btn-danger"><a href="${ctx}/sentiment/download?fileName=nian_sentiment.csv">下载</a></td>
                    </tr>
                    <tr>
                        <td>nian_sentiment.csv</td>
                        <td class="btn btn-danger"><a href="${ctx}/sentiment/download?fileName=nian_sentiment.csv">下载</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
</div>
<script src="${ctx}/static/js/jquery.js" type="application/javascript"></script>
<script>
    function getSemantic() {
        var tag = new Array("抱歉还未找到分类，请换语句查询！", "妆容", "场景", "导演", "服装", "剧情", "演员", "背景音乐");
        var text = $("#text").val();
        $.post("${ctx}/sentiment/getSemantic", {text: text}, function (data) {
            change(data);
        });
        $.post("${ctx}/sentiment/getClassify", {text: text}, function (data) {
            $("#classify").html("该句预测分类为："+tag[data]);
        })
    }
    function change(number) {
        var l = 0;
        var num = Math.round(number * 100) / 100;
        if (number < 0) {
            l = Math.abs(num) * 100;
        } else {
            l = 100 - num * 100;
        }
        $(".txt_l").html("负面" + l + "%");
        $(".plan_l").css({"width": l + "%"});
        $(".txt_r").html("正面" + (100 - l) + "%");
        $(".plan_r").css({"width": (100 - l) + "%"});
    }

    function getsem(){
        var set = $("#sets").val();
        var arr = $("#keyword").val().split(',');
        var likes = new Array();
        for(i = 0; i < arr.length;i++){
            likes.push(arr[i]);
        }
        var show = $("#tv_show").val();
        var name = $("#taskName").val();
        $.post("${ctx}/sentiment/getSemantics",{'teleplay':show,'set':set,'likes':likes,'name':name},function(bate){
        })
    }

</script>
</body>
</html>
