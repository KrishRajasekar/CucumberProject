@CancelBooking
Feature: Verify cancel booking hotel module Automation

  Scenario Outline: Cancel the new OrderId
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<RoomType>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and price
    And User click the first hotel
    And User click Ok the Alert
    Then User should verify after select hotel success message "Book Hotel"
    When User add the guest details "<SelectSalutation>","<FirstName>","<LastName>","<MobileNo>" and "<Email>",
    And User add the GST details "<EnterRegistrationNo>", "<EnterCompanyName>" and "<EnterCompanyAddress>",
    And User add the special request "<Request>"
    And User enter the payment details,procced with cardtype "<cardType>"
      | SelectCard | CardNo           | CardName  | Month    | Year | Cvv |
      | Visa       | 5555555555552222 | Rajasekar | December | 2024 | 123 |
      | Mastercard | 5555555555554444 | Rajasekar | December | 2024 | 123 |
      | Amex       | 5555555555550000 | Rajasekar | December | 2024 | 123 |
      | Discover   | 5555555555556666 | Rajasekar | December | 2024 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save order id
    And User should verify same selected hotel is booked or not
    When User navigate into the my booking page
    Then User should verify the after navigating my booking success message "Bookings"
    When User search the order id
    Then User should verify the same booked hotelname is present or not
    And User should verify the hotel price
    And User should verify the order id
    When User modify the Check-In Date "<ModifyCheckInDate>"
    Then User should verify after modify Check-In Date success message "Booking updated successfully"
    When User search the order id
    Then User should verify the same booked hotelname is present or not
    And User should verify the hotel price
    And User should verify the order id
    When User cancel the New order id
    Then User should verify the after cancel success message "Your booking cancelled successfully"

    Examples: 
      | username                 | password  | State      | City       | RoomType | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders | SelectSalutation | FirstName | LastName | MobileNo   | Email                    | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | Request | cardType   | ModifyCheckInDate |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 | Mr.              | Rajasekar | Sekar    | 8760836156 | rajasekar93446@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | nice    | Debit Card | 2024-05-21        |

  Scenario Outline: Cancel the existing OrderId
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    When User navigate into the my booking page
    Then User should verify the after navigating my booking success message "Bookings"
    When User search the order id "<OrderId>"
    Then User should verify the same booked hotelname is present or not
    When User cancel the Existing order id "<OrderId>"
    Then User should verify the after cancel success message "Your booking cancelled successfully"

    Examples: 
      | username                 | password  | OrderId     |
      | Rajasekar93446@gmail.com | Raja@2709 | #ULDKN42249 |

  Scenario Outline: Cancel the 1st OrderId
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    When User navigate into the my booking page
    Then User should verify the after navigating my booking success message "Bookings"
    When User cancel the First displayed order id
    Then User should verify the after cancel success message "Your booking cancelled successfully"

    Examples: 
      | username                 | password  |
      | Rajasekar93446@gmail.com | Raja@2709 |
