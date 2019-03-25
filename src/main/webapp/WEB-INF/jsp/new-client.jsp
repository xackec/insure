<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="/css/main.css" rel="stylesheet">
</head>

<body>
	<div class="generic-container">
		<div class="panel-create"><span class="lead">Новый клиент</span></div>
			<fieldset>
				  <legend></legend>
					  <form:form method="POST" modelAttribute="client" class="form-horizontal">
                              <form:input type="hidden" path="id" id="id"/>
                              <div class="row">
                                  <div class="form-group col-md-12">
                                      <label class="col-md-3 control-lable" for="fullName">First Name</label>
                                      <div class="col-md-7">
                                          <form:input type="text" path="fullName" id="fullName" class="form-control input-sm"/>
                                          <div class="has-error">
                                              <form:errors path="fullName" class="help-inline"/>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                      </form:form>
			</fieldset>
	</div>
</body>

</html>