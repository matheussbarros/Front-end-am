<%@include file="header.jsp"%>

<%
	String user = null;
	int codMed = 0;
	Usuario usuario = (Usuario) session.getAttribute("user");

	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	} else if (usuario.getNivel() != 2) {
		response.sendRedirect("login.jsp");
	} else {
		user = usuario.getNome();
		codMed = usuario.getCod();
	}
%>

<div class="wrapper">
	<nav id="sidebar">
		<div class="sidebar-header">

			<!--  <div class="avatar">
                
                    <img src="img/doctor.png" alt="" title="">
                </div> -->

			<h3>
				Olá, Dr(a)
				<%=user%>
			</h3>
			<strong>BS</strong>
		</div>


		<ul class="list-unstyled components nav" id="myTab" role="tablist">

			<li class=" nav-item "><a class="nav-link active "
				id="list-pac-tab" data-toggle="tab" href="#lista-pac" role="tab"
				aria-controls="lista-pac">Lista de Paciêntes</a></li>

			<li class="nav-item"><a class="nav-link" id="acomp-tab"
				data-toggle="tab" href="#acomp" role="tab" aria-controls="acomp">Acompanhamentos</a></li>

			<li class="nav-item"><a class="nav-link" id="duv-tab"
				data-toggle="tab" href="#duvidas" role="tab" aria-controls="duvidas">Responder
					duvidas</a></li>

			<br>


			<form method="post" action="logout">

				<button type="submit" id="btn-logout" value="logout"
					class="btn btn-success">Sair</button>
			</form>

		</ul>

	</nav>


	<div class="tab-content" id="content">


		<div class="tab-pane fade show active" id="lista-pac" role="tabpanel"
			aria-labelledby="med-tab">
			<ul class="list-group">

				<%
					List<Paciente> pacientes = PacienteBO.listaDePaciente();
					for (Paciente p : pacientes) {
				%>

				<li
					class="list-group-item d-flex justify-content-between align-items-center"
					data-id="<%=p.getCod()%>"><%=p.getNome()%> <span
					data-toggle="modal" data-target="#exampleModal" data-t="tooltip"
					data-placement="top" title="Abrir Acompanhamento"
					class="badge badge-primary badge-pill acomp"><i
						class="fas fa-plus"></i></span></li>

				<%
					}
				%>

			</ul>

		</div>

		<div class="tab-pane fade" id="acomp" role="tabpanel"
			aria-labelledby="med-tab">

			<h2>Meus Acompanhamentos</h2>

			<%
				
			
			
			List<Acompanhamento> acomps = AcompanhamentoBO.listAcomPorMed(codMed);
			for (Acompanhamento ac : acomps) {
			//System.out.println(ac.getNome());
			
			
			
			%>


			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title"><%=ac.getNome() %></h5>
					<h6 class="card-subtitle mb-2 text-muted"><%=ac.getAbertura() %></h6>
					<p class="card-text"><%=ac.getDescricao() %></p>
					<a href="#" class="card-link btn-admin">Abrir</a>

				</div>
			</div>

<%} %>

		<!-- 	<ul class="list-group">
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					Acompanhamento 1 <span class="badge badge-primary badge-pill acomp"><i
						class="fas fa-plus"></i></span>
				</li>
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					Acompanhamento 2<span class="badge badge-primary badge-pill acomp"><i
						class="fas fa-plus"></i></span>
				</li>
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					Acompanhamento 3 <span class="badge badge-primary badge-pill acomp"><i
						class="fas fa-plus"></i></span>
				</li>
			</ul>-->
		</div>

		<div class="tab-pane fade" id="duvidas" role="tabpanel"
			aria-labelledby="med-tab">
			<ul class="list-group">
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					Duvida 1 <span class="badge badge-primary badge-pill acomp"><i
						class="fas fa-plus"></i></span>
				</li>
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					Duvida 2<span class="badge badge-primary badge-pill acomp"><i
						class="fas fa-plus"></i></span>
				</li>
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					Duvida 3 <span class="badge badge-primary badge-pill acomp"><i
						class="fas fa-plus"></i></span>
				</li>
			</ul>
		</div>

		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Abrir
							Acompanhamento para :</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="AddAcomp" method="post">

							<div class="form-group">
								<label for="recipient-name" class="col-form-label">Codigo
									do Acompanhamento:</label> <input type="text" name="codAcomp"
									class="form-control fmCodigo" id="recipient-name">
							</div>
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">Motivo:</label>
								<input type="text" class="form-control" id="recipient-name"
									name="nome"> <input type="hidden" name="codMedico"
									value="<%=codMed%>" class="form-control" id="recipient-name">
								<input type="hidden" name="codPaciente" value=""
									class="form-control" id="recipient-name" required>

							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">Descrição:</label>
								<textarea class="form-control" name="descricao"
									id="message-text" required></textarea>
							</div>

							<div class="form-group">
								<label for="dt-abertura" class="col-form-label">Data
									Abertura:</label> <input type="text" class="form-control fmData"
									name="abertura" id="dt-abertura" required>

							</div>
							<div class="form-group">
								<label for="dt-encerramento" class="col-form-label">Data
									Encerramento:</label> <input type="text" class="form-control fmData"
									name="encerramento" id="dt-encerramento" required>
							</div>

							<div class="modal-footer">
								<button type="submit" class="btn btn-primary">Confirmar</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Fechar</button>

							</div>
						</form>
					</div>

				</div>
			</div>
		</div>

	</div>

</div>

<div class="modal fade" tabindex="-1" role="dialog" id="alertNewAcomp">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Acompanhamento aberto com Sucesso</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>

			</div>
		</div>
	</div>
</div>


<%@include file="footer.jsp"%>

<script>
	$('#exampleModal').on(
			'show.bs.modal',
			function(event) {
				var button = $(event.relatedTarget) // Button that triggered the modal
				var recipient = button.data('whatever') // Extract info from data-* attributes
				// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				var paciente = button.parent("li").text();
				var dataId = button.parent("li").attr('data-id');
				console.log(paciente);
				console.log(button);
				console.log(dataId);
				var modal = $(this)
				modal.find('.modal-title').text(
						'Abrir Acompanhamento para: ' + paciente + '?')
				modal.find(".modal-body input[name='codPaciente']").val(dataId)
			})

	if ($.cookie('newAcomp')) { //if cookie isset
		//do stuff here like hide a popup when cookie isset
		//document.getElementById("hideElement").style.display = "none";
		$('#alertNewAcomp').modal('show');
		console.log("Existe cookie");
	} else {
		//var CookieSet = $.cookie('cookie', 'value'); //set cookie
	}
</script>

</body>

</html>
