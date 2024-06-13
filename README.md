# 🛒 E-Commerce Application

This repository contains the code for a basic e-commerce application developed in Java using JavaFX for the user interface and MySQL for the database. The application includes product management, user management, shopping cart and checkout, order management, and delivery tracking modules.

## Features

### 📦 Product Management
- Add new products with details like name, description, price, and image.
- Update existing product information.
- Delete products from the inventory.
- Search for products by keyword and category.
- View all products.

### 👤 User Management
- User registration and login.
- Update user profile information.
- View order history.
- Role-based access control.

### 🛒 Shopping Cart and Checkout
- Add products to the shopping cart.
- View cart contents.
- Calculate total cost in real-time, including taxes and discounts.
- Apply discount codes.
- Multiple payment options (e.g., credit/debit cards, PayPal).
- Order confirmation page with review and edit options.

### 📦 Order Management and Fulfillment
- Process orders and update order statuses.
- Generate shipping labels and track shipments.
- Manage returns.
- Generate sales and inventory reports.
- Communicate with customers regarding order inquiries.

### 🚚 Delivery Tracking
- Track delivery status and update tracking information.

## Getting Started

### Prerequisites
- ☕ Java 17
- 🐬 MySQL
- 🎨 JavaFX

### Setting Up the Database
1. Install MySQL and create a new database named `e_commerce`.
2. Run the following SQL script to create the necessary tables:

    ```sql
    -- Create the database
    CREATE DATABASE e_commerce;
    USE e_commerce;

    -- Create the Users table
    CREATE TABLE Users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL UNIQUE,
        password VARCHAR(255) NOT NULL
    );

    -- Create the Products table
    CREATE TABLE Products (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        description TEXT,
        price DOUBLE NOT NULL,
        image_url VARCHAR(255),
        category VARCHAR(255)
    );

    -- Create the Orders table
    CREATE TABLE Orders (
        id INT AUTO_INCREMENT PRIMARY KEY,
        user_id INT NOT NULL,
        address TEXT NOT NULL,
        payment_method VARCHAR(255) NOT NULL,
        status VARCHAR(255) NOT NULL,
        FOREIGN KEY (user_id) REFERENCES Users(id)
    );

    -- Create the Cart table
    CREATE TABLE Cart (
        id INT AUTO_INCREMENT PRIMARY KEY,
        user_id INT NOT NULL,
        FOREIGN KEY (user_id) REFERENCES Users(id)
    );

    -- Create the CartItems table (association table for Cart and Products)
    CREATE TABLE CartItems (
        id INT AUTO_INCREMENT PRIMARY KEY,
        cart_id INT NOT NULL,
        product_id INT NOT NULL,
        FOREIGN KEY (cart_id) REFERENCES Cart(id),
        FOREIGN KEY (product_id) REFERENCES Products(id)
    );

    -- Create the Deliveries table
    CREATE TABLE Deliveries (
        id INT AUTO_INCREMENT PRIMARY KEY,
        order_id INT NOT NULL,
        tracking_number VARCHAR(255) NOT NULL,
        delivery_status VARCHAR(255) NOT NULL,
        FOREIGN KEY (order_id) REFERENCES Orders(id)
    );
    ```

### Running the Application

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/e-commerce-app.git
    cd e-commerce-app
    ```

2. Update the database connection details in `ProductService.java` and other relevant files:
    ```java
    private final String DB_URL = "jdbc:mysql://localhost:3306/e_commerce";
    private final String USER = "root";
    private final String PASS = "password";
    ```

3. Build and run the application using your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse) or from the command line:
    ```sh
    mvn clean install
    mvn javafx:run
    ```

## 📂 Folder Structure

- `src/main/java`
  - `controllers` - Contains the JavaFX controllers.
  - `models` - Contains the data models.
  - `services` - Contains the service classes for database operations.
  - `views` - Contains the FXML files for the user interface.
  - `Main.java` - The main entry point of the application.

## 🤝 Contributing

Contributions are welcome! Please submit a pull request or open an issue to discuss any changes.

## 📜 License

This project is licensed under the MIT License.

## 📧 Contact

For any questions or feedback, please contact [your email].

