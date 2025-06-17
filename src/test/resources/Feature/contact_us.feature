Feature: Contact Us Form

  Scenario: Submit a message via Contact Us form
    Given I am on the contact us page
    When I fill in the contact us form with valid details
    And I submit the contact us form
    Then I should see a success message