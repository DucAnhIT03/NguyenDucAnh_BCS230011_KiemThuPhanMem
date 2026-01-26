describe('Login Test', () => {
  it('Should login successfully with valid credentials', () => {
    cy.login();
    cy.url().should('include', '/inventory.html');
  });

  it('Should show error message with invalid credentials', () => {
    cy.visit('/');
    cy.get('#user-name').type('invalid_user');
    cy.get('#password').type('wrong_password');
    cy.get('#login-button').click();
    cy.get('.error-message-container')
      .should('be.visible')
      .and('contain', 'Username and password do not match');
  });
});
