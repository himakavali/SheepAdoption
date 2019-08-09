Feature: Sheep Adoption Form
  User enter details to complete the form for adoption



######   Happy path scenario  - User enter all the data in the form and check for the accepted page

  @tag=regression @auto
  Scenario Outline: Validate all fields present on Logicgate sheep adoption page
    Given Logicgate sheep adoption page
    Then Validate Elements on the page
    When user enter mandatory fields for adoption details "<firstName>","<Lastname>","<email>","<Address>","<Country>","<State>","<Zip>"
    Then submit the form for sheep adoption
    And Validate Adoption Request Accepted page
    Examples:
      | firstName | Lastname | email                | Address         | Country       | State | Zip   |
      | ZipHima   | Kavali   | himakavali@gamil.com | 1271 deerifoeld | United States | IL    | 60089 |

 #######   Happy Path for more than one user, this test will run with different testdata

  @tag=regression @auto
  Scenario Outline: Validate Mandatory fields for Logicgate sheep adoption page
    Given Logicgate sheep adoption page
    When user enter mandatory fields for adoption details "<firstName>","<Lastname>","<email>","<Address>","<Country>","<State>","<Zip>"
    Then submit the form for sheep adoption
    And Validate Adoption Request Accepted page
    Examples:
      | firstName | Lastname | email                 | Address          | Country       | State | Zip   |
      | Hima      | Kavali   | himakavali@gamil.com  | 1271 deerifoeld  | United States | IL    | 60089 |
      | Himak     | Kavalik  | himakavalli@gamil.com | 12712 deerifoeld | United States | IL    | 60080 |


    ######### Negative scenario - when user doesn't enter manadatory field , error message pops out , this scenario check if the correct error msg pops out

  @tag=regression @auto
  Scenario Outline: Validate error messages for Mandatory fields for Logicgate sheep adoption page
    Given Logicgate sheep adoption page
    When user enter mandatory fields for adoption details "<firstName>","<Lastname>","<email>","<Address>","<Country>","<State>","<Zip>"
    Then submit the form for sheep adoption
#    And validate the error message "Valid first name is required."
    And validate the error message when "<MandatoryFieldMissing>","<no>"
    Examples:
      | no | firstName | Lastname | email                | Address         | Country       | State | Zip   | MandatoryFieldMissing         |
      | 1  |           | Kavali   | himakavali@gamil.com | 1271 deerifoeld | United States | IL    | 60089 | Valid first name is required. |
      | 2  | Hima      |          | himakavali@gamil.com | 1271 deerifoeld | United States | IL    | 60089 | Valid last name is required.  |

  ###### ToDo same as above for all other error msgs on form, i have done for firstname and lastname , same flow for other error msgs

#      | Hima      | Kavali   | himakavali@gamil.com |                 | United States | IL    | 60089 | Please enter your home address. |
#      | Hima      | Kavali   | himakavali@gamil.com | 1271 deerifoeld |               | IL    | 60089 | Please select a valid country.  |
#      | Hima      | Kavali   | himakavali@gamil.com | 1271 deerifoeld | United States |       | 60089 | Please provide a valid state.   |
#      | Hima      | Kavali   | himakavali@gamil.com | 1271 deerifoeld | United States | IL    |       | Zip code required.              |










