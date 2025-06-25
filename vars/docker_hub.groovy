def call(String credentialsId, String image){
     withCredentials([usernamePassword(
                credentialsId:"${credentialsId}",
                usernameVariable: "dockerHubUser",
                passwordVariable: "dockerHubPass")]){
            sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
            sh "docker image tag ${image} ${env.dockerHubUser}/${image}"
            sh "docker push ${env.dockerHubUser}/${image}"
        }
}
