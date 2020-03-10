function profileValidation() {
	var name=document.getElementById("name").value;
	var contact=document.getElementById("contact").value;
	var fileInput = document.getElementById("resume").value;
    var filePath = fileInput.value;
    var allowedExtensions = /(\.pdf)$/i;
  
	if(name.length<3 || name.length>30){
		document.getElementById("userspan").innerHTML="Please Enter FullName ";
		return false;
	}
	if(contact.length != 10){
		document.getElementById("contactspan").innerHTML="Please Enter 10 digits ";
		return false;
	}
   
    if(!allowedExtensions.exec(filePath)){
    	document.getElementById("resumespan").innerHTML="Please upload file having extensions .pdf only.";
        fileInput.value = '';
        return false;
    }
  
  	else{
			return true;
	}
}
function onUserCheck() {
	document.getElementById("userspan").innerHTML= "";
	document.getElementById("contactspan").innerHTML= "";
	document.getElementById("resumespan").innerHTML= "";

}