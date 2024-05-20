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

![TodoList Arhcitecture](https://github.com/Omar-tarek3/Assets/blob/master/TodoList-pipeline.png)




The CI/CD process ensures that any changes made by developers are automatically integrated, built, and deployed to the Kubernetes cluster without manual intervention. Here's how it works:

1. **Developer Pushes Changes**: 
   - A developer pushes code changes to the GitHub repository.

2. **Webhook Event Triggers Jenkins Pipeline**: 
   - A GitHub webhook is configured to trigger a Jenkins pipeline whenever changes are pushed by the developer to the repository.

3. **Jenkins Pipeline**:
   - **Build Stage**: Jenkins pulls the latest code from the GitHub repository.
   - **Build Docker Images**: Jenkins builds Docker images for the frontend, backend, and database services.
   - **Push Docker Images to DockerHub**: Jenkins pushes the built Docker images to DockerHub making them accessible for deployment in Kubernetes.

   - **Update Kubernetes Manifest Files**: Jenkins updates the Kubernetes manifest files with the new image tags.

   - **Push Changes to GitHub Repo**: Jenkins pushes the updated Kubernetes manifest files back to the GitHub repository.

4. **ArgoCD Deploys to Kubernetes**:
   - ArgoCD monitors the `K8s` directory in GitHub repository for changes.
   - When changes are detected, ArgoCD pulls the updated manifest files.
   - ArgoCD applies the changes to the local Kubernetes cluster, deploying the new application version.



## Features
- Full stack application
- Responsive and user-friendly frontend for adding and managing todo list using React and custom CSS file
- RESTful API backend for exposing API-Endpoints and handling CRUD operations on todo-items.
- Persistent storage for storing todo-items using a MySQL database.
- Schema.sql file to intiate schema and database table.
- Containerized architecture using Docker build for each microservice component (frontend, backend, database).
- Orchestration and management of containers with Kubernetes.
- Automated Jenkins CI/CD pipeline for building and pushing Docker images and updating K8s manifests.
- Utilized ArgoCD for continuous deployment processes within the Kubernetes cluster.



## App overview 
1. ### Docker Compose
    You can have a quick set up and run to the entire application stack to view the app components and interact with it. Ensure you have Docker and Docker Compose installed on your machine.

   #### Running the Application:
   - Copy the `docker-compose.yaml` file located at the app's root directory
   - Run Docker Compose command at your working directory:
    ```
    docker compose -f <your-file-name> up 
    ```

   #### Access the application:  
   - **Frontend:** Access the frontend at `http://localhost:4173`.

   - **Backend API:** The backend API will be accessible at `http://localhost:8081`.\
    Navigate to `http://localhost:8081/TodoList` to access the API endpoint for fetching items from the database.
    - **Database:** The database service will be running internally and accessible by the backend container .


  
  
![front&back](
https://github.com/Omar-tarek3/Assets/blob/master/front-back-3.png)
 

2. ### Jenkins Setup
   This section explains setting up and running Jenkins in a Docker container for continuous integration and deployment. Jenkins server is accessible at `http://localhost:8080`. \
Here's how it works:
   
   - Copy the `Jenkins/dockerfile` and the `jenkins-compose.yaml` files.
   - Replace ` context: ./Jenkins`section in the `jenkins-compose.yaml` with the path to your dockerfile.
   - Run Docker Compose command at your working directory: 
   ```
   docker compose -f <your-composeFile-name> up
    ```
   - Execute commands within the jenkins container as root-user:
    ```
    docker exec -it -u 0 <container-id> bash 
    ```
   - Adjust Docker-Socket permissions so that Jenkins can communicate with the Docker daemon:
    ```
    chmod 666 /var/run/docker.sock
    ```


![Jenkins](https://github.com/Omar-tarek3/Assets/blob/master/jenkins.png)
 

3. ### Kubernetes
   This section provides an overview of my Kubernetes cluster setup, architecture, and  details of how the application is deployed, exposed, and accessed.
            

   #### Cluster Architecture:
      Kubernetes cluster runs on local development environment using Minikube. NGINX Ingress Controller also is installed using Helm to manage external access. The application is deployed on the Kubernetes cluster using the manifests located in the `K8s` directory.
      - **`frontend-deployment.yaml`:** Frontend Deployment object to ensure a specified number of replicas are running,and NodePort service for allowing external traffic to reach it via a specific port on the Minikube node.
      - **`backend-deployment.yaml`:** Backend Deployment object to ensure a specified number of replicas are running. A ClusterIP service for internal exposeing. An Ingress resource the for setting rules and filtering on the incoming tarffic and exposing api endpoints.
      - **`database-statefulset.yaml`:** deploymetn and nodeport for


   ![K8s-architecture](https://github.com/Omar-tarek3/Assets/blob/master/K8s-archi.png)
 
      

      - The frontend sends request to the API endpoint which is exposed by ingress service 
      -  The backend service handels the CRUD opertation and send the aquired query to the database internally by communocatiing with the database-svc
      - database-svc forwrd the requst to the MySQL database 
      - data is persisted usng pvc and sotarge class for persisting the data on the local machine


  


- api end points 
- Argocd setup
- pics 
