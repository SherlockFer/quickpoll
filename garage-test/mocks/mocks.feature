Feature: Garage dependencies

Background:
	*configure reponseHeaders = {'content-type': 'text/xml'}

Scenario: methodIs('post') && pathMatches('/ws') && bodyPath('//Envelope/Body/GetLocationRequest') != null
    * def response = read("response-200.xml")
    * def responseStatus = 200