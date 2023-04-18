//validate username
var validateUsername = function(){

var value = document.getElementById('usernameBox').value;

 if (value == '') {
    // display the validation errors
  usernameBoxFilledIn = false;
		//console.log("that's not an username, dumbass");
		document.getElementById('usernameValidIcon').style.opacity = "100%";
		document.getElementById('usernameValidIcon').style.backgroundColor = "red";
		document.getElementById('usernameValidIcon').setAttribute('uk-icon', "icon: close");
		user_username = '';
  
  } else {
    // display a success message
	usernameBoxFilledIn = true;
   // console.log('username be good');
	document.getElementById('usernameValidIcon').style.opacity = "100%";
	document.getElementById('usernameValidIcon').style.backgroundColor = "#32d296";
	document.getElementById('usernameValidIcon').setAttribute('uk-icon', "icon: check");
	user_username = value;
	
  }
  

};

var validatePassword = function() {
  const passwordInput = document.getElementById("passwordBox");
  const password = passwordInput.value;

  const constraints = {
    password: {
      presence: true,
      length: { minimum: 8 },
      format: {
        pattern: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/,
        message: "must contain at least one number, one uppercase letter, one lowercase letter, one special character, and be at least 8 characters long."
      }
    }
  };

  const errors = validate({ password }, constraints);

  if (errors) {
    				document.getElementById('passwordValidIcon').style.opacity = "100%";
		document.getElementById('passwordValidIcon').style.backgroundColor = "red";
		document.getElementById('passwordValidIcon').setAttribute('uk-icon', "icon: close");
			//console.log('your password fucking sucks');
			passwordIsValid = false;
			user_password = '';
  } else {

			document.getElementById('passwordValidIcon').style.opacity = "100%";
	document.getElementById('passwordValidIcon').style.backgroundColor = "#32d296";
	document.getElementById('passwordValidIcon').setAttribute('uk-icon', "icon: check");
		//console.log('password meets the requirements');
		passwordIsValid = true;
		user_password = document.getElementById('passwordBox').value;
  }
}

var validateInput = function(){

 $.getJSON("test_registry.json", function(data) {
    // Loop through each object in the data
    $.each(data, function(key, value) {
 
  var username = $('#usernameBox').val();
        var password = $('#passwordBox').val();
        var found = false;

          if (value.userName === username && value.password === password) {
            found = true;
            console.log('Login successful!');
			  UIkit.notification({message: "Login successful. Redirecting..."});
	    localStorage.setItem('username', username);
        localStorage.setItem('password', password);
			window.location.replace('/diskotek/');
            return false; // break out of the $.each() loop
          } else {
       
	    UIkit.notification({message: "Invalid username/password."});
          console.log('Invalid username or password');
		  }
 
 
    });
  });
  
  
};






};


