
<%@ include file="header.jsp" %>
<%
    List<Movie> mvlist =(List<Movie>) request.getSession().getAttribute("movielist");
%>


<div id="reg">
    <h2 title="View"> Movie View </h2>
        
    <table class="list_of_serach">
        <thead>
            <tr class="search_table_head">
            <th><a href=""/>ID</th>
            <th><a href=""/>title</th>
            <th><a href=""/>year</th>
            <th><a href=""/>director</th>
            <th><a href=""/>list of genre</th>
            <th><a href=""/>stars</th>
            <th><a href=""/>cart</th>
            </tr>
        </thead>


        <tbody>
        <%
            for(Movie mv : mvlist){ %>
            <tr class="search_table_content">
                <td> <%out.print(mv.id);%></td>
                <td><a class ="title_page" href="searchSingleMovie?f_id=<%out.print(mv.id);%>"/><%out.print(mv.title);%></td>

                <td><%out.print(mv.year);%></td>
                <td><%out.print(mv.director);%></td>

                <td><%
                    for(Genre ge : mv.lgenres){
                        out.println(ge.name);
                    }
                %></td>
                <td><%
                    for(Actor ac : mv.lstar){
                        out.println(ac.name);
                    }
                %></td>
                <td name="cart"></td>
            </tr>
        <% } %>

        </tbody>
    </table>
</div>


</body>
</html>