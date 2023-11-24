def call( client_dir, nexpull_filepath ) {
    dir ( client_dir ) {
        sh "python3 ./scripts/nexpull.py ${nexpull_filepath}"
    }
}
