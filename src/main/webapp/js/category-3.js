// JavaScript Document
var serUrl = "http://localhost:8080/mysql/";
var categoryName = "",status=2,start='',end='',pageSize=5,currentPage=1,totalPage=0;
$(function(){
	 initFa();
	initLeft();
	closeAlert();
	leftClick();
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
//新增-添加
$('.btn-add-new').live("click", function(){
	$.ajax({
		type: "POST",
		url: serUrl+"addCateThr.json",
		data:{
			categoryId:$('.up-option').val(),
			categoryName:$('.file-1').val(),
			categoryDesc:$('.file-2').val(),
			categoryIndex:$('.file-3').val(),
			categoryImg:"xx.png"
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
//搜索
$('#search').live('click',function(){
	console.log('search='+$('#name').val());
	categoryName = $('#name').val();
	status=$('#status').val();
	start=$('#start').val();
	end=$('#end').val();
	initData();
//	initData(categoryName,status,startTime,endTime,pageSize,currentPage);
//	pageSize=5,currentPage=1;
});
//查看
$('.check').live('click',function(){
	var strArr=$(this).parent().prevAll();
	var j=0;
	for(var i=strArr.length-3;i>=0;i--){
		j++;
		$('.file-'+j).attr("disabled",true);
		if(j==3){
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
	for(var i=0;i<strArr.length;i++){
		$('.file-'+i).val(strArr[i].innerHTML);
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
	for(var i=0;i<5;i++){
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
	$('.alertbox-2 .btn-ok').val('确认');
	
	$('.alertbox-2 .upImg').removeClass('hide');
	$('.btn-cancl').show();
	//除去新增
	for(var i=0;i<5;i++){
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
		url: serUrl+"queryCateSec.json",
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
				str = str + '<option value="'+data.list[i].cateSecId+'">'+data.list[i].cateSecName+"</option>";
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
		url: serUrl+"queryCateThr.json",
		data:{
			categoryName:categoryName,
			status:status,
			startTime:start,
			endTime:end,
			pageSize:pageSize,
			currentPage:currentPage
		},
		dataType: "json",
		success: function(data){
			/*<tr><td><input type="checkbox" /><td>序号31</td><td>序号32</td><td>序号33</td><td>序号34</td><td>序号35</td><td>序号36</td><td><a href="javascript:;" class="check">查看</a>|<a  href="javascript:;" class="update">修改</a>|<a href="javascript:;" class="delete">删除</a></td>
				</tr>*/
			var appe = '';
			console.log(data);
			if('0000'==data.respCode){
				for(var i=0;i<data.list.length;i++){
					var str = '<tr><td><input type="checkbox" /></td>';
					var tdSt = '<td>';
					var tdEn = '</td>';
					var opt = '<td><a href="javascript:;" class="check">查看</a>|<a  href="javascript:;" class="update">修改</a>|<a href="javascript:;" class="delete">删除</a></td>';
					
					str = str + tdSt + data.list[i].cateThrId + tdEn;
					str = str + tdSt + data.list[i].cateThrName + tdEn;
					str = str + tdSt + data.list[i].cateThrDesc + tdEn;
					str = str + tdSt + data.list[i].statusName + tdEn;
					str = str + tdSt + data.list[i].cateThrIndex + tdEn;
					str = str + tdSt + data.list[i].createAt + tdEn;
					str = str + tdSt + data.list[i].cateSecName + tdEn;
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
		  alert('网络异常。')
		}	
	});	
	
}

function test(){
	console.log($(this))
}