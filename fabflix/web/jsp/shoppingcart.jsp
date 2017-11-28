<%@ include file="header.jsp" %>

    <div id="reg">
        <h2 title="View"> Shopping Cart </h2>
        
        <table class="list_of_serach">
            <thead>
                <tr class="search_table_head">
                <th><a />ID</th>
                <th><a />title</th>
                <th><a />Quantity</th>
                <th></th>
            </tr>
        </thead> 
        <tbody>
            <tr class="search_table_content">
                <td>dddddd</td>
                <td>dddddd</td>
                <td><input id="q_sub" name="q_sub" type="number" placeholder="1" style="width: 20px"></td>
                <td> <button id="q_change" type="submit" title="q_change"> change </button> </td>
                
            </tr>
            <tr class="search_table_content">
                <td>dddddd</td>
                <td>dddddd</td>
                <td> <input id="q_sub" name="q_sub" type="number" placeholder="1" style="width: 20px"> </td>
                <td> <button id="q_change" type="submit" title="q_change"> change </button> </td>
            </tr>
        </tbody>
        <div class="move_move" style="float: right">
            <form class="checkout" action="#" method="post">
                <button id="process" type="submit" title="process"> process checkout </button>
            </form>
        </div>
        </div>
        
    </body>
</html>