# TodoList Microservices Application

The TodoList Microservices Application is a comprehensive project that embodies a modern approach to software development and deployment. It comprises a frontend built with React, a backend Node.js Express, and a MySQL database considering DevOps best practcies and automated CI/CD pipelines for efficient and scalable application delivery.

-------------------

## Technology Stack

- **Frontend:** React
- **Backend:** Node.js Express
- **Database:** MySQL
- **Containerization:** Docker
- **Orchestration:** Kubernetes 
- **Continuous Integration:** Jenkins
- **Version Control:** Git/GitHub

## Architecture


The TodoList microservices application follows a modern microservices architecture, utilizing various technologies and tools for containerization, orchestration, and continuous integration/continuous deployment (CI/CD). Below is an overview of the architecture:

### Components

1. **Frontend (React)**
   - The frontend of the application is developed using React, a popular JavaScript library for building user interfaces.
   - It provides the user interface for managing todo items, interacting with the backend services, and displaying data.

2. **Backend (Node.js Express)**
   - The backend of the application is built with Node.js and Express.js, providing RESTful APIs for CRUD operations on todo items.
   - It handles business logic, interacts with the MySQL database, and serves data to the frontend.

3. **Database (MySQL)**
   - The MySQL database is used to store todo items and their associated data.
   - It provides persistence for the application's data and is accessed by the backend services.

### Containerization

- Each component of the application, including the frontend, backend, and database, is containerized using Docker.
- Docker images are created for each component, ensuring consistency and portability across different environments.
- These Docker images are then pushed to Docker Hub, making them accessible for deployment in Kubernetes.

### Orchestration (Kubernetes)

- The application is deployed and managed in a Kubernetes cluster.
- Kubernetes provides container orchestration, scaling, and management capabilities, ensuring high availability and reliability of the application.
- Deployments, services, and ingresses are defined in Kubernetes manifests to configure and manage the application's components.

### CI/CD Pipeline (Jenkins)

- Jenkins is used to implement a CI/CD pipeline for automating the build, test, and deployment processes.
- Pipeline scripts define the stages and tasks involved in building Docker images, running tests, pushing images to Docker Hub, and deploying the application to Kubernetes.
- Continuous integration ensures that code changes are regularly integrated and tested, while continuous deployment automates the deployment of new versions of the application to the Kubernetes cluster.

The architecture enables scalability, reliability, and automation throughout the development, deployment, and operation of the TodoList microservices application.



## Features

- Responsive and user-friendly frontend for adding and managing todo list.
- RESTful API backend for exposing API-Endpoints and handling CRUD operations on todo items.
- Persistent storage using a MySQL database.
- Containerized architecture for easy deployment and scalability.
- Orchestration and management of containers with Kubernetes.
- Automated CI/CD pipeline for efficient development and deployment workflows.



## Deployment Methods 
- Setup the minikube
- apply yaml files       
- expose the services

- or using the jenkins pipeline



---------------------------
## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Deployment](#deployment)
- [Continuous Integration and Deployment](#continuous-integration-and-deployment)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Taking advantage of containerization technology, each component of the application has been encapsulated into Docker containers, providing portability and consistency across various environments. Docker images for the frontend, backend, and database have been created and hosted on Docker Hub, ensuring easy access and distribution.

Furthermore, the project leverages Kubernetes (k8s) for orchestration and scaling, allowing seamless management of the application's lifecycle in a distributed environment. By deploying the Docker images to a Kubernetes cluster, the TodoList Microservices Application achieves high availability, scalability, and resilience.

The Continuous Integration and Continuous Deployment (CI/CD) processes are streamlined using Jenkins pipeline automation. From building Docker images to deploying updates to the Kubernetes cluster, the CI/CD pipeline ensures rapid iteration and delivery of new features, enhancements, and bug fixes.



## Endpoints

### 1. Create a new blog post
- **URL**: `/api/posts`
- **Method**: POST
- **Description**: Creates a new blog post.
- **Request Body**:
  ```json
  {
    "title": "Sample Title",
    "content": "Lorem ipsum dolor sit amet, consectetur adipiscing elit...",
    "author": "John Doe"
  }


