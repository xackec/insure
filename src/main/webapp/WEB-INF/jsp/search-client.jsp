<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="/css/popup.css" rel="stylesheet">
</head>

<body>
<div class="generic-container">
    <div class="panel-create"><span class="lead">Выбрать клиента</span></div>
		<fieldset>
			  <legend></legend>
			  <div class="row">
				<div class="col-sm-3">
							<input type="text" class="form-control" id="surname" placeholder="Фамилия">
				</div>
				<div class="col-sm-3">
                			<input type="text" class="form-control" id="name1" placeholder="Имя">
                </div>
                <div class="col-sm-3">
                             <input type="text" class="form-control" id="name2" placeholder="Отчество">
                </div>
				<div class="col-sm-1">
					<input type="button" class="btn btn-default" onclick="concat()" value="Поиск" />
				</div>
				<script type="text/javascript">
						function concat() {
							window.location.href = "/clients/search-" + document.getElementById("surname").value + " " + document.getElementById("name1").value + " " + document.getElementById("name2").value;
						}
					</script>
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
						<script type="text/javascript">
							function closepopup(fname, bdate, sn) {
								window.opener.document.getElementById('fullName').value = fname;
								window.opener.document.getElementById('birthDate').value = bdate;
								window.opener.document.getElementById('serial').value = sn.substr(0,4);
								window.opener.document.getElementById('number').value = sn.substr(4);
								self.close();
							}
						</script>
                    <tbody>
					<c:if test="${empty clients}">
						<tr>
                            <td>Нет подходящих записей</td>
						</tr>
					</c:if>
					<c:forEach items="${clients}" var="client">
                        <tr>
                            <td>${client.fullName}</td>
                            <td>${client.birthDate}</td>
                            <td>${client.passportSN}</td>
                            <td><button class="btn btn-primary btn-sm" onclick='closepopup("${client.fullName}","${client.birthDate}","${client.passportSN}");'>Выбрать</button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
    </table>
	<div class="form-row">
		<div class="form-group col-sm-6" id="chooseBtn">
				<input type="submit" class="btn btn-primary" onclick='mypopup("http://localhost:8080/clients/new");return false;' value="Новый"/>
		</div>
		<div class="form-group col-sm-6" id="closeBtn">
			<input type="submit" class="btn btn-primary" onclick='self.close();return false;' value="Закрыть"/>
		</div>
	</div>
</div>
</body>
</html>