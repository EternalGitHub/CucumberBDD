Feature: Facebook Application Login 

Scenario: Facebook Application Login With Wrong credentials

Given user is already on Login Page
When title of login page
Then user enters username and password
Then user clicks on login button
Then user verify the error message
Then user quit
