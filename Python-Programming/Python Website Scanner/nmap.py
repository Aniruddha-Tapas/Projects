import os

def get_namp(options, ip):
    command = "nmap " + options + " " + ip
    process = os.popen(command)
    results = str(process.read())
    return results

#print(get_namp('-F','Here-enter-the-ip-address-of-the-website-you-are-scanning'))
print(get_namp('-F','176.34.188.253'))
