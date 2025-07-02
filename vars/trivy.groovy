def call(){
    echo "trivy scanning ----"
    sh " trivy fs . -o report.json "
}
