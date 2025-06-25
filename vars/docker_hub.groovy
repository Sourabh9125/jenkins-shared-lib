def call(string ID, string image){
     withCredentials([usernamePassword(
                credentialsId:"${ID}",
                usernameVariable: "dockerHubUser",
                passwordVariable: "dockerHubPass")]){
            sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
            sh "docker image tag ${image} ${env.dockerHubUser}/${image}"
            sh "docker push ${env.dockerHubUser}/${image}"
        }
}