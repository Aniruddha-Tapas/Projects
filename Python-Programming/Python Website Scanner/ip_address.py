#in linux
#command host fcbarcelona.com gets the ip address
#host fcbarcelona.com
#fcbarcelona.com has address 54.186.250.79

#in windows
#command ping fcbarcelona.com gets the ip address
#host fcbarcelona.com
#fcbarcelona.com has address 54.186.250.79

import os

def get_ip_address(url):

    # for linux
    # command = "host " + url
    # process = os.popen(command)  #runs a new process/ opens the terminal to get the ip address
    # results = str(process.read())  #get the string value of ip address
    # marker = results.find('has address') + 12  #get to the end of the has address
    # #return results[marker:].splitlines()[0]  #splitlines()[0] returns the top line with the 1st ip address of the site that has multiple ip addresses
    # return results[marker:]

    #for windows
    command = "ping " + url
    process = os.popen(command)  #runs a new process/ opens the cmd to get the ip address
    results = str(process.read())  #get the string value of ip address
    strurl = str(url)
    marker = results.find('Pinging ' + url) + 8 + len(strurl) + 2  #get to the end of the Pinging url
    marker2 = results.find('with')-2

    return results[marker:marker2].splitlines()[0]  #splitlines()[0] returns the top line with the 1st ip address of the site that has multiple ip addresses


print(get_ip_address('fcbarcelona.com'))
#print(get_ip_address('google.com'))





