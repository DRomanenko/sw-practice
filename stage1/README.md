### [Book](https://github.com/sanigo/books/blob/master/%5BJAVA%5D%5BOSGi%20in%20Action%5D.pdf)
# Solution
1. Download [Felix Framework Distribution](https://felix.apache.org/downloads.cgi)
2. tar -xvf org.apache.felix.main.distribution-7.0.0.tar.gz
3. cd felix-framework-7.0.0
4. java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8080 -jar bin/felix.jar