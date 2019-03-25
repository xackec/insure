<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="/css/main.css" rel="stylesheet">
</head>

<body>
<div class="generic-container">
    <div class="panel-create"><span class="lead">Выбрать клиента</span></div>
		<fieldset>
			  <legend></legend>
			  <div class="form-row">
				<div class="form-group col-md-3">
						<div class="form-group col-md-4">
							<input type="text" class="form-control" id="surname" placeholder="Фамилия">
						</div>
				</div>
				<div class="form-group col-md-3">
                		<div class="form-group col-md-4">
                			<input type="text" class="form-control" id="name" placeholder="Имя">
                		</div>
                </div>
                <div class="form-group col-md-3">
                        <div class="form-group col-md-4">
                             <input type="text" class="form-control" id="name" placeholder="Отчество">
                        </div>
                </div>
				<div class="form-group col-md-3">
					<button type="submit" class="btn btn-primary">Поиск</button>
				</div>
			  </div>
		</fieldset>
	<table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ФИО</th>
                            <th>Дата рождения</th>
                            <th>Паспортные данные</th>
                            <th width="100"></th>
                            <th width="100"></th>
                        </tr>
                    </thead>
                    <tbody>
					<c:if test="${empty clients}">
						<tr>
                            <td>Нет подходящих записей</td>
						</tr>
					</c:if>
					<c:forEach items="${clients}" var="client">
                        <tr>
                            <td>${client.fullName}</td>
                            <td>${client.birthdate}</td>
                            <td>${client.passportSN}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
    </table>
	<div class="form-row">
		<div class="form-group col-md-6" id="chooseBtn">
					<script type="text/javascript">
						function mypopup(url) {
							width = window.screen.width;
							height = window.screen.height;
							mywindow = window.open(url, "Title",
								"location=0,status=1,scrollbars=1,resizable=0,menubar=0,toolbar=no,width="
											+ width + ",height=" + height);
							mywindow.moveTo(0, 0);
							mywindow.focus();
						}
					</script>
				<input type="submit" class="btn btn-primary" onclick='mypopup("http://localhost:8080/clients/new");return false;' value="Новый"/>
		</div>
		<div class="form-group col-md-6" id="closeBtn">
			<input type="submit" class="btn btn-primary" onclick='self.close();return false;' value="Закрыть"/>
		</div>
	</div>
</div>
</body>
</html>