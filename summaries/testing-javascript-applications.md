# Summary: Testing JavaScript applications by Lucas da Costa

## Part 1: Testing JavaScriptApplications

### Section 1. An introduction to automated testing

### Section 2. What to test and when?

## Part 2: Writing tests

### Section 3. Testing techniques

### Section 4. Testing backend applications

#### 4.1 Structuring a testing environment

Software should be designed with testing in mind.

```mermaid
  flowchart BT
    db[(Database)]:::red
    router(Router)
    e2e-tests:::orange
    logger(Logger):::red
    inventory-controller(InventoryController):::red
    cart-controller(CartController):::red
    file-system(File system):::red

    subgraph Node.js API
      router
      cart-controller
      inventory-controller
      db
      logger
    end

    subgraph Legend
      direction LR
      legend-e2e-tests(e2e tests):::orange
      legend-can-be-accessed-by-tests(Can be accessed by tests):::green
      legend-cant-be-accessed-by-tests(Can not be accessed by tests):::red
    end

    e2e-tests(Can add items to the cart)

    e2e-tests--HTTP request-->router
    router-->inventory-controller
    inventory-controller-->cart-controller
    db<-->inventory-controller
    db<-->cart-controller
    cart-controller-->logger
    logger-->file-system
    logger--HTTP response-->e2e-tests

    classDef red fill:#ff9999;
    classDef orange fill:orange;
    classDef green fill:#79d279;
    linkStyle 1,2,3,4,5,6 stroke:red;
    linkStyle 0,7         stroke:green,color:green;
```

Figure: What tests can access if an application is not designed with testing in mind.

In this situation the best you can do is send an HTTP request and check it response.  
Testable software is broken down in smaller accessible pieces, which you can test separately.

##### 4.1.1 End-to-end testing

Imagine an application that does not expose anything but its routes.  
You can interact with it only by sending HTTP requests.  
In other words, you can write only end-to-end tests.  
Such an app is an impenetrable black box of code.  
You can't set up elaborate scenarios.

```mermaid
  flowchart BT
    router(Router)
    e2e-tests(Test):::orange

    subgraph Node.js API
      router
    end

    e2e-tests

    subgraph Legend
      direction LR
      legend-e2e-tests(e2e tests):::orange
      legend-can-be-accessed-by-tests(Can be accessed by tests):::green
    end

    e2e-tests--HTTP request-->router
    router--HTTP response-->e2e-tests

    classDef orange fill:orange;
    classDef green fill:#79d279;
    linkStyle 0,1 stroke:green,color:green;
```

Lets add a test:

```js
describe('add items to a cart', () => {
  test('adding available items', async () => {
    const response = await fetch(`http://localhost:3000/carts/test_user/items/cheesecake`, {
      method: 'POST',
    })
    expect(response.status).toEqual(200)
  })
})
```

For this test to pass we should make some preparations:

- Before all tests launch the app.
- Before each test set DB to initial state.
- After all tests stop the app.

If you provide direct access to the app DB you are able to make assertions against it:

```mermaid
  flowchart TB
    e2e-tests(e2e tests):::orange
    router(Router):::green
    database[(Database)]:::green

    subgraph Node.js API
      router
      database
    end

    e2e-tests

    subgraph Legend
      direction LR
      legend-e2e-tests(e2e tests):::orange
      legend-can-be-accessed-by-tests(Can be accessed by tests):::green
      legend-cant-be-accessed-by-tests(Can not be accessed by tests):::red
    end

    e2e-tests--HTTP request-->router
    router--HTTP response-->e2e-tests
    e2e-tests--SQL query-->database
    router<-->database
    router<-->database

    classDef green fill:#79d279;
    classDef orange fill:orange;
    classDef red fill:#ff9999;
    linkStyle 0,1,2 stroke:green,color:green;
    linkStyle 3,4 stroke:red;
```

- Access to the router allows to exercise the app.
- Access to the DB allows to set up an initial state and test whether the new state is valid.

##### 4.1.2 Integration testing

We need to make integration testing possible.  
Code winthin routes should be moved to separate modules.  
These modules will expose their functions.  
So we can write tests for these functions individually.

Now can test if these modules interact correctly in more elaborate scenarios.

```javascript
// routes.js
import { addItemToCart } from './addItemToCart' // Import the extracted function.

router.post('/carts/:username/items/:item', (ctx) => {
  const { username, item } = ctx.params
  const newItems = addItemToCart({ username, item })
  ctx.body = newItems
})

// addItemToCart.test.js
describe('addItemToCart', () => {
  test('adding unavailable items to cart', () => {
    carts.set('test_user', [])
    inventory.set('cheesecake', 0)
    try {
      addItemToCart({ username: 'test_user', item: 'cheesecake' })
    } catch (error) {
      const expectedError = new Error(`cheesecake is unavailable`)
      expectedError.code = 400
      expect(error).toEqual(expectedError)
    }
    expect(carts.get('test_user')).toEqual([])
  })
})
```

A test like this does not depend on the route to which to send requests. The router even might not exist at the moment of writing such a test.  
It also doen't rely on authentication, headers, URL parameters or a specific kind of body.  
It provides more granular feedback for every scenario.

```mermaid
  flowchart TB
    e2e-tests(Test: Can add items to the cart):::orange
    router(Router):::green
    inventory-controller(InventoryController):::green
    cart-controller(CartController):::green
    database[(Database)]:::green
    inventory-controller-integration-tests(Test: Removing items from the inventory):::blue
    cart-controller-integration-tests(Test: Adding unavailable items to the cart):::blue

    subgraph Node.js API
      router
      inventory-controller
      cart-controller
      database
    end

    e2e-tests

    subgraph Legend
      direction LR
      legend-e2e-tests(e2e tests):::orange
      legend-integration-tests(Integration tests):::blue
      legend-can-be-accessed-by-tests(Can be accessed by tests):::green
      legend-cant-be-accessed-by-tests(Can not be accessed by tests):::red
    end

    e2e-tests--HTTP request-->router
    router--HTTP response-->e2e-tests
    router-->inventory-controller
    inventory-controller-->cart-controller
    inventory-controller<-->database
    cart-controller<-->database
    inventory-controller-integration-tests-->inventory-controller
    cart-controller-integration-tests-->cart-controller
    inventory-controller-integration-tests---cart-controller-integration-tests

    classDef green fill:#79d279;
    classDef orange fill:orange;
    classDef red fill:#ff9999;
    classDef blue fill:#99b3ff;
    linkStyle 0,1,6,7 stroke:green,color:green;
    linkStyle 2,3,4,5 stroke:red;
```

Figure: Which parts of the app e2e and integration tests have access to.

##### 4.1.3 Unit testing

#### 4.2 Testing HTTP endpoints

##### 4.2.1 Testing middleware

#### 4.3 Dealing with external dependencies

##### 4.3.1 Integrations with databases

##### 4.3.2 Integrations with outer APIs

#### Summary

### Section 5. Advanced backend testing techniques

### Section 6. Testing frontend applications

### Section 7. The React testing ecosystem

### Section 8. Testing React applications

### Section 9. Test-driven development

### Section 10. UI-based end-to-end testing

### Section 11. Writing UI-based end-to-end tests

## Part 3: Business impact

### Section 12. Continious integration and continious delivery

### Section 13. A culture of quality
