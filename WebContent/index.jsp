<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <title>GEMT - Acompanhamento médico</title>
    <meta name="description" content="Sistema de triagem eletrônico e acompanhamento com auxílio de chatbot na comunicação entre médicos e paciêntes">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/custom.css">
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

</head>

<body>

    <header>
        <nav class="fixed-top">
            <div class="container">

                <!--    <div class="logo">
                    <a href="#"></a>
                </div> -->

                <div class="menu">

                    <nav class="navbar  navbar-expand-lg navbar-light">
                        <a class="navbar-brand logo" href="index.html"> <img src="img/logo-gemt.png"></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menuResp" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

                        <div class="collapse navbar-collapse" id="menuResp">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item">
                                    <a class="nav-link js-scroll-trigger" href="#sobre">Sobre </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link js-scroll-trigger" href="#vantagens">Vantagens</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link js-scroll-trigger " href="#formContato">Entre em Contato</a>
                                </li>
                                <!--   <li>
                                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entre em Contato</button>
                                </li>
                                 -->

                            </ul>


                            <!-- 
                            <ul class="nav nav-pills ">
                                



                            </ul> -->

                            <ul class="nav nav-pills ml-auto">
                                <li class="nav-item">
                                    <a class="nav-link active" href="login.jsp"><i class="far fa-user"></i> Login</a>
                                </li>

                               <!--   <li class="nav-item">
                                    <a class="nav-link custom-nav-link" href="cadastro-paciente.html"><i class="far fa-edit"></i> Fazer Cadastro</a>
                                </li> -->

                            </ul>

                        </div>
                    </nav>
                </div>

            </div>

        </nav>


    </header>

    <section class="banner">
        <div class="container">
            <div class="row">
                <div class="col-7">

                    <!--  <div>
                    
                    <h1 class="frase-banner">
                        Aqui iria uma frase de impacto
                    </h1>
                    
                    </div> -->

                    <div class="jumbotron jumbotron-fluid">
                        <div class="container">
                            <h1 class="display-4">GEMT </h1>
                            <p class="lead">Sistema de  Acompanhamento médico</p>

                        </div>
                    </div>

                </div>
            </div>
        </div>

    </section>

    <section class="conteudo pad-t2 pad-top4 c-style-2" id="sobre">
        <div class="container">
            <div class="row">
                <div class=" col-sm-12 col-md-8  col-lg-8">

                    <h2>Sobre</h2>
                    <p>
                        Sistema de Acompanhamento com auxílio de chatbot na comunicação entre médicos e paciêntes.
                    </p>

                    <p>
                        Com o GEMT você poderá consultar informações médicas do seu atendimento sem a necessidade de agendar um nova consulta.

                    </p>

                </div>
                <div class="col-sm-12 col-md-4  col-lg-4">
                    <img src="img/desktop.png" class="img-full">
                </div>
            </div>
        </div>

    </section>

    <section class="conteudo pad-t2 pad-top4 c-style-1" id="vantagens">
        <div class="container">
            <div class="row">

                <div class="col-sm-12 col-md-4  col-lg-4">
                    <img src="img/vantagens.png" class="img-full">
                </div>

                <div class=" col-sm-12 col-md-8  col-lg-8">

                    <h2>Vantagens</h2>

                    <p>
                 

						Você tem a garantia que o seu tratamento será assistido e sempre que precisar poderar abrir uma duvida na sistema, <br>
						e  auxílio do chatbot para consultar informações ulteis.
						

                    </p>


                </div>

            </div>
        </div>

    </section>


    <section class="conteudo pad-t4 c-style-2" id="formContato">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class=" col-sm-12 col-md-8  col-lg-8">

                    <h2>Entre em contato</h2>
                    <br>

                    <form>
                        <div class="form-group ">


                            <label for="exampleInputPassword1">Nome</label>
                            <input type="text" class="form-control" placeholder="Digite seu Nome" required>

                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email</label>
                            <input type="email" class="form-control" placeholder="Digite seu mail" required>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Mensagem</label>

                            <textarea class="form-control" rows="3" required></textarea>
                        </div>


                        <button type="submit" class="btn btn-primary"><i class="far fa-share-square"></i> Enviar</button>
                    </form>
                </div>

            </div>
        </div>

    </section>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col">
                    <p>&copy; GEMT - Acompanhamento médico</p>
                </div>

            </div>
        </div>

    </footer>

    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.easing.min.js"></script>
      <script type="text/jscript" src="js/scripts.js"></script>

    
</body>

</html>
