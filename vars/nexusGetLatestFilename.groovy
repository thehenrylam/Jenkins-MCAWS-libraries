def nexusList = load "nexusList.groovy"

def call( client_dir, nexus_dirpath, nexus_filename ) {
    def nexus_list_output = nexusList.call( client_dir, nexus_dirpath, nexus_filename )
    if (nexus_list_output == "") {
        error "Failed: nexus_list_output is empty!"
    }
    def nexus_latest_filepath = sh (script: "echo \"${nexus_list_output}\" | tail -1", returnStdout: true).trim()
    if (nexus_latest_filepath == "") {
        error "Failed: nexus_latest_filepath is empty!"
    }
    return nexus_latest_filepath
}
