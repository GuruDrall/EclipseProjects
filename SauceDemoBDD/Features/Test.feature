Feature: Login Feature Check

Scenario: Successful login with valid credential

Given open browser "chrome"
When open url "https://www.saucedemo.com/"
And enter username "standard_user" and password "secret_sauce"
And click submit
Then User should be on home page
And close browser

Scenario Outline: Successful login with multipule valid credentials

Given open browser "chrome"
When open url "https://www.saucedemo.com/"
And enter username "<username>" and password "<password>"
And click submit
Then User should be on home page
And close browser

Examples: 
| username			| password 			|
| standard_user | secret_sauce 	|
| visual_user 	| secret_sauce 	|