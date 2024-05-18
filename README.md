# TodoList Microservices Application

The TodoList Microservices Application is a comprehensive project that embodies a modern approach to software development and deployment. It comprises a frontend built with React, a backend Node.js Express, and a MySQL database considering DevOps best practices and automated CI/CD pipelines for efficient and scalable application delivery.



## Technology Stack

- **Frontend:** React, CSS
- **Backend:** Node.js Express
- **Database:** MySQL
- **Containerization:** Docker
- **Orchestration:** Kubernetes 
- **CI/CD Pipeline:** Jenkins
- **GitOps:** ArgoCD
- **Version Control:** Git/GitHub

## Architecture

![TodoList Arhcitecture](https://github.com/Omar-tarek3/Assets/blob/master/TodoList-arhci.png)

Our To-Do application follows a modern microservices architecture, leveraging containerization and Kubernetes for deployment. The following components are essential to our setup:


### CI/CD Process

The CI/CD process ensures that any changes made by developers are automatically built, and deployed to the Kubernetes cluster without manual intervention. Here's how it works:

1. **Developer Pushes Changes**: 
   - A developer pushes code changes to the GitHub repository.

2. **Webhook Event Triggers Jenkins Pipeline**: 
   - A GitHub webhook is configured to trigger a Jenkins pipeline whenever changes are pushed to the repository.

3. **Jenkins Pipeline**:
   - **Build Stage**: Jenkins pulls the latest code from the GitHub repository.
   - **Build Docker Images**: Jenkins builds Docker images for the frontend, backend, and database services.
   - **Push Docker Images to DockerHub**: Jenkins pushes the built Docker images to DockerHub making them accessible for deployment in Kubernetes.

4. **Update Kubernetes Manifest Files**:
   - Jenkins updates the Kubernetes manifest files with the new image tags.

5. **Commit Changes to GitHub Repo**:
   - Jenkins commits the updated Kubernetes manifest files back to the GitHub repository.

6. **ArgoCD Deploys to Kubernetes**:
   - ArgoCD monitors the K8s directory in GitHub repository for changes.
   - When changes are detected, ArgoCD pulls the updated manifest files.
   - ArgoCD applies the changes to the local Kubernetes cluster, deploying the new application version.



## Features
- Full stack application
- Responsive and user-friendly frontend for adding and managing todo list.
- RESTful API backend for exposing API-Endpoints and handling CRUD operations on todo-items.
- Persistent storage for storing todo-items using a MySQL database.
- Schema.sql file to intiate schema and database table.
- Containerized architecture using Docker for easy deployment and scalability.
- Orchestration and management of containers with Kubernetes.
- Automated Jenkins CI pipeline for building and pushing Docker images and updating K8s manifests.
- Utilized ArgoCD for continuous deployment processes within the Kubernetes cluster.



## App overview
going through arhcitecture / pics


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
wwsw
