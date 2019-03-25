<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="/css/main.css" rel="stylesheet">
</head>

<jsp:include page="fragments/header.jsp" />

<body>
	<div class="generic-container">
            <div class="panel panel-default">
                  <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">Список договоров</span></div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Серия-Номер</th>
                            <th>Дата заключения</th>
                            <th>Страхователь</th>
                            <th>Премия</th>
                            <th>Срок действия</th>
                            <th width="100"></th>
                            <th width="100"></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${agreements}" var="agreement">
                        <tr>
                            <td>${agreement.id}</td>
                            <td>${agreement.validFrom}</td>
                            <td>${agreement.client.fullName}</td>
                            <td>${agreement.fee}</td>
                            <td>${agreement.validTo}</td>
							<td><a href="<c:url value="/agreements/${agreement.id}" />">Открыть</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
</body>

<jsp:include page="fragments/footer.jsp" />

</html>