<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="css" value='/resources/css' />
<c:url var="js" value='/resources/js' />
<c:url var="img" value='/resources/images' />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
    <title>My Link</title>

    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <link href="${css}/custom.css" rel="stylesheet">

    <link href='http://fonts.googleapis.com/css?family=Nixie+One' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900" rel="stylesheet">

  </head>
  <body>
 	<div class="loader">
		<div>
			<img src="${img}/icons/preloader.gif" />
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
		<img src="${img}/main.PNG">
			<div class="col-sm-3 left-wrapper">
				<div class="event-banner-wrapper">
					<div class="page">
						<div class="navigation">
							<ul>
								<h1><a href="main">Home</a></h1>
								<h2>Bookmark </h2>
								<c:forEach var="cat" items="${cat_list}">
									<li>
									<a href="site?no=${cat.no}">${cat.name} &nbsp</a> 
									<a href="categoryUpdate?no=${cat.no}&name=${cat.name}"><span class="glyphicon glyphicon-pencil"></span>&nbsp</a> 
									<a href="categoryDeleteAction?no=${cat.no}" onclick="return confirm('삭제하시겠습니까?');"><span class="glyphicon glyphicon-remove"></span></a>
									</li>
								</c:forEach>
							</ul>
							<ul>
								<a href="categoryAdd"><span class="glyphicon glyphicon-plus"></span>카테고리 추가 </a>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-7 right-wrapper">
				<div class="event-ticket-wrapper">

					<div class="event-tab">
                
                  <!-- Tab panes -->
                  <div class="tab-content">
                  
                    <div role="tabpanel" class="tab-pane fade in active" id="buyTicket">
                    
                    	<div class="row">
                        
                        	<h1>📘 MY Link Collection</h1>
                        	<h2>나만의 링크 컬렉터를 만들어보세요.</h2>
                        	<br/>
                        	<p>📢 공지사항</p>
                        	<p>1. 사용자 가이드</p>
                        	<p>2. 업데이트 안내</p>
                        	<p>3. 서버 안정화 작업 안내</p>
                        	<p>4. 문의 안내</p>
                        </div>
                    </div>                          
                </div>
     	
            </div>
        </div>
    </div>


    
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/allscript.js"></script>
  </body>
</html>
