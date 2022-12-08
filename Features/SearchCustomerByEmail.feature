Feature: Search Customer by Email

@sanity
Scenario: Search Customer by Email
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Clicks on Login
		Then User can view Dashboard "Dashboard / nopCommerce administration"
		When User click on customers Menu
		And User click on customers Menu Item
		And Enter Customer Email
		When Click on search button
		Then User should found Email in the search table
		And Close browser