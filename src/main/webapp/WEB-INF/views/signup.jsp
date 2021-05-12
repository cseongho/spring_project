<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="css" value='/resources/css' />
<c:url var="js" value='/resources/js' />
<c:url var="img" value='/resources/images' />
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="${css}/login.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
  </head>
  <body>

<form action="signupAction" method="post">
<div class="container">
  <div class="login-icon">
      <i class="glyphicon glyphicon-tint"></i> MY SITE
  </div>
  <div class="login-form">
    <div class="login-title">
      Sign Up
    </div>
    <div class="login-input-parts">
      <input type="text" name="id" class="login-input" required="required" autofocus="autofocus" placeholder="Enter ID"/>
      <input type="password" name="pwd" class="login-input" required="required" placeholder="Enter Password"/>
      <input type="text" name="email" class="login-input" required="required" placeholder="Enter Email-address"/>
      <input type="submit" class="login-input button" type="button" value="Sign Up"/>
    </div>  
  </div>
</div>
</form>

  </body>
</html>
