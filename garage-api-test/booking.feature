Feature: Be able to booking

    Scenario: Create bookings
        Given url GARAGE_API_URL
        And path "/bookings"
        And request 
        """
        {
            "comments": "abcd",
            "vehiculeNumberPlate" : "{{$guid}}",
            "status": "booked",
            "countryCode": "ES",
            "vatNumber": "12345678"
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

    
    Scenario: List bookings
        Given url GARAGE_API_URL
        And path "/bookings"
        When method get
        Then status 200
        
    Scenario: Update bookings
        Given url GARAGE_API_URL
        And path "/bookings"
        And request 
        """
        {
            "comments": "abcd",
            "vehiculeNumberPlate" : "{{$guid}}",
            "status": "booked",
            "countryCode": "ES",
            "vatNumber": "12345678"
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
        And request {"comments": "abcd"}
        When method put
        Then status 200

    Scenario: Delete bookings
        Given url GARAGE_API_URL
        And path "/bookings"
        And request 
        """
        {
            "comments": "abcd",
            "vehiculeNumberPlate" : "{{$guid}}",
            "status": "booked",
            "countryCode": "ES",
            "vatNumber": "12345678"
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
        And request {"comments": "abcd"}
        When method delete
        Then status 202
