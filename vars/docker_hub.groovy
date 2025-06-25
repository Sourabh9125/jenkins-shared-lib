def call(String credentialsId, String image, String tag){
     withCredentials([usernamePassword(
                credentialsId:"${credentialsId}",
                usernameVariable: "dockerHubUser",
                passwordVariable: "dockerHubPass")]){
            sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
            sh "docker image tag ${image} ${env.dockerHubUser}/${image}:${tag}"
            sh "docker push ${env.dockerHubUser}/${image}:${tag}"
        }
}
