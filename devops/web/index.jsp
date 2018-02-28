<%--
  Created by IntelliJ IDEA.
  User: jiayu
  Date: 2018/2/28
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<!-- DOCTYPE 设置文档类型 -->
<html lang="zh-CN">
<!-- lang 设置网页语言，中文用'zh-CN'，英文用'en' -->
<head>
  <!-- charset 设置网页编码 -->
  <meta charset="utf-8">
  <!-- Bootstrap 不支持 IE 古老的兼容模式。为了让 IE 浏览器运行最新的渲染模式下，添加此 <meta> 标签 -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- 浏览器自适应设备宽度，缩放比例为1(shrink-to-fit=no iOS中让网页的宽度自动适应手机屏幕的宽度) -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- description 网页描述 -->
  <meta name="description" content="基于jsp(3.1)，bootstrap(4.0.0)搭建的运维平台">
  <!-- keywords 关键词 -->
  <meta name="keywords" content="java, jsp, devops, bootstrap, web">
  <!-- author 作者 -->
  <meta name="author" content="李家宇">
  <title>DevOps</title>
  <!-- favicon 图标 -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
  <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
  <!-- 引入 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <!-- 引入 dashboard CSS 文件 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
</head>

<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company name</a>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="#">Sign in</a>
    </li>
  </ul>
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="#">Sign out</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar">
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">
              <span data-feather="home"></span>
              Dashboard <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file"></span>
              Orders
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="shopping-cart"></span>
              Products
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="users"></span>
              Customers
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="bar-chart-2"></span>
              Reports
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="layers"></span>
              Integrations
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Saved reports</span>
          <a class="d-flex align-items-center text-muted" href="#">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Current month
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Last quarter
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Social engagement
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Year-end sale
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group mr-2">
            <button class="btn btn-sm btn-outline-secondary">Share</button>
            <button class="btn btn-sm btn-outline-secondary">Export</button>
          </div>
          <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar"></span>
            This week
          </button>
        </div>
      </div>

      <canvas class="my-4" id="myChart" width="900" height="380"></canvas>

      <h2>Section title</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
          <tr>
            <th>#</th>
            <th>Header</th>
            <th>Header</th>
            <th>Header</th>
            <th>Header</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>1,001</td>
            <td>Lorem</td>
            <td>ipsum</td>
            <td>dolor</td>
            <td>sit</td>
          </tr>
          <tr>
            <td>1,002</td>
            <td>amet</td>
            <td>consectetur</td>
            <td>adipiscing</td>
            <td>elit</td>
          </tr>
          <tr>
            <td>1,003</td>
            <td>Integer</td>
            <td>nec</td>
            <td>odio</td>
            <td>Praesent</td>
          </tr>
          <tr>
            <td>1,003</td>
            <td>libero</td>
            <td>Sed</td>
            <td>cursus</td>
            <td>ante</td>
          </tr>
          <tr>
            <td>1,004</td>
            <td>dapibus</td>
            <td>diam</td>
            <td>Sed</td>
            <td>nisi</td>
          </tr>
          <tr>
            <td>1,005</td>
            <td>Nulla</td>
            <td>quis</td>
            <td>sem</td>
            <td>at</td>
          </tr>
          <tr>
            <td>1,006</td>
            <td>nibh</td>
            <td>elementum</td>
            <td>imperdiet</td>
            <td>Duis</td>
          </tr>
          <tr>
            <td>1,007</td>
            <td>sagittis</td>
            <td>ipsum</td>
            <td>Praesent</td>
            <td>mauris</td>
          </tr>
          <tr>
            <td>1,008</td>
            <td>Fusce</td>
            <td>nec</td>
            <td>tellus</td>
            <td>sed</td>
          </tr>
          <tr>
            <td>1,009</td>
            <td>augue</td>
            <td>semper</td>
            <td>porta</td>
            <td>Mauris</td>
          </tr>
          <tr>
            <td>1,010</td>
            <td>massa</td>
            <td>Vestibulum</td>
            <td>lacinia</td>
            <td>arcu</td>
          </tr>
          <tr>
            <td>1,011</td>
            <td>eget</td>
            <td>nulla</td>
            <td>Class</td>
            <td>aptent</td>
          </tr>
          <tr>
            <td>1,012</td>
            <td>taciti</td>
            <td>sociosqu</td>
            <td>ad</td>
            <td>litora</td>
          </tr>
          <tr>
            <td>1,013</td>
            <td>torquent</td>
            <td>per</td>
            <td>conubia</td>
            <td>nostra</td>
          </tr>
          <tr>
            <td>1,014</td>
            <td>per</td>
            <td>inceptos</td>
            <td>himenaeos</td>
            <td>Curabitur</td>
          </tr>
          <tr>
            <td>1,015</td>
            <td>sodales</td>
            <td>ligula</td>
            <td>in</td>
            <td>libero</td>
          </tr>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-slim.min.js" ></script>
<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/jquery-slim.min.js"><\/script>')</script>
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- Icons -->
<script src="${pageContext.request.contextPath}/js/feather.min.js"></script>
<script>
    feather.replace()
</script>

<!-- Graphs -->
<script src="${pageContext.request.contextPath}/js/chart.min.js"></script>
<script>
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            datasets: [{
                data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>
</body>
</html>
