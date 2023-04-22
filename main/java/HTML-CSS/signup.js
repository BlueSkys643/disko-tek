var passwordIsValid = false;
var emailIsValid = false;
var dobIsValid = false;
var usernameIsValid = false;
var nameboxFilledIn = false;
var usernameBoxFilledIn = false;

var user_name;
var user_DOB;
var user_DOB_converted;
var user_age;
var user_email;
var user_username;
var user_password;


//validate user date
var validateDate = function(){

var dobInput = document.getElementById('dateBox');
var dob = new Date(dobInput.value); // Convert input value to a Date object
var now = new Date(); // Get the current date and time
var diff = now.getTime() - dob.getTime(); // Calculate the time difference in milliseconds
var ageDate = new Date(diff); // Convert the time difference to a Date object
var years = ageDate.getUTCFullYear() - 1970; // Extract the age in years, accounting for leap years and time zones
dobIsValid = years >= 21; // Check if user is 21 or older

 if (!dobIsValid) {
    // display the validation errors
 
		//console.log("you're not old enough, dumbass");
		document.getElementById('dateValidIcon').style.opacity = "100%";
		document.getElementById('dateValidIcon').style.backgroundColor = "red";
		document.getElementById('dateValidIcon').setAttribute('uk-icon', "icon: close");
		user_DOB = '';
		user_age = '';
  } else {
    // display a success message
    //console.log("you're old");
	document.getElementById('dateValidIcon').style.opacity = "100%";
	document.getElementById('dateValidIcon').style.backgroundColor = "#32d296";
	document.getElementById('dateValidIcon').setAttribute('uk-icon', "icon: check");
	user_age = years;
	user_DOB = dob;
	
  }


};

//validate user first/last name 
var validateName = function(){

var value = document.getElementById('nameBox').value;

 if (value === '') {
    // display the validation errors
  nameboxFilledIn = false;
		//console.log("that's not an name, dumbass");
		document.getElementById('nameValidIcon').style.opacity = "100%";
		document.getElementById('nameValidIcon').style.backgroundColor = "red";
		document.getElementById('nameValidIcon').setAttribute('uk-icon', "icon: close");
		user_name = '';
  } else {
    // display a success message
	nameboxFilledIn = true;
   // console.log('name be good');
	document.getElementById('nameValidIcon').style.opacity = "100%";
	document.getElementById('nameValidIcon').style.backgroundColor = "#32d296";
	document.getElementById('nameValidIcon').setAttribute('uk-icon', "icon: check");
	user_name = value;
	
  }
  

};

var validateUsername = function() {
  var value = document.getElementById('usernameBox').value;

  if (value == '') {
    // display the validation errors
    usernameBoxFilledIn = false;
    document.getElementById('usernameValidIcon').style.opacity = "100%";
    document.getElementById('usernameValidIcon').style.backgroundColor = "red";
    document.getElementById('usernameValidIcon').setAttribute('uk-icon', "icon: close");
    user_username = '';
  } else {
    $.getJSON("test_registry.json", function(data) {
      if (data[value]) {
        // display the validation errors
        usernameBoxFilledIn = false;
        document.getElementById('usernameValidIcon').style.opacity = "100%";
        document.getElementById('usernameValidIcon').style.backgroundColor = "red";
        document.getElementById('usernameValidIcon').setAttribute('uk-icon', "icon: close");
        user_username = '';
      } else {
        // display a success message
        usernameBoxFilledIn = true;
        document.getElementById('usernameValidIcon').style.opacity = "100%";
        document.getElementById('usernameValidIcon').style.backgroundColor = "#32d296";
        document.getElementById('usernameValidIcon').setAttribute('uk-icon', "icon: check");
        user_username = value;
      } 
      // wrap the rest of the code here
    });
  }
};


//validate email address
var validateEmail = function() {
  // get the value of the email input box
  
  document.getElementById('emailValidIcon').style.opacity = "0%";
  
  setTimeout(function(){
  
    const email = document.getElementById('emailBox').value;

    // define the validation constraints
    const constraints = {
      email: {
        presence: true,
        email: true
      }
    };

    // validate the email address against the constraints
    const errors = validate({email: email}, constraints);

    // if there are validation errors, display them
    if (errors) {
     // console.log(errors);
      emailIsValid = false;
      document.getElementById('emailValidIcon').style.opacity = "100%";
      document.getElementById('emailValidIcon').style.backgroundColor = "red";
      document.getElementById('emailValidIcon').setAttribute('uk-icon', "icon: close");
	  user_email = '';
    } else {
      // if there are no validation errors, display a success message
      emailIsValid = true;
      //console.log('email be good');
      document.getElementById('emailValidIcon').style.opacity = "100%";
      document.getElementById('emailValidIcon').style.backgroundColor = "#32d296";
      document.getElementById('emailValidIcon').setAttribute('uk-icon', "icon: check");
	  user_email = document.getElementById('emailBox').value;
    }
  }, 500);
}

//validate password
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

//convert js date object to an age
var convertAge = function(){

const date = user_DOB; // creates a new Date object with the current date and time
const month = date.getMonth() + 1; // getMonth() returns 0-indexed month, so we add 1
const day = date.getDate();
const year = date.getFullYear();
user_DOB_converted = formattedDate = `${month.toString().padStart(2, '0')}/${day.toString().padStart(2, '0')}/${year.toString()}`;
 // output: "03/26/2023" (assuming current date is March 26, 2023)

};

//validate name/date input
var validateCard1 = function(){
validateDate();
validateName();

if (!dobIsValid || !nameboxFilledIn){

UIkit.notification({message: "Diskotek is not available to those underage."});


} else {
	
	showSlide('name_date','email_username_password');


}

};

//validate email, username, password input
var validateCard2 = function(){
validateEmail();
validateUsername();
validatePassword();


if (!usernameBoxFilledIn) {
  UIkit.notification({message: "That username is invalid, or taken already."});
}

if (!emailIsValid) {
  UIkit.notification({message: "Please enter a valid email address."});
}

if (!passwordIsValid) {
  UIkit.notification({message: "Please choose a different password."});
}

if (usernameBoxFilledIn && emailIsValid && passwordIsValid) {
  console.log('finished');
  
  create_account();
  
}


};
var create_account = function() {
	

 document.getElementById('finalValidateButton').style.pointerEvents = "none";
 document.getElementById('finalValidateButton').style.opacity = "75%"; 
 
  validateDate();
  validateName();
  validateEmail();
  validateUsername();
  validatePassword();
  convertAge();

  const diskotekUser = new user(user_name, user_DOB_converted, user_age, user_email, user_username, user_password);

  console.log(diskotekUser);

  $.getJSON("test_registry.json", function(data) {
    if (data[diskotekUser.username]) {
      UIkit.notification({message: "This account already exists. Please try again."});
	  setTimeout(function(){
		  window.location.reload(true);
	  },3000);
      return;
    }

    data[diskotekUser.username] = {
      name: diskotekUser.name,
      age: diskotekUser.age,
      password: diskotekUser.password,
      isAdmin: false,
      userName: diskotekUser.username,
      email: diskotekUser.email,
      roles: ["PATRON"],
      DOB: diskotekUser.DOB
    };
    $.ajax({
      type: "POST",
      url: "script.php",
      data: {json: JSON.stringify(data)},
      success: function(response){
        console.log(response);
      }
    });
  });

  UIkit.notification({message: "You created an account! Redirecting..."});
  
  setTimeout(function(){
	  window.location.replace('login.html');
  },3000);
  
};



//the user object
var user = function(name, DOB, age, email, username, password) {
  this.name = name;
  this.DOB = DOB;
  this.age = age;
  this.email = email;
  this.username = username;
  this.password = password;
}

