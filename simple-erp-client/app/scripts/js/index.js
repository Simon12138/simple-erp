$(document).ready(function() {
	$('.nav-pills > li > a').click(function(event) {
		$(event.target).parent().addClass('active');
		$(event.target).parent().siblings().removeClass('active');
	});

	$('.dropdown.crm').dropdown();

	$('.ui.back').click(function() {
		window.history.back();
	});
});