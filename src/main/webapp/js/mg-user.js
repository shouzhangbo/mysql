// JavaScript Document
var serUrl = "http://192.168.1.112:8080/mysql/";
var productName = "",status=2,start='',end='',pageSize=5,currentPage=1,totalPage=0;
$(function(){
	
	initFa();
	initLeft();
	initDate();
	
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
	$('.btn-ok').click(function(){
		$.ajax({
			type: "POST",
			url: serUrl+"bguser/add.json",
			data:{
				userName:$('.file-1').val(),
				userPsd:$('.file-2').val(),
				status:$('.file-3').val(),
				roleId:$('.file-4').val(),
			},
			dataType: "json",
			success: function(data){
				console.log(data);
				$('.alertbox-2').hide();
				initDate();
			},
			error:function(){     
			  alert('网络异常。')
			}
		});
		$('.alertbox-2').hide();
	})
});
function initDate(){
	$.ajax({
		type: "POST",
		url: serUrl+"bguser/query.json",
		data:{
			menuName:''//$('.file-1').val()
		},
		dataType: "json",
		success: function(data){
			console.log(data);
			if('0000'==data.respCode){
				var str = '';
				for(var i=0;i<data.list.length;i++){
					str = str + '<tr>';
					str = str + '<td><input type="checkbox" /><td>'+data.list[i].mgUserId+'</td><td>'+data.list[i].mgUserName+'</td>';
					str = str + '<td>'+data.list[i].statusName+'</td><td>'+data.list[i].roleName+'</td><td>2015-01-11 10:00:11</td>';
					str = str + '<td><a href="javascript:;" class="check">查看</a>|<a href="javascript:;" class="update">修改</a>|<a href="javascript:;" class="delete">删除</a></td>';
					str = str + '</tr>';
				}
				$('.data-tab tbody').children('tr').remove();
				$('.data-tab tbody').append(str);
			}
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
}
function initFa(){
	$.ajax({
		type: "POST",
		url: serUrl+"role/query.json",
		data:{
			menuName:''//$('.file-1').val()
		},
		dataType: "json",
		success: function(data){
			console.log(data);
			if('0000'==data.respCode){
				var str = '';
				for(var i=0;i<data.list.length;i++){
					str = str + '<option value="'+data.list[i].roleId+'">'+data.list[i].roleName+'</option>';
				}
				$('.up-option').children('option').remove();
				$('.up-option').append(str);
			}
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
}