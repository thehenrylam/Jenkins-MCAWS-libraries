def call(name) {
    echo "Hello ${name}, this is a test!"

    dir ("/var/app/") {
        sh "hostname"
        sh "pwd"
    }
}