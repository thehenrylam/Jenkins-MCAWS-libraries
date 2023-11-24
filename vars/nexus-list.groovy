def call( client_dir, nexus_filepath ) {
    nexus_dirname  = sh (script: "dirname  ${nexus_filepath}").trim()
    nexus_filename = sh (script: "basename ${nexus_filepath}").trim()

    command_list = "./raw/list.sh ${nexus_dirname}/ | grep -s ${nexus_filename} | sed -n 's/^.*\\/repository\\/[^/]*\\/\\(.*\\)/\\1/p'"

    output = sh (
        script: command_list, 
        returnStdout: true 
    ).trim()

    if (output == "") {
        error "Failed: Could not find valid file from the command: ${command_list}"
    }

    return output
}
