//判断是否登录
function isLogin(){
	
}
//加载种类
function init_cate(){
	$('.ad-left-nav').append('');
	var Oli = '';
	var lii = '<li><p class="fl font14 nav-txt"><a href="';
	$.ajax({
		type: "POST",
		url: serUrl+"queryCategory.json",
		data:{
			productStatus:1,
			pageSize:100,
			currentPage:1
		},
		dataType: "json",
		success: function(data){
			console.log(data)
			if('0000'==data.respCode){
				for(var i=0;i<data.list.length;i++){
					Oli = Oli+lii+serUrl+'" >'+data.list[i].categoryName+'</a></p><p class="fr pr-10">></p>';
					Oli = Oli+'<div class="ad-left-nav-gai">';
					for(var j=0;j<data.list[i].secList.length;j++){
						Oli = Oli+'<dl><dt><dt><a href="'+serUrl+'" >'+data.list[i].secList[j].cateSecName+'</a></dt>';
						for(var m=0;m<data.list[i].secList[j].categoryThr.length;m++){
							Oli = Oli+'<dd><a href="'+serUrl+'" >'+data.list[i].secList[j].categoryThr[m].cateThrName+'</a></dd>';
						}
						Oli = Oli + '</dl>';
					}
					Oli = Oli + '</div>';
					Oli = Oli + '</li>';
				}
				console.log('*********'+Oli)
				$('.ad-left-nav').append(Oli);
			}else{
				
			}
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
	
}
//加载商品
function init_pro(){
	$.ajax({
		type: "POST",
		url: serUrl+"queryProduct.json",
		data:{
			productStatus:1,
			pageSize:100,
			currentPage:1
		},
		dataType: "json",
		success: function(data){
			if('0000'==data.respCode){
				window.location.href="index.html";	
			}else{
				alert('登录失败');
			}
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
}
//加载购物车
function init_shopcar(){
	$.ajax({
		type: "POST",
		url: serUrl+"queryProduct.json",
		data:{
			productStatus:1,
			pageSize:100,
			currentPage:1
		},
		dataType: "json",
		success: function(data){
			if('0000'==data.respCode){
				window.location.href="index.html";	
			}else{
				alert('登录失败');
			}
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
}