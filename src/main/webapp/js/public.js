//写cookies
function setCookie(name,value)
{
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function setCookie(name, value, hours, path) {
	var name = escape(name);
	var value = escape(value);
	var expires = new Date();
	expires.setTime(expires.getTime() + hours * 3600000);
	path = path == "" ? "" : ";path=" + path;
	_expires = (typeof hours) == "string" ? "" : ";expires=" + expires.toUTCString();
	document.cookie = name + "=" + value + _expires + path;
}
//读取cookies
function getCookie(name)
{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
	return unescape(arr[2]);
	else
	return null;
}
//删除cookies
function delCookie(name)
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=getCookie(name);
	if(cval!=null)
	document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}


function setLocalStorage(key,value){
	var storage = window.localStorage;
	storage.setItem(key, value);
}
function initLeft(){
	var  LeftMenu=[
			{"Ico":"dingdan",
			 "name":"商品管理",
			 "menu2":
			 [
			 	{"name":"商品种类","url":"后台-添加商品种类.html"},
				{"name":"商品","url":"后台-添加商品.html"},
				{"name":"品牌","url":"后台-添加品牌.html"}
			 ]
			},
			{"Ico":"dingdan",
			 "name":"商品管理",
			 "menu2":
			 [
			 	{"name":"商品种类","url":"后台-添加商品种类.html"},
				{"name":"商品","url":"后台-添加商品.html"},
				{"name":"品牌","url":"后台-添加品牌.html"}
			 ]
			},
			{"Ico":"dingdan",
			 "name":"商品管理",
			 "menu2":
			 [
			 	{"name":"商品种类","url":"后台-添加商品种类.html"},
				{"name":"商品","url":"后台-添加商品.html"},
				{"name":"品牌","url":"后台-添加品牌.html"}
			 ]
			},
			{"Ico":"dingdan",
			 "name":"商品管理",
			 "menu2":
			 [
			 	{"name":"商品种类","url":"后台-添加商品种类.html"},
				{"name":"商品","url":"后台-添加商品.html"},
				{"name":"品牌","url":"后台-添加品牌.html"}
			 ]
			}
		];
			var dl = '';
			for(var i=0;i<LeftMenu.length;i++){
				dl = dl + '<dl>';
				dl = dl + '<dt>'+LeftMenu[i].name+'<p class="fr">>></p></dt>'
				var dd = '';
				for(var j=0;j<LeftMenu[i].menu2.length;j++){
					if(i==0&&j==0){
						dd = dd + '<dd class="active"><a href="'+LeftMenu[i].menu2[j].url+'">'+LeftMenu[i].menu2[j].name+'</a></dd>';
					}else{
						dd = dd + '<dd><a href="'+LeftMenu[i].menu2[j].url+'">'+LeftMenu[i].menu2[j].name+'</a></dd>';
					}
				}
				dl = dl + dd;
				dl = dl + '</dl>';
			}
	$('.left').append(dl);
}
$('.left dd').live('click',function(){
	$('.left dd').removeClass('active');
	$(this).addClass('active');
});
function closeAlert(){
	//关闭弹出框
	$('.alertbox-close').live('click',function(){
		$('.alertbox').hide();
		$('.alertbox-2 .btn-ok').removeClass('btn-add-new');
		$('.alertbox-2 .btn-ok').removeClass('btn-cancl');
		$('.alertbox-2 .btn-ok').removeClass('btn-alert-update');
		$('.alertbox-1 .btn-ok').removeClass('btn-alert-delete');
		$('.alertbox-2 .btn-ok').val('确认');
		
		$('.alertbox-2 .img-content').html('');
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
		
		$('.alertbox-2 .img-content').html('');
		$('.alertbox-2 .upImg').removeClass('hide');
		$('.btn-cancl').show();
		//除去新增
		for(var i=0;i<5;i++){
			$('.file-'+i).attr("disabled",false);
			$('.file-'+i).val('');
		}
	});	
}
function leftClick(){
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
	});
}
$('.up-page').live('click',function(){
	if(currentPage<=1){
		return false;
	}
	currentPage--;
	initData();
});
$('.down-page').live('click',function(){
	if(currentPage>=totalPage){
		return false;
	}
	currentPage++;
	initData();
});