#!/bin/bash
echo "Building protocol buffers (Tested on Debian based distro)"
echo "Dependencies: git and protoc in path"

# Define variables relative to project src directory here
projName="serving-protobuf-with-javalin"                            # Set your project's name e.g. myproject or myproject/mymodule
projectRoot="/root/IdeaProjects/$projName/src/main/java"            # Set your project root folder here (I logged in as root, your home directory may be /home/youruser)
protoSrc="app/model/objects/proto"                                  # Source directory under project root for proto files

# And here's where the magic happens
cd "$projectRoot" || echo "Project root doesn't exist"
changed="$(git diff --name-only --diff-filter=AM)"

if [[ -n "$changed" ]]
then
  while read -r file
  do
    if [[ $file == *.proto ]]
    then
      echo "compiling: $file"
      fileNameOnly=$(basename "$file")
      # Note that we use projectRoot for the java_out path because protoc will automatically generate subdirectories based on the path provided in the .proto file's 'package' directive (when generating Java code).
      # Note that if you installed the protobuf compiler from a Debian based apt repo, you may have an older version, and the proto3 optional keyword may require the experimental_allow included below.
      # If you intend to use optional I would highly recommend downloading a newer version of the protobuf-compiler and doing a manual dpkg -i or add a backports repo to your /etc/apt/sources.list.
      protoc -I="$projectRoot/$protoSrc" --proto_path="$projectRoot" --java_out="$projectRoot" --experimental_allow_proto3_optional "$fileNameOnly"
    fi
  done <<< "$changed"
fi
echo "Finished building protocol buffers" && exit
#EOF