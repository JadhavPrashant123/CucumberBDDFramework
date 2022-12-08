Feature: Search Customer by Name

@regression
Scenario: Search Customer by Name
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Clicks on Login
		Then User can view Dashboard "Dashboard / nopCommerce administration"
		When User click on customers Menu
		And User click on customers Menu Item
		And Enter customer Firstname
		And Enter customer Lastname 
		When Click on search button
		Then User should found Name in the search table
		And Close browser