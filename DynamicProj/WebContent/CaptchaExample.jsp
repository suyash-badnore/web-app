<html>
<head><title>JavaScript Captcha Example</title></head>
<body onload="generateCaptcha()">
 
<script>
var captcha;
 
function generateCaptcha() {
    var a = Math.floor((Math.random() * 10));
    var b = Math.floor((Math.random() * 10));
    var c = Math.floor((Math.random() * 10));
    var d = Math.floor((Math.random() * 10));
 
	captcha=a.toString()+b.toString()+c.toString()+d.toString();
	
    document.getElementById("captcha").value = captcha;
}
 
function check(){
	var input=document.getElementById("inputText").value;
 
	if(input==captcha){
		alert("Equal");
	}
	else{
		alert("Not Equal");
	}
}
</script>
 
<input type="text" id="captcha" disabled/><br/><br/>
<input type="text" id="inputText"/><br/><br/>
<button onclick="generateCaptcha()">Refresh</button>
<button onclick="check()">Submit</button>
 
</body>
</html>