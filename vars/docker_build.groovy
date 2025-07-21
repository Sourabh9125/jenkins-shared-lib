def call(Map config= [:]){
    def imageName = config.imageName ?: error ("Image name is required")
    def imageTag = config.imageTag ?: 'latest'
    def context = config.context ?: '.'
    def dockerfile = config.dockerfile ?: 'Dockerfile'
    def dockerHubUser = config.dockerHubUser ?: "sourabhlodhi"

    echo "docker build image : ${dockerHubUser}/${imageName}:${imageTag} using ${dockerfile} "

    sh """
       docker build -t ${dockerHubUser}/${imageName}:${imageTag} -f ${dockerfile} ${context}
       """
}
