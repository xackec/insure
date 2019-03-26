<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="/css/main.css" rel="stylesheet">
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap-datepicker.js"></script>
</head>

<body>
	<spring:url value="/clients" var="clientActionUrl" />
	<form:form class="form-group" method="post" modelAttribute="client" action="${clientActionUrl}">
		<div class="generic-container">
		<c:choose>
			<c:when test="${client['new']}">
				<div class="panel-create"><span class="lead">Новый клиент</span></div>
			</c:when>
			<c:otherwise>
				<div class="panel-create"><span class="lead">Обновить клиента</span></div>
			</c:otherwise>
		</c:choose>
			<fieldset>
				  <legend></legend>
						<div class="form-row">
							<spring:bind path="fullName">
								<div class="form-group col-sm-6 ${status.error ? 'has-error' : ''}">
									<label for="surname">ФИО</label>
									<form:input type="text" class="form-control" id="surname" path="fullName" placeholder="Фамилия Имя Отчество" />
									<form:errors path="fullName" class="control-label" />
								</div>
							</spring:bind>
						  
							<spring:bind path="birthDate">
								<div class="form-group col-sm-4 ${status.error ? 'has-error' : ''}">
									<label for="birthDate">Дата рождения</label>
									<div class="input-group date" id="two">
										<form:input type="text" class="form-control" id="birthDate" path="birthDate" placeholder="Дата" />
										 <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
									</div>
								</div>
							</spring:bind>
								<script>
								  $('.input-group.date').datepicker({
									  format: "dd/mm/yyyy",
									  todayBtn: "linked",
									  autoclose: true,
									  todayHighlight: true
								  });
							  </script>
							  
						</div>
						<div class="form-row">
						
							  <spring:bind path="passportS">
								<div class="form-group col-sm-6 ${status.error ? 'has-error' : ''}">
									<label for="serial">Паспорт: серия</label>
									<form:input type="text" class="form-control" id="serial" path="passportS" placeholder="Серия" />
									<form:errors path="passportS" class="control-label" />
								</div>
							  </spring:bind>
								
								<spring:bind path="passportN">
								<div class="form-group col-sm-6 ${status.error ? 'has-error' : ''}">
									<label for="number">№</label>
									<form:input type="text" class="form-control" id="number" path="passportN" placeholder="Номер" />
									<form:errors path="passportN" class="control-label" />
								</div>
								</spring:bind>
							</div>
							
							<div class="form-row">
								<div class="form-group col-sm-6" id="chooseBtn">
									<c:choose>
									  <c:when test="${client['new']}">
										 <button type="submit" class="btn btn-primary pull-right">Добавить
													 </button>
									  </c:when>
									  <c:otherwise>
										 <button type="submit" class="btn btn-primary pull-right">Обновить
													 </button>
									  </c:otherwise>
									</c:choose>
								</div>
								<div class="form-group col-sm-6" id="closeBtn">
									<input type="submit" class="btn btn-primary" onclick='window.location.href = "/agreements";return false;' value="Закрыть"/>
								</div>
							</div>
			</fieldset>
		</div>
	</div>
	</form:form>
</body>

</html>