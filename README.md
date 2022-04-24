## About

This project contains automated tests for the page http://automationpractice.com/index.php.

The tests are built using JUnit in Java. For browser automation, selenium is used along with ChromeDriver to control chrome.
The test case section contains test cases for the website (I decided to write automation tests for every test case).
Bugs that i reported are located in the Issues section.

## Technology

-Java
-Selenium
-JUnit
-Gitlab (optional)
-Maven

## Installation

To run this project, you need to have Java verison 18 (Most versions after 8 should work).
If you don't have Java installed localy, you can refer to this link https://www.java.com/en/download/help/download_options.html.

If you don't have maven installed, you can refer to these docs https://www.baeldung.com/install-maven-on-windows-linux-mac.

You don't need an IDE to run this project, but it would be helpful to have one.
Test were written in IntelliJ, you can go to this link to download it https://www.jetbrains.com/idea/download.
Those are the only requirements needed to run the tests, detailed steps on how to run the actual tests are described in the section below.

## Running

To run the tests without an IDE, you need to follow these steps:
- Clone this repository
- Open a new terminal window and cd to project folder.
- Run the command: mvn test

To run these tests inside IntelliJ, follow these steps:
- Clone this repository
- Open the project in IntelliJ (open the pom.xml file)
- Navigate to pom.xml file and run the maven install from the widget in the top right corner (or install maven dependencies via the terminal)
- Navigate to the test folder in src
- Right click on the test folder and click 'run all tests' (or a single test)


## Test Cases

# Test Home Page (automated smoke test 1) [positive test case]
Test Case: Test if the home page is responsive
Test Case Description: This test case is written as a small initial test case to ensure that the main page of the website is running after deployment
Test Data: /
Expected Result: The homepage opened in reasonable time and is responsive
Test Steps: 
- Enter home page URL
- Assert home page URL is correct
- Assert that the page is opened and responsive

# Test Item Information (automated smoke test 2) [positive test case]
Test Case: Test if all of the items are reponsive
Test Case Description: The goal of this test is to see if the items of the page are responsive and display the appropriate data
Test Data: /
Expected Result: All of the items are responsive and showing their respective data
Test Steps: 
- Enter home page URL
- Click Women Category
- Find all elements
- Iterate through each element
- Open element page
- Assert that the price and name show appropriate values

# Test Item Purchase (automated smoke test 3) [positive test case]
Test Case: Test if an item can be added to the cart and purchased
Test Case Description: The goal of this test is to see if the user can go through the process of buying an item. This is done by adding the item to the cart and proceeding to checkout. The test also covers the validity of the price given that there is a shipping cost and a tax cost.
Test Data: First item on the Woman collection page, The email for logging in -> (matej.mujezinovic@gmail.com), The password for logging in -> (12345)
Expected Result: The item is successfully added to the cart and the user is able to proceed to the final stage of the checkout.
Test Steps: 
- Enter home page URL
- Click Women Category
- Hover over first item
- Click Add to cart
- Click Proceed to checkout (1)
- Assert that total price is displayed correctly
- Click Proceed to checkout (2)
- Enter email (in the already registered box)
- Enter password
- Click Sign in
- Click Proceed to checkout (3)
- Click Terms of service checkbox
- Click Proceed to checkout (4)

# Register Test [positive test case]
Test Case: Test if a user can register his/her account.
Test Case Description: The goal of this test is to see if a user can register on the website. This test covers input field validation for length, types, formats
Test Data: 
- Email field (matej.mujezinovic@gmail.com)
- First Name (Matej)
- Last Name (Mujezinovic)
- Password (12345)
- Day Of Birth (30)
- Month Of Birth (7)
- Year of Birth (2000)
- Address (Zmaja od Bosne 82)
- City (Sarajevo)
- County (United StateS)
- State (Arizona)
- Zip/Postal Code (85018)
- Mobile Phone (38761272470)
- Address Alias (matej.mujezinovic@gmail.com)
Expected Result: Register should succeed and redirect to account page
Test Steps: 
- Enter home page URL
- Click Sign in
- Enter email (in the create an account box)
- Click Create an account
- Enter first name
- Enter last name
- Enter password
- Enter day of birth
- Enter month of birth
- Enter year of birth
- Enter address
- Enter city
- Enter country
- Enter state
- Enter postal code
- Enter mobile phone
- Enter address alias
- Click Register
- Assert that the user was created and redirected to his account page

# Login Test [positive test case]
Test Case: Test if a registered user can log in
Test Case Description: The goal of this test is to see if a registered user can log in using his/her email and password
Test Data:
- Email (matej.mujezinovic@gmail.com)
- Password (12345)
Expected Result: The user is able to log in using his/her credentials
Test Steps: 
- Enter home page URL
- Click Sign in
- Enter Email (in the already registered box)
- Enter Password
- Click Sign in
- Enter first name
- Assert that the user was redirected to his account page

# Gitlab Integration
I Deployed these tests to a Gitlab environment to simulate real world CI/CD scenarios.
You can view the pipeline on this link: https://gitlab.com/Matkoza/automationpractice-automation-test



