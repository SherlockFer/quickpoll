Feature: Be able to manage Users

    Scenario: Create User
        Given url GARAGE_API_URL
        And path "/users"
        And request 
        """
        {
           "full_name": "Customer",
    			 "mobile": "123456789",
    			 "email": "example@garage.com",
    			 "password": "password"
        }
        """
        And header Content-Type = 'application/json; charset=utf-8'
        When method post
        Then status 201
        And print response
        And def location = responseHeaders['Location'][0]
        And def user_id = location.substring(location.lastIndexOf('/')+1)
        And print user_id
        
        Given path '/users/' + user_id
        When method get
        Then status 200
        And print response
        And match response.id == parseInt(user_id)
        And match response == 
        """
        {
        	 "id": "#number",
        	 "full_name": "Customer",
    			 "mobile": "123456789",
    			 "email": "example@garage.com",
    			 "role": "customer"
        }
        """
        Given path '/users/' + user_id
        When method delete
        Then status 202
        
    Scenario: Get User
        Given url GARAGE_API_URL
        And path "/users/1"
        When method get
        Then status 200
        And print response
        And match response contains
        """
        {
        	 "id": "#number",
        	 "full_name": "#string",
        	 "mobile": "#string",
        	 "email": "#string",
    			 "role": "#string"
    		}
        """
            
    Scenario: List Users
        Given url GARAGE_API_URL
        And path "/users"
        When method get
        Then status 200
        And print response
        And match response == '#[]'
        And match response contains
        """
        {
        	 "id": "#number",
        	 "full_name": "#string",
        	 "mobile": "#string",
        	 "email": "#string",
    			 "role": "#string"
    		}
        """
        
    Scenario: Update User
        Given url GARAGE_API_URL
        And path "/users"
        And request 
        """
        {
           "full_name": "New customer",
    			 "mobile": "123456789",
    			 "email": "example@garage.com",
    			 "password": "password"
        }
        """
        And header Content-Type = 'application/json; charset=utf-8'
        When method post
        Then status 201
        And print response
        And def location = responseHeaders['Location'][0]
        And def user_id = location.substring(location.lastIndexOf('/')+1)
        And print user_id
        
        Given path '/users/' + user_id
        When method get
        Then status 200
        And print response
        And match response.id == parseInt(user_id)
        And match response == 
        """
        {
        	 "id": "#number",
        	 "full_name": "New customer",
    			 "mobile": "123456789",
    			 "email": "example@garage.com",
    			 "role": "customer"
        }
        """
        Given path '/users/' + user_id
        When method delete
        Then status 202

    Scenario: Delete User
        Given url GARAGE_API_URL
        And path "/users"
        And request 
        """
        {
           "full_name": "Customer",
    			 "mobile": "123456789",
    			 "email": "example@garage.com",
    			 "password": "password"
        }
        """
        And header Content-Type = 'application/json; charset=utf-8'
        When method post
        Then status 201
        And print response
        And def location = responseHeaders['Location'][0]
        And def user_id = location.substring(location.lastIndexOf('/')+1)
        And print user_id 
        
        Given path '/users/' + user_id
        When method delete
        Then status 202
        
        Given path '/users/' + user_id
        When method get
        Then status 404
        