@selectHotel
Feature: Verify hotel booking Select Hotel module Automation

  Scenario Outline: Verify select hotel and verify navigate to book hotel upon accepting the alerts
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and price
    And User click the first hotel
    And User click Ok the Alert
    Then User should verify after select hotel success message "Book Hotel"

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |

  Scenario Outline: Verify select hotel and verify navigate to same page upon dimiss the alerts
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    When User click the first hotel
    And User click Cancel the Alert
    Then User should verify after same search hotel success message "Select Hotel"

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |
