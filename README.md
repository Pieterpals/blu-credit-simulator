# 🚀 Credit Simulator (Console-Based Loan Calculator)

Credit Simulator is a **Spring Boot console application** that helps users **simulate loan calculations** based on loan amount, interest rates, and payment tenure. This project is **containerized with Docker** and can be deployed via **GitHub Actions CI/CD**.

---

## 📜 Features
✅ Loan calculation with dynamic interest rates  
✅ Monthly installment estimation  
✅ Interactive console-based input  
✅ Dockerized for easy deployment  
✅ CI/CD integration with GitHub Actions  

---

## 🏗️ Tech Stack
- **Java 21**  
- **Spring Boot 3**  
- **Maven**  
- **Docker**  
- **GitHub Actions (CI/CD)**  

---

## 🔥 Getting Started

### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/Pieterpals/blu-credit-simulator.git
cd blu-credit-simulator
```

---

## **🔹 Running the Application Locally (Java & Maven)**

### **2️⃣ Ensure You Have Java & Maven Installed**
#### ✅ **Check Java Version**
```sh
java -version
```
Expected output:
```
java version "21.0.x"
```
#### ✅ **Check Maven Version**
```sh
mvn -version
```
Expected output:
```
Apache Maven 3.x.x
```

### **3️⃣ Build the Project**
Run the following command to compile and package the application:
```sh
mvn clean package
```
✅ This will generate a JAR file inside `target/`:
```
target/credit-simulator.jar
```

### **4️⃣ Run the Application**
Run the application using:
```sh
java -jar target/credit-simulator.jar
```
✅ The console application will start and prompt for input.

### **5️⃣ Run with Input File**
If you want to use a file as input, run:
```sh
java -jar target/credit-simulator.jar file_inputs.txt
```

### **6️⃣ Run Using the `bin/credit_simulator` Script**
If you have the `bin` script setup, you can run:
```sh
bin/credit_simulator
```
or with a file:
```sh
bin/credit_simulator file_inputs.txt
```

---

## 🛠️ Using Docker for Credit Simulator

### **🔹 1. Build the Docker Image Locally**
```sh
docker build -t your-docker-username/credit-simulator:v1.0 .
```

### **🔹 2. Run the Console Application in Interactive Mode**
```sh
docker run -it your-docker-username/credit-simulator:v1.0
```

To run the application with an input file:
```sh
docker run -it your-docker-username/credit-simulator:v1.0 file_inputs.txt
```

### **🔹 3. Check Running Containers**
```sh
docker ps
```

### **🔹 4. Stop the Container (if needed)**
```sh
docker stop <container_id>
```

---

## 🚀 **Running Credit Simulator from Docker Hub**
If you don’t want to build locally, you can pull the latest image from **Docker Hub**.

### **🔹 1. Pull the Docker Image**
```sh
docker pull your-docker-username/credit-simulator:v1.0
```

### **🔹 2. Run the Console Application**
```sh
docker run -it your-docker-username/credit-simulator:v1.0
```

To run the application with an input file:
```sh
docker run -it your-docker-username/credit-simulator:v1.0 file_inputs.txt
```

---

## 🚀 **CI/CD with GitHub Actions & Docker**
This project **automatically builds & pushes a Docker image** on every `git push` to `main`.

### **🔹 Workflow Automation**
- **GitHub Actions** builds and tests the project.
- **Docker Hub** stores the built images.
- **CI/CD ensures fresh deployment on each push**.

### **🔹 How It Works**
1. **Push code to GitHub**  
2. **GitHub Actions builds the Docker image**  
3. **Image is pushed to Docker Hub**  
4. **You can pull & run it anywhere**  

#### **🔹 Run the App from Docker Hub**
```sh
docker run -it your-docker-username/credit-simulator:v1.0
```

To run the application with an input file:
```sh
docker run -it your-docker-username/credit-simulator:v1.0 file_inputs.txt
```

---
