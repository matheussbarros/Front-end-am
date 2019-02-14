<%@include file="header.jsp"%>

<%
	String user = null;
	Usuario usuario = (Usuario) session.getAttribute("user");
	int codPac = usuario.getCod();
	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	} else if (usuario.getNivel() != 3) {
		response.sendRedirect("login.jsp");
	} else {
		user = usuario.getNome();
	}
%>

<div class="wrapper">



	<nav id="sidebar">
		<div class="sidebar-header">

			<!--    <div class="avatar">

                    <img src="img/user.png" alt="" title="">
                </div> -->

			<h3>
				Olá,
				<%=user%></h3>
			<strong>BS</strong>
		</div>

		<ul class="list-unstyled components nav" id="myTab" role="tablist">


			<li class=" nav-item"><a class="nav-link active"
				id="lista-acomp-tab" data-toggle="tab" href="#lista-acomp"
				role="tab" aria-controls="lista-acomp">Acompanhamentos</a></li>

			<li class="nav-item"><a class="nav-link" id="duvidas-tab"
				data-toggle="tab" href="#duvidas" role="tab" aria-controls="duvidas">Dúvidas</a></li>

			<li class="nav-item"><a class="nav-link" id="cad-duvidas-tab"
				data-toggle="tab" href="#cad-duvidas" role="tab"
				aria-controls="cad-duvidas">Cadastrar Duvidas</a></li>

			<li class="nav-item"><a class="nav-link" id="chatbot"
				data-toggle="modal" data-target="#exampleModalCenter"> <i
					class="fas fa-robot"></i> GEMT Chatbot
			</a></li>


			<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModalCenter">GEMT ChatBot</button> -->

			<form method="post" action="logout">

				<button type="submit" id="btn-logout" value="logout"
					class="btn btn-success">Sair</button>
			</form>

		</ul>


	</nav>


	<div class="tab-content" id="content">
		<div class="tab-pane fade show active" id="lista-acomp"
			role="tabpanel" aria-labelledby="lista-acomp-tab">
			<h2>Acompanhamentos</h2>


			<%
				
			List<Acompanhamento> acomps = AcompanhamentoBO.listAcomPorPac(codPac);
			for (Acompanhamento ac : acomps) {
			//System.out.println(ac.getNome());
				
			
			%>


			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title"><%=ac.getNome() %></h5>
					<h6 class="card-subtitle mb-2 text-muted"><%=ac.getAbertura() %></h6>
					<p class="card-text"><%=ac.getDescricao() %></p>
					<!-- <a href="#" class="card-link btn-admin">Abrir</a> -->

				</div>
			</div>
			
			<% } %>
			
		</div>

		<div class="tab-pane fade" id="duvidas" role="tabpanel"
			aria-labelledby="duvidas-tab">
			<h2>Dúvidas Abertas</h2>

		</div>

		<div class="tab-pane fade" id="cad-duvidas" role="tabpanel"
			aria-labelledby="cad-duvidas-tab">

			<h2>Cadastrar Dúvidas</h2>

		</div>


		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Fale com
							o GEMT Chabot</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div id="textchat" class="pulse"></div>

						<div class="center">
							<form method="post">
								<div style="margin-bottom: 25px" class="input-group">
									<textarea type="text" class="form-control" id="question"
										name="question" title="Digite o numero"
										placeholder="Digite sua Mensagem" required></textarea>
								</div>

								<!-- <input type="text" id="question" name="question" class="field"
							placeholder="Type your question" /> -->
								<button class="chat-bt" id="sendQuestion">Enviar</button>
							</form>
						</div>

					</div>
					<!-- 	<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div> -->


				</div>
			</div>
		</div>






		<!--  <div class="line"></div> -->



	</div>

</div>

<%@include file="footer.jsp"%>
<script type="text/javascript" src="js/main.js"></script>
<script>
	$('#exampleModal').on('show.bs.modal', function(event) {
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
		//modal.find('.modal-title').text('Deletar paciente ' + paciente +'?')
		//modal.find('.modal-body input').val(recipient)
	})
</script>

</body>

</html>
