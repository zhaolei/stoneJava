<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
	<title>${msg}</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container bs-docs-container">
<nav class="navbar navbar-default" role="navigation">
  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li ><a href="<c:url value="/index" />">Home</a></li>
      <li class="active" ><a  href="<c:url value="/file" />">WebFile</a></li>
      <li><a href="<c:url value="/job" />">Job</a></li>
    </ul>
  </div><!-- /.navbar-collapse -->
</nav>

    <table class="table" id="tblist">
        <tr class="thead">
            <td width=900>Path</td>
            <td>Type</td>
        </tr>
    </table>
</div>

    <script>
    var cpath = '/';
    function getfile(flist) {
        tr = $('#tblist .thead');
        $('#tblist tr').remove();
        $('#tblist').append(tr);
        
        ppath = getPpath();
        $("#tblist").append("<tr><td><a onclick=\"fsopen('"+ppath+"')\" href=\"#\" >..</a></td><td>dir</td></tr>");
        for(i=0; i<flist.files.length; i++) {    
            console.log(flist.files[i].path);    
            //$("<tr><td>"+flist.files[i].path+"</td><td><a href='' />open</a></td></tr>").insertAfter($("#filelist tr"));
            dtype = flist.files[i].directory ? 'dir' : 'file';
            $("#tblist").append("<tr><td><a onclick=\"fsopen('"+flist.files[i].path+"')\" href=\"#\" >"+flist.files[i].path+"</a></td><td>"+dtype+"</td></tr>");

        }
    
    }

    function getPpath() {
        if(cpath == '/') {
            return cpath;
        }

        ar = cpath.split('/');
        ar.pop();
        if(ar.length == 1) {
            return "/";
        }
        return ar.join('/');
    }
    function fsopen(path) {
            cpath = path;
            url = '<c:url value="/fs/list?path='+path+'" />'

            req = {
                    url:url, 
                    type:'GET', 
                    dataType:'json',
                    success: getfile};
            $.ajax(req);

    }
    $(document).ready(function(){
            req = {
                    url:'<c:url value="/fs/list?path=/" />', 
                    type:'GET', 
                    dataType:'json',
                    success: getfile};
            $.ajax(req)
        
    })
    </script>
</body>
</html>
