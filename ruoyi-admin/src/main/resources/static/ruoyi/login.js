$(function() {
   
	$('#validimg').click(function() {
		var url = ctx + "captcha/captchaImage?type=" + captchaType + "&s=" + Math.random();
		$("#validimg").attr("src", url);
	});
	
	$("#submitBtn").on("click",function(){
		//隐藏登录文字
		$(".login_txt").css("display","none");
		$(".lgload-container").css("display","block");
		
		username = $("input[name='account']").val();
		password = $("input[name='pwd']").val();
		validateCode = $("input[name='valiCode']").val();
		
		if(vaild(username,password,validateCode) == false){
			$(".login_txt").css("display","block");
			$(".lgload-container").css("display","none");
			return;
		}
		
		$.ajax({
	        type: "post",
	        url: ctx + "login",
	        data: {
	            "username": username,
	            "password": password,
	            "validateCode" : validateCode,
	            "rememberMe": false
	        },
	        success: function(r) {
	            if (r.code == 0) {
	                location.href = ctx + 'index';
	            } else {
	            	$(".login_txt").css("display","block");
					$(".lgload-container").css("display","none");
					$.modal.msg(r.msg);
					
	            	/*$.modal.closeLoading();
	            	$('.imgcode').click();
	            	$(".code").val("");
	            	$.modal.msg(r.msg);*/
	            }
	            $("#validimg").trigger("click");
	        }
	    });
	});
	
	$(document).keydown(function(event){ 
		  //判断当event.keyCode 为13时（即回车键） 
		  if(event.keyCode == 13){ 
			  $("#submitBtn").trigger("click");
		  }
	}); 
});

function vaild(username,password,validateCode){
	if(username.trim().length == 0){
		$.modal.msg("用户名不能为空");
		return false;
	}else if(password.trim().length == 0){
		$.modal.msg("密码不能为空");
		return false;
	}else if(validateCode.trim().length == 0){
		$.modal.msg("验证码不能为空");
		return false;
	}else{
		return true;
	}
}
	
