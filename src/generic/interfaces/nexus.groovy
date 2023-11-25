package generic.interfaces

class Nexus {
    def NEXUS_CLIENT_DIRECTORY

    Nexus( client_dir ) {
        this.NEXUS_CLIENT_DIRECTORY = client_dir
    }

    def list( nexus_dirpath, nexus_filename ) {
        dir ( this.NEXUS_CLIENT_DIRECTORY ) {
            def nexus_list_output = sh (
                script: "./raw/list.sh \"${nexus_dirpath}\" | grep -s \"${nexus_filename}\" | sed -n 's/^.*\\/repository\\/[^/]*\\/\\(.*\\)/\\1/p'"
                returnStdout: true
            ).trim()

            return nexus_list_output
        }
    }

    def getLatestFilename( nexus_dirpath, nexus_filename ) {
        def nexus_list_output = this.list( nexus_dirpath, nexus_filename )
        if (nexus_list_output == "") {
            error "Failed: nexus_list_output is empty!"
        }
        def nexus_latest_filepath = sh (script: "echo \"${nexus_list_output}\" | tail -1", returnStdout: true).trim()
        if (nexus_latest_filepath == "") {
            error "Failed: nexus_latest_filepath is empty!"
        }
        return nexus_latest_filepath
    }
}
