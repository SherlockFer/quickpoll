Feature: Be able to manage Products
     
    Scenario: List Products
        Given url GARAGE_API_URL
        And path "/services"
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
        
    Scenario: Get Products
        Given url GARAGE_API_URL
        And path "/services"
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