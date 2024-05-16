
def buildImage() {
            
            echo 'Building Frontend image'
            sh "docker build -t ${FRONTEND_IMAGE} ./Frontend"

            echo 'Building Backend image'
            sh "docker build -t ${BACKEND_IMAGE} ./Backend"

            echo 'Building Database image'
            sh "docker build -t ${DATABASE_IMAGE} ./Database"
                              
}

def pushImage(){


    echo "Pushing Images to Dockerhub Repo"

    withCredentials([usernamePassword(
        credentialsId:'Dockerhub', passwordVariable:'dockerhubPass', usernameVariable:'dockerhubUser')]){

            sh "echo $dockerhubPass | docker login -u $dockerhubUser --password-stdin"         
            sh "docker push ${FRONTEND_IMAGE}"
            sh "docker push ${BACKEND_IMAGE}"
            sh "docker push ${DATABASE_IMAGE}"
        } 
    

}

return this 