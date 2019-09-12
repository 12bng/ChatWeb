<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<section id="login" class="row">

	<form action="" method="post">
		<div class="form-group row">
			<label for="user" class="col-sm-2 col-form-label">Usuario</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="user" name="user"
					placeholder="Usuario" value="${login.user}">
			</div>
		</div>
		<div class="form-group row">
			<label for="password" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Password">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Aceptar</button>
				<a class="btn btn-danger" href="listado">Cancelar</a>
			</div>
		</div>
	</form>
</section>
