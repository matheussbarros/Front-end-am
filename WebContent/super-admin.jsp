<%@include file="header.jsp"%>

<%
	String user = null;
	Usuario usuario = (Usuario) session.getAttribute("user");

	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	} else if (usuario.getNivel() != 1) {
		response.sendRedirect("login.jsp");
	} else {
		user = usuario.getNome();
	}
%>

<div class="wrapper">



	<nav id="sidebar">
		<div class="sidebar-header">

			<!--  <div class="avatar">
                                
                                    <img src="img/instituicao.png" alt="" title="">
                                </div> -->

			<h3>
				Olá,
				<%=user%></h3>
			<strong>BS</strong>
		</div>

		<ul class="list-unstyled components nav" id="myTab" role="tablist">

			<li class=" nav-item"><a class="nav-link active"
				id="cad-med-tab" data-toggle="tab" href="#cad-medicos" role="tab"
				aria-controls="cad-medicos">Cadastrar Médicos</a></li>

			<li class="nav-item"><a class="nav-link" id="med-tab"
				data-toggle="tab" href="#lista-medicos" role="tab"
				aria-controls="lista-medicos">Lista de Médicos</a></li>

			<li class="nav-item"><a class="nav-link" id="cad-pac-tab"
				data-toggle="tab" href="#cad-pac" role="tab" aria-controls="cad-pac">Cadastrar
					Pacientes</a></li>

			<li class="nav-item"><a class="nav-link" id="pac-tab"
				data-toggle="tab" href="#lista-pacientes" role="tab"
				aria-controls="lista-pacientes">Lista de Pacientes</a></li>

			<br>

			<form method="post" action="logout">

				<button type="submit" id="btn-logout" value="logout"
					class="btn btn-success">Sair</button>
			</form>
		</ul>
	</nav>


	<div class="tab-content" id="content">

		<!-- <div class="tab-content">
			<div class="tab-pane" id="lista-medicos" role="tabpanel"
				aria-labelledby="med-tab">LISTA DE MEDICOS</div>
		</div>-->
		<div class="tab-pane fade show active" id="cad-medicos"
			role="tabpanel" aria-labelledby="cad-med-tab">
			<h2>Cadastrar novo Médico</h2>
			<form id="loginform" class="form-horizontal" role="form"
				action="AddMedico" method="post">
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control" name="nome" title="Nome"
						placeholder="Nome" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control" name="crm" title="CRM"
						placeholder="CRM" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control" name="especialidade"
						title="Especialidade" placeholder="Especialidade" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="email" class="form-control" name="email" title="Email"
						placeholder="Email" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control" name="senha" title="Senha"
						placeholder="Senha" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control fmFone" name="fone"
						title="Telefone" placeholder="Telefone" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control fmCodigo" name="cod"
						placeholder="Código de Usuario" required>
				</div>

				<h5>Endereco</h5>

				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control" name="logradouro"
						title="Nome da Rua/Av..." placeholder="Nome da Rua/Av" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control fmNumEnd" name="numero"
						title="Digite o numero" placeholder="Numero" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control fmCep" name="cep"
						title="Digite o Cep" placeholder="CEP" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control" name="bairro"
						title="Digite o bairro" placeholder="Bairro" required>
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control" name="cidade"
						title="Digite o bairro" placeholder="Cidade" required>
				</div>

				<div style="margin-bottom: 25px" class="input-group">
					<input type="text" class="form-control" name="estado"
						title="Digite o estado" placeholder="Estado" required>
				</div>
				<div class="input-group"></div>
				<div style="margin-top: 10px" class="form-group">
					<!-- Button -->
					<div class="col-sm-12 controls">
						<button type="submit" id="btn-login" href="#"
							class="btn btn-success">Cadastrar</button>
					</div>
					<div class="col-sm-12 controls"></div>
				</div>
			</form>
		</div>

		<div class="tab-pane fade" id="lista-medicos" role="tabpanel"
			aria-labelledby="med-tab">

			<ul class="list-group">

				<%
					List<Medico> medicos = MedicoBO.listaDeMedico();
					for (Medico m : medicos) {
				%>
				<li
					class="list-group-item d-flex justify-content-between align-items-center"
					data-id="<%=m.getCod()%>" data-nvl="<%=m.getNivel()%>"><%=m.getNome()%>
					<span class="badge badge-primary badge-pill btnDelete"
					data-toggle="modal" data-target="#exampleModal" data-t="tooltip"
					data-placement="top" title="Excluir Usuario"><i
						class="fas fa-times"></i></span></li>

				<%
					}
				%>
				<!-- <li
					class="list-group-item d-flex justify-content-between align-items-center" data-id="">
					Nome Paciente <span
					class="badge badge-primary badge-pill btnDelete"
					data-toggle="modal" data-target="#exampleModal"><i
						class="fas fa-times"></i></span>
				</li>
				<li
					class="list-group-item d-flex justify-content-between align-items-center" data-id="">
					Nome Paciente <span
					class="badge badge-primary badge-pill btnDelete"
					data-toggle="modal" data-target="#exampleModal"><i
						class="fas fa-times"></i></span>
				</li>-->
			</ul>

		</div>

		<div class="tab-pane fade" id="cad-pac" role="tabpanel"
			aria-labelledby="pac-tab">
			<div class="tab-pane fade show active" id="cad-medicos"
				role="tabpanel" aria-labelledby="cad-med-tab">
				<h2>Cadastrar Paciente</h2>
				<form id="loginform" class="form-horizontal" role="form"
					action="addPaciente" method="post">
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control" name="nome" title="Nome"
							placeholder="Nome" required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control fmCpf" name="cpf" 
							title="Digite o CPF" placeholder="CPF" required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control fmData" name="dt-nasc" id="dt-nasc"
							title="Data de Nascimento" placeholder="Data de Nascimento"
							required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="email" class="form-control" name="email"
							title="Digite o Email" placeholder="Email" required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control" name="senha"
							title="Digita a Senha" placeholder="senha" required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control fmFone" name="fone"
							title="Digite o Telefone" placeholder="Telefone" required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control fmCodigo" name="cod"
							title="Codigo para o Usuario" placeholder="Codigo" required>
					</div>

					<h5>Endereco</h5>

					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control" name="logradouro"
							title="Nome da Rua/Av..." placeholder="Nome da Rua/Av" required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control fmNumEnd" name="numero"
							title="Digite o numero" placeholder="Numero" required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control fmCep" name="cep"
							title="Digite o Cep" placeholder="CEP" required>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control" name="bairro"
							title="Digite o bairro" placeholder="Bairro" required>
					</div>

					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control" name="cidade"
							title="Digite a Cidade" placeholder="Cidade" required>
					</div>

					<div style="margin-bottom: 25px" class="input-group">
						<input type="text" class="form-control" name="estado"
							title="Digite o estado" placeholder="Estado" required>
					</div>

					<div class="input-group"></div>
					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->
						<div class="col-sm-12 controls">
							<button type="submit" id="btn-login" href="#"
								class="btn btn-success">Cadastrar</button>
						</div>
						<div class="col-sm-12 controls"></div>
					</div>
				</form>
			</div>
		</div>

		<div class="tab-pane fade" id="lista-pacientes" role="tabpanel"
			aria-labelledby="med-tab">





			<ul class="list-group">

				<%
					List<Paciente> pacientes = PacienteBO.listaDePaciente();
					for (Paciente p : pacientes) {
				%>
				<li
					class="list-group-item d-flex justify-content-between align-items-center"
					data-id="<%=p.getCod()%>" data-nvl="<%=p.getNivel()%>"><%=p.getNome()%> <span
					class="badge badge-primary badge-pill btnDelete"
					data-toggle="modal" data-target="#exampleModal" data-t="tooltip"
					data-placement="top" title="Excluir Usuario"><i
						class="fas fa-times"></i></span></li>

				<%
					}
				%>
				<!-- <li
					class="list-group-item d-flex justify-content-between align-items-center"
					data-id="3">Nome Paciente <span
					class="badge badge-primary badge-pill btnDelete"
					data-toggle="modal" data-target="#exampleModal"><i
						class="fas fa-times"></i></span>
				</li>-->
				<!-- <li
					class="list-group-item d-flex justify-content-between align-items-center"
					data-id="4">Nome Paciente <span
					class="badge badge-primary badge-pill btnDelete"
					data-toggle="modal" data-target="#exampleModal"><i
						class="fas fa-times"></i></span>
				</li>-->
			</ul>

		</div>

		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Excluir
							Usuario: ?</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="deleteUser" method="post">
							<div class="form-group">
								<!-- <label for="recipient-name" class="col-form-label">Recipient:</label> -->
								<input type="hidden" name="cod" value="" class="form-control"
									id="recipient-name"> <input type="hidden" name="nvl"
									value="" class="form-control" id="recipient-name">
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-primary">Confirma</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Não</button>

							</div>

						</form>
					</div>

				</div>
			</div>
		</div>

		<div class="modal fade" tabindex="-1" role="dialog" id="alertNewUser">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Usuario Adicionado com Sucesso</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fechar</button>

					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" tabindex="-1" role="dialog" id="alertDelUser">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Usuario Excluido com Sucesso</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fechar</button>

					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" tabindex="-1" role="dialog" id="NotDelUser">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Usuario não pode ser Excluido, existe acompanamentos em aberto</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fechar</button>

					</div>
				</div>
			</div>
		</div>
		


		<!--  <div class="line"></div> -->



	</div>

</div>



<%@include file="footer.jsp"%>


<script>
	$('#exampleModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var recipient = button.data('whatever') // Extract info from data-* attributes
		// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		var paciente = button.parent("li").text();
		var dataId = button.parent("li").attr('data-id');
		var dataNvl = button.parent("li").attr('data-nvl');
		console.log(paciente);
		console.log(button);
		console.log(dataId);
		console.log(dataNvl);
		var modal = $(this)
		//modal.find('.modal-title').text('Deletar paciente ' + paciente +'?')
		modal.find(".modal-body input[name='cod']").val(dataId);
		modal.find(".modal-body input[name='nvl']").val(dataNvl);
	})

	$(document).ready(function() {
		if ($.cookie('delUser')) { //if cookie isset
			//do stuff here like hide a popup when cookie isset
			//document.getElementById("hideElement").style.display = "none";
			$('#alertDelUser').modal('show');
			console.log("Existe cookie");
		} else {
			//var CookieSet = $.cookie('cookie', 'value'); //set cookie
		}
		
		if ($.cookie('NotDelUser')) { //if cookie isset
			//do stuff here like hide a popup when cookie isset
			//document.getElementById("hideElement").style.display = "none";
			$('#NotDelUser').modal('show');
			console.log("Existe cookie");
		}else {
			//var CookieSet = $.cookie('cookie', 'value'); //set cookie
		}

		if ($.cookie('newUser')) { //if cookie isset
			//do stuff here like hide a popup when cookie isset
			//document.getElementById("hideElement").style.display = "none";
			$('#alertNewUser').modal('show');
			console.log("Existe cookie");
		} else {
			//var CookieSet = $.cookie('cookie', 'value'); //set cookie
		}
	});
</script>


</body>

</html>