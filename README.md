# CTAC-104-Order Management Project

## Building Up/Running The Project
- Clone the repository onto your local machine
    - This can be done by either downloading the repo as a .zip file and unpacking it or if using IntelliJ/VSCode
      into your desired directory via command line: ```gh repo clone EastonA01/CTAC-104-Order-Management-System```
- Navigate to the Main class (named CtacTddMiniProjectApplication)
    - (If running through IntelliJ) you can right click the class in the project files and select "Run".
    - (Command Line Option) in the root of our project folder you can run ```mvn spring-boot:run``` if all dependencies
      are properly installed

## Executing Test Cases
- Using Command Line:
  - Execute in the root directory ```mvn test``` to run all tests in Maven's Test Folder
- If Using IntelliJ:
  - You can right click the test folder that you would like to run the test cases from (ex. /src/test/java/org.example.ctac104ordermanagementsystem/) and
  select "Run 'Tests in '/src/test/java/org.example.ctac104ordermanagementsystem" and all test cases in that package will be run.

## Chosen Methodology
- For this particular project I chose Test Driven Development (TDD) as
my preferred method of implementation. My reasoning behind this is primarily in my familiarity
in TDD over Behavior Driven Development (BDD) and my ability to write test cases for such.

## Test Cases Written

#### Test Case 1: Create Order
- Test Case Creates `Order` with name "John Doe"
  - Intended Results: Customer is created and is found in database

#### Test Case 2: Get Order by ID
- Test Case Gets `Order` by the OrderID in OrderRepository
    - Intended Results: Fetched order customer name is equal to requested customer order name.

#### Test Case 3: Update Order
- Test Case updates an existing `Order` (ID 1) with a new customer name "Jane Smith".
    - Intended Results: Order is updated, and the new customer name "Jane Smith" is saved in the database.

#### Test Case 4: Delete Order
- Test Case deletes an `Order` by ID (1L).
    - Intended Results: Order is successfully deleted, and no longer exists in the db.

#### Test Case 5: Create Product
- Test Case creates a Product with the name "Laptop", quantity 10, and price $1000.
    - Intended Results: Product is successfully created and saved in the database.

#### Test Case 6: Get Product by ID
- Test Case fetches a `Product` by ID (1L).
    - Intended Results: Product with ID 1 is successfully retrieved from the database and has the name "Laptop".

#### Test Case 7: Get All Products
- Test Case retrieves all products from the database.
    - Intended Results: A list of products is successfully retrieved. The list contains "Laptop" and "Smartphone".

#### Test Case 8:
- Test Case updates an existing `Product` (ID 1) with a new product name "Desktop", quantity 5, and price $800.
    - Intended Results: Product is updated, and the new product details ("Desktop", 5, $800) are saved in the database.

#### Test Case 9:
- Test Case deletes a `Product` by ID (1L).
    - Intended Results: Product is successfully deleted, and no longer exists in the database.


## Testing Routes With Postman

### Products

- BASE ROUTE: `http://localhost:8080/products`
- POST Product
  - RAW JSON:
  - ```json
    {
    "productName": "Laptop",
    "quantity": 10,
    "price": 1000.0
    }
    ```
- GET ALL `http://localhost:8080/products`
  - Response:
    - List Of Products
- GET BY ID `http://localhost:8080/products/{id}`
  - Response:
    - 200 Response if Found with Object
    - 500 Internal Error if not found
- PUT BY ID (update product) `http://localhost:8080/products/{id}`
  - RAW JSON:
  - ```json
    {
    "productName": "Desktop",
    "quantity": 5,
    "price": 800.0
    }
    ```
  - Response:
  - Updated Product Object
- DELETE BY ID `http://localhost:8080/products/{id}`
  - Expected Response: 204 No Content

### Orders

- BASE ROUTE: `http://localhost:8080/orders`
  - POST (Create) ORDER
    - RAW JSON:
    - ```json
      {
      "id": 1,
      "customerName": "John Doe",
      "orderDate": "2024-09-15",
      "products": [
      {
      "id": 1,
      "quantity": 2
      }
      ]
      }
      ```
  - GET BY ID: `http://localhost:8080/orders/{id}`
  - Response:
    - Order object with id, name, date and products
  - PUT (UPDATE) BY ID: `http://localhost:8080/orders/{id}`
  - RAW JSON:
  - ```json
    {
    "customerName": "Jane Doe",
    "orderDate": "2024-09-16",
    "products": [
    {
    "id": 2,
    "quantity": 3
    }
    ]
    }
    ```
  - Response: 200 OK with updated Order object.
  - DELETE BY ID: `http://localhost:8080/orders/{id}`
  - Response: 204 No Content