# Cypress end-to-end exercises (Sauce Demo)

This folder now includes Cypress tests for https://www.saucedemo.com alongside the existing JMeter artifacts. The tests cover login, cart, sorting, removal, and checkout flows as required by the assignment.

## Prerequisites
- Node.js 14+ and npm
- Chrome installed (used by the run script)

## Install and open
```bash
cd jmeter
npm install
npm run cypress:open   # interactive runner
npm run cypress:run    # headless run in Chrome
```

## Test scenarios
- Successful login and redirect to inventory: [cypress/e2e/login_spec.cy.js](cypress/e2e/login_spec.cy.js)
- Invalid login shows error message: [cypress/e2e/login_spec.cy.js](cypress/e2e/login_spec.cy.js)
- Add first product to cart (badge shows 1): [cypress/e2e/cart_spec.cy.js](cypress/e2e/cart_spec.cy.js)
- Sort products by Price (low to high) and see $7.99 first: [cypress/e2e/cart_spec.cy.js](cypress/e2e/cart_spec.cy.js)
- Remove product after adding and badge disappears: [cypress/e2e/cart_spec.cy.js](cypress/e2e/cart_spec.cy.js)
- Checkout: add product, go to cart, fill John Doe / 12345, land on /checkout-step-two.html: [cypress/e2e/cart_spec.cy.js](cypress/e2e/cart_spec.cy.js)

## Notes and helpers
- Base URL is set in [cypress.config.js](cypress.config.js); tests call `cy.visit('/')` implicitly.
- Reusable commands live in [cypress/support/commands.js](cypress/support/commands.js) (`cy.login`, `cy.addFirstProductToCart`).
- Videos are disabled by default; enable when you need evidence: `npx cypress run --config video=true`.
- Screenshots and videos (if enabled) will be generated under `cypress/screenshots` and `cypress/videos`.

## Suggested evidence capture
1) Run `npm run cypress:run -- --spec "cypress/e2e/**/*.cy.js" --browser chrome --config video=true`.
2) Collect screenshots/videos from `cypress/screenshots` or `cypress/videos` and attach them to the submission.

## Existing JMeter files
Performance plan and outputs remain under this folder (for reference: `performance-test-plan.jmx`, `results/`).
