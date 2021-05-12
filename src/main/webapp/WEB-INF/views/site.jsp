<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link href='http://fonts.googleapis.com/css?family=Nixie+One'
	rel='stylesheet' type='text/css'>
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900"
	rel="stylesheet">

</head>
<body>
	<div class="loader">
		<div>
			<img src="${img}/icons/preloader.gif" />
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 left-wrapper">
				<div class="event-banner-wrapper">
					<div class="page">
						<div class="navigation">
							<ul>
								<h1><a href="main">Home</a></h1>
								<h2>MY Link Site</h2>
								<c:forEach var="cat" items="${cat_list}">
									<li>
									<a href="site?no=${cat.catNo}">${cat.name} &nbsp</a> 
									<a href="categoryUpdate?no=${cat.catNo}&name=${cat.name}"><span class="glyphicon glyphicon-pencil"></span>&nbsp</a> 
									<a href="categoryDeleteAction?no=${cat.catNo}"><span class="glyphicon glyphicon-remove"></span></a>
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

						<div class="tab-content">
							<div role="tabpanel" class="tab-pane fade in active"
								id="buyTicket">
								<div class="row">
									<br /><br /><br /><br />

									<!--  card  -->
									<c:forEach var="site" items="${site_list}">			
										<div class="col-md-6">
											<div class="ticketBox">
												<div class="inactiveStatus"></div>

												<div class="row">
													<div class="col-xs-6">
														<div class="ticket-name">
															<a href="siteDetail?linkNo=${site.linkNo}">
																${site.title} </a> <span> </span>
					
														</div>
													</div>

													<div class="col-xs-6">
														<div class="ticket-price-count-box">
															<div class="ticket-control">
																<div class="input-group">

																	<input type="text" name="quant[1]"
																		class="form-control input-number"> <span
																		class="input-group-btn">
																		<button
																			onclick="location.href='siteUpdate?linkNo=${site.linkNo}&catNo=<c:out value="${param.no}" />'"
																			type="button">
																			<span class="glyphicon glyphicon-pencil"></span>
																		</button>
																		<button
																			onclick="location.href='siteDeleteAction?linkNo=${site.linkNo}&catNo=<c:out value="${param.no}" />'"
																			type="button">
																			<span class="glyphicon glyphicon-remove"></span>
																			
																		</button>
																	</span>
																</div>
															</div>

														</div>
													</div>
												</div>

												<div class="ticket-description">
													<p>
														<strong>${site.link}</strong><br>${site.content}</p>
												</div>
											</div>
										</div>
									</c:forEach>
									<!--  card end -->

									<div class="col-md-6">
										<div class="ticketBox">

											<a href="siteAdd?no=<c:out value="${param.no}"/>"><span
												class="glyphicon glyphicon-plus"></span> 링크추가 </a> <br/>
											<br /><br /><br /><br />

										</div>
									</div>
									

								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

			<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
			<!-- Include all compiled plugins (below), or include individual files as needed -->
			<script src="${js}/bootstrap.min.js"></script>
			<script src="${js}/allscript.js"></script>
</body>
</html>
