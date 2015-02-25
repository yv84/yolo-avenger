$ export glassfishdir='path to glassfish firectory'
$ export glassfishdomain=' domain_name '
setup admin password, create master-password
$ bin/./asadmin start-domain domain1 --passwordfile 'path to glassfish/domains/domain_name/master-password'
$ mvn install compile glassfish:deploy (glassfish:redeploy)


127.0.0.1:8080/helloworldws/bar?WSDL