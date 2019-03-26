<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.dev.insure.model.Client" %>
<%@ page session="true" %>


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
	<spring:url value="/agreements" var="agreementActionUrl" />

	<form:form class="form-group" method="post" modelAttribute="agreement" action="${agreementActionUrl}">

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
                      format: "dd/mm/yyyy",
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
              <form:input type="number" min="1900" max="2019" step="1" path="subject.constructionYear" class="form-control" id="subjectYear" value="2000" />
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
              <input type="button" class="btn btn-primary" onclick="calcFunction()" value="Рассчитать" />
			  <script>
				function calcFunction()
				{
				    var koef1;
					switch(document.getElementById("subjectType").value) {
						case 'Квартира': koef1 = 1.7;
						break;
						case 'Дом': koef1 = 1.5;
						break;
						case 'Комната': koef1 = 1.3;
						break;
					}
					var koef2;
					var temp = document.getElementById("subjectYear").value;
					if(temp<2000) {
						koef2 = 1.3;
					} else if(temp<=2014) {
						koef2 = 1.6;
					} else if(temp>2014) {
						koef2 = 2.0;
					}
					var koef3;
					var tmp = document.getElementById("square").value;
					if(temp<50) {
						koef3 = 1.2;
					} else if(temp<=100) {
						koef3 = 1.5;
					} else if(temp>100) {
						koef3 = 2.0;
					}
					alert(koef1);
					alert(koef2);
					alert(koef3);
					var date1 = new Date(document.getElementById("validFrom").value);
					var date2 = new Date(document.getElementById("validTo").value);
					var timeDiff = Math.abs(date2.getTime() - date1.getTime());
					var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
					var amount = document.getElementById("amount").value;
				    document.getElementById("fee").value = (amount/diffDays)*koef1*koef2*koef3;
					document.getElementById("calcDate").value = new Date().toJSON().slice(0,10).replace(/-/g,'/');
				return false;
				}
				</script>
            </div>
			
			<div class="form-row">
			<spring:bind path="subject.square">
				<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
					<label for="calcDate">Дата расчёта</label>
					<form:input type="text" path="calculationDate" class="form-control" id="calcDate" placeholder="Дата" readonly="true" />
					<form:errors path="calculationDate" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="fee">
				<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
					<label for="fee">Премия</label>
					<form:input type="text" path="fee" class="form-control" id="fee" placeholder="Рубли" />
					<form:errors path="fee" class="control-label" />
				</div>
			</spring:bind>
			</div>
			
          </fieldset>
		  <fieldset>
			<legend></legend>
			<div class="form-row">
			<spring:bind path="id">
				<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
					<label for="num">№ договора</label>
					<form:input type="text" path="id" class="form-control" id="num" placeholder="Номер" />
					<form:errors path="id" class="control-label" />
				</div>
				</spring:bind>
				
				<spring:bind path="submitDate">
				<div class="form-group col-md-6">
					<label for="creationDate">Дата заключения</label>
					<div class="input-group date" id="two">
						<form:input type="text" class="form-control" id="creationDate" path="submitDate" placeholder="Дата" />
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
											+ 800 + ",height=" + height/2);
							mywindow.moveTo(0, 0);
							mywindow.focus();
						}
					</script>
				<input type="button" class="btn btn-primary" onclick='mypopup("http://localhost:8080/clients");' value="Выбрать"/>
				</div>
				
				<spring:bind path="client.id">
					<form:hidden path="client.id" id="hideid" />
				</spring:bind>
				
				<spring:bind path="client.fullName">
				<div class="form-group col-md-4" id="fullname">
					<form:input type="text" class="form-control" id="fullName" path="client.fullName" placeholder="Фамилия Имя Отчество" readonly="true" />
				</div>
				</spring:bind>
				

				<div class="form-group col-md-4">
					<input type="button" class="btn btn-primary" onclick='mypopup("http://localhost:8080/clients/"+document.getElementById("hideid").value);' value="Изменить"/>
				</div>

			</div>
			<div class="form-row">
				<spring:bind path="client.birthDate">
				<div class="form-group col-md-4">
				<label for="birthDate">Дата рождения</label>
					<div class="input-group date">
						<form:input type="text" class="form-control" id="birthDate" path="client.birthDate" placeholder="Дата" readonly="true" />
						 <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
					</div>	
				</div>
				</spring:bind>
				
				<spring:bind path="client.passportS">
				<div class="form-group col-md-4">
					<label for="serial">Паспорт: серия</label>
					<form:input type="text" class="form-control" id="serial" path="client.passportS" placeholder="Серия" readonly="true" />
				</div>
				</spring:bind>
				
				<spring:bind path="client.passportN">
				<div class="form-group col-md-4">
					<label for="number">№</label>
					<form:input type="text" class="form-control" id="number" path="client.passportN" placeholder="Номер" readonly="true" />
				</div>
				</spring:bind>
			</div>
		  </fieldset>
		  <fieldset>
			<legend>Адрес недвижимости</legend>
				<div class="form-row">
					<spring:bind path="subject.state">
						<div class="form-group col-sm-2 ${status.error ? 'has-error' : ''}">
						  <label for="subjectstate">Государство</label>
								<form:select path="subject.state" id="subjectstate" items="<%= com.dev.insure.utils.STATES.values() %>" multiple="false" size="1" class="form-control" />
								<form:errors path="subject.state" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="subject.postcode">
						<div class="form-group col-sm-2 ${status.error ? 'has-error' : ''}">
							<label for="postcode">Почтовый индекс</label>
							<form:input type="text" class="form-control" id="postcode" path="subject.postcode" placeholder="Индекс" />
							<form:errors path="subject.postcode" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="subject.region">
						<div class="form-group col-sm-4 ${status.error ? 'has-error' : ''}">
							<label for="region">Республика</label>
							<form:input type="text" class="form-control" id="region" path="subject.region" placeholder="Название" />
							<form:errors path="subject.region" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="subject.district">
						<div class="form-group col-sm-4 ${status.error ? 'has-error' : ''}">
							<label for="district">Район</label>
							<form:input type="text" class="form-control" id="district" path="subject.district" placeholder="Название" />
							<form:errors path="subject.district" class="control-label" />
						</div>
					</spring:bind>
				</div>		
				<div class="form-row">
					<spring:bind path="subject.city">
						<div class="form-group col-sm-4 ${status.error ? 'has-error' : ''}">
							<label for="city">Населенный пункт</label>
							<form:input type="text" class="form-control" id="city" path="subject.city" placeholder="Название" />
							<form:errors path="subject.city" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="subject.street">
						<div class="form-group col-sm-4 ${status.error ? 'has-error' : ''}">
							<label for="street">Улица</label>
							<form:input type="text" class="form-control" id="street" path="subject.street" placeholder="Название" />
							<form:errors path="subject.street" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="subject.buildnum">
						<div class="form-group col-sm-1 ${status.error ? 'has-error' : ''}">
							<label for="buildnum">Дом</label>
							<form:input type="text" class="form-control" id="buildnum" path="subject.buildnum"  />
							<form:errors path="subject.buildnum" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="subject.part">
						<div class="form-group col-sm-1 ${status.error ? 'has-error' : ''}">
							<label for="part">Корпус</label>
							<form:input type="text" class="form-control" id="part" path="subject.part"  />
							<form:errors path="subject.part" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="subject.bldg">
						<div class="form-group col-sm-1 ${status.error ? 'has-error' : ''}">
							<label for="bldg">Строение</label>
							<form:input type="text" class="form-control" id="bldg" path="subject.bldg"  />
							<form:errors path="subject.bldg" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="subject.flatnum">
						<div class="form-group col-sm-1 ${status.error ? 'has-error' : ''}">
							<label for="flatnum">Квартира</label>
							<form:input type="text" class="form-control" id="flatnum" path="subject.flatnum"  />
							<form:errors path="subject.flatnum" class="control-label" />
						</div>
					</spring:bind>
				</div>
				 <div class="form-group">
					  <label for="comment">Комментарий (не печатается на полисе)</label>
					  <textarea style="overflow:auto;resize:none" class="form-control" rows="4" id="comment"><c:out value="${comment}" /></textarea>
				</div> 
				<div class="form-row">
					<div class="form-group col-sm-6" id="chooseBtn">
						<c:choose>
						  <c:when test="${agreement['new']}">
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
						<input type="submit" class="btn btn-primary" onclick='self.close();return false;' value="Закрыть"/>
					</div>
				</div>
		</fieldset>
    </div>
	</form:form>
</body>
</html>