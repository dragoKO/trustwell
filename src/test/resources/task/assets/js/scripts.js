
jQuery(document).ready(function() {
	
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
		
	
		var formUsername = $("input").eq(0).val();
		var formPassword = $("input").eq(1).val()
		
		if (formUsername == "")
		{
			e.preventDefault();
			$('#validation-errors').text('Password cannot be blank.');
		}
		
		if (formUsername == "" || formUsername != "testUser")
		{
			e.preventDefault();
			$('#validation-errors').text('Invalid login attempt. Please try again.');
		}
		
		if (formUsername == "testUser" && formPassword != "Test1234")
		{
			e.preventDefault();
			$('#validation-errors').text('The password is incorrect for username ' + formUsername);
		}

		
		if (formUsername == "testUser" && formPassword == "Test1234")
		{	
			window.location = "home.html?username=testUser";
		}

		return false;
    	
    });
	
    
    
});
