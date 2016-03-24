import os

def create_dir(directory): #check if the directory already exists, if not cretae a new one to store info files
    if not os.path.exists(directory):
        os.makedirs(directory)

def write_file(path,data): #write the file
    f = open(path,'w')
    f.write(data)
    f.close()


