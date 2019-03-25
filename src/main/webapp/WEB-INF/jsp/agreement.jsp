<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<head>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap-datepicker.js"></script>
</head>

<jsp:include page="fragments/header.jsp" />

<body>

	<c:choose>
		<c:when test="${agreement['new']}">
			<h1>Новый договор</h1>
		</c:when>
		<c:otherwise>
			<h1>Изменить договор</h1>
		</c:otherwise>
	</c:choose>
	<br />
	
	<spring:url value="/agreements" var="agreementActionUrl" />

	<form:form class="form-group" method="post" modelAttribute="agreement" action="${agreementActionUrl}">
	
	<form:hidden path="id" />

    <div class="generic-container">
        <fieldset>
          <legend>Расчёт</legend>
            <div class="form-row">
			<spring:bind path="amount">
              <div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
                <label for="amount">Страховая сумма</label>
                <form:input type="text" class="form-control" id="amount" path="amount" placeholder="Сумма в рублях" />
				<form:errors path="amount" class="control-label" />
              </div>
			 </spring:bind>
			 
			 <spring:bind path="validFrom">
			  <div class="form-group col-md-4 ${status.error ? 'has-error' : ''}">
				<label for="validFrom">Действителен с</label>
				<div class="input-group date">
					<form:input type="text" class="form-control" id="validFrom" path="validFrom" placeholder="Дата начала" />
					<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
				</div>
			  </div>
			</spring:bind>
			
			<spring:bind path="validTo">
			<div class="form-group col-md-2 ${status.error ? 'has-error' : ''}">
				<label for="validTo">По</label>
				<div class="input-group date" id="two">
					<form:input type="text" class="form-control" id="validTo" path="validTo" placeholder="Дата окончания" />
                     <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
              </div>
			</div>
			</spring:bind>
              <script>
                  $('.input-group.date').datepicker({
                      format: "yyyy/mm/dd",
                      todayBtn: "linked",
                      autoclose: true,
                      todayHighlight: true
                  });
              </script>
            </div>
			
			<spring:bind path="subject.objType">
            <div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
              <label for="subjectType">Тип недвижимости</label>
					<form:select path="subject.objType" id="subjectType" items="<%= com.dev.insure.utils.INSURANCE_OBJECT_TYPE.values() %>" multiple="false" size="1" class="form-control" />
					<form:errors path="subject.objType" class="control-label" />
            </div>
			</spring:bind>
			
			<spring:bind path="subject.constructionYear">
            <div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
              <label for="subjectYear">Год постройки</label>
              <form:input type="number" min="1900" max="2019" step="1" path="subject.constructionYear" class="form-control" id="subjectYear" />
			  <form:errors path="subject.constructionYear" class="control-label" />
            </div>
			</spring:bind>
			
			<spring:bind path="subject.square">
			<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
              <label for="square">Площадь</label>
              <form:input type="text" path="subject.square" class="form-control" id="square" placeholder="кв. м." />
			  <form:errors path="subject.square" class="control-label" />
            </div>
			</spring:bind>
			
			<div class="form-group col-md-9 calculate">
              <button class="btn btn-primary" onclick="calcFunction()">Рассчитать</button>
			  <script>
				function calcFunction()
				{
				document.getElementById("fee").value = "123.45";
				document.getElementById("calcDate").value = "now";
				return false;
				}
				</script>
            </div>
			
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="calcDate">Дата расчёта</label>
					<input type="text" class="form-control" id="calcDate" placeholder="Дата">
				</div>
				<div class="form-group col-md-6">
					<label for="fee">Премия</label>
					<input type="text" class="form-control" id="fee" placeholder="Рубли">
				</div>
			</div>
          </fieldset>
		  <fieldset>
			<legend></legend>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="num">№ договора</label>
					<input type="text" class="form-control" id="num" placeholder="Номер">
				</div>
				<div class="form-group col-md-6">
					<label for="creationDate">Дата заключения</label>
					<input type="text" class="form-control" id="creationDate" placeholder="Дата">
				</div>
			</div>
		  </fieldset>
		  <fieldset>
			<legend>Страхователь</legend>
			<div class="form-row">
				<div class="form-group col-md-4" id="chooseBtn">
					<script type="text/javascript">
						function mypopup(url) {
							width = window.screen.width;
							height = window.screen.height;
							mywindow = window.open(url, "Title",
								"location=0,status=1,scrollbars=1,resizable=1,menubar=0,toolbar=no,width="
											+ width/1.92 + ",height=" + height/2);
							mywindow.moveTo(0, 0);
							mywindow.focus();
						}
					</script>
				<input type="submit" class="btn btn-primary" onclick='mypopup("http://localhost:8080/clients");return false;' value="Выбрать"/>
				</div>
				<div class="form-group col-md-4" id="fullname">
					<input type="text" class="form-control" id="fullName" placeholder="Фамилия Имя Отчество">
				</div>
				<div class="form-group col-md-4">
					<button type="submit" class="btn btn-primary">Изменить</button>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
				<label for="validFrom">Дата рождения</label>
					<div class="input-group date">
						<input type="text" class="form-control" id="birthDate" placeholder="Дата рождения">
						<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
					</div>	
				</div>
				<div class="form-group col-md-4">
					<label for="serial">Паспорт: серия</label>
					<input type="text" class="form-control" id="serial" placeholder="Серия">
				</div>
				<div class="form-group col-md-4">
					<label for="number">№</label>
					<input type="text" class="form-control" id="number" placeholder="Номер">
				</div>
			</div>
		  </fieldset>
    </div>
	</form:form>
</body>
</html>