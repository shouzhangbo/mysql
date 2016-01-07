// JavaScript Document
$(function(){
	initAuthor(jsonStr);
	initOkAuthor(addStr);
})
//初始化已选择权限，提供预览
function initOkAuthor(addStr){
	var str = '<dl>';
	for(var i=0;i<addStr.length;i++){
		str = str + '<dt data-cid="11"><em class="down" data-res="resDtEm"></em>';
		str = str + '<span>'+addStr[i].name+'('+addStr[i].count+')</span><input type="button" name="delete" class="qingkongBtn" value="删除"></dt>';
		for(var j=0;j<addStr[i].list.length;j++){
			str = str + '<dd data-ssid="179" data-pid="11"><span>'+addStr[i].list[j].name+'</span><input type="button" name="delete" class="delBtn" value=""></dd>';
		}
	}
	str = str + '</dl>';   
	$('.resultArea').append(str);         
}
//初始化所有权限，等待选择
function initAuthor(jsonStr){
	var json = jsonStr;//JSON.parse(jsonStr);//.toJSONString();
	var str = '<input type="checkbox" name="ch_level_0" class="get-all" />';
     	str = str + '<em class="down" data-lv="level0"></em><span data-id="-1" class="data-level0" style="cursor: pointer;">全选('+json.count+')</span>';
		str = str + '<ul class="ul_lv_0">';
	for(var i=0;i<json.list.length;i++){
		str = str + '<li style="position: relative;">';
        str = str + '<em class="up" data-lv="level1"></em>';
        str = str + '<input type="checkbox" name="ch_level_1" data-cid="11"/>';
        str = str + '<span  class="data-level1" data-sid="11">'+json.list[i].name+'</span>';
        str = str + '<dl class="dl_lv_1" style="display: none;" data-did="11">';
		for(var j=0;j<json.list[i].list.length;j++){
				str = str + '<dd><label><input type="checkbox" name="ch_level_2" data-cpid="11"/><span data-id="179" class="data-level2">'+json.list[i].list[j].name+'</span> </label></dd>';
		}
		str = str + '</dl><label style="position:absolute;top:0px;left:88px;">('+json.list[i].count+')</label>';
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
	if($('.get-all').is(':checked')){
		
	}else{
		$("input[type='checkbox']").each(function(){ 
			if($(this).attr("checked")){
				if($(this).attr('name')!='ch_level_1'){
					$(this).parent().parent().parent().siblings('span').html()
					arr.push($(this).siblings('span').html());
					console.log();
				}else{
					
				}
			}
		})
	}
	$('.levelServer') 
});
//选择某一项
$("input[name='ch_level_1']").live('click',function(){
	if($(this).is(':checked')){
		$(this).siblings('dl').find("input[type='checkbox']").attr('checked','checked');
	}else{
		$(this).siblings('dl').find("input[type='checkbox']").removeAttr('checked');
	}
})
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