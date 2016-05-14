<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        平台数据总览
        <small id="sys-date"></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">平台数据总览</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <!-- Small boxes (Stat box) -->
    <div class="row">
        <div class="col-lg-2 col-xs-4">
            <div class="small-box bg-aqua">
                <div class="inner">
                    <h3>1500000</h3>

                    <p>用户数据</p>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
        <div class="col-lg-2 col-xs-4">
            <!-- small box -->
            <div class="small-box bg-green">
                <div class="inner">
                    <h3>530000<sup style="font-size: 20px">%</sup></h3>

                    <p>视频数据</p>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
        <div class="col-lg-2 col-xs-4">
            <!-- small box -->
            <div class="small-box bg-yellow">
                <div class="inner">
                    <h3>44</h3>

                    <p>电影数据</p>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
        <div class="col-lg-2 col-xs-4">
            <!-- small box -->
            <div class="small-box bg-red">
                <div class="inner">
                    <h3>6500000</h3>

                    <p>明星数据</p>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
        <div class="col-lg-2 col-xs-4">
            <!-- small box -->
            <div class="small-box bg-maroon-active">
                <div class="inner">
                    <h3>6995</h3>

                    <p>导演数据</p>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
        <div class="col-lg-2 col-xs-4">
            <div class="small-box bg-blue-gradient">
                <div class="inner">
                    <h3>788</h3>

                    <p>其他数据</p>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
    </div>
    <!-- Main row -->
    <div class="box">
        <div class="box-body">
            <div class="row">
                <div class="box-header with-border">
                    <h3 class="box-title">网络剧播放量</h3>
                </div>
                <div id="main" style="height: 300px;width:100%;"/>
            </div>
        </div>
    </div>
    <div class="box">
        <div class="box-body">
            <div class="row">
                <div class="box-header with-border">
                    <h3 class="box-title">平台用户情况</h3>
                </div>
                <div id="line" style="height: 300px;width:100%;"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="box">
                <div class="box-body">
                    <div class="box-header with-border">
                        <h3 class="box-title">文本云</h3>
                    </div>
                    <div class="col-md-10" id="cloud_of_word" style="height: 500px;"/>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="box box-primary">
                <div class="box-body">
                    <div class="box-header with-border">
                        <h3 class="box-title">文本内容</h3>
                    </div>
                    <form role="form">
                        <div class="box-body">
                            <div class="form-group">
                                <textarea type="text" class="form-control" id="text"
                                       placeholder="请输入文本..." style="height: 400px"></textarea>
                            </div>
                            <div class="box-footer">
                                <butto class="btn btn-primary" onclick="getCloud()">提交文本</butto>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</section>
<script src="${ctx}/static/js/china.js" type="application/javascript"></script>
<script src="${ctx}/static/js/dashboard.js" type="application/javascript"></script>
<!-- /.content -->