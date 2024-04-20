
def buildImage() {
                  
    withCredentials([usernamePassword(
        credentialsId:'Dockerhub', passwordVariable:'dockerhubPass', usernameVariable:'dockerhubUser')]){
            
            echo 'Building Frontend image'
            sh 'docker build -t omartarekabdelall/todo-list-app:frontend-jenkins ./Frontend'

            echo 'Building Backend image'
            sh 'docker build -t omartarekabdelall/todo-list-app:backend-jenkins ./Backend'

            echo 'Building Database image'
            sh 'docker build -t omartarekabdelall/todo-list-app:database-jenkins ./Database'

            sh "echo $dockerhubPass | docker login -u $dockerhubUser --password-stdin"         
            sh "docker push omartarekabdelall/todo-list-app:frontend-jenkins"
            //sh "docker pull omartarekabdelall/todo-list-app:frontend"
        }                       
}

def pushImage(){

    echo "Pushing Images to Dockerhub Repo"

     withCredentials([usernamePassword(
        credentialsId:'Dockerhub', passwordVariable:'dockerhubPass', usernameVariable:'dockerhubUser')]){

            sh "echo $dockerhubPass | docker login -u $dockerhubUser --password-stdin"         
            sh "docker push omartarekabdelall/todo-list-app:frontend-jenkins"
            sh "docker push omartarekabdelall/todo-list-app:backend-jenkins"
            sh "docker push omartarekabdelall/todo-list-app:database-jenkins"
        } 
    

}

return this 