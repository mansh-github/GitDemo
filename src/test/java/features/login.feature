Feature: Login into Application

Scenario Outline: Positive test validating login

Given Initilize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" Site
And Click on Login likn in home page to land on Secure sing in page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in

Examples:
|username    |password |
|user1			 |password1|
|user2			 |password2|