Feature: Be able to manage Products
     
    Background:
			  * def myFeature = call read('tokenAuthentication.feature') {email:'admin@garage.com', password:'123456'}
				* def authToken =  myFeature.accessToken 
     
    Scenario: List Products
        Given url GARAGE_API_URL
        And path "/services"
        And header Authorization = 'token ' + authToken
        When method get
        Then status 200
        And print response
        And match response == '#[]'
        And match response contains
        """
        {
        	 "id": "#number",
        	 "name": "#string",
        	 "category": "#string",
        	 "price": "#number"
    		}
        """

    Scenario: List Products when category=base
        Given url GARAGE_API_URL
        And path "/services"
        And header Authorization = 'token ' + authToken
        And param filter[category] = "base"
        And header Content-Type = 'application/json; charset=utf-8'
        When method get
        Then status 200
        And print response
        And match response == '#[]'
        And match response contains
        """
        {
        	 "id": "#number",
        	 "name": "#string",
        	 "category": "base",
        	 "price": "#number"
    		}
        """
        
     Scenario: List Products when category=extra
        Given url GARAGE_API_URL
        And path "/services"
        And header Authorization = 'token ' + authToken
        And param filter[category] = "extra"
        And header Content-Type = 'application/json; charset=utf-8'
        When method get
        Then status 200
        And print response
        And match response == '#[]'
        And match response contains
        """
        {
        	 "id": "#number",
        	 "name": "#string",
        	 "category": "extra",
        	 "price": "#number"
    		}
        """
        
    Scenario: Get Products
        Given url GARAGE_API_URL
        And path "/services"
        And header Authorization = 'token ' + authToken
        When method get
        Then status 200
        And print response
        And match response contains
        """
        {
        	 "id": "#number",
        	 "name": "#string",
        	 "category": "#string",
        	 "price": "#number"
    		}
        """