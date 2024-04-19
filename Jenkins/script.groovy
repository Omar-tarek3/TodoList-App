def buildImage{
    
    echo 'Building Frontend image'
                    
    withCredentials([usernamePassword(
        credentialsId:'Dockerhub', passwordVariable:'dockerhubPass', usernameVariable:'dockerhubUser')]){

        sh 'docker build -t omartarekabdelall/todo-list-app:frontend-jenkins ./Frontend'
        sh "echo $dockerhubPass | docker login -u $dockerhubUser --password-stdin"         
        sh "docker push omartarekabdelall/todo-list-app:frontend-jenkins"
        //sh "docker pull omartarekabdelall/todo-list-app:frontend"
        }                       
}

def deployApp{
    echo "Building Frontend Image"

}

