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
	<div class="generic-container">
		<div class="panel-create"><span class="lead">Новый клиент</span></div>
			<fieldset>
				  <legend></legend>
					  <form:form method="POST" modelAttribute="client" class="form-horizontal">
						  <div class="row form-inline">
							<div class="col-md-4">
								<form:input type="text" path="surname" id="surname" class="form-control" placeholder="Фамилия"/>
											  <div class="has-error">
												  <form:errors path="surname" class="help-inline"/>
											  </div>
							</div>
							<div class="col-md-4">
								<form:input type="text" path="name" id="name" class="form-control" placeholder="Имя"/>
											  <div class="has-error">
												  <form:errors path="name" class="help-inline"/>
											  </div>
							</div>
							<div class="col-md-4">
								<form:input type="text" path="name2" id="name2" class="form-control" placeholder="Отчество"/>
											  <div class="has-error">
												  <form:errors path="name2" class="help-inline"/>
											  </div>
							</div>
						</div>
						<div class="row form-inline">
							  <div class="form-group col-md-12" id="birthdt">
							  <label for="birth">Дата рождения</label>
									<div class="input-group date">
										<form:input type="text" path="birthDate" id="birth" class="form-control" placeholder="Дата рождения"/>
										 <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
									</div>
								  		<script>
															  $('.input-group.date').datepicker({
																  format: "yyyy/mm/dd",
																  todayBtn: "linked",
																  autoclose: true,
																  todayHighlight: true
															  });
										</script>
							  </div>
						</div>
                    </form:form>
			</fieldset>
	</div>
</body>

</html>