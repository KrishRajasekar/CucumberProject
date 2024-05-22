@Login
Feature: Verify Omr hotel booking login module Automation

  Scenario Outline: Login to hotel booking page with valid credientials
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login success message as "Welcome Raja"

    Examples: 
      | username                 | password  |
      | Rajasekar93446@gmail.com | Raja@2709 |

  Scenario Outline: Login to hotel booking page with valid credientials using enter key
    Given User is on the omr branch page
    When User login "<username>" and "<password>" using enter key
    Then User should verify the after login success message as "Welcome Raja"

    Examples: 
      | username                 | password  |
      | Rajasekar93446@gmail.com | Raja@2709 |

  Scenario Outline: Login to hotel booking page with Invalid credientials
    Given User is on the omr branch page
    When User login "<username>" and "<password>"
    Then User should verify the after login error message as "Invalid Login details or Your Password might have expired."

    Examples: 
      | username                 | password  |
      | Rajasekar93446@gmail.com | Raja@1234 |
