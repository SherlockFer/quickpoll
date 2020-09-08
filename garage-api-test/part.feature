Feature: Be able to part
     
    Scenario: List parts
        Given url GARAGE_API_URL
        And path "/vehicles/parts"
        When method get
        Then status 200
        And print response
        And match response == '#[]'
        And match response contains
        """
        {
        	 "id": "#number",
        	 "name": "#string",
        	 "price": "#number"
    		}
        """
        
    Scenario: Get partById
        Given url GARAGE_API_URL
        And path "/vehicles/parts/1"
        When method get
        Then status 200
        And print response
        And match response contains
        """
        {
        	 "id": "#number",
        	 "name": "#string",
        	 "price": "#number"
    		}
        """