<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Connection_Pooling </title>
</head>
<body>

<p>
    <h1>Connection pooling</h1>

    When a search is done on a website, servlet opens the connection to the database server every time <br>
    when larger number of data request comes in, there exists a overhead on entering the database.
    With the Connection pooling, the server keeps the data connection open util the user set time so that the when user asks for a data, <br>
    open connection just goes into the database and fetch the data. So there exists low overhead for connecting the data.<br>

    <br>
    When user enters the url, Apache server uses load balancer to redirect the web pages so that load on the one server splits. <br>
    Also when the load balancing is used, throughput goes up where the distributed server gets the higher throughput to the data.<br>

    <br>

    There was network overload due to network usage of my house mates so the data output was not consistent.<br>

</p>
</body>
</html>