def call(name) {
    echo "Hello ${name}, this is a test!"

    sh "hostname"
    sh "pwd"
}