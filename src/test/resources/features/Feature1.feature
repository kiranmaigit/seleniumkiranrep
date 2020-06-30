Feature: facebook login validation

Scenario: validate login page
Given launch site using "chrome"
When  login id "9160466609" and password is "$n665544kk"
Then home page wiith tittle "Facebook" should be displayed
