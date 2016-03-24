import requests
from bs4 import BeautifulSoup

def crawler(max_pages):
    page = 1
    while page <= max_pages:
        url = 'http://www.snapdeal.com/product/apple-macbook-pro-13-inch/199160/reviews?page=' + str(page) + '&sortBy=HELPFUL#defRevPDP'
        # find the source code of the desired webpage
        source_code = requests.get(url)
        plain_text = source_code.text
        #print(plain_text)

        bsobj = BeautifulSoup(plain_text, "html.parser")  # Create a BeutifulSoup object

        # Open a file
        #file = open("reviews.txt","w")
        
        for main in bsobj.findAll('div', {'class': 'user-review'}):
            p = main.get_text()
            #print(p)
            with open("reviews.txt","a") as myfile:
                    myfile.write(p)
                
        page += 1

                
crawler(25)
#myfile.close()

