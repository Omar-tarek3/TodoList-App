# TodoList Microservices Application

The TodoList Microservices Application is a comprehensive end-to-end project that embodies a modern approach to software development and deployment. It comprises a frontend built with React, a backend Node.js Express, and a MySQL database considering DevOps best practices and automated CI/CD pipelines for efficient and scalable application delivery.



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




The CI/CD process ensures that any changes made by developers are automatically built, and deployed to the Kubernetes cluster without manual intervention. Here's how it works:

1. **Developer Pushes Changes**: 
   - A developer pushes code changes to the GitHub repository.

2. **Webhook Event Triggers Jenkins Pipeline**: 
   - A GitHub webhook is configured to trigger a Jenkins pipeline whenever changes are pushed to the repository.

3. **Jenkins Pipeline**:
   - **Build Stage**: Jenkins pulls the latest code from the GitHub repository.
   - **Build Docker Images**: Jenkins builds Docker images for the frontend, backend, and database services.
   - **Push Docker Images to DockerHub**: Jenkins pushes the built Docker images to DockerHub making them accessible for deployment in Kubernetes.

   - **Update Kubernetes Manifest Files**: Jenkins updates the Kubernetes manifest files with the new image tags.

   - **Push Changes to GitHub Repo**: Jenkins pushes the updated Kubernetes manifest files back to the GitHub repository.

4. **ArgoCD Deploys to Kubernetes**:
   - ArgoCD monitors the K8s directory in GitHub repository for changes.
   - When changes are detected, ArgoCD pulls the updated manifest files.
   - ArgoCD applies the changes to the local Kubernetes cluster, deploying the new application version.



## Features
- Full stack application
- Responsive and user-friendly frontend for adding and managing todo list.
- RESTful API backend for exposing API-Endpoints and handling CRUD operations on todo-items.
- Persistent storage for storing todo-items using a MySQL database.
- Schema.sql file to intiate schema and database table.
- Containerized architecture using Docker build for each microservice component (frontend, backend, database).
- Orchestration and management of containers with Kubernetes.
- Automated Jenkins CI/CD pipeline for building and pushing Docker images and updating K8s manifests.
- Utilized ArgoCD for continuous deployment processes within the Kubernetes cluster.



## App overview
going through arhcitecture  
- docker images
- run app using docker-compose.yaml
- api end points 
- jenkins setup
- k8s cluster arhcitecture 
- port forward 
- Argocd setup
- pics 
