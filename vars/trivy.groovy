def call(){
    sh " trivy fs . -o report.json "
}
