cd ~/Documents/TUDelft/webdsl/src
java -Xms512m -Xmx2048m -Xss16m -jar ../stratego.build.bench.jar \
  --input webdslc.str \
  -p org.webdsl.webdslc \
  -I . \
  -I org/webdsl/dsl/syntax\
  -I share/strategoxt/java_front/languages/stratego-java \
  --main webdslc-main \
  --output src-gen/org/webdsl/webdslc/Main.java \
  -DPACKAGE_VERSION_TERM="8282aaa614ff450b421fb673567d91ebbf251594"
cd -
