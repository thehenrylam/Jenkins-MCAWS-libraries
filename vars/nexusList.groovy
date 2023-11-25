def call( client_dir, nexus_dirpath, nexus_filename ) {
    dir ( client_dir ) {
        nexus_list_output = sh (
            script:"./raw/list.sh \"${nexus_dirpath}\" | grep -s \"${nexus_filename}\" | sed -n 's/^.*\\/repository\\/[^/]*\\/\\(.*\\)/\\1/p'", 
            returnStdout: true
        ).trim()
        
    return nexus_list_output
    }
}
