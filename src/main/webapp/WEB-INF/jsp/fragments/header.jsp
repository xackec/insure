<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Управление договорами</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="/css/main.css" rel="stylesheet">
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/create" var="urlAddAgreement" />
<spring:url value="/clients/new" var="urlAddClient" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Управление страховыми договорами</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddAgreement}">Добавить договор</a></li>
				<li class="active"><a href="${urlAddClient}">Добавить клиента</a></li>
			</ul>
		</div>
	</div>
</nav>