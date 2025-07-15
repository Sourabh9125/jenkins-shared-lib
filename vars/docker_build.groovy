def call(Map config= [:]){
    def imageName = config.imageName ?: error ("Image name is required")
    def imageTag = config.imageTag ?: 'latest'
    def context = config.context ?: '.'
    def dockerfile = config.dockerfile ?: 'Dockerfile'

    echo "docker build -t ${imageName}:${imageTag} ${dockerfile} "

    sh """
       docker build -t ${imageName}:${imageTag} -f ${dockerfile} ${context}
       """
}
