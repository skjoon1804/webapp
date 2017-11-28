<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="no-js modern">
<title> Fabflix </title>

<link rel="stylesheet" href="./css/style.css" />
<link href="http://fonts.googleapis.com/css?family=Sansita+One" rel="stylesheet" />

<body>
<div id="reg">
  <h2 title="Login"> Login Page </h2>

  <form id="login_form" action="login" method="post">
    <p>
      <label for="u_email"> e-mail </label>
      <input id = "u_email" name ="u_email" type ="text" placeholder="email adress" required />
    </p>

    <p>
      <label for="u_password"> password </label>
      <input id = "u_password" name ="u_password" type ="password" placeholder="password" required />
    </p>

    <p id="submit">
      <button id="f_login_submit" type="submit" title="f_login_submit_form"> submit </button>
    </p>

    <%--<div class="g-recaptcha" data-sitekey="6LcJxR4TAAAAAEy0kGDclcpEVXSfQiQJfsNtudou"></div>--%>
  </form>
</div>
</body>
</html>
