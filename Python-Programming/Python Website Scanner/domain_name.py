#In https://www.fcbarcelona.com, fcbarcelona.com is the top level domain
#whois can be used to get it
#cmd: whois fcbarcelona.com

from tld import get_tld

def get_domain_name(url):
    domain_name = get_tld(url)  #pass url and it gives top level domain
    return domain_name

#print(get_domain_name("https://www.fcbarcelona.com"))

