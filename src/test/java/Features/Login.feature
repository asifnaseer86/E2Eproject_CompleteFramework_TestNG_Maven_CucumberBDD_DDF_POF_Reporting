#Simple test Scenario will be same
#Parametrization then instead of Scenario will be Scenario Outline
Feature: Login into Apllication
#---------- normal mode
#Scenario: Positive test validating login
#parametizing mode
Scenario Outline: Positive test validating login
Given intialize the browser with chrome
And navigate to "http://qaclickacademy.com/" site
And click on login button in home page to land on secure sign in page
#-------------- normal mode
#When user enters "test99@gmail.com" and "123456" and logs in
#parametizing mode
When user enters <username> and <password> and logs in
Then verify that user is successfully logged in
And close browser

#paramiterzing
Examples:
|username			|password	|
|test99@gmail.com	|123456		|
|test9@gmail.com	|12345		|