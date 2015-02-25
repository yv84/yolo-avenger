# pip install suds - python2
# pip install suds-jurko - python3

from suds.client import Client


URL = 'http://127.0.0.1:8080/helloworldws/bar?WSDL'
client = Client(URL)
result = client.service.getList()
assert(result == ["Table 1", "Table 2", "Table 3"])
