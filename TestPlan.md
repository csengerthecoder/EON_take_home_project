# Test Plan – EON Take Home Project (E2E Testing)

## Purpose
The purpose of this test plan will be to verify that the RealWorld application works correctly from the user’s perspective by testing the main workflows through the UI in a real browser.

---

## What I plan to test

### Authentication
I will test the basic authentication features:
- signing in with valid credentials
- trying to sign in with missing or wrong data and checking the error messages
- navigating between login and register pages
- registering a new user with valid and invalid inputs
- logging out works correctly

### Home page and tags
On the home page I will check:
- clicking on a popular tag filters the articles
- the filtered articles show the selected tag correctly

### Articles
For article functionality I will test:
- creating a new article
- opening the edit page and modifying an article
- deleting an article
- adding comments to articles
- favoriting and unfavoriting articles
- following/unfollowing an author
- checking that favorited articles appear in the profile favorites tab

### Settings / profile
For user settings I will test:
- updating profile data like username or bio
- changing email or password
- logging out and logging back in with the new credentials

---

## Test approach
The tests will be automated using **Selenium WebDriver with JUnit 5**.  
They will run in a Chrome browser and simulate real user actions like clicking buttons, filling forms, and navigating between pages.  
The expected UI behavior, messages, and page changes will be checked.

---

## Test environment
- The frontend will run locally at `http://localhost:3000`
- The backend will be running and connected
- Tests will be executed locally, possibly also in headless mode

---

## Out of scope
For this project I will not focus on:
- API testing
- performance or load testing
- security testing