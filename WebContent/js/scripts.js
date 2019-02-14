$(document).ready(function() {
	var $cpf = $("#cpf");
	$cpf.mask('00000000000', {
		reverse : true
	});

	var $cnpj = $("#cnpj");
	$cnpj.mask('00.000.000/0000-00', {
		reverse : true
	});
	
	/*var $dtNascimento = $("#dt-nasc");
	$dtNascimento.mask('99/99/9999', {
		reverse : true  fmCpf
	});*/
	
	$(".fmData").mask("99/99/9999");
	$(".fmCodigo").mask("999999");
	$(".fmCpf").mask("99999999999");
	$(".fmCep").mask("99999999");
	$(".fmFone").mask("99999999999");
	$(".fmNumEnd").mask("99999");

});

(function($) {
	"use strict"; // Start of use strict

	// Smooth scrolling using jQuery easing
	$('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(
			function() {
				if (location.pathname.replace(/^\//, '') == this.pathname
						.replace(/^\//, '')
						&& location.hostname == this.hostname) {
					var target = $(this.hash);
					target = target.length ? target : $('[name='
							+ this.hash.slice(1) + ']');
					if (target.length) {
						$('html, body').animate({
							scrollTop : (target.offset().top - 54)
						}, 1000, "easeInOutExpo");
						return false;
					}
				}
			});

	// Closes responsive menu when a scroll trigger link is clicked
	$('.js-scroll-trigger').click(function() {
		$('.navbar-collapse').collapse('hide');
	});

	// Activate scrollspy to add active class to navbar items on scroll
	$('body').scrollspy({
		target : '#mainNav',
		offset : 54
	});

})(jQuery); // End of use strict
