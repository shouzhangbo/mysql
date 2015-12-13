// JavaScript Document
var serUrl = "http://localhost:8080/mysql/";
var productName = "",status=2,start='',end='',pageSize=5,currentPage=1,totalPage=0;
$(function(){
	initFa();
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
	//表格初始化
	initData();
	
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
	
	
	//切换页签
	$('.tab li').click(function(){
			$('.tab li').removeClass('active');
			$(this).addClass('active');
	});
	//新增
	$('.add-new').click(function(){
		$('.alertbox-2').show();
		$('.alertbox-2 .btn-ok').addClass('btn-add-new');
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
//上传图片提供给iframe调用的方法
function imgCallBack(img){
	//预览图片
	$('#img1').attr('src',img);
}
//上传图片
$('.upImg-1').live('change',function(){
	$('#form1').submit();
});
//搜索
$('#search').live('click',function(){
	productName = $('#name').val();
	status=$('#status').val();
	start=$('#start').val();
	end=$('#end').val();
	initData();
});
//新增-添加
$('.btn-add-new').live("click", function(){
	$.ajax({
		type: "POST",
		url: serUrl+"addCategory.json",
		data:{
			categoryName:$('.file-1').val(),
			categoryDesc:$('.file-2').val(),
			categoryIndex:$('.file-3').val(),
			categoryImg:$('#img1').attr('src')
		},
		dataType: "json",
		success: function(data){
			alert('ok');
			$('.alertbox').hide();
			remove();
			initData();
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
});
$('.btn-alert-delete').live("click", function(){
	$.ajax({
		type: "POST",
		url: serUrl + "getCategory.json",
		data:{
			categoryName:$('.file-1').val(),
			categoryName:$('.file-2').val(),
			categoryName:$('.file-3').val(),
			status:$('.alert-inp option:selected').val()
		},
		dataType: "json",
		success: function(data){
			alert('ok');
			$('.alertbox').hide();
			remove();
			initData();
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
});
//查看
$('.check').live('click',function(){
	var strArr=$(this).parent().prevAll();
	var j=0;
	for(var i=strArr.length-3;i>=0;i--){
		j++;
		$('.file-'+j).attr("disabled",true);
		if(j==3||j==4){
			for(var m=0;m<$('.file-'+j+' option').length;m++){
				if($('.file-'+j+' option').eq(m).val()==strArr[i].innerHTML){
					$('.file-'+j+' option').eq(m).selected = true;
					break;
				}
			}
		}else{
			$('.file-'+j).val(strArr[i].innerHTML);
			$('.file-'+j).html(strArr[i].innerHTML);
		}
	}
	$('.alert-inp').attr("disabled",true);
	$('.btn-cancl').hide();
	$('.btn-ok').attr("onClick",'test();');
	$('.btn-ok').val('关闭');
	$('.btn-ok').addClass('btn-cancl');
	
	$('.alertbox-2 .upImg').addClass('hide');
	$('.alertbox-2').show();
});
//修改
$('.update').live('click',function(){
	var strArr=$(this).parent().prevAll();
	var j=0;
	for(var i=strArr.length-3;i>=0;i--){
		j++;
		$('.file-'+j).attr("disabled",false);
		if(j==3||j==4){
			for(var m=0;m<$('.file-'+j+' option').length;m++){
				if($('.file-'+j+' option').eq(m).val()==strArr[i].innerHTML){
					$('.file-'+j+' option').eq(m).selected = true;
					break;
				}
			}
		}else{
			$('.file-'+j).val(strArr[i].innerHTML);
			$('.file-'+j).html(strArr[i].innerHTML);
		}
	}
	$('.alertbox-2 .btn-ok').addClass('btn-alert-update');
	$('.alertbox-2').show();
});
//删除
$('.delete').live('click',function(){
	var str=$(this).parent().prevAll()[3].innerHTML;
	$('.alertbox-1 .alertbox-content').html('你确定要删除'+str+'商品吗？');
	$('.alertbox-1 .btn-ok').attr('onClick','deleDate('+$(this).parent().prevAll()[1].innerHTML+');');
	$('.alertbox-1').show();
});
//确认删除
function deleDate(id){
	$.ajax({
		type: "POST",
		url: serUrl+"deletCategory.json",
		data:{
			categoryId:id
		},
		dataType: "json",
		success: function(data){
			console.log(data)
			alert('ok');
			$('.alertbox').hide();
			remove();
			initData();
		},
		error:function(){     
		  alert('网络异常。')
		}
	});	
}
//关闭弹出框
$('.alertbox-close').live('click',function(){
	$('.alertbox').hide();
	$('.alertbox-2 .btn-ok').removeClass('btn-add-new');
	$('.alertbox-2 .btn-ok').removeClass('btn-cancl');
	$('.alertbox-2 .btn-ok').removeClass('btn-alert-update');
	$('.alertbox-1 .btn-ok').removeClass('btn-alert-delete');
	$('.alertbox-2 .btn-ok').val('确认');
	
	$('.alertbox-2 .upImg').removeClass('hide');
	$('.btn-cancl').show();
	//除去新增
	for(var i=0;i<10;i++){
		$('.file-'+i).attr("disabled",false);
		$('.file-'+i).val('');
	}
});
$('.btn-cancl').live('click',function(){
	$('.alertbox').hide();	
	$('.alertbox-2 .btn-ok').removeClass('btn-add-new');
	$('.btn-ok').removeClass('btn-cancl');
	$('.alertbox-2 .btn-ok').removeClass('btn-alert-update');
	$('.alertbox-1 .btn-ok').removeClass('btn-alert-delete');
	
	$('.alertbox-2 .upImg').removeClass('hide');
	$('.alertbox-2 .btn-ok').val('确认');
	$('.btn-cancl').show();
	//除去新增
	for(var i=0;i<10;i++){
		$('.file-'+i).attr("disabled",false);
		$('.file-'+i).val('');
	}
});
$('.js-btn-close').live('click',function(){
	$('.alertbox').hide();
});
//弹框修改
$('.btn-alert-update').live('click',function(){
	$.ajax({
		type: "POST",
		url: serUrl+"getCategory.json",
		data:{
			categoryName:$('.file-1').val(),
			categoryName:$('.file-2').val(),
			categoryName:$('.file-3').val(),
			status:$('.alert-inp option:selected').val()
		},
		dataType: "json",
		success: function(data){
			alert('ok');
			initData();
		},
		error:function(){     
		  alert('网络异常。')
		}
	});	
});
function remove(){
	$('.alertbox-2 .btn-ok').removeClass('btn-add-new');
	$('.btn-ok').removeClass('btn-cancl');
	$('.alertbox-2 .btn-ok').removeClass('btn-alert-update');
	$('.alertbox-1 .btn-ok').removeClass('btn-alert-delete');
	$('.alertbox-2 .btn-ok').val('确认');
}
//加载上级
function initFa(){
	$.ajax({
		type: "POST",
		url: serUrl+"queryCateThr.json",
		data:{
			status:1,
			pageSize:100,
			currentPage:1
		},
		dataType: "json",
		success: function(data){
			console.log(data)
			var str = '';
			for(var i=0;i<data.list.length;i++){
				str = str + '<option value="'+data.list[i].cateThrId+'">'+data.list[i].cateThrName+"</option>";
			}
			$('.up-option').append(str);
		},
		error:function(){     
			  //alert('网络异常。')
		}
	});
}
function initData(){
	$.ajax({
		type: "POST",
		url: serUrl+"queryProduct.json",
		data:{
			productName:productName,
			productStatus:status,
			startTime:start,
			endTime:end,
			currentPage:currentPage,
			pageSize:pageSize
		},
		dataType: "json",
		success: function(data){
			/*<tr>
                        	<td><input type="checkbox" /><td>1</td><td>三星手机</td><td>三星曲面平手机</td><td>上线</td>
                            <td>手机</td><td><img src="../../images/proImg9.jpg" /></td><td>10000</td><td>￥12.00</td><td>2015-01-11 10:00:11</td>
                            <td><a href="javascript:;" class="check">查看</a>|<a href="javascript:;" class="update">修改</a>|<a href="javascript:;" 								class="delete">删除</a></td>
                        </tr>*/
			var appe = '';
			console.log(data);
			if('0000'==data.respCode){
				for(var i=0;i<data.list.length;i++){
					var str = '<tr><td><input type="checkbox" /></td>';
					var tdSt = '<td>';
					var tdEn = '</td>';
					var opt = '<td><a href="javascript:;" class="check">查看</a>|<a  href="javascript:;" class="update">修改</a>|<a href="javascript:;" class="delete">删除</a></td>';
					
					str = str + tdSt + data.list[i].productId + tdEn;
					str = str + tdSt + data.list[i].productName + tdEn;
					str = str + tdSt + data.list[i].productDesc + tdEn;
					str = str + tdSt + data.list[i].productStatusName + tdEn;
					str = str + tdSt + data.list[i].cateThrName + tdEn;
					str = str + tdSt + '<img src="../../images/proImg9.jpg" />' + tdEn;
					str = str + tdSt + '1000' + tdEn;
					str = str + tdSt + '$12.00' + tdEn;
					str = str + tdSt + data.list[i].createAt + tdEn;
					str = str + opt + '</tr>';
					appe = appe + str;
				}
				$('.data-tab tbody').remove('tbody');
				$('.data-tab').append(appe);
			}else{
				alert('登录失败');
			}
		},
		error:function(){     
		 // alert('网络异常。')
		}	
	});	
	
}

function test(){
	console.log($(this))
}


