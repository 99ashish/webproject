/**
 * 
 */
function firstfocus()
  {
  var uid = document.registration.name.focus();
  return true;
  }
function userName()
{
var username=document.forms["registration"]["name"].value;
if(username.length==0)
	{
	alert("User name should not be empty");
	username.focus();
	return false;
	}
document.registration.email.focus();
return true;
}
function emailValidation()
{
var email=	document.forms["registration"]["email"].value;
if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
{
	document.registration.dob.focus();
  return (true)
}
  alert("You have entered an invalid email address!")
  return (false)
}
function mobileNumber()
{
	var contactNumber=	document.forms["registration"]["mobnum"].value;
	if(contactNumber<1111111111 || contactNumber>9999999999)
		{
		alert("You have entered an invalid mobile number")
		  return false
		}
	document.registration.password.focus();
	return true;
}
function password(mx,my)
{
var passid = document.forms["registration"]["password"].value;
var passid_len = passid.value.length;
if (passid_len == 0 ||passid_len >= my || passid_len < mx)
{
alert("Password should not be empty / length be between "+mx+" to "+my);
passid.focus();
return false;
}
return true;
}