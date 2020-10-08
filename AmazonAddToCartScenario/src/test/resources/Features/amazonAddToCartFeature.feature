Feature: Amazon Add to Cart

  Scenario Outline: Add Item to cart and Verify that
    Given browser is open
    And navigate to amazon.com
    And clicks on Hello Sign In
    And verify enter username textbox is visible
    And user enters <username>
    And user clicks Continue
    And verify enter password textbox is visible
    And user enter <password>
    When clicks on Sign-In button
    And user is navigated to the home page and verify <loggedinuser>
    And enter the product name in search box <searchitem>
    And clicks on search icon
    And clicks on items linktext
    And clicks on addToCart button
    And clicks on cart button
    And verify the item in cart page <product>
    And mousehover on loggedin username
    And clicks on Sign Out button
    And user should navigate to enter username page
    Then close the browser

    Examples: 
      | username                  | password | loggedinuser | searchitem  | product                                                                         |
      | meenakshi262714@gmail.com | Test.123 | Menaka       | apple watch | New Apple Watch SE (GPS, 44mm) - Space Gray Aluminum Case with Black Sport Band |
