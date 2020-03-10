function loginValidation(){
	var username=document.getElementById("user").value;
	var password=document.getElementById("pass").value;
	
	
	if(username.length<3 || username.length>20){
		document.getElementById("userspan").innerHTML="Please Enter valid UserName ";
		return false;
	}
	if(password.length<5 || password.length>10){
		document.getElementById("passspan").innerHTML="Please Enter Strong Password ";
		return false;
	}
	
	else{
			return true;
	}
}
function onUserCheck() {
	document.getElementById("userspan1").innerHTML= "";
	document.getElementById("passspan1").innerHTML= "";
	document.getElementById("repassspan").innerHTML= "";

}
function registerValidation() {
	var username1=document.getElementById("user1").value;
	var password1=document.getElementById("pass1").value;
	var repassword=document.getElementById("repass").value;

	if(username1.length<3 || username1.length>20){
		console.log("username");
		document.getElementById("userspan1").innerHTML="Please Enter valid UserName ";
		return false;
	}
	if(password1.length<5 || password1.length>10){
		console.log("passspan1");

		document.getElementById("passspan1").innerHTML="Please Enter Strong Password ";
		return false;
	}
	if(repassword!=password1){
		console.log("repassword");

		document.getElementById("repassspan").innerHTML="Confirm Password ";
		return false;
	}
	else{
			return true;
	}
}