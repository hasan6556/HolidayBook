@wip
Feature: US_01

  Background:  For All Test
     * User goes to "Url" web site
     * User logs the web site

  Scenario: TC_01 Verify the site is accessible.
    * User can see home page
    * closes driver


  Scenario: TC_02 Verify there are search boxes on the main page.

    * User can see search boxes in home page
    * closes driver

  Scenario: TC_03  When a search is made with the search boxes and search button is pressed,it is confirmed that the desired results are listed.

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User can see the holiday list
    * closes driver


  Scenario: TC_04  when the desired holiday is selected and clicked on, it is confirmed that the new page opens.

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User can see the new page
    * closes driver

  Scenario: TC_05  As a user ı can see make a reservation button in new page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User can see make a reservation button in new page
    * closes driver


  Scenario: TC_06 As a user ı can see information boxes in reservation page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User can see boxes for enter his informations
    * closes driver


  Scenario: TC_07 As ı user ı  can enter my information in boxes in reservation page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User can enter his informations in boxes
    * closes driver


  Scenario: TC_08 As ı user ı can add another person for reservation so ı can see add another person check box in reservation page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User see add another person in rezervation page
    * when cliks add another person checkbox can see other information boxes
    * closes driver

  Scenario: TC_09 As ı user ı can add billing  for reservation so ı can see add billing  check box in reservation page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User see add billing checkbox in rezervation page
    * when cliks add billig checkbox can see other information boxes
    * closes driver


  Scenario: TC_10 As ı user ı can add note for reservation so when ı click to add note checkbox ı can see description box in page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User see add note checkbox in rezervation page
    * when cliks add note checkbox can see description box
    * closes driver



  Scenario: TC_11 As ı user ı can add transportation for reservation so when ı click to add transportation checkbox ı can see boxes for transportation in page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User see add transportation in rezervation page
    * when cliks add transportation checkbox can see description box
    * closes driver




  Scenario: TC_12 As ı user ı can see contiune to payment button after ı fill necessary information boxes

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User see check out to payment button in rezervation page
    * closes driver




  Scenario: TC_13 When ı click contiune to payment button ı can see payment page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User can enter his informations in boxes
    * when cliks checkout to payment page  can see payment page
    * closes driver



  Scenario: TC_14 As ı user ı can enter my credit card information in payment page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User can enter his informations in boxes
    * User clicks checkout to payment button
    * In new page user can enter his payment information in boxes
    * closes driver


  Scenario: TC_15 As ı user ı can use my coupon so ı should see coupon box in payment page

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User can enter his informations in boxes
    * User clicks checkout to payment button
    * In new page user can see coupon box
    * closes driver


  Scenario: TC_16 As ı user ı can enter my coupon code in coupon box

    * User fills  the necessary information in boxesd
    * Clicks searh button
    * User selects the desired hotel and clicks
    * User clicks the make a reservation button
    * User can enter his informations in boxes
    * User clicks checkout to payment button
    * In new page user can enter his coupon code in  coupon box
    * closes driver




