/* fly - v1.0.0 - 2014-12-22
* https://github.com/amibug/fly
* Copyright (c) 2014 wuyuedong; Licensed MIT */
(function(A){A.fly=function(E,D){var F={version:"1.0.0",autoPlay:true,vertex_Rtop:50,speed:1.2,start:{},end:{},onEnd:A.noop};var C=this,B=A(E);B.show();C.init=function(G){this.setOptions(G);!!this.settings.autoPlay&&this.play()};C.setOptions=function(N){this.settings=A.extend(true,{},F,N);var G=this.settings,I=G.start,J=G.end;B.appendTo(A(".search_list"));if(J.width!=null&&J.height!=null){A.extend(true,I,{width:B.width(),height:B.height()})}var K=Math.min(I.top,J.top)-Math.abs(I.left-J.left)/3;if(K<G.vertex_Rtop){K=Math.min(G.vertex_Rtop,Math.min(I.top,J.top))}var M=Math.sqrt(Math.pow(I.top-J.top,2)+Math.pow(I.left-J.left,2)),O=Math.ceil(Math.min(Math.max(Math.log(M)/0.05-75,30),100)/G.speed),H=I.top==K?0:-Math.sqrt((J.top-K)/(I.top-K)),L=(H*I.left-J.left)/(H-1),P=J.left==L?0:(J.top-K)/Math.pow(J.left-L,2);A.extend(true,G,{count:-1,steps:O,vertex_left:L,vertex_top:K,curvature:P})};C.play=function(){this.move()};C.move=function(){var G=this.settings,H=G.start,I=G.count,N=G.steps,J=G.end;var L=H.left+(J.left-H.left)*I/N,K=G.curvature==0?H.top+(J.top-H.top)*I/N:G.curvature*Math.pow(L-G.vertex_left,2)+G.vertex_top;if(J.width!=null&&J.height!=null){var M=N/2,O=J.width-(J.width-H.width)*Math.cos(I<M?0:(I-M)/(N-M)*Math.PI/2),Q=J.height-(J.height-H.height)*Math.cos(I<M?0:(I-M)/(N-M)*Math.PI/2);B.css({width:O+"px",height:Q+"px","font-size":Math.min(O,Q)+"px"})}B.css({left:L+"px",top:K+"px"});G.count++;var P=null;if(window.requestAnimationFrame){timer=window.requestAnimationFrame(A.proxy(this.move,this))}else{timer=window.setTimeout(A.proxy(this.move,this),1000/60)}if(I==N){if(window.cancelAnimationFrame){window.cancelAnimationFrame(P)}C.destory();G.onEnd.apply(this)}};C.destory=function(){B.remove()};C.init(D)};A.fn.fly=function(B){return this.each(function(){if(undefined==A(this).data("fly")){A(this).data("fly",new A.fly(this,B))}})}})(jQuery);