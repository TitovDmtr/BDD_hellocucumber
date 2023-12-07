Feature: Website search

  Scenario: find webdriver site

    Given prepare browser
    When search website by name using google search
    Then check first website in the response list