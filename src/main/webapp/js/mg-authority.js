// JavaScript Document
var serUrl = "http://192.168.1.112:8080/mysql/";
$(function(){
	initHtmlDate();
	initAllDate();
	initOKDate();
	initRole();
	
	initLeft();
	$('.add-new').click(function(){
		$('.alertSelectFwz').show();
	})
})
function initHtmlDate(){
$.ajax({
	type: "POST",
	url: serUrl+"authority/queryRoleList.json",
	data:{
	},
	dataType: "json",
	success: function(data){
		console.log(data);
		var str = '';
		if('0000'==data.respCode){
			for(var i=0;i<data.list.length;i++){
				str = str + '<tr>';
				str = str + '<td>'+data.list[i].roleId+'</td>';
				str = str + '<td>'+data.list[i].roleName+'</td>';
				str = str + '<td>';
				if(data.list[i].list.length>0){
					str = str + '<ul>';
					for(var j=0;j<data.list[i].list.length;j++){
						str = str + '<li>'+data.list[i].list[j].menuName+'</li>';
					}
					str = str + '</ul>';
				}
				str = str + '</td>';
				str = str + '<td>'+data.list[i].createAt+'</td>';
				str = str + '<td><a href="javascript:;" class="check">查看详情</a>|<a href="javascript:;" class="update">修改</a>|<a href="javascript:;" class="delete">删除</a></td>';
				str = str + '</tr>';
			}
			$('.data-tab tbody').children('tr').remove();
			$('.data-tab tbody').append(str);
		}
	},
	error:function(){     
	  alert('网络异常。11111')
	}
});
}
//初始化已选择权限，提供预览
function initOkAuthor(addStr){
	var str = '<dl>';
	for(var i=0;i<addStr.list.length;i++){
		str = str + '<dt data-cid="11"><em class="down" data-res="resDtEm"></em>';
		str = str + '<span>'+addStr.list[i].menuName+'('+10+')</span><input type="button" name="delete" class="qingkongBtn" value="删除"></dt>';
		for(var j=0;j<addStr.list[i].pageList.length;j++){
			str = str + '<dd data-ssid="179" data-pid="11"><span>'+addStr.list[i].pageList[j].pageName+'</span><input type="button" name="delete" class="delBtn" value=""></dd>';
		}
	}
	str = str + '</dl>';
	$('.resultArea').children('dl').remove();
	$('.resultArea').append(str);         
}
//初始化所有权限，等待选择
function initAuthor(jsonStr){
	var json = jsonStr;//JSON.parse(jsonStr);//.toJSONString();
	var str = '<input type="checkbox" name="ch_level_0" class="get-all" />';
     	str = str + '<em class="down" data-lv="level0"></em><span data-id="-1" class="data-level0" style="cursor: pointer;">全选('+json.totalReco+')</span>';
		str = str + '<ul class="ul_lv_0">';
	for(var i=0;i<json.list.length;i++){
		str = str + '<li style="position: relative;">';
        str = str + '<em class="up" data-lv="level1"></em>';
        str = str + '<input type="checkbox" name="ch_level_1" data-cid="11"/>';
        str = str + '<span  class="data-level1" data-sid="11">'+json.list[i].menuName+'</span>';
        str = str + '<dl class="dl_lv_1" style="display: none;" data-did="11">';
        if(json.list[i].pageList){
			for(var j=0;j<json.list[i].pageList.length;j++){
					str = str + '<dd><label><input type="checkbox" name="ch_level_2" data-cpid="'+json.list[i].pageList[j].pageId+'"/><span data-id="179" class="data-level2">'+json.list[i].pageList[j].pageName+'</span> </label></dd>';
			}
		}
		str = str + '</dl><label style="position:absolute;top:0px;left:88px;">('+json.list[i].pageList.length+')</label>';
        str = str + '<div class="clear"></div></li>';
	}
    str = str + '</ul>';
	$('.levelServer').append(str);
}
//全部
$('.down').live('click',function(){
	//$(this).css('width','13px');
	if($(this).siblings('ul.ul_lv_0').length>0){
		//左边
		if($('.ul_lv_0').is(":hidden")){
			$(this).css('background-position','38px 27px');
			$('.ul_lv_0').show();
		}else{
			$(this).css('background-position','25px 26px');
			$('.ul_lv_0').hide();
		}
	}else{
		//右边
		if($(this).parent().siblings('dd').is(":hidden")){
			$(this).css('background-position','38px 27px');
			$(this).parent().siblings('dd').show();
		}else{
			$(this).css('background-position','25px 26px');
			$(this).parent().siblings('dd').hide();
		}
	}
});
//某个节点打开
$('.ul_lv_0 li>em').live('click',function(){
	//$(this).css('width','13px');
	if($(this).siblings('.dl_lv_1').is(":hidden")){
		$(this).css('background-position','25px 27px');
		$(this).siblings('.dl_lv_1').show();
	}else{
		$(this).css('background-position','36px 30px');
		$(this).siblings('.dl_lv_1').hide();
	}
});
//全选
$('.get-all').live('click',function(){
	if($(this).is(':checked')){
		$(this).siblings('ul').find("input[type='checkbox']").attr('checked','checked');
	}else{
		$(this).siblings('ul').find("input[type='checkbox']").removeAttr('checked');
	}
});
//加入到左边
$('.moveBtn').live('click',function(){
	//如果全选
	var str = {};
	var arr = [];
	var nameArr=[];
	if($('.get-all').is(':checked')){
		
	}else{
		/*for(var i=0;i<$("input:checkbox[name='ch_level_1']").length;i++){
			console.log($("input:checkbox[name='ch_level_1']")[i])
			console.log($(this));
			var oInp = $("input:checkbox[name='ch_level_1']")[i];
			if(oInp.is(":checked")){
				//下面的内容也选择了
				
			}else{
				$("input:checkbox[name='ch_level_1']")[i].siblings('dl').find("input[type='checkbox']").each(function(){ 
					if($(this).attr("checked")){
						arr.push($(this).siblings('span').html());
					}
				});
			}
		}*/
		$("input[type='checkbox']").each(function(){ 
			if($(this).attr("checked")){
				if($(this).attr('name')!='ch_level_1'){
					nameArr.push($(this).parent().parent().parent().siblings('span').html());
					arr.push({'pageId':$(this).attr('data-cpid')});
				}else{
					
				}
			}
		})
		console.log(nameArr);
		console.log(arr);
		var ss = {list:arr};
		$.ajax({
			type: "POST",
			url: serUrl+"authority/add.json",
			data:{
				roleId:$('.role-txt').val(),
				arr:JSON.stringify(ss)
			},
			dataType: "json",
			success: function(data){
				console.log(data);
				initOKDate();
			},
			error:function(){     
			  alert('网络异常。11111')
			}
		});
	}
});
//选择某一项
$("input[name='ch_level_1']").live('click',function(){
	if($(this).is(':checked')){
		$(this).siblings('dl').find("input[type='checkbox']").attr('checked','checked');
	}else{
		$(this).siblings('dl').find("input[type='checkbox']").removeAttr('checked');
	}
});
//关闭
$('#delBtn').live('click',function(){
	$('.alertSelectFwz').hide();
})
//加载所有的
function initAllDate(){
	$.ajax({
		type: "POST",
		url: serUrl+"authority/queryAll.json",
		data:{
			menuName:$('.file-1').val()
		},
		dataType: "json",
		success: function(data){
			console.log(data);
			initAuthor(data);
		},
		error:function(){     
		  alert('网络异常。11111')
		}
	});
}
//加载所有的
function initOKDate(){
	$.ajax({
		type: "POST",
		url: serUrl+"authority/queryByRole.json",
		data:{
			roleId:$('.role-txt').val()
		},
		dataType: "json",
		success: function(data){
			if('0000'==data.respCode){
				console.log(data);
				initOkAuthor(data);
			}
		},
		error:function(){     
		  alert('网络异常。11111')
		}
	});
}
//加载角色
function initRole(){
	$.ajax({
		type: "POST",
		url: serUrl+"role/query.json",
		dataType: "json",
		success: function(data){
			console.log(data);
			if('0000'==data.respCode){
				var str = '';
				for(var i=0;i<data.list.length;i++){
					str = str + '<option value="'+data.list[i].roleId+'">'+data.list[i].roleName+'</option>'
				}
				$('.role-txt').children('option').remove();
				$('.role-txt').append(str);
			}
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
}
var jsonStr=
{
	count:100,
	list:
	[
		{
			name:'功能管理',
			count:5,
			list:
			[
				{name:'用户管理'},
				{name:'权限管理'},
				{name:'功能管理'},
				{name:'页面管理'},
				{name:'角色管理'}
			]
		},
		{
			name:'商品管理',
			count:5,
			list:
			[
				{name:'订单管理'},
				{name:'商品管理'},
				{name:'种类管理'},
				{name:'评价管理'},
				{name:'品牌管理'}
			]
		}
	]	
}
var addStr=
[
	{
		name:'功能管理',
		count:2,
		list:
		[
			{name:'用户管理'},
			{name:'权限管理'}
		]
	}
]