@Warehouse
Feature: Warehouse CRUD

  Scenario Outline: Updating a warehouse

    Given I am on the Warehouse List page

    When I click on the edit icon for the Warehouse I want to edit

    And I change the "<location>" and/or "<capacity>" with valid information

    And I click on the UPDATE WAREHOUSE button

    Then I should see the updated details for the Warehouse I edited in the list of Warehouses

  Examples:
  | location | capacity |
  | New location 3     | 10000    |

  Scenario: Delete a warehouse
    Given I am on the Warehouse List page

    When I click on the delete icon for the Warehouse I want to delete

    Then the warehouse should be removed from the list

  