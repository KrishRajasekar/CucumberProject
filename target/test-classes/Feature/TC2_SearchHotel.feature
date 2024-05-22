@Select
Feature: Verify hotel booking Search Hotel module Automation

  Scenario Outline: Verify Search Hotel enter in valid credientials
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    When User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |

  Scenario Outline: Verify Search Hotel enter in manatory fields
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    When User search hotels "<State>","<City>","<CheckIn>","<CheckOut>","<No.OfRoom>" and "<No.OfAdults>" in the fields and
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | username                 | password  | State      | City       | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |

  Scenario Outline: Verify Click Search button without enter values in the fields
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    When User click search button
    Then User should verify after search hotel error message "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | username                 | password  |
      | Rajasekar93446@gmail.com | Raja@2709 |

  Scenario Outline: Verify selected roomtype is endswith hotelName
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    When User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should verify all hotel listed in the selected roomtype "<roomtype>"

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |

  Scenario Outline: Verify all selected roomtype displayed in header
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should verify all listed hotel roomtype displayed in header "<roomtype>"

    Examples: 
      | username                 | password  | State      | City       | Roomtype                            | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard/Deluxe/Suite/Luxury/Studio | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |

  Scenario Outline: Verify sorting functionality hotel price from Low to High
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    When User click sorting functionality price Low to High
    Then User Should verify the displayed hotel names are in price Low to High

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |

  Scenario Outline: Verify sorting functionality hotel price from High to Low
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    When User click sorting functionality price High to Low
    Then User Should verify the displayed hotel names are in price High to Low

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |

  Scenario Outline: Verify sorting functionality hotel name Ascending
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    When User click sorting functionality name Ascending
    Then User Should verify the displayed hotel names are in ascending

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |

  Scenario Outline: Verify sorting functionality hotel name Descending
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    When User click sorting functionality name Descending
    Then User Should verify the displayed hotel names are in descending

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 |
