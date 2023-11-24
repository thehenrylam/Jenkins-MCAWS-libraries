def call( client_dir, local_filepath, nexus_filepath ) {
    dir ( client_dir ) {
        sh "./raw/upload.sh ${local_filepath} ${nexus_filepath}"
    }
}
