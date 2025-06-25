def call(string image, string tag){
    sh "docker build -t ${image}:${tag} ."
}