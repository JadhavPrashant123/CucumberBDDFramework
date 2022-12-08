Feature: Login

@sanity
Scenario: Successful Login with Valid Credentials
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Clicks on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And Close browser

@regression    
Scenario Outline: Successful Login with Valid Credentials DDT
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "<email>" and Password as "<password>"
    And Clicks on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And Close browser

Examples:
|email|password|
|admin@yourstore.com|admin|
|admin@yourstore.com|admin|
