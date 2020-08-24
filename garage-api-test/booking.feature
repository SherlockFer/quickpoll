Feature: Be able to booking

    Scenario: Post bookings
        Given url "http://192.168.1.140:8080/bookings"
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
    
    Scenario: Get bookings
        Given url "http://192.168.1.140:8080/bookings"
        When method get
        Then status 200
    
    Scenario: put bookings
        Given url "http://192.168.1.140:8080/bookings/19"
         And request { "comments": "abcd" }
        When method put
        Then status 200
    
    Scenario: delete bookings
        Given url "http://192.168.1.140:8080/bookings/19"
        When method delete
        Then status 202