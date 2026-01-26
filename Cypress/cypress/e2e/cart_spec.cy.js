describe('Cart Test', () => {
  beforeEach(() => {
    cy.login();
    cy.url().should('include', '/inventory.html');
  });

  it('Should add a product to the cart', () => {
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
  });

  it('Should sort products by price low to high', () => {
    cy.get('.product_sort_container').select('lohi');
    cy.get('.inventory_item_price').first().should('have.text', '$7.99');
  });

  it('Should remove a product from the cart', () => {
    cy.get('.inventory_item').first().as('firstItem');
    cy.get('@firstItem').find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
    cy.get('@firstItem').find('.btn_inventory').should('have.text', 'Remove').click();
    cy.get('.shopping_cart_badge').should('not.exist');
  });

  it('Should complete checkout step one and reach confirmation page', () => {
    cy.addFirstProductToCart();
    cy.get('.shopping_cart_link').click();
    cy.get('#checkout').click();
    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');
    cy.get('#continue').click();
    cy.url().should('include', '/checkout-step-two.html');
  });
});
