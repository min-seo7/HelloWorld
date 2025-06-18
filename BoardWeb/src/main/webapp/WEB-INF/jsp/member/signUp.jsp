<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signUp.jsp)</h3>
<form name="signForm" action="signUp.do" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input class="form-control" type="text" name="userId"></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input class="form-control" type="password" name="userPw"></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input class="form-control" type="text" name="userName"></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>

<script>
	let check = false;
	//document.forms
	console.log(document.forms.signForm)
	document.forms.signForm.addEventListener('submit', function(e){
		if(!check){
			e.preventDfault(); //
			alert('입력값을 확인하세요.');
			return;
		}
		
		this.submit();
	})
	
	//아이디 중복여부체크
	document.querySelector('input[name="userId"]').addEventListener('change', function(){
		console.log(this); //this는 이벤트를 받는 대상으로 <input ~~~~> 태그나옴.
		let user = this.value;
		//회원입력값check.
		fetch('checkId.do?id=' + user)
		    .then(data => data.json())
		    .then(result => {
		    	console.log(result.retCode)
		    	if(result.retCode == 'Exist'){
		    		alert("존재하는 아이디.");
		    	} else {
		    		alert("사용가능한 아이디");
		    		check = true;
		    	}
		    })
		    .catch(err=> console.log(err))
	}) 
	 
	//비밀번호 길이 확인
 	document.querySelector('input[name="userPw"]').addEventListener('change',function(){
 		console.log(this) // 콘솔에 <input ~~~~> 태그나옴.
		let pw = this.value;
		if(pw.length < 5){
			alert("비밀번호길이를 확인하세요.");
		} else{
			alert("사용가능한 비밀번호");
		}
	})
</script>