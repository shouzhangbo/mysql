var serUrl = 'http://localhost:8080/mysql/';
$(function(){
	init_cate();
	//是否登录
	isLogin();
	//退出
	$('.tuichu').click(function(){
		setLocalStorage("username",null);
		isLogin();
	});
	//搜索栏
	$('.sort-up li').click(function(){
		$('.sort-up li').removeClass('ok');
		$(this).addClass('ok');								
	});
	//我的购物车
	$('.sort-shopcar').hover(function(){
		$('.shopcar-content').show();
		$('.shopcar-content').addClass('sort-shopcar-1');
	},function(){
		$('.shopcar-content').hover(function(){
			$('.shopcar-content').show();									 
		},function(){
			$('.shopcar-content').hide();	
		})
		$('.shopcar-content').hide();	
		$('.shopcar-content').removeClass('sort-shopcar-1');
	});
	//左侧全局定位
	$('.fix-left-ul li').hover(function(){
		$(this).find('.fix-left-ul-txt').show();
		$(this).find('.fix-p').addClass('fix-p-1');
	},function(){
		$(this).find('.fix-left-ul-txt').hide();
		$(this).find('.fix-p').removeClass('fix-p-1')
	});
	$('.fix-left-up li').hover(function(){
		$(this).find('.fix-left-ul-txt').show();
		$(this).find('.fix-p').addClass('fix-p-1');		
	},function(){
		$(this).find('.fix-left-ul-txt').hide();
		$(this).find('.fix-p').removeClass('fix-p-1')
	});
	//返回顶部
	window.onscroll=function(){
		var scrollTop=$(document).scrollTop();
		if(scrollTop>200){
			$('.fix-left-up').show();
		}
		if(scrollTop<200){
			$('.fix-left-up').hide();
		}
		if(scrollTop>700){
			$('.fix-right-flow').show();
			for(var i=1;i<9;i++){
				if(scrollTop>=700+380*(i-1)&&scrollTop<700+380*i){
					$('.fix-right-flow li').eq(i-1).find('.fix-flow').hide();
					$('.fix-right-flow li').eq(i-1).find('.fix-flower').css('display','block');
				}else if(scrollTop>=700+380*8){
					$('.fix-right-flow li').eq(7).find('.fix-flow').hide();
					$('.fix-right-flow li').eq(7).find('.fix-flower').css('display','block');
				}else{
					$('.fix-right-flow li').eq(i-1).find('.fix-flow').show();
					$('.fix-right-flow li').eq(i-1).find('.fix-flower').hide();	
				}
			}
		}
		if(scrollTop>700&&scrollTop<380+700){
			
		}
		if(scrollTop<700){
			$('.fix-right-flow').hide();
		}
		if(scrollTop>300){
			$('.fix-head').show();
		}
		if(scrollTop<300){
			$('.fix-head').hide();
		}
	}
	//楼层
	$('.fix-right-flow li').hover(function(){
		$(this).find('.fix-flow').hide();
		$(this).find('.fix-flower').css('display','block');
	},function(){
		$(this).find('.fix-flow').show();
		$(this).find('.fix-flower').hide();
	});
	//我的品牌的hover事件
	$('.main-rang-con li').hover(function(){
		$(this).find('.rang-position').show();
	},function(){
		$('.rang-position').hide();										   
	});
	$('.main-rang-con li').eq($('.main-rang-con li').length-1).hover(function(){
		$(this).find('.rang-position-last').show();
	},function(){
		$('.rang-position-last').hide();										   
	});
	//顶部定位
	$('.sort-input-1 .sort-left li').hover(function(){
		$('.sort-input-1 .sort-left li').show();
	},function(){
		$('.sort-input-1 .sort-left li').hide();
		$('.sort-input-1 .sort-left .ok').show();
	});
	$('.sort-input-1 .sort-left li').click(function(){
		$('.sort-input-1 .sort-left li').removeClass('ok');
		$(this).addClass('ok');							
	});
	//顶部定位结束
	
	//购物数量 加
	$('.btn-add').click(function(){
		var kucun =parseInt($(this).parent().prev('.recomm-linag').find('p').html())
		var inp = parseInt($(this).prev('.shop-input').val());
		if(++inp<=kucun){
			$(this).prev('.shop-input').val(inp);
		}else{
			$(this).prev('.shop-input').val(--inp);
		}	 
	});
	//购物数量 减
	$('.btn-jian').click(function(){
		var kucun =parseInt($(this).parent().prev('.recomm-linag').find('p').html())
		var inp = parseInt($(this).next('.shop-input').val());
		if(--inp>=0){
			$(this).next('.shop-input').val(inp);
		}else{
			$(this).next('.shop-input').val(++inp);
		}	 
	});
	/**广告轮播**/
	var timer1 = setInterval(timer,3000);
	$('.banner-index').hover(function(){
		clearInterval(timer1);
	},function(){
		timer1 = setInterval(timer,3000);
	});
	$('.banner-mount li').click(function(){
		index=$(this).index();
		timerClick();
	});
	$('.banner-right').click(function(){
		if(index<len-1){
			index++;
		}else{
			index=0;
		}
		timerClick();
	});
	$('.banner-left').click(function(){
		if(index>-1){
			index--;
		}else{
			index=4
		}
		timerClick();
	});
	/**广告轮播**/
	var left1 = setInterval(left,3000);
	$('.lunbo-index').hover(function(){
		$('.lunbo-left').show();
		$('.lunbo-right').show();
	},function(){
		$('.lunbo-left').hide();
		$('.lunbo-right').hide();
	});
	$('.lunbo-left').click(function(){
		if(i<0){
			i=leftLen-4;
		}else{
			i--;
		}
		leftSin();
	});
	$('.lunbo-right').click(function(){
		if(i>leftLen-4){
			i=0;
		}else{
			i++;
		}
		leftSin();
	});
	//左右滑动
	var right1 = setInterval(right,3000);
	$('.ad-img').hover(function(){
		$('.ad-img-left').show();
		$('.ad-img-right').show();
	},function(){
		$('.ad-img-left').hide();
		$('.ad-img-right').hide();
	});
	$('.ad-img-left').click(function(){
		if(j<0){
			j=leftLen-2;
		}else{
			j--;
		}
		rightSin();						 
	});
	$('.ad-img-right').click(function(){
		if(j>leftLen-2){
			j=0;
		}else{
			j++;
		}
		rightSin();
	});
	//快报
	kuaibaofun();
});
function kuaibaofun(){
	var speed=50
	var txt = document.getElementById("ad-recomm-txt");
	var li = document.getElementById("ad-recomm-li");
	li.innerHTML = li.innerHTML+li.innerHTML;
	var MyMar=setInterval(kuaibao,speed)
    txt.onmouseover=function() {clearInterval(MyMar)}
    txt.onmouseout=function() {MyMar=setInterval(kuaibao,speed)}
}
function kuaibao(){
	var txt = document.getElementById("ad-recomm-txt");
	var li = document.getElementById("ad-recomm-li");
    if(li.offsetTop-txt.scrollTop<=0){
    	txt.scrollTop-=li.offsetHeight/2;
	}else{
   		txt.scrollTop++;
    }
}
//添加购物车
$('.btn-add-shop').on('click',test);
function test(event) {
	if(parseInt($(this).siblings('.shop-input').val())>0){
		$('.shopbar-mount').html(parseInt($(this).siblings('.shop-input').val())+parseInt($('.shopbar-mount').html()));	
		$('.mount').html(parseInt($(this).siblings('.shop-input').val())+parseInt($('.mount').html()));
		//用户，商品id，数量
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/mysql/addShopCar.json",
			data:{
				userName:'',
				productId:1,
				productCount:1
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
		
		//组建数组
		var proArr = new Array();
		var proDate = 
		proData.push();
	}else{
		return;	
	}
	
	var offset = $('.fix-left-ul li').eq(0).find('.fix-p').offset(), flyer = $("<img src='../images/youxi-02.png' class='move-sp'>");
	flyer.fly({
		start: {
			left: event.pageX,
			top: event.pageY - $(window).scrollTop()
		},
		end: {
			left: offset.left+40,
			top: offset.top + 40 - $(window).scrollTop(),
			width: 30,
			height: 30
		}
	});
}

var len=$('.banner-img li').length;
var index=$('.banner-img .active').index();

function timer(){
	
	if(index>=len-1){
		index=-1;
	}
	index++;
	$('.banner-img li').removeClass('active');
	$('.banner-img li').eq(index).addClass('active');
	$('.banner-mount li').removeClass('active');
	$('.banner-mount li').eq(index).addClass('active');
}
function timerClick(){
	$('.banner-img li').removeClass('active');
	$('.banner-img li').eq(index).addClass('active');
	$('.banner-mount li').removeClass('active');
	$('.banner-mount li').eq(index).addClass('active');
}
var leftLen = $('.lunbo-img li').length;
var i=1;
function left(){
	if(i>leftLen-4){
		i=0;
		$('.lunbo-img').css('left','0px').animate({'left':-190*i-10+'px'});
	}else{
		i++;
		$('.lunbo-img').animate({'left':-190*i-10+'px'});
	}
}
function leftSin(){
	if(i>leftLen-4){
		i=0;
		$('.lunbo-img').css('left','0px').animate({'left':-190*i-10+'px'});
	}else{
		$('.lunbo-img').animate({'left':-190*i-10+'px'});
	}
}
var rightLen = $('.ad-img-li li').length;
var j=1;
function right(){
	if(j>rightLen-2){
		j=0;
		$('.ad-img-li').css('left','0px').animate({'left':-235*j+'px'});
	}else{
		$('.ad-img-li').animate({'left':-235*j+'px'});
		j++;
	}
}
/*function rightSin(){
	if(j>leftLen-2){
		j=0;
		$('.ad-img-li').css('left','0px').animate({'left':-235*j+'px'});
	}else{
		$('.ad-img-li').animate({'left':-235*j+'px'});
	}
}*/

function isLogin(){
	var user = window.localStorage.getItem("username");
	if(user!=''&&user!='null'&&user!=null){
		$('.un-login').hide();
		$('.ag-login').show();
		$('.user-txt').html(user);
	}else{
		$('.ag-login').hide();
		$('.un-login').show();
	}
}

