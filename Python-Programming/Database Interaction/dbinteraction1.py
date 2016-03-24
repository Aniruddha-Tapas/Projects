import sqlite3

def Main():
	con = sqlite3.connect('test.db')
    
	cur = con.cursor()    
	cur.execute('SELECT SQLITE_VERSION()')
    
	data = cur.fetchone()
    
	print(data)

	con.close()

if __name__ == '__main__':
	Main()
