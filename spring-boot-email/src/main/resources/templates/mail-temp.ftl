<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FreeMarker 邮件</title>
</head>
<style>
    h1{
        background-color: cyan;
    }
</style>
<body>
<h1>这是一封 Freemarker邮件</h1>

<table>
    <tr>
        <td>序号</td>
        <td>标题</td>
        <td>创建时间</td>

    </tr>
<img src="https://img1.baidu.com/it/u=413643897,2296924942&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500">
    <#list articles as article>
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.createTime?string('yyyy-MM-dd hh:mm:ss')}</td>

        </tr>
    </#list>
</table>
</body>

</html>