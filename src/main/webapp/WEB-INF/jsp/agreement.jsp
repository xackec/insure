<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap-datepicker.js"></script>
</head>

<body>

    <div class="generic-container">
    <div class="panel-create"><span class="lead">Оформление договора</span></div>
        <fieldset>
          <legend>Расчёт</legend>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="amount">Страховая сумма</label>
                <input type="text" class="form-control" id="amount" path="amount" placeholder="Сумма в рублях" />
              </div>
			  <div class="form-group col-md-4">
				<label for="validFrom">Действителен с</label>
				<div class="input-group date">
					<input type="text" class="form-control" id="validFrom" placeholder="Дата начала">
					<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
				</div>
			</div>
			<div class="form-group col-md-2">
				<label for="validTo">По</label>
				<div class="input-group date" id="two">
					<input type="text" class="form-control" id="validTo" placeholder="Дата окончания">
                     <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
              </div>
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
            <div class="form-group col-md-6">
              <label for="subjectType">Тип недвижимости</label>
              <select id="subjectType" class="form-control">
					<c:forEach items="<%= com.dev.insure.utils.INSURANCE_OBJECT_TYPE.values() %>" var="state">
						<option value="${state}">${state}</option>        
					</c:forEach>
				</select>
            </div>
            <div class="form-group col-md-6">
              <label for="subjectYear">Год постройки</label>
              <input type="text" class="form-control" id="subjectYear" placeholder="Год">
            </div>
			<div class="form-group col-md-6">
              <label for="square">Площадь</label>
              <input type="text" class="form-control" id="square" placeholder="кв. м.">
            </div>
			<div class="form-group col-md-9 calculate">
              <button type="submit" class="btn btn-primary">Рассчитать</button>
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
</body>
</html>