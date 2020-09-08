Feature: Be able to booking

    Scenario: Create Booking
        Given url GARAGE_API_URL
        And path "/bookings"
        And request 
        """
        {
           "date": "2020-01-02",
    			 "comments": "comment1",
    			 "vehicle_number_plate" : "AAA-111",
    			 "vehicle_type": "car",
    			 "base_product": {
        	 "id": 1
    			 }
        }
        """
        And header Content-Type = 'application/json; charset=utf-8'
        When method post
        Then status 201
        And print response
        And def location = responseHeaders['Location'][0]
        And def booking_id = location.substring(location.lastIndexOf('/')+1)
        And print booking_id
        
        Given path '/bookings/' + booking_id
        When method get
        Then status 200
        And print response
        And match response.id == parseInt(booking_id)
        And match response ==
        """
        {
        	 "date": "2020-01-02",
    			 "comments": "comment1",
    			 "base_product": {
    			 		"price": "#number",
    			 		"name": "Annual Service",
    			 		"id": 1,
    			 		"category": "base"
    			 	},
    			 "vat_number": "#null",
    			 "vehicle_model": "#null",
    			 "mechanic": "#null",
    			 "vehicle_type": "car",
    			 "reference": "#string",
    			 "vehicle_number_plate": "AAA-111",
    			 "vehicle_brand": "#null",
    			 "total": "#number",
    			 "extra_products": "#[0]",
    			 "parts": "#[0]",
    			 "id": "#number",
    			 "vehicle_engine": "#null",
    			 "status": "booked",
    			 "customer": "#null"
    		}
        """
       
		Scenario: Get Booking
        Given url GARAGE_API_URL
        And path "/bookings/1"
        When method get
        Then status 200
        And print response
        And match response contains
        """
        {
        	 "date": "#string",
    			 "comments": "#string",
    			 "base_product": {
    			 		"price": "#number",
    			 		"name": "#string",
    			 		"id": "#number",
    			 		"category": "#string"
    			 	},
    			 "vat_number": "#present",
    			 "vehicle_model": "#present",
    			 "mechanic": "#present",
    			 "vehicle_type": "#string",
    			 "reference": "#string",
    			 "vehicle_number_plate": "#string",
    			 "vehicle_brand": "#present",
    			 "total": "#number",
    			 "extra_products": "#[]",
    			 "parts": "#[]",
    			 "id": "#number",
    			 "vehicle_engine": "#present",
    			 "status": "#string",
    			 "customer": "#present"
    		}
        """
        
    Scenario: List Bookings
        Given url GARAGE_API_URL
        And path "/bookings"
        When method get
        Then status 200
        And print response
        And match response == '#[]'
        And match response contains
        """
        {
        	 "date": "#string",
    			 "comments": "#string",
    			 "base_product": {
    			 		"price": "#number",
    			 		"name": "#string",
    			 		"id": "#number",
    			 		"category": "#string"
    			 	},
    			 "vat_number": "#present",
    			 "vehicle_model": "#present",
    			 "mechanic": "#present",
    			 "vehicle_type": "#string",
    			 "reference": "#string",
    			 "vehicle_number_plate": "#string",
    			 "vehicle_brand": "#present",
    			 "total": "#number",
    			 "extra_products": "#[]",
    			 "parts": "#[]",
    			 "id": "#number",
    			 "vehicle_engine": "#present",
    			 "status": "#string",
    			 "customer": "#present"
    		}
        """
        
    Scenario: Update Booking
        Given url GARAGE_API_URL
        And path "/bookings"
        And request 
        """
        {
           "date": "2020-01-02",
    			 "comments": "comment1",
    			 "vehicle_number_plate" : "AAA-111",
    			 "vehicle_type": "car",
    			 "base_product": {
        	 "id": 1
    			 }
        }
        """
        And header Content-Type = 'application/json; charset=utf-8'
        When method post
        Then status 201
        And print response
        And def location = responseHeaders['Location'][0]
        And def booking_id = location.substring(location.lastIndexOf('/')+1)
        And print booking_id
        
        Given path '/bookings/' + booking_id
        And request 
        """
				{
				    "reference": "1d669e10-9b78-441e-871e-50586d7e2e2b",
				    "vehicle_number_plate": "AAA-111",
				    "vehicle_model": null,
				    "vehicle_brand": null,
				    "vehicle_engine": null,
				    "vehicle_type": "car",
				    "status": "booked",
				    "base_product": {
				        "id": 1,
				        "name": "Annual Service",
				        "category": "base",
				    },
				    "extra_products": [],
				    "parts": [],
				    "mechanic": null,
				    "customer": null,
				    "date": "2020-01-02",
				    "comments": "new comment",
				    "vat_number": null
				}
        """

        When method put
        Then status 201
        
        Given path '/bookings/' + booking_id
        When method get
        Then status 200
        And print response
        And match response.id == parseInt(booking_id)
        And match response ==
        """
        {
        	 "date": "2020-01-02",
    			 "comments": "new comment",
    			 "base_product": {
    			 		"price": "#number",
    			 		"name": "Annual Service",
    			 		"id": 1,
    			 		"category": "base"
    			 	},
    			 "vat_number": "#null",
    			 "vehicle_model": "#null",
    			 "mechanic": "#null",
    			 "vehicle_type": "car",
    			 "reference": "#string",
    			 "vehicle_number_plate": "AAA-111",
    			 "vehicle_brand": "#null",
    			 "total": "#number",
    			 "extra_products": "#[0]",
    			 "parts": "#[0]",
    			 "id": "#number",
    			 "vehicle_engine": "#null",
    			 "status": "booked",
    			 "customer": "#null"
    		}
        """
        
    Scenario: Delete Booking
    		Given url GARAGE_API_URL
        And path "/bookings"
        And request 
        """
        {
           "date": "2020-01-02",
    			 "comments": "comment1",
    			 "vehicle_number_plate" : "AAA-111",
    			 "vehicle_type": "car",
    			 "base_product": {
        	 "id": 1
    			 }
        }
        """
        And header Content-Type = 'application/json; charset=utf-8'
        When method post
        Then status 201
        And print response
        And def location = responseHeaders['Location'][0]
        And def booking_id = location.substring(location.lastIndexOf('/')+1)
        And print booking_id
        
        Given path '/bookings/' + booking_id
        When method delete
        Then status 202
        
        Given path '/bookings/' + booking_id
        When method get
        Then status 404
