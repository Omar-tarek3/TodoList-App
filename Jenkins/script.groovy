
def buildImage() {
            
            echo 'Building Frontend image'
            sh "docker build -t ${FRONTEND_IMAGE}${env.BUILD_NUMBER} ./Frontend"

            echo 'Building Backend image'
            sh "docker build -t ${BACKEND_IMAGE}${env.BUILD_NUMBER} ./Backend"

            echo 'Building Database image'
            sh "docker build -t ${DATABASE_IMAGE}${env.BUILD_NUMBER} ./Database"
                              
}

def pushImage(){


    echo "Pushing Images to Dockerhub Repo"

    withCredentials([usernamePassword(
        credentialsId:'Dockerhub', passwordVariable:'dockerhubPass', usernameVariable:'dockerhubUser')]){

            sh "echo $dockerhubPass | docker login -u $dockerhubUser --password-stdin"         
            sh "docker push ${FRONTEND_IMAGE}${env.BUILD_NUMBER}"
            sh "docker push ${BACKEND_IMAGE}${env.BUILD_NUMBER}"
            sh "docker push ${DATABASE_IMAGE}${env.BUILD_NUMBER}"
        } 
    

}

def updateK8s() {

    sh "sed -i 's|${BACKEND_IMAGE}.*|${BACKEND_IMAGE}${env.BUILD_NUMBER}|g' k8s/backend-deployment.yaml"
    sh"cat k8s/backend-deployment.yaml"

    sh "sed -i 's|${FRONTEND_IMAGE}.*|${FRONTEND_IMAGE}${env.BUILD_NUMBER}|g' k8s/frontend-deployment.yaml"
    sh"cat k8s/frontend-deployment.yaml"  

}


def githubPush() {
     echo "Pushing K8s manifests to github"
     
    withCredentials([string(credentialsId: 'github-token', variable: 'GITHUB_TOKEN')]) {

        sh 'git config --global user.email "omartarekabdelall@gmail.com" '
        sh 'git config --global user.name "Jenkins" '
        sh 'git status'
        sh 'git branch'
        sh 'git config --list'

        sh "git remote set-url origin https://$GITHUB_TOKEN@github.com/Omar-tarek3/TodoList-App.git"
        sh "git add . "
        sh 'git commit -m "jenkins pipeline: update k8s manifests" '
        sh "git push origin HEAD:master"
        sh "git pull origin master"
    }

}

return this 