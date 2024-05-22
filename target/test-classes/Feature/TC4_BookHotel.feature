@BookHotel
Feature: Verify booking hotel module Automation

  Scenario Outline: Book hotel including GST-card (debitcard-VISA) with special request
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"
    And User search hotels "<State>","<City>","<Roomtype>","<CheckIn>","<CheckOut>","<No.OfRoom>","<No.OfAdults>" and "<No.OfChilders>"
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

    Examples: 
      | username                 | password  | State      | City       | Roomtype | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders | SelectSalutation | FirstName | LastName | MobileNo   | Email                    | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | Request | cardType   |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 | Mr.              | Rajasekar | Sekar    | 8760836156 | rajasekar93446@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | nice    | Debit Card |

  Scenario Outline: Book hotel including GST-card (creditcard-VISA) with special request
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
      | Visa       | 5555555555552223 | Rajasekar | December | 2024 | 123 |
      | Mastercard | 5555555555554444 | Rajasekar | December | 2024 | 123 |
      | Amex       | 5555555555550000 | Rajasekar | December | 2024 | 123 |
      | Discover   | 5555555555556666 | Rajasekar | December | 2024 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save order id
    And User should verify same selected hotel is booked or not

    Examples: 
      | username                 | password  | State      | City       | RoomType | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders | SelectSalutation | FirstName | LastName | MobileNo   | Email                    | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | Request | cardType    |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 | Mr.              | Rajasekar | Sekar    | 8760836156 | rajasekar93446@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | nice    | Credit Card |

  Scenario Outline: Book hotel including GST-card (debitcard-VISA) without special request
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
    And User add the without Special Request
    And User enter the payment details,procced with cardtype "<cardType>"
      | SelectCard | CardNo           | CardName  | Month    | Year | Cvv |
      | Visa       | 5555555555552222 | Rajasekar | December | 2024 | 123 |
      | Mastercard | 5555555555554444 | Rajasekar | December | 2024 | 123 |
      | Amex       | 5555555555550000 | Rajasekar | December | 2024 | 123 |
      | Discover   | 5555555555556666 | Rajasekar | December | 2024 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save order id
    And User should verify same selected hotel is booked or not

    Examples: 
      | username                 | password  | State      | City       | RoomType | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | cardType   |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 | Mr.              | Rajasekar | Sekar    | 8760836156 | rajasekar9346@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | Debit Card |

  Scenario Outline: Book hotel including GST-card (creditcard-VISA) without special request
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
    And User add the without Special Request
    And User enter the payment details,procced with cardtype "<cardType>"
      | SelectCard | CardNo           | CardName  | Month    | Year | Cvv |
      | Visa       | 5555555555552223 | Rajasekar | December | 2024 | 123 |
      | Mastercard | 5555555555554444 | Rajasekar | December | 2024 | 123 |
      | Amex       | 5555555555550000 | Rajasekar | December | 2024 | 123 |
      | Discover   | 5555555555556666 | Rajasekar | December | 2024 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save order id
    And User should verify same selected hotel is booked or not

    Examples: 
      | username                 | password  | State      | City       | RoomType | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders | SelectSalutation | FirstName | LastName | MobileNo   | Email                    | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | cardType    |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 | Mr.              | Rajasekar | Sekar    | 8760836156 | rajasekar93446@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | Credit Card |

  Scenario Outline: Book hotel without GST-card (debitcard-VISA) with special request
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
    And User add the without GST Details
    And User add the special request "<Request>"
    And User enter the payment details,procced with cardtype "<cardType>"
      | SelectCard | CardNo           | CardName  | Month    | Year | Cvv |
      | Visa       | 5555555555552222 | Rajasekar | December | 2024 | 123 |
      | Mastercard | 5555555555554444 | Rajasekar | December | 2024 | 123 |
      | Amex       | 5555555555550000 | Rajasekar | December | 2024 | 123 |
      | Discover   | 5555555555556666 | Rajasekar | December | 2024 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save order id
    And User should verify same selected hotel is booked or not

    Examples: 
      | username                 | password  | State      | City       | RoomType | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | Request | cardType   |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 | Mr.              | Rajasekar | Sekar    | 8760836156 | rajasekar9346@gmail.com | nice    | Debit Card |

  Scenario Outline: Book hotel without GST-card (creditcard-VISA) without special request
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
    And User add the without GST Details
    And User add the without Special Request
    And User enter the payment details,procced with cardtype "<cardType>"
      | SelectCard | CardNo           | CardName  | Month    | Year | Cvv |
      | Visa       | 5555555555552223 | Rajasekar | December | 2024 | 123 |
      | Mastercard | 5555555555554444 | Rajasekar | December | 2024 | 123 |
      | Amex       | 5555555555550000 | Rajasekar | December | 2024 | 123 |
      | Discover   | 5555555555556666 | Rajasekar | December | 2024 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save order id
    And User should verify same selected hotel is booked or not

    Examples: 
      | username                 | password  | State      | City       | RoomType | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders | SelectSalutation | FirstName | LastName | MobileNo   | Email                    | cardType    |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 | Mr.              | Rajasekar | Sekar    | 8760836156 | rajasekar93446@gmail.com | Credit Card |

  Scenario Outline: Without entering any field book hotel and verify error message
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
    And User without entering any field click submit button
    Then User should verify after payment details error message "Please select your card type","Please select your card","Please provide your card number","Please provide name on your card","Please provide your Card Expiry Date" and "Please provide your Card's security code"

    Examples: 
      | username                 | password  | State      | City       | RoomType | CheckIn    | CheckOut   | No.OfRoom | No.OfAdults | No.OfChilders | SelectSalutation | FirstName | LastName | MobileNo   | Email                    | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | Request |
      | Rajasekar93446@gmail.com | Raja@2709 | Tamil Nadu | Coimbatore | Standard | 2024-05-20 | 2024-05-22 | 1-One     | 1-One       |             1 | Mr.              | Rajasekar | Sekar    | 8760836156 | rajasekar93446@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | nice    |
