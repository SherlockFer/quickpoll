@ignore
Feature: API Authentication

    Scenario: Authentication test	
				Given url GARAGE_API_URL   
    		And path "/token"
        And request
        """
        {
        	"email": '#(email)',
    			"password": '#(password)'
        }
        """
    		When method POST
    		And form field grant_type = 'client_credentialsh'
    		Then status 200
    		And print 'token----',response
    		* def accessToken = response.token
    		Then print 'accessToken---', accessToken
    		
