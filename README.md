# FLATprotecc
GitHub for ProgEx SoSe2021 at Frankfurt Univerity of Applied Sciences

## Database setup(MySQL Workbench): 
1. Create new connecntion "flat_protecc".
2. Goto Server->Data import, load dump file from zip-file.
3. New default shema: flat_protecc.
4. Start import.
5. There won't be any sample data that you will be able to access because we cannot create an account for you, as we cannot access your e-mails.
6. Go to FLATprotecc/src/main/java/de/frauas/progex/flatprotecc/Connect2DB.java.
7. In line 20 insert your root-password behind "...root&password=", so that it reads "password=[your password]".
8. Build Project, now you are ready to go

## Build Project
### Installing Maven
1. Visit https://maven.apache.org/download.cgi and download the binary archives
2. Unpack the archive.
3. Add the bin folder ([zipfile]/apache-maven-3.8.1/bin) to your system PATH.
### Building the Project
4. Go to the project folder (the one containing pom.xml)
5. Run "mvn clean install" on your command prompt
6. The JAR file is ./target/FLATprotecc-1.0.0-jar-with-dependencies.jar

