//判断是否登录
function isLogin(){
	if(localStorage.username){
		if("null"!=localStorage.username&&null!=localStorage.username){
			$('.un-login').hide();
			$('.user-txt').html(localStorage.username);
			$('.ag-login').show();
		}
	}
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
			pageSize:10,
			currentPage:1
		},
		dataType: "json",
		success: function(data){
			if('0000'==data.respCode){
				$('.main-recomm-con').children('li').remove();
				var str = '';
				for(var i=0;i<data.list.length;i++){
					str = '<li><div class="recomm-img"><img src="'+data.list[i].productImgFirst+'" /></div>';
					str = str + '<div class="recomm-price fl">￥12.00</div>';
					str = str + '<div class="recomm-price fl ml-10">'+data.list[i].productName+'</div>';
					str = str + '<div class="cl"></div>';
					str = str + '<div class="recomm-desc">'+data.list[i].productDesc+'</div>';
					str = str + '<div class="recomm-linag"><span class=fl"">销量：10件</span><span class="fr mr-10">库存：<p class="fr">10000</p></span></div>';
					str = str + '<div class="recomm-shop">';
					str = str + '<input type="button" class="fl btn btn-jian ml-10" value="-" />';
					str = str + '<input type="text" class="fl shop-input" readonly="readonly" value="1" />';
					str = str + '<input type="button" class="fl btn btn-add" value="+" />';
					str = str + '<input type="hidden" class="productId" value="'+data.list[i].productId+'" />';
					str = str + '<input type="button" class="fr mr-10 btn btn-add-shop" value="加入购物车" />';
					str = str + '</div>';
					str = str + '	<div class="cl"></div>';
					str = str + '<div class="recomm-company mt-10">'+data.list[i].brandName+'</div>';
					str = str + '</li>';
				}
				$('.main-recomm-con').append(str);
				//window.location.href="index.html";	
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
	var username='';
	if(localStorage.username){
		username = localStorage.username;
	}else{
		username='';
	}
	$.ajax({
		type: "POST",
		url: serUrl+"redis/query.json",
		data:{
			userId:username
		},
		dataType: "json",
		success: function(data){
			var str = '';
			if('0000'==data.respCode){
				console.log('data====='+data);
				$('.shop-car-content').children('li').remove();
				if(data.list.length>0){
					for(var i=0;i<data.list.length;i++){
						str = str + '<li><span>'+data.list[i].productName+'</span><span>'+data.list[i].price+'</span><input type="hidden" value="'+data.list[i].productId+'" class="productId" /><a  class="ml-10 shop-dele" href="javascript:;">删除</a></li>';
					}
					console.log('str====='+str);
					$('.shop-car-content').append(str);
				}else{
					
				}
			}else{
				alert('登录失败');
			}
		},
		error:function(){     
		  alert('网络异常。')
		}
	});
}