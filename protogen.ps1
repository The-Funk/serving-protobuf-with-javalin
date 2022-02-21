Write-Host "Building protocol buffers"
Write-Host "Dependencies: git and protoc in path"

# Define variables relative to project src directory here
$user = (whoami).split("\")[1]                                          # Gets username from system
$projName = "serving-protobuf-with-javalin"                             # Set your project's name e.g. myproject or myproject/mymodule
$projectRoot = "C:/Users/$user/IdeaProjects/$projName/src/main/java"    # Set your project root folder here
$protoSrc = "app/model/objects/proto"                                   # Source directory under project root for proto files

# And here's where the magic happens
Set-Location $projectRoot
$changed = git diff --name-only --diff-filter=AM

if($null -ne $changed) {
    $changedArray = $changed.Split(“`n”)

    foreach ($file in $changedArray) {
        if ($file.EndsWith(".proto")) {
            Write-Host "compiling: $file"
            $fileNameOnly = Split-Path $file -leaf
            # Note that we use $projectRoot for the java_out path.
            # protoc will automatically generate subdirectories based on the path provided in the .proto file's 'package' directive (when generating Java code)
            Start-Process protoc.exe -ArgumentList "-I=`"$projectRoot/$protoSrc`"","--proto_path=`"$projectRoot`"","--java_out=`"$projectRoot`"","$fileNameOnly" -Wait -NoNewWindow
        }
    }
}
Write-Host "Finished building protocol buffers"
exit
#EOF