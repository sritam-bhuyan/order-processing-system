# Order Processing System (Spring Boot)

This is a simple **Order Processing System** built using **Java and Spring Boot**.  
The application exposes REST APIs to create and retrieve orders and stores data using **in-memory storage**.

---

## Tech Stack
- Java 21
- Spring Boot
- Maven
- REST APIs
- In-memory storage (HashMap)
- SLF4J / Logback

---

## Project Features
- Create Order
- Get Order by Order ID
- Get Orders by Customer ID
- Get All Orders
- Global Exception Handling
- Clean layered architecture

---

## Setup and Run Instructions

### Prerequisites
- Java 17 or above
- Maven
- Git

---

### Steps to Run the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/order-processing-system.git

2. Navigate to project directory:
   ```bash
   cd order-processing-system

3. Build the project:
   ```bash
   mvn clean install

4. Run the application:
   ```bash
   mvn spring-boot:run

5. Application will start on:
   ```bash
   http://localhost:8080


## API Usage Examples

1. Create Order (Save Data)
-----------------------------
   Method: POST
   URL:http://localhost:8080/api/orders

   Query Parameters:
     Key                Value
   customerId          CUST1001
   product             Laptop
   amount              75000

   Sample Response:
     {
      "orderId": "generated-uuid",
      "status": "CREATED"
     }

2. Get Order by Order ID
-----------------------------
   Method: GET
   URL:http://localhost:8080/api/orders/{orderId}
 
   Sample Response:
     {
      "orderId": "uuid",
      "customerId": "CUST1001",
      "product": "Laptop",
      "amount": 75000,
      "createdAt": "2026-02-21T11:30:00"
     }
     
3. Get Orders by Customer ID
--------------------------------
   Method: GET
   URL:http://localhost:8080/api/orders?customerId=CUST1001
   
   Sample Response:
     {
      "orderId": "uuid",
      "customerId": "CUST1001",
      "product": "Laptop",
      "amount": 75000,
      "createdAt": "2026-02-21T11:30:00"
     }

4. Get All Orders
----------------------
   Method: GET
   URL:http://localhost:8080/api/orders/all

   Sample Response:
    [
      {
       "orderId": "uuid1",
       "customerId": "CUST1001",
       "product": "Laptop",
       "amount": 75000,
       "createdAt": "2026-02-21T11:30:00"
      },
      {
       "orderId": "uuid2",
       "customerId": "CUST1002",
       "product": "Mobile",
       "amount": 25000,
       "createdAt": "2026-02-21T11:35:00"
      }
    ] 
     
     
     
     
     
     


















