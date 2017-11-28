<%@ include file="header.jsp" %>

<div id="reg">
        <h2 title="Search_movie"> Search Movie </h2>
        
        <form id="serach_movie" action="searching" method="get">
            <p>
                <label for="f_title"> title </label>
                <input id="f_title" name="f_title" type="text" placeholder="eg) Harry Potter">
            </p>
            <p>
                <label for="f_year"> year </label>
                <input id="f_year" name="f_year" type="text" placeholder="eg) 2010">
            </p>
            <p>
                <label for="f_director"> director </label>
                <input id="f_director" name="f_director" type="text" placeholder="Steven Stillburg">
            </p>
            <p>
                <label for="f_first_name"> firstname of the star </label>
                <input id="f_first_name" name="f_first_name" type="text" placeholder="Jack">
            </p>
            <p>
                <label for="f_last_name"> last name of the star </label>
                <input id="f_last_name" name="f_last_name" type="text" placeholder="Black">
            </p>
            <p>
               <button id="u_login_s" type="submit" title="u_login_s"> submit </button>
            </p>
            
        </form>
    </div>
    </body>
</html>