<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <title>GEMT - Cadastro Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/custom.css">
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

</head>

<body class="login">

    <header>
        <nav>
            <div class="container">


                <div class="menu">

                    <nav class="navbar navbar-expand-lg navbar-light">
                        <a class="navbar-brand logo" href="index.html"> <img src="img/logo-gemt.png"></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menuResp" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

                        <div class="collapse navbar-collapse" id="menuResp">


                            <ul class="nav nav-pills ml-auto">


                                <li class="nav-item">
                                    <a class="nav-link custom-nav-link" href="index.html"><i class="fas fa-undo"></i> Voltar</a>
                                </li>

                            </ul>

                        </div>
                    </nav>
                </div>

            </div>

        </nav>


    </header>


    <section class="conteudo pad-t2">
        <div class="container">
            <div class="row justify-content-md-center">




                <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 ">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Como desaja se cadastrar</div>
                        </div>

                        <div style="padding-top:30px" class="panel-body">


                            <p>
                                <a class="btn btn-outline-primary" href="cadastro-paciente.html" role="button">
                                
    Paciênte
  </a>
                                <a class="btn btn-primary" href="cadastro-instituicao.html" role="button">
   Instituição de Saúde
  </a>

                            </p>


                            <div class="" id="instituicao">

                                <form id="loginform" class="form-horizontal" role="form">

                                    <div style="margin-bottom: 25px" class="input-group">
                                        <input type="text" class="form-control" name="nomeEmpresa" value="" placeholder="Empresa" required>
                                    </div>

                                    <div style="margin-bottom: 25px" class="input-group">
                                        <input type="text" class="form-control" name="razaoSocial" placeholder="Razão Social" required>
                                    </div>

                                    <div style="margin-bottom: 25px" class="input-group">
                                        <input type="text" id="cnpj" class="form-control" name="cnpj" placeholder="CNPJ" required>
                                    </div>

                                    <div style="margin-bottom: 25px" class="input-group">
                                        <input type="text" class="form-control" name="endereco" placeholder="Endereço" required>
                                    </div>

                                    <div style="margin-bottom: 25px" class="input-group">
                                       
                                        <input type="email" id="email" class="form-control" name="email" placeholder="Email" title="" required> 
                                    </div>

                                    <div style="margin-bottom: 25px" class="input-group">
                                        <input type="text" class="form-control" name="fone" placeholder="Telefone" required>
                                    </div>



                                    <div class="input-group">

                                    </div>


                                    <div style="margin-top:10px" class="form-group">
                                        <!-- Button -->

                                        <div class="col-sm-12 controls">

                                            <button type="submit" id="btn-login" href="#" class="btn btn-success"> Enviar</button>
                                        </div>

                                        <div class="col-sm-12 controls">
                                            <div class="copy-login">
                                                <p>&copy; GEMT - Triagem e acompanhamento médico</p>
                                            </div>
                                        </div>
                                    </div>



                                </form>
                            </div>




                        </div>
                    </div>
                </div>



            </div>
        </div>

    </section>




    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script type="text/javascript" src="js/jquery.mask.js"></script>
    <script type="text/jscript" src="js/scripts.js"></script>

</body>

</html>
