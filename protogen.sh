#!/bin/bash
echo "Building protocol buffers (!Untested Linux script!)"
echo "Dependencies: git and protoc in path"

# Define variables relative to project src directory here
user=$(whoami)                                                      # Gets username from system
projName="serving-protobuf-with-javalin"                            # Set your project's name e.g. myproject or myproject/mymodule
projectRoot="/home/$user/IdeaProjects/$projName/src/main/java"      # Set your project root folder here
protoSrc="app/model/objects/proto"                                  # Source directory under project root for proto files

# And here's where the magic happens
cd "$projectRoot" || echo "Project root doesn't exist" && exit
changed=$(git diff --name-only --diff-filter=AM)

if [ -n "$changed" ]
then
  while read -r file
  do
    if [[ $file == *.proto ]]
    then
      echo "compiling: $file"
      fileNameOnly=$(basename "$file")
      # Note that we use projectRoot for the java_out path because
      # protoc will automatically generate subdirectories based on the path provided in the .proto file's 'package' directive (when generating Java code)
      protoc -I="$projectRoot/$protoSrc" --proto_path="$projectRoot" --java_out="$projectRoot" "$fileNameOnly"
    fi
  done < <(changed)
fi
echo "Finished building protocol buffers" && exit
#EOF