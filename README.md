# TodoList Microservices Application

The TodoList Microservices Application is a comprehensive end-to-end project that embodies a modern approach to software development and deployment. It comprises a frontend built with React, a backend Node.js Express, and a MySQL database considering DevOps best practices and automated CI/CD pipelines for efficient and scalable application delivery.

## Table of Contents

1. [Technology Stack](#technology-stack)
2. [App Architecture](#app-architecture)
3. [Features](#features)
4. [App Overview](#app-overview)
   1. [Docker Compose](#docker-compose)
   2. [Jenkins Setup](#jenkins-setup)
   3. [Kubernetes](#kubernetes)
      - [Cluster Architecture](#cluster-architecture)
      - [Accessing the Application](#accessing-the-application)
   4. [Argo CD](#argo-cd)



## Technology Stack

- **Frontend:** React, CSS
- **Backend:** Node.js Express
- **Database:** MySQL
- **Containerization:** Docker
- **Orchestration:** Kubernetes 
- **CI/CD Pipeline:** Jenkins
- **GitOps:** ArgoCD
- **Version Control:** Git/GitHub

## App Architecture

![TodoList Arhcitecture](https://github.com/Omar-tarek3/Assets/blob/master/TodoList-pipeline.png)




The CI/CD process ensures that any changes made by developers are automatically integrated, built, and deployed to the Kubernetes cluster without manual intervention. Here's how it works:

1. ### **Developer Pushes Changes**: 
   - A developer pushes code changes to the GitHub repository.

2. ### **Webhook Triggers Jenkins Pipeline**: 
   - A GitHub webhook is configured to trigger a Jenkins pipeline whenever changes are pushed by the developer to the repository.

3. ### **Jenkins Pipeline**:
   - **Build Stage**: Jenkins pulls the latest code from the GitHub repository.
   - **Build Docker Images**: Jenkins builds Docker images for the frontend, backend, and database services.
   - **Push Docker Images to DockerHub**: Jenkins pushes the built Docker images to DockerHub making them accessible for deployment in Kubernetes.

   - **Update Kubernetes Manifest Files**: Jenkins updates the Kubernetes manifest files with the new image tags.

   - **Push Changes to GitHub Repo**: Jenkins pushes the updated Kubernetes manifest files back to the GitHub repository.

4. ### **ArgoCD Deploys to Kubernetes**:
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



## App Overview 
1. ### Docker Compose
    You can have a quick set up and run to the entire application stack to view the app components and interact with it. Ensure you have Docker and Docker Compose installed on your machine.

   #### Running the Application:
   - Copy the `docker-compose.yaml` file located at the app's root directory

   - Navigate to your working directory , then execute Docker Compose command:
       ```
      docker compose -f <your-composeFile-name> up 
       ```

   #### Access the application:  
   - **Frontend:** Access the frontend at `http://localhost:4173`.

   - **Backend API:** The backend API will be accessible at `http://localhost:8081`.\
    Navigate to `http://localhost:8081/TodoList` to access the API endpoint for fetching items from the database.
    - **Database:** The database service will be running internally and accessible by the backend container .


  
  
     ![front&back](
https://github.com/Omar-tarek3/Assets/blob/master/front-back-3.png)
 

2. ### Jenkins Setup
   This section explains setting up and running Jenkins in a Docker container. Jenkins server is accessible at `http://localhost:8080`. \
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
      Kubernetes cluster runs on local development environment using **Minikube**. I also installed **NGINX Ingress Controller** using Helm to manage external access. The application is deployed on the Kubernetes cluster using the manifests located in the `K8s` directory.

   ![K8s-architecture](https://github.com/Omar-tarek3/Assets/blob/master/K8s-archi-2.png)
 
   Here's a breakdown of how a request travels through the Kubernetes cluster from the frontend to the database. We can outline it step-by-step, emphasizing the role of each component:

      1.  ##### **Frontend Sends Request:**

           -  The user interacts with the frontend application and triggers an action that sends an HTTP-request to an API endpoint.

            - This request is resolved by DNS and sent to the IP where the ingress controller is running.

      2. ##### **Ingress Service:**
          - NGINX Ingress controller processes the request and routes it to the `backend-svc` as defined in the Ingress resource rules.

      3. ##### **Backend Service:**

         - The `backend-svc` receives the request and forwards it to the to the pods that are part of the `backend-deployment` where it performs the requested CRUD operations.

      5. ##### **Communication with Database Service:**

         - The `backend-svc` communicates internally with the `database-svc` allowing the webserver to reach the MySQL database.

      6. ##### **Database Service and MySQL Database:**

         - The `database-svc` forwards the query to the `database-statefulset` where actual MySQL database pod runs.
         - MySQL processes the query, performing the requested database operations (e.g., retrieving, inserting, updating, or deleting records).

      7. ##### **Persistent Storage:**

         - The MySQL database request storage using Persistent Volume Claims `PVC`  with the specified requirements, and refers to the `fast` StorageClass to determine how the storage should be provisioned.

         - When the PVC `mysql-pvc` is created, Kubernetes looks for the `fast` StorageClass and uses the `k8s.io/minikube-hostpath` provisioner to create a PV and bound it to the PVC.
   
      
   #### Accessing the Application:
   This section provides an overview of how I exposed and accessed the application on  a Minikube cluster.

      1. ##### Setup DNS Mapping:
         - I added an entery at `C:\Windows\System32\drivers\etc\hosts` file to map the app name `todolist.app.com` to the IP `127.0.0.1` where the Ingress controller runs.

         - For example, to retrieve the todo lists, you need to access the API endpoint at `http://todolist.app.com/TodoList`. You may Refer to Axios requests in `Frontend/src/App.jsx` for further details.

         ```
         #C:\Windows\System32\drivers\etc\hosts entery
         127.0.0.1 todolist.app.com
         ``` 

     2. ##### Access the Frontend:
         -  Run the following command to forward port 4173 on your local machine to the port used by the `frontend-svc` service:

         ```
          kubectl port-forward svc/frontend-svc 4173:4173
         ```
         -  Navigate to `http://localhost:4173` to access the frontend.
   

   3.  ##### Accessing the Ingress Service:
        
       -  Run the following command to forward port 80 on your local machine to the port used by the LoadBalancer Ingress service:
       ```
       kubectl port-forward svc/ingress-nginx-controller 80:80
       ```
       - This command will make the Ingress controller accessible at `http://localhost:80`
4. ### Argo CD
   This section provides an overview of setting up and configuring Argo.
   
   - Create `argocd` namespace and apply the Argo CD installation manifest:
     ```
      kubectl create namespace argocd

      kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
      ```
   - Access the Argo  UI:
      -  Forward the Argo server port to your local machine.
      
      ```
      kubectl port-forward -n argocd svc/argocd-server 8083:443
      ```
      - Navigate to `http://localhost:8083` to access the Argo UI.
   
   - Configure an application manifest to hold your Argo configuration and apply this manifest to your local Kubernetes cluster:
   
     ```
     kubectl apply -f k8s/application.yaml
     ```
     Refer to `k8s/application.yaml` for an example
   app.yaml

   
![Argo-Home](https://github.com/Omar-tarek3/Assets/blob/master/home.png)

![Argo-Home](https://github.com/Omar-tarek3/Assets/blob/master/argo-svc.png)

![Argo-Home](https://github.com/Omar-tarek3/Assets/blob/master/argo-archi.png)


   


