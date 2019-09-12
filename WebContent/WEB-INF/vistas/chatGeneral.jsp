<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="accesoADatos.MessageList, modelo.Message" %>
<section id="chatGeneral" class="row">
<table>
<thead><h1>Mensajes</h1></thead>
<tbody>
<% for(Message mensaje: MessageList.getList()){  %>
<tr>
<td>
<%= mensaje.getDate() %>
</td>
<td>
<%= mensaje.getUsername() %>
</td>
<td>
<%= mensaje.getMessage()  %>
</td>
</tr>
<%} %>
</tbody>
</table>


	<form action="chatGeneral" method="post">
		<div class="form-group row">
			<div class="col-sm-10">
				<input type="text" class="form-control" id="message" name="message"
					placeholder="Escribe aqui tu mensaje...">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Enviar</button>
			</div>
		</div>
	</form>
	
	
</section>