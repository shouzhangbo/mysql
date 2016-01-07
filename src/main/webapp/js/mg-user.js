// JavaScript Document
var serUrl = "http://192.168.1.112:8080/mysql/";
var productName = "",status=2,start='',end='',pageSize=5,currentPage=1,totalPage=0;
$(function(){
	
	//initFa();
	initLeft();
	
	$('.left dl dd').hide();
	$('.left dl').eq(0).children('dd').show();
	$('.left dl').eq(0).children('dt').addClass('ok');
	$('.left dl').eq(0).children('dt').children('p').html('<<');
	$('.left dl').click(function(){
		if($(this).children('dd').is(":hidden")){
			$(this).children('dd').show();
			$(this).children('dt').addClass('ok');
			$(this).children('dt').children('p').html('<<');
		}else{
			$(this).children('dd').hide();
			$(this).children('dt').removeClass('ok');
			$(this).children('dt').children('p').html('>>');
		}
		
	})
	
	//新增
	$('.add-new').click(function(){
		$('.alertbox-2').show();
		$('.alertbox-2 .btn-ok').addClass('btn-add-new');
	});
});