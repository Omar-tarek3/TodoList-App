
def buildImage() {
            
            echo 'Building Frontend image'
            sh "docker build -t omartarekabdelall/todo-list-app:frontend-${env.BUILD_NUMBER} ./Frontend"

            echo 'Building Backend image'
            sh "docker build -t omartarekabdelall/todo-list-app:backend-${env.BUILD_NUMBER} ./Backend"

            echo 'Building Database image'
            sh "docker build -t omartarekabdelall/todo-list-app:database-${env.BUILD_NUMBER} ./Database"
                              
}

def pushImage(){


    echo "Pushing Images to Dockerhub Repo"

    withCredentials([usernamePassword(
        credentialsId:'Dockerhub', passwordVariable:'dockerhubPass', usernameVariable:'dockerhubUser')]){

            sh "echo $dockerhubPass | docker login -u $dockerhubUser --password-stdin"         
            sh "docker push omartarekabdelall/todo-list-app:frontend-${env.BUILD_NUMBER}"
            sh "docker push omartarekabdelall/todo-list-app:backend-${env.BUILD_NUMBER}"
            sh "docker push omartarekabdelall/todo-list-app:database-${env.BUILD_NUMBER}"
        } 
    

}

return this 