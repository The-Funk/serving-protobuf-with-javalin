# Define variables relative to project src directory here
$user = (whoami).split("\")[1]
$projName = "serving-protobuf-with-javalin"
$projectRoot = "C:/Users/$user/IdeaProjects/$projName/src/main/java"

# And here's where the magic happens
cd $projectRoot
$changed = git diff --name-only --diff-filter=AM
$changedArray = $changed.Split(“`n”)

foreach ($file in $changedArray)
{
  if ($file.EndsWith(".proto"))
  {
      Write-Host "compiling: $file"
      $fileNameOnly = Split-Path $file -leaf
      # Note that we use $projectRoot for the java_out path. 
      # protoc will automatically generate subdirectories based on the path provided in the .proto file's 'package' directive
      Start-Process protoc.exe -ArgumentList "-I=`"$projectRoot/app/model/objects/proto`"","--proto_path=`"$projectRoot`"","--java_out=`"$projectRoot`"","$fileNameOnly" -Wait -NoNewWindow
  }
}

#EOF