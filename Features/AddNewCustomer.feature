Feature: Customer

@regression
Scenario: Add New Customer
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Clicks on Login
		Then User can view Dashboard "Dashboard / nopCommerce administration"
		When User click on customers Menu
		And User click on customers Menu Item
		And User click on Add new button
		Then User can view Add new customer page
		When User enter customer info
		And click on Save button
		Then User can view confirmation message "The new customer has been added successfully."
		And Close browser