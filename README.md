# 🚀 Automation Test (Saucedemo)

This repository contains automated test scripts for web application [saucedemo.com](https://www.saucedemo.com/) testing using **Selenium WebDriver** and **TestNG**. The framework follows the **Page Object Model (POM)** to enhance maintainability and reusability.

---

## 📂 Repository Structure

Repository Structure

|-- Pages/                   # Page Object Model classes for UI elements

|-- Test/                    # Test cases written using TestNG

|-- Util/                    # Utility classes for setup, assertions, and window management

|-- testng.xml               # TestNG configuration file

|-- pom.xml (if using Maven) # Maven dependencies

|-- README.md                # Setup and usage instructions

## 🔧 Prerequisites

Ensure you have the following installed on your system:
- **Java (JDK 8 or later)**
- **Maven** (if using Maven for dependency management)
- **Chrome Browser** and **ChromeDriver**
- **IntelliJ IDEA, Eclipse, or any preferred IDE**
- **TestNG plugin installed in your IDE**

## ⚙️ Setup Instructions

### Step 1: Clone the Repository
git clone https://github.com/Ikrachowdhury/Saucedemo_Selenium_Automation

cd repository-folder

### Step 2: Install Dependencies
mvn clean install

### Step 3: Configure WebDriver
Ensure the correct path to the chromedriver.exe is set in SetUp.java:

System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

Alternatively, place chromedriver.exe in the project root and modify the path accordingly.

--- 
## Test Cases

**1. Login Tests**
  - Verify valid login  
  - Verify invalid login

**2. Cart Functionalities**
  - Add items to cart
  - Remove items from cart  
  - Validate cart badge number 

**3. Checkout Process**
  - Fill checkout details
  - Verify checkout overview
  - Complete order and validate confirmation

**4. Logout Test**
  - Verify successful logout  

## Video Result
* [*Test Script Result*](https://youtu.be/LPNr2fhVzHU)
