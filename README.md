# AmazonEG_Project 🚀  

AmazonEG_Project is a Selenium-based automation testing framework designed for automating shopping scenarios on **Amazon Egypt**. The project utilizes **Java, Selenium, TestNG, and the Page Object Model (POM)** to ensure maintainable and scalable test automation.  

## 📂 Project Structure  

```
AmazonEG_Project
│── src/
│   ├── main/java/
│   │   ├── pages/                  # Page Object Model (POM) classes
│   │   │   ├── CartPage.java
│   │   │   ├── CheckoutPage.java
│   │   │   ├── HomePage.java
│   │   │   ├── LeftSideMenu.java
│   │   │   ├── LoginPage.java
│   │   │   ├── PrimeSubscriptionPage.java
│   │   │   ├── VideoGamesProductsPage.java
│   │   ├── pages/PageBases/        # Base Page class for common actions
│   │   │   ├── PageBase.java
│   ├── test/java/
│   │   ├── data/
│   │   │   ├── config.properties   # Test configuration file
│   │   ├── tests/
│   │   │   ├── PurchaseProductsFromAmazonTest.java
│   │   ├── tests/TestBases/
│   │   │   ├── TestBase.java       # Test setup and teardown
│   │   ├── utils/
│   │   │   ├── ConfigReader.java   # Utility class for reading config properties
│── drivers/                        # WebDriver executables (Chrome, Edge, etc.)
│── pom.xml                          # Maven dependencies
│── test-output/                     # TestNG reports
│── allure-results/                   # Allure test reports
│── README.md                         # Project documentation
```

## 🛠️ Technologies Used  

- **Java** (JDK 17)  
- **Selenium WebDriver**  
- **TestNG**  
- **Maven** (Dependency Management)  
- **Allure Reports** (For test reporting)  
- **Page Object Model (POM)**  

## ⚙️ Setup & Installation  

### 1️⃣ Clone the Repository  
```sh
git clone https://github.com/MohamedDerbala007/AmazonEG_Project.git
cd AmazonEG_Project
```

### 2️⃣ Install Dependencies  
Ensure **Java 17** and **Maven** are installed. Run:  
```sh
mvn clean install
```

### 3️⃣ Configure Properties  
Modify the `config.properties` file in `src/test/java/data/` with your Amazon credentials:  
```properties
amazon.email=your-email@example.com  
amazon.password=your-password  
amazon.country=Egypt
amazon.fullname=John Doe
amazon.mobile=01012345678
amazon.street=XYZ Street
amazon.building=123
amazon.city=Cairo
amazon.state=Cairo
```

### 4️⃣ Run Tests  
To execute test cases, run:  
```sh
mvn test
```

### 5️⃣ Generate Allure Report (Optional)  
```sh
allure serve allure-results
```

## ✅ Test Scenarios Automated  

- **Login to Amazon Egypt**  
- **Navigate to Video Games category**  
- **Apply sorting & filtering options**  
- **Add products to the cart**  
- **Validate cart contents**  
- **Proceed to checkout**  
- **Enter new shipping address**  
- **Select payment method**  

## 📌 Contributing  

1. Fork the repository  
2. Create a feature branch: `git checkout -b feature-name`  
3. Commit your changes: `git commit -m "Added new feature"`  
4. Push to your branch: `git push origin feature-name`  
5. Open a Pull Request  

## 📄 License  

This project is licensed under the **MIT License**.  

---

### 🚀 Happy Testing! 🎯
