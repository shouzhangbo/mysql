// JavaScript Document
$(function(){
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
	//关闭弹出框
	$('.alertbox-close').click(function(){
		$('.alertbox').hide();
	});
	$('.btn-cancl').click(function(){
		$('.alertbox').hide();	
	});
	$('.js-btn-close').click(function(){
		$('.alertbox').hide();
	});
	//全选
	$('.all-select').click(function(){
		if($(this).is(':checked')){
			//选择	
			$(".table-2 input[type='checkbox']").attr('checked','true');
		}else{
			//不选
			$(".table-2 input[type='checkbox']").removeAttr('checked');
		}
	});
	//查看
	$('.check').click(function(){
		var strArr=$(this).parent().prevAll();
		for(var i=0;i<strArr.length;i++){
			$('.file-'+i).attr("disabled",true);
			$('.file-'+i).val(strArr[i].innerHTML);
		}
		$('.btn-cancl').hide();
		$('.btn-ok').attr("onClick",'test();');
		$('.btn-ok').val('关闭');
		$('.alertbox-2').show();
	});
	//删除
	$('.delete').click(function(){
		var str=$(this).parent().prevAll()[3].innerHTML;
		$('.alertbox-1 .alertbox-content').html('你确定要删除'+str+'商品吗？');
		$('.alertbox-1').show();
	});
	//切换页签
	$('.tab li').click(function(){
			$('.tab li').removeClass('active');
			$(this).addClass('active');
	});
	//新增
	$('.add-new').click(function(){
		$('.alertbox').show();	
	});
	//全删除
	$('.all-dele').click(function(){
		var strArr = $(".table-2 input[type='checkbox']");
		var j=0;
		for(var i=0;i<strArr.length;i++){
			if(strArr[i].checked==false){
				if(i>0){
					j++;
				}
			}
		}
		if(j>0){
			
			$('.alertbox-1 .alertbox-content').html('请选择一个');
			$('.alertbox-1 .alertbox-btn-content').addClass('w-80');
			$('.btn-cancl').hide();
			$('.btn-ok').attr('onClick','test();');
			$('.alertbox-1').show();
		}
	});
	//分页
	$('.page-data li').click(function(){
		console.log($(this).index())
		if($(this).index()==3){
			return;	
		}
		$('.page-data li').removeClass('ok');
		$(this).addClass('ok');
	});
	$('.page-f-1').click(function(){
		//首页
		$('.page-data li').removeClass('ok');
		$('.page-data li').eq(0).addClass('ok');
	});
	$('.page-f-2').click(function(){
		//尾页
		var i = $('.page-data li.ok').index();
		$('.page-data li').removeClass('ok');
		$('.page-data li').eq($('.page-data li').length-1).addClass('ok');
	});
	$('.page-f-3').click(function(){
		//上一页
		var i = $('.page-data li.ok').index();
		$('.page-data li').removeClass('ok');
		$('.page-data li').eq(i-1).addClass('ok');
	});
	$('.page-f-4').click(function(){
		//下一页
		var i = $('.page-data li.ok').index();
		$('.page-data li').removeClass('ok');
		$('.page-data li').eq(i+1).addClass('ok');
	});
});
function test(){
	$('.alertbox').hide();
};